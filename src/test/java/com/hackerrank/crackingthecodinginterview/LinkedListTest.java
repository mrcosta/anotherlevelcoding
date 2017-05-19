package com.hackerrank.crackingthecodinginterview;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class LinkedListTest {

    @Test
    public void shouldReturnFalseIfThereIsNoCycleInLinkedList() {
        LinkedList linkedList = new LinkedList();
        assertThat(linkedList.hasCycle(new LinkedList.Node()), is(false));
    }

    @Test
    public void shouldReturnTrueIfThereIsACycleInLinkedList() {
        LinkedList linkedList = new LinkedList();
        LinkedList.Node head = new LinkedList.Node();
        LinkedList.Node next = new LinkedList.Node();
        head.next = next;
        next.next = head;
        assertThat(linkedList.hasCycle(head), is(true));
    }
}