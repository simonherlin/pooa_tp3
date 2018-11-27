package drawing.commands;

import drawing.shapes.IShape;
import drawing.ui.DrawingPane;

public class ShapeCommand implements ICommand {

    private DrawingPane pane;
    private IShape shape;

    public ShapeCommand(DrawingPane pane, IShape shape) {
        this.pane = pane;
        this.shape = shape;
    }

    @Override
    public void execute() {
        pane.addShape(shape);
    }

    @Override
    public void undo() {
        pane.removeShape(shape);
    }

}
