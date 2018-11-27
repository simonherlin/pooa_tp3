package drawing.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import drawing.commands.ICommand;
import drawing.commands.DeleteCommand;
import drawing.ui.DrawingPane;

public class DeleteButtonHandler implements EventHandler<ActionEvent> {

    private ICommand command;
    private DrawingPane pane;

    public DeleteButtonHandler(DrawingPane pane) {
        this.pane = pane;
    }

    @Override
    public void handle(ActionEvent event) {
        this.command = new DeleteCommand(this.pane);
        this.command.execute();
    }

}
