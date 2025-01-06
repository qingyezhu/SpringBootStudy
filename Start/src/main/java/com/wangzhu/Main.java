package com.wangzhu;

import java.util.LinkedList;

/**
 * Created by wangzhu on 2024/10/31 15:53.
 **/
public class Main {


    public static void main(String[] args) {
        Node<Integer> rootV2 = buildTreeV3(4, null, 1);
        printTree(rootV2);
    }

//    static <E> Node<E> buildTree(int n) {
//        if (n <= 0) {
//            return null;
//        }
//        Node<E> root = new Node<>();
//        LinkedList<Node<E>> linkedList = new LinkedList<>();
//        linkedList.addLast(root);
//        for (int i = 1; i < n; i++) {
//            final int size = linkedList.size();
//            for (int j = 0; j < size; j++) {
//                Node<E> parentNode = linkedList.removeFirst();
//                Node<E> leftChild = new Node<>();
//                leftChild.setParent(parentNode);
//                Node<E> rightChild = new Node<>();
//                rightChild.setParent(parentNode);
//
//                parentNode.setLeftChild(leftChild);
//                parentNode.setRightChild(rightChild);
//                linkedList.addLast(leftChild);
//                linkedList.addLast(rightChild);
//            }
//        }
//        return root;
//    }

    static Node<Integer> buildTreeV2(int n, Node<Integer> parent) {
        if (n == 0) {
            return null;
        }
        Node<Integer> node = new Node<>();
        node.setParent(parent);
        if (parent == null) {
            node.setE(1);
        }else{
            if(parent.getLeftChild() == null || node == parent.getLeftChild()){
                node.setE(parent.getE() * 2);
            }else{
                node.setE(parent.getE() * 2 + 1);
            }
        }
        Node<Integer> leftNode = buildTreeV2(n - 1, node);
//        if(leftNode != null){
//            leftNode.setE(node.getE() * 2);
//        }
        node.setLeftChild(leftNode);

        Node<Integer> rightNode = buildTreeV2(n - 1, node);
//        if(rightNode != null){
//            rightNode.setE(node.getE() * 2 + 1);
//        }
        node.setRightChild(rightNode);
        return node;
    }

    static Node<Integer> buildTreeV3(int n, Node<Integer> parent, int val) {
        if (n == 0) {
            return null;
        }
        Node<Integer> node = new Node<>();
        node.setParent(parent);
        node.setE(val);
        Node<Integer> leftNode = buildTreeV3(n - 1, node, val * 2);
//        if(leftNode != null){
//            leftNode.setE(node.getE() * 2);
//        }
        node.setLeftChild(leftNode);

        Node<Integer> rightNode = buildTreeV3(n - 1, node, val * 2 + 1);
//        if(rightNode != null){
//            rightNode.setE(node.getE() * 2 + 1);
//        }
        node.setRightChild(rightNode);
        return node;
    }


    static void printTree(Node<Integer> root){
        LinkedList<Node<Integer>> linkedList = new LinkedList<>();
        linkedList.addLast(root);
        while(!linkedList.isEmpty()){
            final int size = linkedList.size();
            for(int i = 0;i < size;i ++){
                Node<Integer> node = linkedList.removeFirst();
                System.out.print(node.e + " ");

                if(node.getLeftChild() != null){
                    linkedList.addLast(node.getLeftChild());
                }
                if(node.getRightChild() != null){
                    linkedList.addLast(node.getRightChild());
                }
            }
            System.out.println();
        }
    }
}
