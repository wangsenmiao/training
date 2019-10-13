package leetcode.easy;

public class Q125_ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null) return false;
        if (s == "") return true;
        char[] c = s.toCharArray();
        int i = 0, j = c.length - 1;
        while (i <= j) {
            if (!check(c[i])) {
                i ++;
                continue;
            }
            char curr = c[i];
            i ++;

            while (i <= j) {
                if (!check(c[j])) {
                    j --;
                    continue;
                } else {
                    if (!isEquals(c[j], curr)) {
                        return false;
                    } else {
                        j --;
                        break;
                    }
                }
            }
        }
        return true;
    }

    private boolean check(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z');
    }

    private boolean isEquals(char a, char b) {
        if (a >= 'A' && a <= 'Z') {
            a = (char)(a - 'A' + 'a');
        }
        if (b >= 'A' && b <= 'Z') {
            b = (char)(b - 'A' + 'a');
        }
        return a == b;
    }

    public static void main(String[] args) {
        Q125_ValidPalindrome q = new Q125_ValidPalindrome();
        System.out.println(q.isPalindrome("0P"));
    }
}
