package drawing.commands;

import java.util.List;

import drawing.shapes.IShape;
import drawing.shapes.ShapeGroup;
import drawing.ui.DrawingPane;

public class GroupCommand implements ICommand {

    private DrawingPane dPane;
    private ShapeGroup group;

    public GroupCommand(DrawingPane drawingPane) {
        this.dPane = drawingPane;
        List<IShape> selectedShapes = dPane.getSelection();
        group = new ShapeGroup();
        group.addAllShapes(selectedShapes);
    }

    @Override
    public void execute() {

        for(IShape s : group.getShapes())
            dPane.removeShape(s);

        dPane.addShape(group);
    }

    @Override
    public void undo() {
        for(IShape shape : this.dPane)
            shape.setSelected(false);
        this.dPane.removeShape(group);
        for(IShape shape : group.getShapes()) {
            this.dPane.addShape(shape);
            shape.setSelected(true);
        }
    }

}
