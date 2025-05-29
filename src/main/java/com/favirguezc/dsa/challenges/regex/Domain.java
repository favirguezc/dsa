package com.favirguezc.dsa.challenges.regex;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Domain {

    public static List<String> find(String line) {
        Pattern p = Pattern
                .compile(
                        "(?:http(?:s)?\\://)(?:(?:(?:www)|(?:ww2))\\.)?([a-zA-Z0-9\\-]+(?:\\.[a-zA-Z0-9\\-]+)+)");
        Set<String> domains = new HashSet<>();
        Matcher m = p.matcher(line);
        while (m.find()) {
            int groups = m.groupCount();
            for (int i = 1; i <= groups; i++) {
                domains.add(m.group(i));
            }
        }
        return domains.stream().sorted().toList();
    }
}
