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
}