package lc0004_median_of_two_sorted_arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Solution2 {

  public static void main(String[] ags){
    int[] nums1 = new int[]{1, 4, 7, 9, 15, 18, 18};
    int[] nums2 = new int[]{2, 4, 6, 8, 10, 15, 18, 22};
    double result = findMedianSortedArrays(nums1, nums2);
    String resultStr = result + "";
    String expectedStr = "8.5";
    System.out.println(String.format("result is : %s",resultStr));
    System.out.println(String.format("expected is : %s", expectedStr));
  }

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int n1 = nums1.length;
    int n2 = nums2.length;

    if (n1 == 0) {
      if (n2 == 0) {
        return 0.0;
      } else {
          return findMedianInOneSortedArray(nums2);
      }
    } else if (n2 == 0) {
      return findMedianInOneSortedArray(nums1);
    }

    int n = n1 + n2;
    if ((n&1) == 1) {
      return findKInSortedArrays(nums1, 0, nums2, 0, n/2 + 1);
    } else {
      return (findKInSortedArrays(nums1, 0, nums2, 0, n/2) + findKInSortedArrays(nums1, 0, nums2, 0, n/2 + 1)) / 2.0;
    }
  }

  public static double findKInSortedArrays(int[] nums1, int n1start, int[] nums2, int n2start, int k) {
    if (n1start >= nums1.length)
      return nums2[n2start + k - 1];
    if (n2start >= nums2.length)
      return nums1[n1start + k - 1];

    if (k == 1)
      return nums1[n1start] <= nums2[n2start] ? nums1[n1start] : nums2[n2start];

    int n1_mid = Integer.MAX_VALUE;
    int n2_mid = Integer.MAX_VALUE;

    if (n1start + k/2 - 1 < nums1.length)
      n1_mid = nums1[n1start + k/2 - 1];
    if (n2start + k/2 - 1 < nums2.length)
      n2_mid = nums2[n2start + k/2 - 1];

    if( n1_mid < n2_mid) {
      return findKInSortedArrays(nums1, n1start + k/2, nums2, n2start, k - k/2);
    } else {
      return findKInSortedArrays(nums1, n1start, nums2, n2start + k/2, k - k/2);
    }
  }

  public static double findMedianInOneSortedArray(int[] nums) {
    if ((nums.length&1) == 0) {
      return (nums[nums.length/2 - 1] + nums[nums.length/2]) / 2.0;
    } else {
      return nums[nums.length/2];
    }
  }

}
