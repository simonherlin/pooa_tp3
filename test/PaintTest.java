import drawing.ui.PaintApplication;
import drawing.shapes.ShapeAdapter;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import java.util.Iterator;

import static org.junit.Assert.*;

public class PaintTest extends ApplicationTest {

    PaintApplication app;

    @Override
    public void start(Stage stage) {
        try {
            app = new PaintApplication();
            app.start(stage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void should_draw_circle_programmatically() {
        interact(() -> {
                    app.getDrawingPane().addShape(new ShapeAdapter(new Ellipse(20, 20, 30, 30)));
                });
        Iterator it = app.getDrawingPane().iterator();
        assertTrue(it.next() instanceof Ellipse);
        assertFalse(it.hasNext());
    }

    @Test
    public void should_draw_circle() {
        // given:
        clickOn("Circle");
        moveBy(60,60);

        // when:
        drag().dropBy(30,30);
        //press(MouseButton.PRIMARY); moveBy(30,30); release(MouseButton.PRIMARY);

        // then:
        Iterator it = app.getDrawingPane().iterator();
        assertTrue(it.next() instanceof Ellipse);
        assertFalse(it.hasNext());
    }

    @Test
    public void should_draw_rectangle() {
        // given:
        clickOn("Rectangle");
        moveBy(0,60);

        // when:
        drag().dropBy(70,40);

        // then:
        Iterator it = app.getDrawingPane().iterator();
        assertTrue(it.next() instanceof Rectangle);
        assertFalse(it.hasNext());
    }

    @Test
    public void should_draw_triangle() {
        clickOn("Triangle");
        moveBy(120,60);
        drag().dropBy(90,40);
        Iterator it = app.getDrawingPane().iterator();
        assertTrue(it.next() instanceof Polygon);
        assertFalse(it.hasNext());
    }

    @Test
    public void should_clear() {
        // given:
        clickOn("Rectangle");
        moveBy(30,60).drag().dropBy(70,40);
        clickOn("Circle");
        moveBy(-30,160).drag().dropBy(70,40);
        clickOn("Triangle");
        moveBy(-30,160).drag().dropBy(70,40);

        // when:
        clickOn("Clear");

        // then:
        assertFalse(app.getDrawingPane().iterator().hasNext());
    }

    @Test
    public void sould_good_number1() {
        clickOn("Rectangle");
        moveBy(30,60).drag().dropBy(70,40);
        clickOn("Circle");
        moveBy(-30,160).drag().dropBy(70,40);
        clickOn("Triangle");
        moveBy(-30,160).drag().dropBy(70,40);

        assertTrue(app.getDrawingPane().getNumberShape() == 3);
    }

    @Test
    public void sould_good_number2() {
        clickOn("Rectangle");
        moveBy(30,60).drag().dropBy(70,40);
        clickOn("Circle");
        moveBy(-30,160).drag().dropBy(70,40);
        clickOn("Triangle");
        moveBy(-30,160).drag().dropBy(70,40);
        clickOn("Clear");
        assertTrue(app.getDrawingPane().getNumberShape() == 0);
    }

    @Test
    public void sould_good_number_selected() {
        clickOn("Rectangle");
        moveBy(30,60).drag().dropBy(70,40);
        clickOn("Circle");
        moveBy(70,160).drag().dropBy(70,40);
        clickOn(app.getDrawingPane().getChildren().get(0));
        press(KeyCode.SHIFT).clickOn(app.getDrawingPane().getChildren().get(1));
        assertTrue(app.getDrawingPane().getSelectHandler().getShapes().size() == 2);
    }

    @Test
    public void remove_shape_selected() {
        clickOn("Rectangle");
        moveBy(30,60).drag().dropBy(70,40);
        clickOn("Circle");
        moveBy(70,160).drag().dropBy(70,40);
        clickOn(app.getDrawingPane().getChildren().get(0));
        clickOn("Delete");
        assertTrue(app.getDrawingPane().getNumberShape() == 1);
    }
}