package com.ifyou;

/**
 * 三个满二叉树头形成环 二叉树有父节点  从任意一个节点 遍历整个树 不能重复 不能用集合 不能用成员变量
 * @param <T>
 */
public class Node2< T > {

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node2 < T > getParent() {
        return parent;
    }

    public void setParent(Node2 < T > parent) {
        this.parent = parent;
    }

    public Node2 < T > getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node2 < T > leftChild) {
        this.leftChild = leftChild;
    }

    public Node2 < T > getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node2 < T > rightChild) {
        this.rightChild = rightChild;
    }

    private T value;
    private Node2 < T > parent;
    private Node2 < T > leftChild;
    private Node2 < T > rightChild;

    private static Node2 < Integer > create(int n) {
        int i = 1;
        int level = 1;
        Node2 < Integer > node = new Node2 <>();
        node.setValue(i);
        handle(node, i, level, n);
        return node;
    }

    private static int handle(Node2 < Integer > parent, int i, int level, int n) {
        level++;
        Node2 < Integer > left = new Node2();
        Node2 < Integer > right = new Node2();
        parent.setLeftChild(left);
        parent.setRightChild(right);
        left.setParent(parent);
        left.setValue(parent.getValue() * 2);
        right.setParent(parent);
        right.setValue(parent.getValue() * 2 + 1);
        if (level == n) {
            return i;
        }
        i = handle(left, i, level, n);
        i = handle(right, i, level, n);
        return i;
    }

    public static void main(String[] args) {
        Node2 < Integer > root1 = create(4);
        Node2 < Integer > root2 = create(4);
        Node2 < Integer > root3 = create(4);
        root1.parent = root2;
        root2.parent = root3;
        root3.parent = root1;
        print(root1.getLeftChild().rightChild);

    }


    private static void print(Node2 < Integer > node) {
        if (node == null || node.getValue() < 0) {
            return;
        }
        System.out.println(node.value);
        //读取了
        node.setValue(-node.getValue());
        if (node.getLeftChild() != null && node.getLeftChild().getValue() > 0) {
            print(node.getLeftChild());
        }
        if (node.getRightChild() != null && node.getRightChild().getValue() > 0) {
            print(node.getRightChild());
        }
        if (node.getParent() != null && node.getParent().getValue() > 0) {
            print(node.getParent());
        }
    }
}
