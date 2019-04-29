package com.ygdxd.str;

/**
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * @author Created by ygdxd_admin at 2019-03-20 6:58 PM
 */
public class Trie {

    public TrieNode root;

    public static final char base = 'a';

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.getChildrens()[c - base] == null){
                node.getChildrens()[c - base] = new TrieNode(c);
            }
            node = node.getChildrens()[c - base];
        }
        node.setWord(true);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.getChildrens()[c - base] == null){
                return false;
            }
            node = node.getChildrens()[c - base];
        }
        return node.isWord();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (node.getChildrens()[c - base] == null){
                return false;
            }
            node = node.getChildrens()[c - base];
        }
        return true;
    }

}

class TrieNode {
    private boolean isWord;
    private char val;
    private TrieNode[] childrens = new TrieNode[26];

    TrieNode(){

    }

    public TrieNode(char c){
        this.val = c;
    }

    public char getVal() {
        return val;
    }

    public void setVal(char val) {
        this.val = val;
    }

    public TrieNode[] getChildrens() {
        return childrens;
    }

    public void setChildrens(TrieNode[] childrens) {
        this.childrens = childrens;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setWord(boolean word) {
        isWord = word;
    }
}
