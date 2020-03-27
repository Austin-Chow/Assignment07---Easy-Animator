package cs5004.shape;

import java.awt.*;

public class Oval extends AbstractShape {
  public Oval(int red, int green, int blue, String name, double posX, double posY,
              double height, double width, int appears, int disappears) {
    super(red, green, blue, name, posX, posY, height, width, appears, disappears);
    System.out.println("Name: " + this.getName() + "\n" +
            "Type: oval\n" +
            "Center: (" + this.getPosX() + "," + this.getPosY() +"), X radius: " + this.getWidth() +
            ", Y radius: " + this.getHeight() + ", Color: " + this.getColor() + "\n" +
            "Appears at t=" + this.getAppears() + "\n" +
            "Disappears at t=" + this.getDisappears());
  }

  @Override
  public String scale(double leftToRightNewDimension, double upToDownNewDimension,  int startTime, int endTime) throws IllegalArgumentException {
    if (startTime >= endTime) {
      throw new IllegalArgumentException("StartTime can't be greater than or equal to endTime");
    }
    if (startTime < this.getAppears()) {
      throw new IllegalArgumentException("StartTime can't be before this object appears");
    }
    if (endTime > this.getDisappears()) {
      throw new IllegalArgumentException("EndTime can't be after this object disappears");
    }

    double currWidth = this.getWidth();
    double currHeight = this.getHeight();
    this.width = leftToRightNewDimension;
    this.height = upToDownNewDimension;
    return "Shape " + this.getName() + " scales from X radius: " + currWidth
            + ", Y radius: " + currHeight + " to X radius: " + leftToRightNewDimension
            + ", Y radius: " + upToDownNewDimension + " from time t=" + startTime + " to t=" + endTime;
  }
}
