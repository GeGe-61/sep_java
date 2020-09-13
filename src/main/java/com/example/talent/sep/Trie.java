package com.example.talent.sep;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private boolean isEnd = false;
    private Map<Character, Trie> subNodes = new HashMap<>();
    public boolean isEnd() {
        return isEnd;
    }
    public void setEnd(boolean isEnd) {
        this.isEnd = isEnd;
    }
    public void addSubNode(Character c, Trie node) {
        subNodes.put(c, node);
    }
    public Trie getSubNode(Character c) {
        return subNodes.get(c);
    }
}
