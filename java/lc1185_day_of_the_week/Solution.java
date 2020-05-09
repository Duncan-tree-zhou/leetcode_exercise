package lc1185_day_of_the_week;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {


  public static void main(String[] ags) {
    int[][] inputs = new int[][] {
        new int[]{31,8,2019},
        new int[]{18,7,1999},
        new int[]{15,8,1993}
    };
    String[] expectedResults = new String[] {"Saturday","Sunday","Sunday"};
    for (int i = 0; i < 3; i++) {
      System.out.println(String.format("Input: day=%d, month=%d, year=%d", inputs[i][0], inputs[i][1], inputs[i][2]));
      String result = dayOfTheWeek(inputs[i][0], inputs[i][1], inputs[i][2]);
      System.out.println(String.format("Output: %s", result));
      System.out.println(String.format("Expected: %s", expectedResults[i]));
    }
  }

  int leapYear = 366;
  int commonYear = 356;



  public static String dayOfTheWeek(int day, int month, int year) {
    return "";
  }

}
