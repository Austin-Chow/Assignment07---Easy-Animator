package cs5004.motion;

public class Scale extends AbstractMotion {
  double leftToRightNewDimension;
  double upToDownNewDimension;

  public Scale(double leftToRightNewDimension, double upToDownNewDimension, int startTime, int endTime) {
    super(startTime, endTime);
    this.leftToRightNewDimension = leftToRightNewDimension;
    this.upToDownNewDimension = upToDownNewDimension;
  }
}
