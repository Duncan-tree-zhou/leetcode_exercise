package lc001_two_sum;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {

  public static void main(String[] ags) {
    int[] nums = new int[]{1,2,3};
    int target = 3;
    int[] result = twoSum1(nums,target);
    String resultStr = Arrays.stream(result).mapToObj(o->o+"").collect(Collectors.joining(","));
    String expectedStr = "0,1";
    System.out.println(String.format("result is : %s",resultStr));
    System.out.println(String.format("expected is : %s", expectedStr));
  }

  static public int[] twoSum1(int[] nums, int target) {
    Map<Integer, Integer> nmap = new HashMap<Integer, Integer>(nums.length);
    for (int i = 0; i < nums.length ; i++){
      if(nmap.containsKey(nums[i])){
        return new int[]{nmap.get(nums[i]),i};
      }
      nmap.put(target - nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
  }

}
