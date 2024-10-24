package com.wangzhu.leetcode;

/**
 * Created by wangzhu on 2024/10/23 17:49.
 **/
public class PredecessorAndSuccessor {
    static class Node {
        Node parent, left, right;
        int value;

        Node(int value) {
            this.value = value;
        }
    }

    // 找前驱节点
    Node findPredecessor(Node node) {
        if (node.left != null) {
            // 左子树存在，则找左子树中的最右的一个
            return findRight(node.left);
        }
        Node parent = node.parent;
        while (parent != null && parent.right != node) {
            node = parent;
            parent = node.parent;
        }
        return parent;
    }

    Node findRight(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    // 找后继节点
    Node findSuccessor(Node node) {
        if (node.right != null) {
            return findLeft(node.right);
        }
        Node parent = node.parent;
        while (parent != null && parent.left != node) {
            node = parent;
            parent = node.parent;
        }
        return parent;
    }

    Node findLeft(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
