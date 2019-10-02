package lc002_add_two_numbers;

public class Solution {

  public static void main(String[] ags) {
    // init l1
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(3);
    // init l2
    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next = new ListNode(4);

    ListNode result = addTwoNumbers(l1,l2);
    String resultStr = getResultStr(result);
    String expectedStr = "7 -> 0 -> 8";
    System.out.println(String.format("result is : %s",resultStr));
    System.out.println(String.format("expected is : %s", expectedStr));
  }

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode re = new ListNode(0);
    ListNode sentry = re;
    int carry = 0;
    while (null != l1 || null != l2) {
      int s = (null == l1?0:l1.val) + (null==l2?0:l2.val) + carry;
      carry = s/10;
      sentry.next = new ListNode(s%10);
      sentry = sentry.next;
      l1 = null==l1?null:l1.next;
      l2 = null==l2?null:l2.next;
    }

    if (carry >0) {
      sentry.next = new ListNode(1);
    }
    return re.next;
  }

  private static String getResultStr(ListNode l) {
    return l.val + getResultStrIter(l);
  }

  private static String getResultStrIter(ListNode l) {
    if (null == l) return "";
    if (null == l.next) return "";
    return " -> " + l.next.val + getResultStrIter(l.next);
  }

}
