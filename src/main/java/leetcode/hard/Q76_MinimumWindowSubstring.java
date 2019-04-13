package leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串 S 和一个字符串 T，请在 S 中找出包含 T 所有字母的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class Q76_MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        Map<Character, Integer> smap = new HashMap<>();//窗口内字符
        Map<Character, Integer> tmap = new HashMap<>();//需要满足的字符
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        for (char c : ct) {
            smap.put(c, 0);
            if (tmap.containsKey(c)) {
                tmap.put(c, tmap.get(c) + 1);
            } else {
                tmap.put(c, 1);
            }
        }

        int l = 0, r = 0, count = 0;
        String result = "";
        for (; r < cs.length; r ++ ) {
            if (hasChar(ct, cs[r])) {
                int old = smap.get(cs[r]) + 1;
                if (old <= tmap.get(cs[r])) count ++;
                smap.put(cs[r], old);
            }

            while (count == ct.length) {
                if (r - l + 1 < result.length() || result.equals("")) {
                    result = String.valueOf(cs, l, r - l + 1);
                }
                if (hasChar(ct, cs[l])) {
                    int old = smap.get(cs[l]) - 1;
                    if (old < tmap.get(cs[l])) count --;
                    smap.put(cs[l], old);
                }
                l ++;
            }
        }
        return result;
    }

    private boolean hasChar(char[] ct, char c) {
        for (char aCt : ct) {
            if (aCt == c) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Q76_MinimumWindowSubstring q = new Q76_MinimumWindowSubstring();
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(q.minWindow(s, t));
    }
}
