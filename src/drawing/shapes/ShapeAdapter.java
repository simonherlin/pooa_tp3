package drawing.shapes;


import drawing.ui.DrawingPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class ShapeAdapter implements IShape {
    private Shape shape;
    private boolean isSelected;

    public ShapeAdapter (Shape shape) {
        super();
        this.shape = shape;
        this.isSelected = false;
    }

    @Override
    public void addShapeToPane(Pane dp) {
        dp.getChildren().add(this.shape);
    }
    @Override
    public boolean isSelected(){
        return isSelected;
    }
    @Override
    public void setSelected(boolean selected) {
        if (isSelected)
            shape.getStyleClass().add("selected");
        else
            shape.getStyleClass().remove("selected");
        this.isSelected = isSelected;
    }
    @Override
    public boolean isOn(double x, double y){
        return shape.getBoundsInParent().contains(x, y);
    }
    @Override
    public void offset(double x, double y) {
        shape.setTranslateX(shape.getTranslateX()+x);
        shape.setTranslateY(shape.getTranslateY()+y);
    }
    @Override
    public void removeShapeFromPane(Pane pane) {
        pane.getChildren().remove(shape);
    }

    @Override
    public void remove(DrawingPane drawingPane) {
        drawingPane.getChildren().removeAll(shape);
    }
}
