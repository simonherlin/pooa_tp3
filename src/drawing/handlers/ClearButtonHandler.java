package drawing.handlers;

import drawing.commands.ClearCommand;
import drawing.commands.ICommand;
import drawing.ui.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ClearButtonHandler implements EventHandler<ActionEvent> {

    private ICommand command;
    private DrawingPane pane;

    public ClearButtonHandler(DrawingPane dPane)
    {
        this.pane = dPane;
    }

    @Override
    public void handle(ActionEvent arg0)
    {
        this.command = new ClearCommand(pane);
        this.pane.getHistory().exec(command);
    }

}
