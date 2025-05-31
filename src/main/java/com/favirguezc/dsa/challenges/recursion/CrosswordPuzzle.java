package com.favirguezc.dsa.challenges.recursion;

import java.util.ArrayList;
import java.util.List;

public class CrosswordPuzzle {

    public static Character[][] crosswordPuzzle(Character[][] crossword, List<String> words) {
        List<Character[][]> initial = new ArrayList<>();
        initial.add(crossword);
        List<Character[][]> solutions = crosswordPuzzle(initial, words);
        if (solutions.isEmpty()) {
            return null;
        } else {
            return solutions.get(0);
        }
    }

    private static List<Character[][]> crosswordPuzzle(List<Character[][]> crosswords, List<String> words) {
        if (words.isEmpty()) {
            return crosswords.stream().filter(CrosswordPuzzle::isValid).toList();
        }
        List<Character[][]> placed = new ArrayList<>();
        crosswords.forEach(crossword -> placed.addAll(placeWord(crossword, words.get(0))));
        return crosswordPuzzle(placed, words.subList(1, words.size()));
    }

    private static List<Character[][]> placeWord(Character[][] crossword, String word) {
        List<Character[][]> placed = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (crossword[i][j] != '+') {
                    Character[][] down = placeWordDown(crossword, word, i, j);
                    Character[][] up = placeWordUp(crossword, word, i, j);
                    Character[][] left = placeWordLeft(crossword, word, i, j);
                    Character[][] right = placeWordRight(crossword, word, i, j);
                    if (down != null) {
                        placed.add(down);
                    }
                    if (up != null) {
                        placed.add(up);
                    }
                    if (left != null) {
                        placed.add(left);
                    }
                    if (right != null) {
                        placed.add(right);
                    }
                }
            }
        }
        return placed;
    }

    private static Character[][] placeWordDown(Character[][] crossword, String word, int x, int y) {
        return placeWord(crossword, word, x, y, 1, 0);
    }

    private static Character[][] placeWordUp(Character[][] crossword, String word, int x, int y) {
        return placeWord(crossword, word, x, y, -1, 0);
    }

    private static Character[][] placeWordRight(Character[][] crossword, String word, int x, int y) {
        return placeWord(crossword, word, x, y, 0, 1);
    }

    private static Character[][] placeWordLeft(Character[][] crossword, String word, int x, int y) {
        return placeWord(crossword, word, x, y, 0, -1);
    }

    private static Character[][] placeWord(Character[][] crossword, String word, int x, int y, int dx, int dy) {
        Character[][] copy = copy(crossword);
        for (int i = 0; i < word.length(); i++) {
            int newX = x + i * dx;
            int newY = y + i * dy;
            if (outOfBounds(newX, newY)) {
                return null;
            }
            char c = copy[newX][newY];
            char w = word.charAt(i);
            if (c == '-' || c == w) {
                copy[newX][newY] = w;
            } else {
                return null;
            }
        }
        int newX = x + word.length() * dx;
        int newY = y + word.length() * dy;
        if (isEmpty(crossword, newX, newY)) {
            return null;
        }
        return copy;
    }

    private static Character[][] copy(Character[][] original) {
        Character[][] copy = new Character[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                copy[i][j] = original[i][j];
            }
        }
        return copy;
    }

    private static boolean isValid(Character[][] crossword) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (crossword[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isEmpty(Character[][] crossword, int x, int y) {
        if (outOfBounds(x, y)) {
            return false;
        }
        return crossword[x][y] == '-';
    }

    private static boolean outOfBounds(int x, int y) {
        return x < 0 || x >= 10 || y < 0 || y >= 10;
    }
}
