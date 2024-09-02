package org.LeetCode.ValidParantheses;

public class Main {
    public static void main(String[] args) {
        ValidParantheses lib = new ValidParantheses();
        lib.isValid("()");
        lib.isValid("()[]{}");
        lib.isValid("(]");
        lib.isValid("([])");
    }
}
