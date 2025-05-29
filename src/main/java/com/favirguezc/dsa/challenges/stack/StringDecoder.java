package com.favirguezc.dsa.challenges.stack;

import com.favirguezc.dsa.ds.stack.LinkedListStack;

public class StringDecoder {

    public static String decode(String input) {
        String output = input;
        StringBuilder numberSb = new StringBuilder();
        LinkedListStack<Integer> stack = new LinkedListStack<>();
        LinkedListStack<String> numberStack = new LinkedListStack<>();
        for (int i = 0; i < output.length(); i++) {
            char c = output.charAt(i);
            if (c >= 48 && c <= 57) {
                numberSb.append(c);
            } else if (c == '[') {
                stack.push(i);
                numberStack.push(numberSb.toString());
                numberSb = new StringBuilder();
            } else if (c == ']') {
                int start = stack.pop() + 1;
                String number = numberStack.pop();
                int n = Integer.parseInt(number);
                String r = output.substring(start, i);
                StringBuilder sb = new StringBuilder();
                sb.append(output.substring(0, start - 1 - number.length()));
                for (int j = 0; j < n; j++) {
                    sb.append(r);
                }
                sb.append(output.substring(i + 1, output.length()));
                output = sb.toString();
                i -= number.length() + 2;
            }
        }
        return output;
    }

}
