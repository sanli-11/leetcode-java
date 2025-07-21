public class LongestCommonPrefix {
  public String longestCommonPrefix(String[] strs) {
    int shortestWordIndex = 0;

    for (int i = 1; i < strs.length; i++) {
      if (strs[i].length() < strs[shortestWordIndex].length())
        shortestWordIndex = i;
    }

    String commonPrefix = "";
    String shortestWord = strs[shortestWordIndex];

    for (int j = 0; j < shortestWord.length(); j++) {
      String substring = commonPrefix + shortestWord.charAt(j);

      for (int k = 0; k < strs.length; k++) {
        if (!strs[k].contains(substring))
          break;

        if (k == strs.length - 1)
          commonPrefix = substring;
      }
    }

    return commonPrefix;
  }

  public static void main(String[] args) {
    LongestCommonPrefix lcp = new LongestCommonPrefix();
    String case1Result = lcp
        .longestCommonPrefix(new String[] { "flower", "flow", "flight" });
    String case2Result = lcp
        .longestCommonPrefix(new String[] { "dog", "racecar", "car" });
    String case3Result = lcp
        .longestCommonPrefix(new String[] { "dom", "omega", "gloomy" });
    String case4Result = lcp
        .longestCommonPrefix(new String[] { "reflower", "flow", "flight" });

    System.out.println(case1Result);
    System.out.println(case2Result);
    System.out.println(case3Result);
    System.out.println(case4Result);
  }
}
