package alpha;

public class trie_prefix {

    static class Node{
        Node children[]=new Node[26];
        boolean eow=false;
        int freq;

        public Node(){
            for(int i=0;i<26;i++){
                children[i]=null;
            }
            freq=1;
        }
    }

    public static Node root=new Node();

    public static void create(String word) {
        int j=0;
        Node curr=root;

        while(j<word.length()){
            if(curr.children[word.charAt(j)-'a']==null){
                curr.children[word.charAt(j)-'a']=new Node();
            }else{
                curr.children[word.charAt(j)-'a'].freq++;
            }
            curr=curr.children[word.charAt(j)-'a'];
            j++;
        }
        curr.eow=true;
    }

    public static void findprefix(Node root,String ans) {
        
        if(root==null){
            return;
        }

        if(root.freq==1){
            System.out.println(ans);
            return;
        }
        
        for (int i = 0; i < root.children.length; i++) {
            if(root.children[i]!=null){
                findprefix(root.children[i], ans+(char)(i+'a'));
            }
        }
    }
    public static void main(String[] args) {
        String arr[]={"zebra","dog","dove","duck"};

        for (int i = 0; i < arr.length; i++) {
            create(arr[i]);
        }

        root.freq=-1;

        findprefix(root, "");

    }
}
