import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RoverTest {

  private static final String DIRECTION_NORTH = "N";
  private static final String DIRECTION_SOUTH = "S";
  private static final String DIRECTION_WEST = "W";

  @Test
  void shouldInitializeRover() {
    int[] position = new int[]{1, 2};
    Rover rover = new Rover(position, DIRECTION_NORTH);

    assertArrayEquals(position, rover.getPosition());
    assertEquals(DIRECTION_NORTH, rover.getDirection());
  }

  @Test
  void shouldNotTurnWhileMoving() {
    Rover rover = new Rover(new int[]{1, 2}, DIRECTION_NORTH);
    rover.executeCommand(new char[]{'f'});

    assertEquals(DIRECTION_NORTH, rover.getDirection());
  }

  @Test
  void shouldMoveForwardToNorth() {
    Rover rover = new Rover(new int[]{1, 2}, DIRECTION_NORTH);
    rover.executeCommand(new char[]{'f'});

    assertArrayEquals(new int[]{1, 3}, rover.getPosition());
  }

  @Test
  void shouldMoveForwardToNorthTwice() {
    Rover rover = new Rover(new int[]{1, 2}, DIRECTION_NORTH);
    rover.executeCommand(new char[]{'f', 'f'});

    assertArrayEquals(new int[]{1, 4}, rover.getPosition());
  }

  @Test
  void shouldMoveForwardToSouth() {
    Rover rover = new Rover(new int[]{1, 2}, DIRECTION_SOUTH);
    rover.executeCommand(new char[]{'f'});

    assertArrayEquals(new int[]{1, 1}, rover.getPosition());
  }

  @Test
  void shouldNotMoveWhileTurning() {
    Rover rover = new Rover(new int[]{1, 2}, DIRECTION_NORTH);
    rover.executeCommand(new char[]{'l'});

    assertArrayEquals(new int[]{1, 2}, rover.getPosition());
  }

  @Test
  void shouldTurnLeftFromNorth() {
    Rover rover = new Rover(new int[]{1, 2}, DIRECTION_NORTH);
    rover.executeCommand(new char[]{'l'});

    assertEquals(DIRECTION_WEST, rover.getDirection());
  }

  @Test
  void shouldTurnLeftFromNorthTwice() {
    Rover rover = new Rover(new int[]{1, 2}, DIRECTION_NORTH);
    rover.executeCommand(new char[]{'l', 'l'});

    assertEquals(DIRECTION_SOUTH, rover.getDirection());
  }

  @Test
  void shouldTurnLeftFromSouth() {
    Rover rover = new Rover(new int[]{1, 2}, DIRECTION_NORTH);
    rover.executeCommand(new char[]{'l'});

    assertEquals(DIRECTION_WEST, rover.getDirection());
  }

  @Test
  void shouldTurnLeft() {
    Rover rover = new Rover(new int[]{1, 2}, DIRECTION_NORTH);
    rover.executeCommand(new char[]{'l'});
    assertEquals(DIRECTION_WEST, rover.getDirection());

    rover.executeCommand(new char[]{'l'});
    assertEquals(DIRECTION_WEST, rover.getDirection());

    rover.executeCommand(new char[]{'l'});
    assertEquals(DIRECTION_WEST, rover.getDirection());
  }
}
