package drawing.commands;

import java.util.ArrayList;
import java.util.List;
import drawing.shapes.IShape;
import drawing.ui.DrawingPane;

public class ClearCommand implements ICommand {

    private DrawingPane pane;
    private List<IShape> shapes;

    public ClearCommand(DrawingPane receiver) {
        pane = receiver;
        this.shapes = new ArrayList<>();
    }

    @Override
    public void execute() {
        pane.getShapes().forEach(shape -> this.shapes.add(shape));
        pane.clear();
    }

    @Override
    public void undo() {
        for(IShape shape : shapes)
            pane.addShape(shape);
        shapes.clear();
    }

}
