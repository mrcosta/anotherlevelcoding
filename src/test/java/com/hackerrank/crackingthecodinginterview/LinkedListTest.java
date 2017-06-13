package com.hackerrank.crackingthecodinginterview;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class LinkedListTest {

    @Test
    public void shouldReturnFalseIfThereIsNoCycleInLinkedList() {
        LinkedList linkedList = new LinkedList();
        assertThat(linkedList.hasCycle(new LinkedList.Node(1)), is(false));
    }

    @Test
    public void shouldReturnTrueIfThereIsACycleInLinkedList() {
        LinkedList linkedList = new LinkedList();
        LinkedList.Node head = new LinkedList.Node(1);
        LinkedList.Node next = new LinkedList.Node(1);
        head.next = next;
        next.next = head;
        assertThat(linkedList.hasCycle(head), is(true));
    }

    @Test
    public void shouldReturnSpecificNodeForNthPosition() {
        LinkedList linkedList = new LinkedList();

        LinkedList.Node node = new LinkedList.Node(1);
        LinkedList.Node node2 = new LinkedList.Node(2);
        LinkedList.Node node3 = new LinkedList.Node(3);
        LinkedList.Node node4 = new LinkedList.Node(4);
        LinkedList.Node node5 = new LinkedList.Node(5);

        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        assertThat(linkedList.get(4, node), is(4));
    }

    @Test
    public void shouldAddNodeForInNthPosition() {
        LinkedList linkedList = new LinkedList();

        LinkedList.Node node = new LinkedList.Node(1);
        LinkedList.Node node2 = new LinkedList.Node(2);
        LinkedList.Node node3 = new LinkedList.Node(3);
        LinkedList.Node node4 = new LinkedList.Node(4);
        LinkedList.Node node5 = new LinkedList.Node(5);

        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        linkedList.insertIn(4, 8, node);

        assertThat(linkedList.get(4, node), is(8));
        assertThat(linkedList.get(5, node), is(4));
    }
}