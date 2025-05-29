package com.favirguezc.dsa.challenges.stack;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.favirguezc.dsa.ds.stack.LinkedListStack;

public class Parentheses {

    private static final Map<Character, Character> PARENTHESES = Map.of(')', '(', ']', '[', '}', '{');
    private static final Set<Character> OPENING = new HashSet<>(PARENTHESES.values());
    private static final Set<Character> CLOSING = new HashSet<>(PARENTHESES.keySet());

    public static boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        LinkedListStack<Character> stack = new LinkedListStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (OPENING.contains(c)) {
                stack.push(c);
            } else if (CLOSING.contains(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                char last = stack.pop();
                if (last != PARENTHESES.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
