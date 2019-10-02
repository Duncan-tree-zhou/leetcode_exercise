package lc0030_substring_with_concatenation_of_all_words;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {


  public static void main(String[] ags) {
    String s = "barfoothefoobarman";
    String[] words = new String[]{"foo","bar"};
    List<Integer> result = findSubstring(s,words);
    String resultStr = result.stream().map(o->o+"").collect(Collectors.joining(","));
    String expectedStr = "0,9";
    System.out.println(String.format("result is : %s",resultStr));
    System.out.println(String.format("expected is : %s", expectedStr));
  }

  public static List<Integer> findSubstring(String s, String[] words) {
    if (s.length() == 0 || words.length == 0) return new ArrayList<Integer>();
    int step = words[0].length();
    Map<String,Integer> wmap = new HashMap<>();
    Map<String,Integer> cmap = new HashMap<>();
    List<Integer> list = new ArrayList<Integer>();
    for (String w :words) {
      wmap.compute(w,(k,v)->null==v?1:v+1);
    }
    for (int i = 0; i < s.length() - words.length * step + 1; i++) {
      for (String w : words) {
        cmap.put(w, 0);
      }
      boolean notMatched = false;
      for (int j = 0; j < words.length; j++) {
        String word = s.substring(i+j*step,i+(j+1)*step);
        Integer wc = wmap.get(word);
        if (null == wc) {
          notMatched = true;
          break;
        }
        int cc = cmap.get(word) + 1;
        if (cc > wc) {
          notMatched = true;
          break;
        }
        cmap.put(word, cc);
      }
      if (!notMatched) {
        list.add(i);
      }
    }
    return list;
  }

}
