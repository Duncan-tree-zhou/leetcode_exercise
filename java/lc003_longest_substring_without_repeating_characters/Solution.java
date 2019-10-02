package lc003_longest_substring_without_repeating_characters;

public class Solution {


  public static void main(String[] ags) {
    String s = "abcabcbb";
    int result = lengthOfLongestSubstring(s);
    String resultStr = result + "";
    String expectedStr = "3";
    System.out.println(String.format("result is : %s",resultStr));
    System.out.println(String.format("expected is : %s", expectedStr));
  }

  public static int lengthOfLongestSubstring(String s) {
    int max = 0;
    int len = s.length();
    int[] smap = new int[256];
    for (int start = 0, end = 0; end < len; end++) {
      char c = s.charAt(end);
      if (smap[c] > start) {
        start = smap[c];
      }
      int offset = end - start + 1;
      max = max > offset ? max : offset;
      smap[c] = end+1;
    }
    return max;
  }
}
