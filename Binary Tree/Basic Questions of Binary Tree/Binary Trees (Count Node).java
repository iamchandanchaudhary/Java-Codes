class BinaryTrees {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx = -1;
        public static Node buildTree(int nodes[]) {
            idx++;
            if(nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    public static void preorder(Node root) {
        if(root == null) {
            //System.out.print(-1 + " ");
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Count Node
    public static int countNode(Node root) {
        if(root == null) {
            return 0;
        }

        int leftSubtree = countNode(root.left);
        int rightSubtree = countNode(root.right);
        
        return leftSubtree + rightSubtree + 1;
    }

    public static void main(String args[]) {
        System.out.println("Count Node of a Binary Tree :- \n");

        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);

        //System.out.println(root.data);
        System.out.print("Preorder : ");
        preorder(root);

        System.out.println("\nTotal Nodes : " + countNode(root));
    }
}