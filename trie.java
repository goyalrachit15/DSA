package alpha;

public class trie {

    // CREATION
    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;
        
        public Node() {
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    // INSERTION
    public static void insertion(String str) {
        Node curr = root;
        int j = 0;
        while (j < str.length()) {
            if (curr.children[str.charAt(j) - 'a'] == null) {
                Node newnode = new Node();
                curr.children[str.charAt(j) - 'a'] = newnode;
            }
            curr = curr.children[str.charAt(j) - 'a'];
            j++;
        }
        curr.eow = true;
    }

    public static boolean search(String word) {
        Node curr=root;

        int j=0;
        while(j<word.length()){
            if(curr.children[word.charAt(j)-'a'] == null){
                return false;
            }
            curr=curr.children[word.charAt(j)-'a'];
            j++;
        }
        if(curr.eow != true){
            return false;
        }
        return true;
    }

    public static boolean startsWith(String prefix) {
        Node curr=root;

        int j=0;
        while(j<prefix.length()){
            if(curr.children[prefix.charAt(j)-'a'] == null){
                return false;
            }
            curr=curr.children[prefix.charAt(j)-'a'];
            j++;
        }
        return true;
    }

    public static boolean word_break(String key) {
        if(key.length()==0){
            return true;
        }
        for(int i=1;i<=key.length();i++) {
            if(search(key.substring(0, i)) && word_break(key.substring(i))){
                return true;
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        String word[] = { "the", "a", "there", "their", "any", "thee" };
        String word1[]={"i","like","samsung","sam","mobile","ice"};
        for (int i = 0; i < word.length; i++) {
            insertion(word1[i]);
        } 

        String key="ilikesamsung";

        System.out.println(word_break(key));

        System.out.println(search("thee"));
        System.out.println(search("thor"));
    }
}
