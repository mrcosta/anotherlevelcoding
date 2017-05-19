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

    static class Node {
        Node next;
    }
}
