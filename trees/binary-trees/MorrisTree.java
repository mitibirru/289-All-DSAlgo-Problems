class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class MorrisTree {
    public void morrisTraversal(Node root) {
        Node node = root;

        while (node != null) {
            if (node.left == null) {
                System.out.print(node.data + " ");
                node = node.right;
            } else {
                Node current = node.left;
                while (current.right != null && current.right != node) {
                    current = current.right;
                }

                if (current.right == node) {
                    current.right = null;
                    node = node.right;
                } else {
                    System.out.print(node.data + " ");
                    current.right = node;
                    node = node.left;
                }
            }
        }
    }
}
