package cs5004.motion;

public class Move extends AbstractMotion {
  double endPosX;
  double endPosY;

  public Move(double endPosX, double endPosY, int startTime, int endTime) {
    super(startTime, endTime);
    this.endPosX = endPosX;
    this.endPosY = endPosY;
  }
}
