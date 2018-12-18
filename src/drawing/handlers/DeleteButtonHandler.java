package drawing.handlers;

import drawing.commands.DeleteCommand;
import drawing.commands.ICommand;
import drawing.ui.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class DeleteButtonHandler implements EventHandler<ActionEvent> {

    private ICommand command;
    private DrawingPane pane;

    public DeleteButtonHandler(DrawingPane dPane) {
        this.pane = dPane;
    }

    @Override
    public void handle(ActionEvent event) {
        this.command = new DeleteCommand(pane);
        this.pane.getHistory().exec(command);
    }

}
