package com.favirguezc.dsa.challenges.stack;

import com.favirguezc.dsa.ds.stack.LinkedListStack;

public class StringDecoder {

    public static String decode(String input) {
        StringBuilder sb = new StringBuilder();
        StringBuilder numberSb = new StringBuilder();
        LinkedListStack<String> numberStack = new LinkedListStack<>();
        LinkedListStack<String> stringStack = new LinkedListStack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c >= 48 && c <= 57) {
                numberSb.append(c);
            } else if (c == '[') {
                numberStack.push(numberSb.toString());
                numberSb = new StringBuilder();
                stringStack.push(sb.toString());
                sb = new StringBuilder();
            } else if (c == ']') {
                int n = Integer.parseInt(numberStack.pop());
                StringBuilder temp = new StringBuilder(stringStack.pop());
                for (int j = 0; j < n; j++) {
                    temp.append(sb.toString());
                }
                sb = temp;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
