public class Trie {
    static class Node {
        Node[] children;
        boolean eow;

        public Node() {
            children = new Node[26];
            eow = false;
        }
    }

    static Node root = new Node();

    static void insert(String word) {
       Node curr = root;

       for(int i = 0; i < word.length(); i++) {
        int idx = word.charAt(i) - 'a';

        if(curr.children[idx] == null) {
            curr.children[idx] = new Node();
        }

        curr = curr.children[idx];
       }

       curr.eow = true;
    }

    static boolean search(String key) {
       Node curr = root;

       for(int i = 0; i < key.length(); i++) {
        int idx = key.charAt(i) - 'a';

        if(curr.children[idx] == null) {
            return false;
        }

        curr = curr.children[idx];
       }

       return curr.eow;
    }
    

    public static void main(String[] args) {
        String[] words = {"apple", "any", "their", "there", "a"};

        for(String s : words) {
            insert(s);
        }

        System.out.println(search("apple")); //true;
        System.out.println(search("ap")); //false;
        System.out.println(search("the")); //false;

    }
}

/*
class TrieNode {
    TrieNode[] children;
    boolean eow;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.eow = false;
    }
}

class Trie {
    static TrieNode root = new TrieNode();

    public static void insert(String word) {
        TrieNode curr = root;

        for(int i = 0; i < word.length(); i++ ){
            int idx = word.charAt(i) - 'a';

            if(curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }

            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static boolean search(String str) {
        TrieNode curr = root;

        for(int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';

            if(curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];
        }

        return curr.eow;
    }
}

public class Main {
    public static void main(String[] args) {
        String[] words = {"apple", "ant", "any", "the", "this"};

        Trie t = new Trie();
    
        for(String word : words) {
         t.insert(word);
        }

        System.out.println(t.search("apple"));
        System.out.println(t.search("aunt"));
        System.out.println(t.search("any"));
        System.out.println(t.search("these"));
        System.out.println(t.search("this"));
    }
}
*/
