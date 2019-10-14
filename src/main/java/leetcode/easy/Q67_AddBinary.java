package leetcode.easy;

/**
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 链接：https://leetcode-cn.com/problems/add-binary
 */
public class Q67_AddBinary {

    public static String addBinary(String a, String b) {
        char[] ac, bc;
        if (a.length() >= b.length()) {
            ac = a.toCharArray();
            bc = b.toCharArray();
        } else {
            ac = b.toCharArray();
            bc = a.toCharArray();
        }
        int alen = ac.length;
        int blen = bc.length;
        int temp = 0;
        for (int i = 0; i < alen; i ++) {
            int bvalue = blen - 1 - i < 0 ? 0 : toInt(bc[blen - 1 - i]);
            int sum = toInt(ac[alen - 1 - i]) + bvalue + temp;
            if (sum == 1) {
                ac[alen - 1 - i] = '1';
                temp = 0;
            } else if (sum == 2) {
                ac[alen - 1 - i] = '0';
                temp = 1;
            }
        }
        if (temp == 0) {
            return String.valueOf(ac);
        } else {
            return "1" + String.valueOf(ac);
        }
    }

    private static int toInt(char c) {
        return (int)c - (int)'0';
    }

    public static void main(String[] args) {
        String a = "1010", b = "1011";
        System.out.println(addBinary(a, b));

        Math.sqrt(1.1);
    }
}
