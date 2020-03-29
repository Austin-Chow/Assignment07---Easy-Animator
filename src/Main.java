import model.IModel;
import model.ModelImpl;
import shape.Oval;
import shape.Rectangle;
import shape.Shape;

public class Main {
  public static void main(String args[]) {
    IModel model = new ModelImpl();
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    Shape oval = new Oval(0,0,0, "O", 100, 100, 5, 5, 0, 100);
    model.addShape(rect);
    model.addShape(oval);
    //model.addShape(rect);

    model.addChangeColor(rect,0, 0, 255, 20,50);
    model.addScale(rect, 10, 50, 25, 40);
    model.addMove(rect,200, 400, 30, 40);
    model.addMove(rect,420, 420, 40, 50);
    model.addMove(rect, 400,400,20, 30);
    //model.print();

    /*
    Shape rect = new Rectangle(255,0,0, "R", 200, 250, 10, 10, 20, 50);
    Shape oval = new Oval(0,0,0, "O", 100, 100, 5, 5, 0, 100);

    IModel model = new ModelImpl();
    model.addShape(rect);
    model.addShape(oval);

    model.addChangeColor(rect,0, 0, 255, 20,50);
    model.addScale(rect, 10, 50, 25, 40);
    model.addMove(rect,200, 400, 30, 40);
    model.addMove(rect,420, 420, 40, 50);

    System.out.println("Shapes: ");
    for (Shape shape:model.getListOfShapes()) {
      System.out.println(shape.toString());
    }
    for (Shape shape: model.getListOfShapes()) {
      for (Motion motion: shape.getListOfMotions()) {
        System.out.println(motion.toString());
      }
    }
     */
  }
}
