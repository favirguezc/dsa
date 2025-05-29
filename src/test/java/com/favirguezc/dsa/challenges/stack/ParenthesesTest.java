package com.favirguezc.dsa.challenges.stack;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ParenthesesTest {

    @Test
    void testIsValid() {
        assertTrue(Parentheses.isValid(null));
        assertTrue(Parentheses.isValid(""));
        assertTrue(Parentheses.isValid("()"));
        assertTrue(Parentheses.isValid("[]"));
        assertTrue(Parentheses.isValid("{}"));
        assertTrue(Parentheses.isValid("x[x]x"));
        assertTrue(Parentheses.isValid("x[x]x"));
        assertTrue(Parentheses.isValid("x{x}x"));
        assertTrue(Parentheses.isValid("()[]{}"));
        assertTrue(Parentheses.isValid("([{}[]([{}])])"));
        assertFalse(Parentheses.isValid("([{}[]([{])])"));
    }
}
