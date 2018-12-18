package drawing.ui;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class FactoryButton {
    public static final String[] CLEAR = new String[] {"Clear","clear.png"};
    public static final String[] DELETE = new String[] {"Delete","delete.png"};
    public static final String[] RECTANLGE = new String[] {"Rectangle","rectangle.png"};
    public static final String[] CIRCLE = new String[] {"Circle","circle.png"};
    public static final String[] TRIANGLE = new String[] {"Triangle","triangle.png"};
    public static final String[] GROUP = new String[] {"Group","group.png"};
    public static final String[] DEGROUP = new String[] {"Degroup","degroup.png"};
    public static final String[] UNDO = new String[] {"Undo", "undo.png"};
    public static final String[] REDO = new String [] {"Redo", "redo.png"};

    public static final int TEXT_ONLY = 0;
    public static final int ICONS_ONLY = 1;
    public static final int BOTH = 2;

    private int style;

    public FactoryButton() {
        style = BOTH;
    }

    public FactoryButton(int style) {
        this.style = style;
    }

    public Button createButton(String[] option) {
        Image image = new Image(getClass().getResourceAsStream("../images/"+option[1]));
        switch (this.style) {
            case ICONS_ONLY:
                return new Button("", new ImageView(image));
            case TEXT_ONLY:
                return new Button(option[0]);
            default:
                return new Button(option[0], new ImageView(image));
        }
    }
}
