package com.favirguezc.dsa.challenges.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class StringDecoderTest {

    @Test
    void testDecoder() {
        assertEquals("aaabcbc", StringDecoder.decode("3[a]2[bc]"));
        assertEquals("accaccacc", StringDecoder.decode("3[a2[c]]"));
        assertEquals("abcabccdcdcdef", StringDecoder.decode("2[abc]3[cd]ef"));
        assertEquals("abcabcabcabcabcabcabcabcabcabcabcabc", StringDecoder.decode("12[abc]"));
        assertEquals("aa", StringDecoder.decode("00000002[a]"));
        assertEquals("baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", StringDecoder.decode("b2[2[2[2[2[a]]]]]b"));
    }
}
