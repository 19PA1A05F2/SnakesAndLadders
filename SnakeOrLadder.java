package snakesandladders;

public class SnakeOrLadder {
  private int end;
  private int start;
  SnakeOrLadder(int startPoint, int endPoint) {
      this.start = startPoint;
      this.end = endPoint;
  }

  public int getEndPoint() {
      return end;
  }
}


class Snakes extends SnakeOrLadder {

  Snakes(int start, int end) {
      super(start, end);
  }

}

class Ladders extends SnakeOrLadder {

  Ladders(int start, int end) {
      super(start, end);
  }
}