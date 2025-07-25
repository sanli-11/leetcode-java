public class IndexOfStringInString {
  public int strStr(String haystack, String needle) {
    return haystack.indexOf(needle);
  }

  public static void main(String[] args) {
    IndexOfStringInString iss = new IndexOfStringInString();

    int case1Result = iss.strStr("sadbutsad", "sad");
    int case2Result = iss.strStr("leetcode", "leeto");

    System.out.println(case1Result);
    System.out.println(case2Result);
  }
}
