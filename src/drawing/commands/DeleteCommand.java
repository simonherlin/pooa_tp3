package drawing.commands;

import java.util.ArrayList;
import java.util.List;

import drawing.shapes.IShape;
import drawing.ui.DrawingPane;

public class DeleteCommand implements ICommand {

    private DrawingPane pane;
    private List<IShape> shapes;

    public DeleteCommand(DrawingPane dPane) {
        this.pane = dPane;
        this.shapes = new ArrayList<>();
        List<IShape> selectedShapes = this.pane.getSelection();
        selectedShapes.iterator().forEachRemaining(shapes::add);
    }

    @Override
    public void execute() {
        for(IShape shape : shapes)
        {
            pane.removeShape(shape);
        }
    }

    @Override
    public void undo() {
        for(IShape shape : this.pane)
            shape.setSelected(false);
        for(IShape shape : this.shapes) {
            this.pane.addShape(shape);
            shape.setSelected(true);
        }
    }

}
