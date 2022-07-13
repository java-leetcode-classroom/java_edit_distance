import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
  final private Solution sol = new Solution();
  @Test
  void minDistanceExamples1() {
    assertEquals(3, sol.minDistance("horse", "ros"));
  }
  @Test
  void minDistanceExamples2() {
    assertEquals(5, sol.minDistance("intention", "execution"));
  }

  @Test
  void minDistanceDFSExample1() {
    assertEquals(3, sol.minDistanceDFS("horse", "ros"));
  }
  @Test
  void minDistanceDFSExample2() {
    assertEquals(5, sol.minDistanceDFS("intention", "execution"));
  }
  @Test
  void minDistanceDFSExample3() {
    assertEquals(1, sol.minDistanceDFS("", "a"));
  }
}