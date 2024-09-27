package Trie;

import java.util.HashMap;
import java.util.Map;

public class trieNode {
    Map<Character,trieNode> children;
    boolean endOfString;

    public trieNode() {
        children = new HashMap<>();
        endOfString=false;
    }
    
}
