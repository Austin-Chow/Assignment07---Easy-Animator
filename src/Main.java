import java.awt.*;

import cs5004.shape.Rectangle;
import cs5004.shape.Shape;

public class Main {
  public static void main(String args[]) {
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);

    System.out.println();
    System.out.println(rect.changeColor(0, 0, 255, 20,50));
    System.out.println(rect.scale(10, 50, 15, 40));
    System.out.println(rect.move(200, 400, 40, 50));
  }
}
