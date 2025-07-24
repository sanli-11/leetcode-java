class ListNode {
  int val;
  ListNode next;

  public ListNode() {}

  public ListNode(int val) {
    this.val = val;
  }

  public ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

  public ListNode add(int n, ListNode head) {
    ListNode node = new ListNode(n);

    if (head == null)
      return node;

    ListNode current = head;

    while (current.next != null)
      current = current.next;

    current.next = node;

    return head;
  }

  public String traverse(ListNode head) {
    if (head == null) {
      return "";
    }

    String values = "";
    ListNode current = head;

    while (current != null) {
      if (current.next != null)
        values += current.val + ", ";
      else
        values += current.val;

      current = current.next;
    }

    return values;
  }
}

public class MergeTwoSortedLists {
  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null)
      return list2;
    else if (list2 == null)
      return list1;

    ListNode node = new ListNode();
    ListNode current = node;

    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        current.next = list1;
        list1 = list1.next;
      } else {
        current.next = list2;
        list2 = list2.next;
      }

      current = current.next;
    }

    if (list1 == null)
      current.next = list2;
    else
      current.next = list1;

    return node.next;
  }

  public static void main(String[] args) {
    int[] case1array1 = new int[] { 1, 2, 4 };
    int[] case1array2 = new int[] { 1, 2, 3 };
    int[] case2array1 = new int[] { 0, 2, 4, 6, 8, 10 };
    int[] case2array2 = new int[] { 0, 1, 3, 5, 7, 9 };
    int[] case3array1 = new int[] { 0 };
    int[] case3array2 = new int[] { 0 };

    ListNode case1head1 = null;
    ListNode case1head2 = null;
    ListNode case2head1 = null;
    ListNode case2head2 = null;
    ListNode case3head1 = null;
    ListNode case3head2 = null;

    ListNode ls = new ListNode();
    MergeTwoSortedLists msl = new MergeTwoSortedLists();

    for (int i = 0; i < case1array1.length; i++)
      case1head1 = ls.add(case1array1[i], case1head1);

    for (int i = 0; i < case1array2.length; i++)
      case1head2 = ls.add(case1array2[i], case1head2);

    for (int i = 0; i < case2array1.length; i++)
      case2head1 = ls.add(case2array1[i], case2head1);

    for (int i = 0; i < case2array2.length; i++)
      case2head2 = ls.add(case2array2[i], case2head2);

    for (int i = 0; i < case3array1.length; i++)
      case3head1 = ls.add(case3array1[i], case3head1);

    for (int i = 0; i < case3array2.length; i++)
      case3head2 = ls.add(case3array2[i], case3head2);

    System.out.println("Case 1 List 1: " + ls.traverse(case1head1));
    System.out.println("Case 1 List 2: " + ls.traverse(case1head2));
    System.out.println("Case 2 List 1: " + ls.traverse(case2head1));
    System.out.println("Case 2 List 2: " + ls.traverse(case2head2));
    System.out.println("Case 3 List 1: " + ls.traverse(case3head1));
    System.out.println("Case 3 List 2: " + ls.traverse(case3head2));

    ListNode case1Result = msl.mergeTwoLists(case1head1, case1head2);
    ListNode case2Result = msl.mergeTwoLists(case2head1, case2head2);
    ListNode case3Result = msl.mergeTwoLists(case3head1, case3head2);

    System.out.println("After sorting: " + ls.traverse(case1Result));
    System.out.println("After sorting: " + ls.traverse(case2Result));
    System.out.println("After sorting: " + ls.traverse(case3Result));
  }
}
