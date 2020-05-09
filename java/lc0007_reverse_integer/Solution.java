package lc0007_reverse_integer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

  public static void main(String[] ags){
    int[] nums1 = new int[]{1, 4, 7, 9, 15, 18, 20};
    int[] nums2 = new int[]{2, 4, 6, 8, 10, 15, 18};
    double result = findMedianSortedArrays(nums1, nums2);
    String resultStr = result + "";
    String expectedStr = "8.5";
    System.out.println(String.format("result is : %s",resultStr));
    System.out.println(String.format("expected is : %s", expectedStr));
  }

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    List<Integer> nums = new ArrayList(nums1.length + nums2.length);
    nums.addAll(Arrays.stream(nums1).mapToObj(o->o).collect(Collectors.toList()));
    nums.addAll(Arrays.stream(nums2).mapToObj(o->o).collect(Collectors.toList()));
    Collections.sort(nums);
    double result;
    int size = nums.size();
    if(size % 2 == 1){
      result = nums.get((size-1)/2);
    }else {
      result = (nums.get(size/2-1) + nums.get(size/2) + 0.0)/2;
    }
    return result;
  }

}
