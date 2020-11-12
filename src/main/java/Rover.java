public class Rover {

  // (x,y)
  // (0,2) (1,2)
  // (0,1) (1,1)
  // (0,0) (1,0) (2,0)

  int[] position; // x,y

  String direction; // N = top, E = right

  public Rover(int[] position, String direction) {
    this.position = position;
    this.direction = direction;
  }

  public int[] getPosition() {
    return position;
  }

  public String getDirection() {
    return direction;
  }

  public void executeCommand(char[] chars) {
    for (char command : chars) {
      if (command == 'f') {
        if (direction.equals("N")) {
          position = new int[]{1, position[1] + 1};
        } else if (direction.equals("S")) {
          position = new int[]{1, position[1] - 1};
        }
      } else if (command == 'l') {
        if (direction.equals("N")) {
          direction = "W";
        } else if (direction.equals("W")) {
          direction = "S";
        }
      }
    }
  }

  /*
    [x] The rover receives a character array of commands.
    [x] Implement commands that move the rover forward (f).
    Implement commands that turn the rover left (l).
    Implement wrapping at edges. But be careful, planets are spheres. Connect the x edge to the other x edge, so (1,1) for x-1 to (5,1), but connect vertical edges towards themselves in inverted coordinates, so (1,1) for y-1 connects to (5,1).
    Implement obstacle detection before each move to a new square. If a given sequence of commands encounters an obstacle, the rover moves up to the last possible point, aborts the sequence and reports the obstacle.
    Implement commands that move the rover backward (b).
    Implement commands that turn the rover right (r).
   */


}
