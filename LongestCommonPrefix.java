public class LongestCommonPrefix {
  public boolean commonPrefix(String[] strs, int len) {
    String substring = strs[0].substring(0, len);

    for (int i = 1; i < strs.length; i++) {
      if (!strs[i].startsWith(substring))
        return false;
    }

    return true;
  }

  public String longestCommonPrefix(String[] strs) {
    if (strs.length < 1)
      return "";

    int shortestWordLength = strs[0].length();

    for (int i = 1; i < strs.length; i++) {
      if (strs[i].length() < shortestWordLength)
        shortestWordLength = strs[i].length();
    }

    int low = 1;
    int high = shortestWordLength;

    while (low <= high) {
      int mid = (low + high) / 2;

      if (commonPrefix(strs, mid))
        low = mid + 1;
      else
        high = mid - 1;
    }

    return strs[0].substring(0, (low + high) / 2);
  }

  public String longestCommonPrefixUsingNestedLoop(String[] strs) {
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
