package cs5004.motion;

public abstract class AbstractMotion implements Motion {
  int startTime;
  int endTime;

  public AbstractMotion(int startTime, int endTime) {
    this.startTime = startTime;
    this.endTime = endTime;
  }


  //Abstract class does the common stuff: starttime, endtime, moveToFrom,
  //what type of move it is

}