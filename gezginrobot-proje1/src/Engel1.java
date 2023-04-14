import javax.swing.*;
import java.awt.*;

public class Engel1 extends JFrame {
    private static Color engel1=Color.BLACK;
    private static Color engel2=Color.darkGray;
    private static Color engel3=Color.pink;


    public static Color getEngel1() {
        return engel1;
    }

    public static void setEngel1(Color engel1) {
        Engel1.engel1 = engel1;
    }
    public static Color getEngel2() {
        return engel2;
    }

    public static void setEngel2(Color engel2) {
        Engel1.engel2 = engel2;
    }
    public static Color getEngel3() {
        return engel3;
    }

    public static void setEngel3(Color engel3) {
        Engel1.engel3 = engel3;
    }

}
