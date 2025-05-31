package com.favirguezc.dsa.challenges.recursion;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class CrosswordPuzzleTest {

    @Test
    void test1() {
        Character[][] crossword = new Character[][] {
                { '+', '+', '+', '+', '+', '+', '+', '+', '+', '+' },
                { '+', '-', '-', '-', '-', '-', '-', '+', '+', '+' },
                { '+', '+', '+', '-', '+', '+', '+', '+', '+', '+' },
                { '+', '+', '+', '-', '+', '+', '+', '+', '+', '+' },
                { '+', '+', '+', '-', '-', '-', '-', '-', '+', '+' },
                { '+', '+', '+', '-', '+', '+', '-', '+', '+', '+' },
                { '+', '+', '+', '+', '+', '+', '-', '+', '+', '+' },
                { '+', '+', '+', '+', '+', '+', '-', '+', '+', '+' },
                { '+', '+', '+', '+', '+', '+', '-', '+', '+', '+' },
                { '+', '+', '+', '+', '+', '+', '+', '+', '+', '+' }
        };
        List<String> words = List.of("POLAND", "LHASA", "SPAIN", "INDIA");
        Character[][] solution = CrosswordPuzzle.crosswordPuzzle(crossword, words);
        Character[][] expected = new Character[][] {
                { '+', '+', '+', '+', '+', '+', '+', '+', '+', '+' },
                { '+', 'P', 'O', 'L', 'A', 'N', 'D', '+', '+', '+' },
                { '+', '+', '+', 'H', '+', '+', '+', '+', '+', '+' },
                { '+', '+', '+', 'A', '+', '+', '+', '+', '+', '+' },
                { '+', '+', '+', 'S', 'P', 'A', 'I', 'N', '+', '+' },
                { '+', '+', '+', 'A', '+', '+', 'N', '+', '+', '+' },
                { '+', '+', '+', '+', '+', '+', 'D', '+', '+', '+' },
                { '+', '+', '+', '+', '+', '+', 'I', '+', '+', '+' },
                { '+', '+', '+', '+', '+', '+', 'A', '+', '+', '+' },
                { '+', '+', '+', '+', '+', '+', '+', '+', '+', '+' }
        };
        assertArrayEquals(expected, solution);
    }
}
