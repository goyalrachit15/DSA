package alpha;

import java.util.ArrayList;

public class bst {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void preorder(Node root) {
        if(root==null){
            return;
        }

        System.out.print(root.data+" ");
        preorder(root.left);
        preorder(root.right); 
    }

    public static void inoder(Node root) {

        if(root==null){
            return;
        }

        inoder(root.left);
        System.out.print(root.data+" ");
        inoder(root.right);
        
    }
    public static Node insert(Node root, int val) {
        if(root==null){
            root=new Node(val);
            return root;
        }
        if(root.data>val){
            Node left=insert(root.left, val);
            root.left=left;
        }else{
            root.right=insert(root.right, val);
        }
        return root;
    }

     public static boolean search(int key, Node root) {
        if(root == null){
            return false;
        }
        if(root.data==key){
            return true;
        }
        if(key<root.data){
            return search(key, root.left);
        }else{
            return search(key, root.right);
        }
    }

    public static Node findinordersuccess(Node root) {
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }

    public static Node delete(Node root,int data) {
        if(root.data<data){
            root.right=delete(root.right, data);
        }
        else if(root.data>data){
            root.left=delete(root.left, data);
        }else{

            //if node is leaf node
            if(root.left==null && root.right==null){
                return null;
            }

            //if node has 1 child
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }

            //if node has 2 children
            Node is=findinordersuccess(root.right);
            root.data=is.data;
            root.right=delete(root.right, is.data);
        }
        return root;
    }


    public static void printinrange(Node root,int k1,int k2) {
        if(root==null){
            return;
        }
        if(root.data>=k1 && root.data<=k2){
            printinrange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printinrange(root.right, k1, k2);
        }
        else if(root.data>k2){
            printinrange(root.left, k1, k2);
        }else{
            printinrange(root.right, k1, k2);
        }
        
    }

    public static void roottoleaf(Node root,ArrayList<Integer> path) {
        if(root==null){
            return;
        }
        path.add(root.data);
        if(root.left==null && root.right==null){
            System.out.println(path);
            return;
        }
        
        roottoleaf(root.left,path); 
        roottoleaf(root.right,path);
        path.remove(path.size()-1);
    }

    public static Node findinorderprec(Node root) {
        while(root.right!=null){
            root = root.right;
        }
        return root;
    }

    public static Node findinordersucc(Node root) {
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }

    public static boolean valid(Node root,Node min,Node max) {
        if(root==null){
            return true;
        }
        if(min!=null && root.data<=min.data){
            return false;
        }
        else if(max!=null && root.data>=max.data){
            return false;
        }

        return valid(root.left, min, root) && valid(root.right, root, max);
    }

    public static void mirror(Node root) {
        if(root==null){
            return;
        }
        mirror(root.left);
        mirror(root.right);
        Node temp=root.left;
        root.left=root.right;
        root.right=temp;
    }

    public static Node createbst(int arr[],int start,int end) {
        if(start>end){
            return null;
        }
        int mid=(start+end) /2;
        Node root=new Node(arr[mid]);
        root.left=createbst(arr,start,mid-1);
        root.right=createbst(arr, mid+1,end);
        return root;
    }

    public static Node createbstlist(ArrayList<Integer> path,int start,int end) {
        if(start>end){
            return null;
        }
        int mid=(start+end) /2;
        Node root=new Node(path.get(mid));
        root.left=createbstlist(path,start,mid-1);
        root.right=createbstlist(path, mid+1,end);
        return root;
    }

    public static void inorderpath(Node root,ArrayList<Integer> path) {
        if(root==null) return;

        inorderpath(root.left, path);
        path.add(root.data);
        inorderpath(root.right, path);
    }

    public static Node tobalancebst(Node root) {
        ArrayList<Integer> path=new ArrayList<>();
        inorderpath(root,path);
        root=createbstlist(path, 0, path.size()-1);
        return root;
        
    }

    static class Info{
        boolean isBST;
        int size;
        int min;
        int max;

        public Info(boolean isBST, int size, int min, int max){
            this.isBST=isBST;
            this.size=size;
            this.min=min;
            this.max=max;
        }
    }

    static int maxBST=0;
    public static Info largestBST(Node root){
        if(root==null){
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }

        Info left=largestBST(root.left);
        Info right=largestBST(root.right);

        int size=left.size+right.size+1;
        int min=Math.min(left.min, Math.min(right.min,root.data));
        int max=Math.max(left.max, Math.max(right.max,root.data));

        if(root.data<left.max || root.data>right.min){
            return new Info(false, size, min, max);
        }

        if(left.isBST && right.isBST){
            maxBST=Math.max(maxBST,size);
            return new Info(true, size, min, max);
        }

        return new Info(false, size, min, max);

    }

    public static Node mergebst(Node root1,Node root2) {
        ArrayList<Integer> path1=new ArrayList<>();
        ArrayList<Integer> path2=new ArrayList<>();

        inorderpath(root1, path1);
        inorderpath(root2, path2);

        int i=0;
        int j=0;
        
        ArrayList<Integer> path=new ArrayList<>();
        while(i<path1.size() && j<path2.size()){
            if(path1.get(i)>path2.get(j)){
                path.add(path2.get(j));
                j++;
            }else{
                path.add(path1.get(i));
                i++;
            }
        }
        while(i<path1.size()){
            path.add(path1.get(i));
            i++;
        }
        while(j<path2.size()){
            path.add(path2.get(j));
            j++;
        }

        Node root=createbstlist(path, 0, path.size()-1);
        return root;
        
    }
    public static void main(String[] args) {
        // int values[]={3,5,6,8,10,11,12};
        // Node root=null;

        // for(int i=0; i<values.length;i++){
        //     root=insert(root,values[i]);
        // }

        // preorder(root);

        // System.out.println(search(6, root));

        // delete(root, 1);
        // inoder(root);
        // delete(root, 10);
        // inoder(root);

        // printinrange(root, 5, 17 );

        // ArrayList<Integer> path=new ArrayList<Integer>();
        // roottoleaf(root,path);

        // System.out.println(valid(root,null,null));
        // mirror(root);
        // System.out.println();
        // preorder(root);

        // int n=arr.length-1;
        // Node root=createbst(arr, 0, n);
        // preorder(root);
        // root=tobalancebst(root);
        // // inoder(root);
        // preorder(root);

        // System.out.println(largestBST(root).size);


        Node root1=new Node(2);
        root1.left = new Node(1);
        root1.right = new Node(4);

        Node root2=new Node(9);
        root2.left = new Node(3);
        root2.right = new Node(12);

        Node root=mergebst(root1, root2);

        inoder(root);
        preorder(root);
    }
}
