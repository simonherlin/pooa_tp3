package drawing.shapes;

import java.util.ArrayList;
import java.util.List;

import drawing.ui.DrawingPane;

public class ShapeGroup implements IShape {

    private List<IShape> shapes;

    public List<IShape> getShapes() {
        return shapes;
    }

    public ShapeGroup() {
        shapes = new ArrayList<>();
    }

    public void addShape(IShape shape) {
        shapes.add(shape);
    }

    public void addAllShapes(List<IShape> shapes)
    {
        this.shapes.addAll(shapes);
    }

    @Override
    public void addShapeToPane(DrawingPane pane)
    {
        for(IShape s : shapes)
            s.addShapeToPane(pane);
    }

    @Override
    public void offset(double x, double y) {
        for(IShape s : shapes) {
            s.offset(x, y);
        }
    }

    @Override
    public boolean isOn(double x, double y) {
        for(IShape s : shapes)
        {
            if(s.isOn(x, y))
                return true;
        }
        return false;
    }

    @Override
    public double getTranslateX() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getTranslateY() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void setSelected(boolean flag)
    {
        for(IShape s : shapes)
            s.setSelected(flag);
    }

    @Override
    public void remove(DrawingPane drawingPane)
    {
        for(IShape s : shapes)
            s.remove(drawingPane);
    }

}
