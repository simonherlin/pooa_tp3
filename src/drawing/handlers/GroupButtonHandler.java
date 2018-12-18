package drawing.handlers;

import drawing.commands.GroupCommand;
import drawing.commands.ICommand;
import drawing.ui.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class GroupButtonHandler implements EventHandler<ActionEvent> {

    private DrawingPane pane;
    private ICommand command;

    public GroupButtonHandler(DrawingPane drawingPane) {
        this.pane = drawingPane;
    }

    @Override
    public void handle(ActionEvent event)
    {
        this.command = new GroupCommand(pane);
        this.pane.getHistory().exec(command);
    }

}
