public class LongestCommonPrefix {
  public String longestCommonPrefix(String[] strs) {
    if (strs.length <= 1)
      return strs[0];

    String commonPrefix = "";
    String firstWord = strs[0];

    for (int j = 0; j < firstWord.length(); j++) {
      for (int k = 1; k < strs.length; k++) {
        String substring = commonPrefix + firstWord.charAt(j);

        if (!strs[k].startsWith(substring))
          return commonPrefix;

        if (k == strs.length - 1)
          commonPrefix = substring;
      }
    }

    return commonPrefix;
  }

  public static void main(String[] args) {
    LongestCommonPrefix lcp = new LongestCommonPrefix();

    String case0Result = lcp
        .longestCommonPrefix(new String[] { "flower", "flower", "flower" });
    String case1Result = lcp
        .longestCommonPrefix(new String[] { "flower", "flow", "flight" });
    String case2Result = lcp
        .longestCommonPrefix(new String[] { "dog", "racecar", "car" });
    String case3Result = lcp
        .longestCommonPrefix(new String[] { "dom", "omega", "gloomy" });
    String case4Result = lcp
        .longestCommonPrefix(new String[] { "reflower", "flow", "flight" });
    String case5Result = lcp.longestCommonPrefix(new String[] { "a" });

    System.out.println(case0Result);
    System.out.println(case1Result);
    System.out.println(case2Result);
    System.out.println(case3Result);
    System.out.println(case4Result);
    System.out.println(case5Result);
  }
}
