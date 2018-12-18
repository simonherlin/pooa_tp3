package drawing.commands;

import java.util.ArrayList;
import java.util.List;

import drawing.shapes.IShape;
import drawing.shapes.ShapeGroup;
import drawing.ui.DrawingPane;

public class DegroupCommand implements ICommand {

    private DrawingPane pane;
    private List<IShape> shapes;
    private List<ShapeGroup> groups;

    public DegroupCommand(DrawingPane drawingPane) {
        this.pane = drawingPane;
        List<IShape> selectedShapes = pane.getSelection();
        this.groups = new ArrayList<>();
        for(IShape shape : selectedShapes) {
            if(shape instanceof ShapeGroup) {
                groups.add((ShapeGroup)shape);
            }
        }
    }
    @Override
    public void execute() {

        for(ShapeGroup g : groups)
            degroup(g);
    }

    private void degroup(ShapeGroup group) {
        shapes = group.getShapes();
        pane.removeShape(group);
        for(IShape s : shapes)
            pane.addShape(s);
    }

    @Override
    public void undo() {
        this.shapes.forEach(shape -> this.pane.removeShape(shape));
        this.groups.forEach(group -> this.pane.addShape(group));
    }

}
