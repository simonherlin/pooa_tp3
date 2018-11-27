package drawing.handlers;

import drawing.commands.ICommand;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ClearButtonHandler implements EventHandler<ActionEvent> {

    private ICommand command;

    public ClearButtonHandler(ICommand command)
    {
        this.command = command;
    }

    @Override
    public void handle(ActionEvent arg)
    {
        command.execute();
    }

}