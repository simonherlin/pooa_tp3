package drawing.shapes;

import drawing.ui.DrawingPane;

public interface IShape{
    public void addShapeToPane(DrawingPane pane);

    public void offset(double x, double y);

    public boolean isOn(double x, double y);

    public double getTranslateX();

    public double getTranslateY();

    public void setSelected(boolean flag);

    public void remove(DrawingPane drawingPane);
}
