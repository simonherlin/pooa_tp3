package drawing.ui;

import drawing.handlers.MouseMoveHandler;
import drawing.handlers.SelectHandler;
import drawing.shapes.IShape;
import drawing.ui.Observable;
import drawing.ui.Observer;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lewandowski on 20/12/2017.
 */
public class DrawingPane extends Pane implements Iterable<IShape>, Observable {

    private MouseMoveHandler mouseMoveHandler;
    private SelectHandler selectHandler;
    private ArrayList<IShape> shapes;
    private int numberShape;
    private Collection<Observer> observers = new ArrayList<>();
    private int state = 0;

    public DrawingPane() {
        clipChildren();
        shapes = new ArrayList<>();
        mouseMoveHandler = new MouseMoveHandler(this);
        selectHandler = new SelectHandler(this);
    }


    /**
     * Clips the children of this {@link Region} to its current size.
     * This requires attaching a change listener to the region’s layout bounds,
     * as JavaFX does not currently provide any built-in way to clip children.
     */
    void clipChildren() {
        final Rectangle outputClip = new Rectangle();
        this.setClip(outputClip);

        this.layoutBoundsProperty().addListener((ov, oldValue, newValue) -> {
            outputClip.setWidth(newValue.getWidth());
            outputClip.setHeight(newValue.getHeight());
        });
    }

    public List<IShape> getSelection()
    {
        return selectHandler.getShapes();
    }

    public void addShape(IShape shape) {
        shapes.add(shape);
        //this.getChildren().add(shape);
        shape.addShapeToPane(this);
        setState(getState()+1);
        this.notifyObservers();
    }

    public void removeShape(IShape shape) {
        shapes.remove(shape);
        shape.remove(this);
        this.selectHandler.removeShape(shape);
        notifyObservers();
    }


    @Override
    public Iterator<IShape> iterator() {
        return shapes.iterator();
    }

    public void clear() {
        for (IShape shap : shapes){
            this.selectHandler.removeShape(shap);
            shap.remove(this);
        }
        shapes.clear();
        setState(0);
        notifyObservers();
    }

    public int getNumberShape() {
        return this.shapes.size();
    }

    public void addObserver (Observer o) {
        observers.add (o);
    }
    public void removeObserver (Observer o) {
        observers.remove (o);
    }
    public void notifyObservers (){
        for(Observer obs : observers)
            obs.update ();
    }
    public int getState () {
        return this.state;
    }
    public void setState (int state) {
        this.state = state;
        notifyObservers ();
    }

    public SelectHandler getSelectHandler()
    {
        return this.selectHandler;
    }

    public List<IShape> getShapes()
    {
        return this.shapes;
    }

}
