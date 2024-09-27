package Trie;

public class Main {
    public static void main(String[] args) {
        trie newTrie = new trie();
        newTrie.insert("API");
        newTrie.insert("APIS");
        newTrie.insert("APPLE");
        newTrie.insert("APOS");

        newTrie.search("API");
        newTrie.search("AP");

        newTrie.delete("APIS");

        newTrie.search("APIS");

    }
}
