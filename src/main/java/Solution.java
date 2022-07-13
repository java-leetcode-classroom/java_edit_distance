public class Solution {
  public int minDistance(String word1, String word2) {
    int word1Len = word1.length();
    int word2Len = word2.length();
    int[][] dp = new int[word1Len+1][word2Len+1];
    for (int word1Start = 0; word1Start <= word1Len; word1Start++) {
      dp[word1Start][word2Len] = word1Len - word1Start;
    }
    for (int word2Start = 0; word2Start < word2Len; word2Start++) {
      dp[word1Len][word2Start] = word2Len - word2Start;
    }
    for (int word1Start = word1Len - 1; word1Start >= 0; word1Start--) {
      for (int word2Start = word2Len -1; word2Start >= 0; word2Start--) {
        if (word1.charAt(word1Start) == word2.charAt(word2Start)) {
          dp[word1Start][word2Start] = dp[word1Start+1][word2Start+1];
        } else {
          dp[word1Start][word2Start] = 1 + Math.min(
              dp[word1Start+1][word2Start+1],
              Math.min(dp[word1Start][word2Start+1], dp[word1Start+1][word2Start])
          );
        }
      }
    }

    return dp[0][0];
  }
  public int minDistanceDFS(String word1, String word2) {
    int word1Len = word1.length();
    int word2Len = word2.length();
    int[][] cache = new int[word1Len][word2Len];
    for (int row =0; row < word1Len; row++) {
      for (int col =0 ; col < word2Len; col++) {
        cache[row][col]= -1;
      }
    }
    return DFS(word1, 0, word2, 0, cache);
  }
  public int DFS(String word1, int word1End, String word2, int word2End, int[][] cache) {
    int word1Len = word1.length();
    int word2Len = word2.length();
    if (word1End == word1Len && word2End == word2Len) {
      return 0;
    }
    if (word1End == word1Len ) {
      return word2Len - word2End;
    }
    if (word2End == word2Len ) {
      return word1Len - word1End;
    }
    if (cache[word1End][word2End] != -1) {
      return cache[word1End][word2End];
    }
    int result;
    if (word1.charAt(word1End) == word2.charAt(word2End)) {
      result = DFS(word1, word1End+1, word2, word2End+1, cache);
    } else {
      result = 1+ Math.min(
          DFS(word1, word1End+1, word2, word2End+1, cache),
          Math.min(
              DFS(word1, word1End+1, word2, word2End, cache),
              DFS(word1, word1End, word2, word2End+1, cache)
          )
      );
    }
    cache[word1End][word2End] = result;
    return result;
  }
}
