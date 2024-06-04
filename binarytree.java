package alpha;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class binarytree {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Info {
        int diam;
        int height;

        public Info(int diam, int height) {
            this.diam = diam;
            this.height = height;
        }
    }

    static class BinaryTree {
        static int idx = -1;

        public static Node buildpreorder(int arr[]) {
            idx++;
            if (arr[idx] == -1) {
                return null;
            }
            Node newnode = new Node(arr[idx]);
            newnode.left = buildpreorder(arr);
            newnode.right = buildpreorder(arr);

            return newnode;

        }

        public static void preoder(Node root) {
            if (root == null) {
                // System.out.print("-1 ");
                return;
            }
            System.out.print(root.data + " ");
            preoder(root.left);
            preoder(root.right);
        }

        public static void inoder(Node root) {
            if (root == null) {
                // System.out.print("-1 ");
                return;
            }
            inoder(root.left);
            System.out.print(root.data + " ");
            inoder(root.right);
        }

        public static void postoder(Node root) {
            if (root == null) {
                // System.out.print("-1 ");
                return;
            }
            postoder(root.left);
            postoder(root.right);
            System.out.print(root.data + " ");
        }

        public static void levelorder(Node root) {
            if (root == null) {
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while (!q.isEmpty()) {
                Node curr = q.remove();
                if (curr == null) {
                    System.out.println();
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    System.out.print(curr.data + " ");
                    if (curr.left != null) {
                        q.add(curr.left);
                    }
                    if (curr.right != null) {
                        q.add(curr.right);
                    }
                }
            }
        }

        public static int height(Node root) {
            if (root == null) {
                return 0;
            }
            int lh = height(root.left);
            int rh = height(root.right);
            int h = Math.max(lh, rh) + 1;

            return h;

        }

        public static int count(Node root) {
            if (root == null) {
                return 0;
            }

            int lc = count(root.left);
            int rc = count(root.right);

            return lc + rc + 1;
        }

        public static int sum(Node root) {
            if (root == null) {
                return 0;
            }
            int left = sum(root.left);
            int right = sum(root.right);
            return left + right + root.data;
        }

        public static int diameter1(Node root) { // O(n^2)
            if (root == null) {
                return 0;
            }
            int ld = diameter1(root.left);
            int rd = diameter1(root.right);
            int lh = height(root.left);
            int rh = height(root.right);

            int selfdiameter = lh + rh + 1;

            return Math.max(selfdiameter, Math.max(ld, rd));
        }

        public static Info diameter2(Node root) {
            if (root == null) {
                return new Info(0, 0);
            }
            Info left = diameter2(root.left);
            Info right = diameter2(root.right);

            int diameter = Math.max(left.diam, Math.max(right.diam, left.height + right.height + 1));
            int finalh = Math.max(left.height, right.height) + 1;

            return new Info(diameter, finalh);
        }

        public static boolean isIdentical(Node root, Node subroot) {
            if (root == null && subroot == null) {
                return true;
            }
            if (root == null || subroot == null || root.data != subroot.data) {
                return false;
            }

            if (!isIdentical(root.left, subroot.left)) {
                return false;
            }
            if (!isIdentical(root.right, subroot.right)) {
                return false;
            }
            return true;
        }

        public static boolean subtree(Node root, Node subroot) {

            if (root == null) {
                return false;
            }
            if (root.data == subroot.data) {
                if (isIdentical(root, subroot)) {
                    return true;
                }
            }

            return subtree(root.left, subroot) || subtree(root.right, subroot);
        }

        static class Info1 {
            Node node;
            int hd;

            public Info1(Node node, int hd) {
                this.node = node;
                this.hd = hd;
            }
        }

        public static void TopView(Node root) {
            Queue<Info1> q = new LinkedList<>();
            HashMap<Integer, Node> map = new HashMap<>();
            int min = 0;
            int max = 0;

            q.add(new Info1(root, 0));
            q.add(null);

            while (!q.isEmpty()) {
                Info1 curr = q.remove();
                if (curr == null) {
                    if (q.isEmpty()) {
                        break;
                    } else {
                        q.add(null);
                    }
                } else {
                    if (!map.containsKey(curr.hd)) {
                        map.put(curr.hd, curr.node);
                    }

                    if (curr.node.left != null) {
                        q.add(new Info1(curr.node.left, curr.hd - 1));
                        min = Math.min(curr.hd - 1, min);
                    }

                    if (curr.node.right != null) {
                        q.add(new Info1(curr.node.right, curr.hd + 1));
                        max = Math.max(curr.hd + 1, max);
                    }
                }
            }
            for (int i = min; i <= max; i++) {
                System.out.print(map.get(i).data + " ");
            }
        }

        public static void kth(Node root, int level, int k) {
            if (root == null) {
                return;
            }
            if (level == k) {
                System.out.print(root.data + " ");
                return;
            }
            kth(root.left, level + 1, k);
            kth(root.right, level + 1, k);
        }

        public static Boolean getPath(Node root, int n, ArrayList<Node> path) {
            if (root == null) {
                return false;
            }
            path.add(root);

            if (root.data == n) {
                return true;
            }

            boolean foundleft = getPath(root.left, n, path);
            boolean foundright = getPath(root.right, n, path);

            if (foundleft || foundright) {
                return true;
            }

            path.remove(path.size() - 1);
            return false;
        }

        public static Node lca(Node root, int n1, int n2) {
            ArrayList<Node> path1 = new ArrayList<>();
            ArrayList<Node> path2 = new ArrayList<>();

            getPath(root, n1, path1);
            getPath(root, n2, path2);

            int i = 0;
            for (; i < path1.size() && i < path2.size(); i++) {
                if (path1.get(i) != path2.get(i)) {
                    break;
                }
            }

            Node lca = path1.get(i - 1);
            return lca;
        }

        public static Node lca2(Node root, int n1, int n2) {
            if (root == null || root.data == n1 || root.data == n2) {
                return root;
            }

            Node left = lca2(root.left, n1, n2);
            Node right = lca2(root.right, n1, n2);

            if (right == null) {
                return left;
            }

            if (left == null) {
                return right;
            }
            return root;
        }

        public static int lca_dis(Node root, int n) {
            if (root == null) {
                return -1;
            }

            if (root.data == n) {
                return 0;
            }

            int left = lca_dis(root.left, n);
            int right = lca_dis(root.right, n);

            if (left == -1 && right == -1) {
                return -1;
            } else if (left == -1) {
                return right + 1;
            } else {
                return left + 1;
            }
        }

        public static int min(Node root, int n1, int n2) {
            Node lca = lca2(root, n1, n2);
            int dis1 = lca_dis(lca, n1);
            int dis2 = lca_dis(lca, n2);

            return dis1 + dis2;

        }

        public static int kth_ancestor(Node root, int n, int k) {
            if (root == null) {
                return -1;
            }
            if (root.data == n) {
                return 0;
            }

            int left = kth_ancestor(root.left, n, k);
            int right = kth_ancestor(root.right, n, k);

            if (left == -1 && right == -1) {
                return -1;
            }

            int max = Math.max(left, right);
            if (max + 1 == k) {
                System.out.println(root.data);
            }
            return max + 1;
        }

        public static int sumtree(Node root) {
            if (root == null) {
                return 0;
            }

            int left = sumtree(root.left);
            int right = sumtree(root.right);

            int data = root.data;
            int newleft = (root.left == null) ? 0 : root.left.data;
            int newright = (root.right == null) ? 0 : root.right.data;
            root.data = left + right + newleft + newright;

            return data;
        }

        public static void invert(Node root) {
            if(root == null) {
                return;
            }
            invert(root.left);
            invert(root.right);

            Node temp=root.left;
            root.left=root.right;
            root.right=temp;
        }

        public static Node delete(Node root,int n) {
            if(root == null) {
                return null;
            }

            root.left=delete(root.left, n);
            root.right=delete(root.right, n);
            
            if(root.data==n && root.left==null && root.right==null) {
                return null;
            }
            return root;
        }

        public static void main(String[] args) {
            // int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
            // BinaryTree tree = new BinaryTree();
            // Node root = tree.buildpreorder(nodes);
            // System.out.println(root.data);
            // tree.preoder(root);
            // System.out.println();
            // tree.inoder(root);
            // System.out.println();
            // tree.postoder(root);
            // System.out.println();
            // tree.levelorder(root);

            // System.out.println(tree.height(root));
            // System.out.println(tree.count(root));
            // System.out.println(tree.sum(root));
            // System.out.println(tree.diameter1(root));
            // System.out.println(tree.diameter2(root).diam);

            Node root = new Node(1);
            root.left = new Node(3);
            root.right = new Node(3);
            root.left.left = new Node(3);
            root.left.right = new Node(2);
            // root.right.left = new Node(6);
            // root.right.right = new Node(7);

            // Node subroot = new Node(2);
            // subroot.left = new Node(4);
            // subroot.right = new Node(5);

            // System .o ut.println(subtree(root, subroot));
            // TopView(root);
            // kth(root, 1, 2);
            // System.out.println(lca(root, 4, 5).data);
            // System.out.println(lca2(root, 4, 5).data);

            // System.out.println(min(root, 4, 6));
            // sumtree(root);

            // invert(root);
            delete(root, 3);
            levelorder(root);
        }
    }
}
