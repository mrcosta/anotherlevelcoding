package com.hackerrank.crackingthecodinginterview;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {

    public boolean hasCycle(Node head) {
        return hasCycleIn(head, new HashSet<Node>());
    }

    private boolean hasCycleIn(Node head, Set<Node> alreadyVisiteds) {
        if (isLastElement(head)) {
            return false;
        } else if (alreadyVisiteds.contains(head)) {
            return true;
        }

        alreadyVisiteds.add(head);
        return hasCycleIn(head.next, alreadyVisiteds);
    }

    private boolean isLastElement(Node head) {
        return head == null;
    }

    public int get(int position, Node head) {
        int countPosition = 1;

        while (countPosition != position && head.next != null) {
            if (head.next != null) {
               head = head.next;
               countPosition++;
            }
        }

        return head.value;
    }

    public void insertIn(int position, int value, Node head) {
       int countPosition = 1;

       while (countPosition != position -1 && head.next != null) {
            if (head.next != null) {
               head = head.next;
               countPosition++;
            }
       }

       Node newNode = new Node(value);
       newNode.next = head.next;
       head.next = newNode;
    }

    static class Node {
        public int value;
        public Node next;

        Node(int value) {
            this.value = value;
        }
    }
}
