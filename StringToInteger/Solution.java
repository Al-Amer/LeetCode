/*
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer
(similar to C/C++'s atoi function).
The algorithm for myAtoi(string s) is as follows:
 */

package StringToInteger;

class Solution {
    public int myAtoi(String s) {
        if (s == null) return 0;
        int n = s.length();
        if (n == 0) return 0;
        int i = 0;
        while (s.charAt(i) == ' ') {
            // only contains blank space
            if (++i == n) return 0;
        }
        int sign = 1;
        if (s.charAt(i) == '-') sign = -1;
        if (s.charAt(i) == '-' || s.charAt(i) == '+') ++i;
        int res = 0, flag = Integer.MAX_VALUE / 10;
        for (; i < n; ++i) {
            // not a number, exit the loop
            if (s.charAt(i) < '0' || s.charAt(i) > '9') break;
            // if overflows
            if (res > flag || (res == flag && s.charAt(i) > '7'))
                return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (s.charAt(i) - '0');
        }
        return sign * res;
    }
}
