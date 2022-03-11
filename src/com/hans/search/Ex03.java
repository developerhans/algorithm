package com.hans.search;

/**
 * 문제 : 이분검색 심화
 */

class BinarySearchTree {
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    Node root;

    public Node search(Node root, int key) {
        if(root == null || root.data == key) // root 에 해당값이 있을때
            return root;

        if(root.data > key) // 트리 왼쪽을 찾아야 할 때
            return search(root.left, key);

        return search(root.right, key); // 트리 오른쪽을 찾아야 할 때
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node root, int data) {
        if(root == null) {
            root = new Node(data);
            return root;
        }

        if(data < root.data) {
            root.left = insert(root.left, data);
        } else if(data > root.data) {
            root.right = insert(root.right, data);
        }

        return root;
    }

    public void delete(int data) {
        root = delete(root, data);
    }

    private Node delete(Node root, int data) {
        if(root == null) return root;

        if(data < root.data) {
            root.left = delete(root.left, data);
        } else if(data > root.data) {
            root.right = delete(root.right, data);
        } else {
            if(root.left == null && root.right == null) { // 자식이 없는 경우
                return null;
            } else if(root.left == null) { // 자식이 한쪽만 있는 경우(왼쪽)
                return root.right;
            } else if(root.right == null) { // 자식이 한쪽만 있는 경우(오른쪽)
                return root.left;
            }

            // 자식이 둘다 있는 경우
            root.data = findMin(root.right);
            root.right = delete(root.right, root.data);
        }

        return root;
    }

    private int findMin(Node root) {
        int min = root.data;
        while (root.left != null) {
            min = root.left.data;
            root = root.left;
        }

        return min;
    }

    public void inorder() {
        inorder(root);
    }

     private void inorder(Node root) {
        if(root != null) {
            inorder(root.left);
            System.out.print(root.data + ", ");
            inorder(root.right);
        }
     }


}

public class Ex03 {

    public static void main(String[] args) {
        int[] a = new int[10];
        for(int i = 0; i < a.length; i++) {
            a[i] = i;
        }

        Tree t = new Tree();
        t.makeTree(a);
        t.searchBTree(t.root, 2);

        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(4);
        tree.insert(2);
        tree.insert(1);
        tree.insert(3);
        tree.insert(6);
        tree.insert(5);
        tree.insert(7);

        tree.inorder();
        System.out.println();
        tree.delete(5);
        tree.inorder();
        System.out.println();

        BinarySearchTree.Node node = tree.search(tree.root, 6);
        System.out.println("serarch node = " + node.data);
        tree.delete(6);
        node = tree.search(tree.root, 6);
        System.out.println("serarch node = " + node);
        tree.inorder();


    }
}
