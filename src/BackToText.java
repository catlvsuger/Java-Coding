/**
 * @Auther: discat
 * @Email: distantcat@126.com
 * @Date: 2018-10-12 15:22
 * @Description: 回文 给定一个字符串，找出该字符串的最长回文子串。回文字符串指的就是从左右两边看都一样的字符串，
 * 如 aba，cddc 都是回文字符串。字符串 abbacdc 存在的回文子串有 abba 和 cdc，因此它的最长回文子串为 abba
 */
public class BackToText {

    //判断字符串s是否是回文字符串
    public static  int isPalindrome(String s, int start, int end) {
        for (; start < end; ++start, --end) {
            if(s.charAt(start) != s.charAt(end)) {
                return 0;
            }
        }
        return 1;
    }

    //蛮力法通过对字符串所有子串进行判断，如果是回文字符串，则更新最长回文的长度。
    // 因为长度为 N 的字符串的子串一共可能有 (1+N)*N/2 个，每次判断子串需要 O(N) 的时间，
    // 所以一共需要 O(N^3) 时间求最长回文子串。
    //最长回文子串-蛮力法 O(N^3)
    public static  String  longestPaliendrome(String s) {
        int len = s.length(), maxLen = 1;
        int start = 0 , i, j;
        /*遍历字符串所有的子串，若子串为回文字符串则更新最长回文的长度*/
        for (i = 0; i < len - 1; i++) {
            for (j = i+1; j < len; j++) {
                //如果str[i,j]是回文，则判断其长度是否大于最大值，大于则更新长度和位置
                if (isPalindrome(s, i, j) == 1) {
                    int pLen = j - i +1;
                    if (pLen >maxLen) {
                        start = i ;//更新最长回文起始位置
                        maxLen = pLen;//更新最长回文的长度
                    }
                }
            }
        }
        return s.substring(start, start+maxLen);
    }

    /**
     * 还有一个更简单的方法可以使用 O(N^2) 时间、不需要额外的空间求最长回文子串。
     * 我们知道回文字符串是以字符串中心对称的，如 abba 以及 aba 等。
     * 一个更好的办法是从中间开始判断，因为回文字符串以字符串中心对称。一个长度为 N 的字符串可能的对称中心有 2N-1 个，
     * 至于这里为什么是 2N-1 而不是 N 个，是因为可能对称的点可能是两个字符之间，比如 abba 的对称点就是第一个字母 b 和第二个字母 b 的中间
     */
    static class BackText {
        int longestBegin; //回文起始位置
        int longestLen;   //回文长度

        public int getLongestBegin() {
            return longestBegin;
        }

        public void setLongestBegin(int longestBegin) {
            this.longestBegin = longestBegin;
        }

        public int getLongestLen() {
            return longestLen;
        }

        public void setLongestLen(int longestLen) {
            this.longestLen = longestLen;
        }
    }

    public static void expandAroundCenter(String s, int l, int r, BackText backText) {
        int n = s.length();
        while (l >= 0 && r <= n-1 && s.charAt(l) == s.charAt(r)) {
            l--; r++;
        }
        backText.setLongestBegin(l + 1);
        backText.setLongestLen(r - l - 1);
    }

    /**
     * 最长回文子串-中心法，时间O(N^2)。
     */
    public static String longestPalindromeCenter(String s) {
        int n = s.length();
        if (n == 0) return  s;
        int longestBegin = 0, longestLen = 1;
        BackText backText = new BackText();
        for (int i = 0; i < n; i++) {
            expandAroundCenter(s, i, i, backText);//以位置i为中心的最长回文字符串
            if (backText.getLongestLen() > longestLen) {
                longestLen = backText.getLongestLen();
                longestBegin = backText.getLongestBegin();
            }
            expandAroundCenter(s, i, i+1, backText); //以i和i+1之间的位置为中心的最长回文字符串
            if (backText.getLongestLen() > longestLen) {
                longestLen = backText.getLongestLen();
                longestBegin = backText.getLongestBegin();
            }
        }
        return s.substring(longestBegin, longestBegin+longestLen);
    }

    public static void main(String[] args) {
        System.out.println(longestPaliendrome("asdbdBsc"));
        System.out.println(longestPalindromeCenter("asdbdBsc"));
        Integer a = new Integer(1), b = new Integer(2);
        swap(a,b);
        System.out.println("a: " + a + "  b:"+ b);
    }

    public static void swap(Integer a, Integer b) {
        a = 2;b = 1;
        System.out.println("a: " + a + "  b:"+ b);
    }

}
