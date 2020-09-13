package com.example.talent.sep;

public class StreamAlerter {
    private RingBuffer ring = new RingBuffer();
    private Trie root = new Trie();

    public StreamAlerter(String[] strings) {
        for (int i = 0; i < strings.length; i++) {
            Trie temp = root;
            for (int j = 0; j < strings[i].length(); j++) {
                char key = strings[i].charAt(j);
                Trie trie = temp.getSubNode(key);
                if (trie == null) {
                    trie = new Trie();
                    temp.addSubNode(key, trie);
                }
                temp = trie;

                if (j == strings[i].length() - 1) {
                    temp.setEnd(true);
                }
            }
        }
    }

    public boolean query(char ch) {
        Trie node;
        if (ring.isEmpty()) {
            node = root.getSubNode(ch);
            if (null == node ) {
                return false;
            }
            if (node.isEnd()){
                return true;
            }
        }


        node = root;
        String word = ring.getAlltoStr();
        for (int i = 0; i <word.length(); i++) {
            node = node.getSubNode(word.charAt(i));
        }
        Trie temp = node.getSubNode(ch);
        if (null==temp){
            return false;
        }
        if (temp.isEnd()){
            ring.empty();
            return true;
        }else {
            ring.enqueue(ch);
            return false;
        }
    }
}
