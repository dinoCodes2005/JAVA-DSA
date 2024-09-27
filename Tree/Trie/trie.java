package Trie;

public class trie {
    private trieNode root;
    public trie()
    {
        root = new trieNode();
        System.out.println("Trie has been created");
    }

    public void insert(String word)
    {
        trieNode current = root;
        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            trieNode node = current.children.get(ch);
            if(node==null)
            {
                node = new trieNode();
                current.children.put(ch,node);
            }
            current = node;
        }
        current.endOfString = true;
        System.out.println("This word has been successfully inserted ");
    }

    public boolean search(String word)
    {
        trieNode currentNode = root;
        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            trieNode node = currentNode.children.get(ch);
            if(node==null)
            {
                System.out.println("String does not exist");
                return false;
            }
            currentNode = node;
        }
        if(currentNode.endOfString==true)
        {
            System.out.println("String does exist");
            return true;
        }
        else{
            System.out.println("This string is a prefix of another string");
        }
        return currentNode.endOfString;
    } 

    private boolean delete(trieNode parent,String word,int index)
    {
        char ch = word.charAt(index);
        trieNode current = parent.children.get(ch);
        boolean canDeleted;
        if(current.children.size()>1)
        {
            delete(current,word,index+1);
            return false;
        }
        if(index == word.length()-1)
        {
            if(current.children.size()>=1)
            {
                current.endOfString = false;
                return false;
            }
            else{
                parent.children.remove(ch);
                return true;
            }
        }

        if(current.endOfString == true)
        {
            delete(current,word,index+1);
            return false;
        }

        canDeleted = delete(current, word, index+1);
        if(canDeleted == true)
        {
            parent.children.remove(ch);
            return true;
        }
        else{
            return false;
        }
    }

    public void delete(String word)
    {
        if(search(word)==true)
        {
            delete(root,word,0);
        }
    }
}
