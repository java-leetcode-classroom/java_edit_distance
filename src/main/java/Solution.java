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
}
