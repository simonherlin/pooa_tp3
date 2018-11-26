package drawing.shapes;

import drawing.ui.DrawingPane;
import javafx.scene.shape.Shape;

public class ShapeAdapter implements IShape {

    protected Shape shape;

    public ShapeAdapter(Shape shape) {
        super();
        this.shape = shape;
    }

    @Override
    public void addShapeToPane(DrawingPane pane)
    {
        pane.getChildren().add(shape);
    }

    @Override
    public void offset(double x, double y)
    {
        shape.setTranslateX(x + shape.getTranslateX());
        shape.setTranslateY(y + shape.getTranslateY());
    }

    @Override
    public boolean isOn(double x, double y)
    {
        if(shape.getBoundsInParent().contains(x, y))
            return true;
        return false;
    }

    @Override
    public double getTranslateX() {
        return shape.getTranslateX();
    }

    @Override
    public double getTranslateY() {
        return shape.getTranslateY();
    }

    @Override
    public void setSelected(boolean flag) {
        if(flag)
            shape.getStyleClass().add("selected");
        else
            shape.getStyleClass().remove("selected");
    }

    @Override
    public void remove(DrawingPane drawingPane) {
        drawingPane.getChildren().removeAll(shape);
    }

    public Shape getSelectedShape() {
        return shape;
    }
}
