class PalidromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        else if (x <= 9)
            return true;

        String str = String.valueOf(x);

        for (int i = 0; i < Math.floor(str.length() / 2); i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        PalidromeNumber p = new PalidromeNumber();

        boolean case1Results = p.isPalindrome(121);
        boolean case2Results = p.isPalindrome(-121);
        boolean case3Results = p.isPalindrome(10);

        System.out.println(case1Results);
        System.out.println(case2Results);
        System.out.println(case3Results);
    }
}
