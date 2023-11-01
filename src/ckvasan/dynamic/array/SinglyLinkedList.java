package ckvasan.dynamic.array;

import java.util.Iterator;

public class SinglyLinkedList<T> implements Iterable<T> {

	Node<T> head;
	Node<T> tail;

	public void add(T e) {
		addLast(e);

	}

	public void addLast(T e) {
		if (head == null) {
			Node<T> newNode = new Node();
			newNode.data = e;
			newNode.next = null;
			this.head = newNode;
			this.tail = newNode;
		} else {
			Node<T> newNode = new Node();
			newNode.data = e;
			newNode.next = null;
			this.tail.next = newNode;
			this.tail = newNode;
		}

	}

	public void addfist(T e) {
		if (head == null) {
			Node<T> newNode = new Node();
			newNode.data = e;
			newNode.next = null;
			this.head = newNode;
			this.tail = newNode;
		} else {
			Node<T> newNode = new Node();
			newNode.data = e;
			newNode.next = this.head;
			this.head = newNode;
		}

	}

	public T peek() {
		return this.head.data;
	}

	public T remove(T e) {
		Node<T> trav1 = this.head;
		T t = null;
		if (trav1.data == e) {
			this.head = trav1.next;
			t = trav1.data;
			trav1 = null;
			return t;
		}

		Node<T> trav2 = this.head.next;

		while (true) {
			if (trav2.data != e) {
				trav1 = trav2;
				trav2 = trav2.next;
			} else {
				trav1.next = trav2.next;
				t = trav2.data;
				break;
			}
		}

		return t;
	}

	public T removeLast() {
		return remove(this.tail.data);

	}

	public T removeFirst() {
		return remove(this.head.data);

	}

	public void insert(int pos, T e) {
		// Assuming head position is at 1;
		int i = 1;
		if (i == pos) {
			addfist(e);
			return;
		}
		i++;
		Node<T> trav1 = this.head;
		Node<T> trav2 = this.head.next;
		while (true) {
			if (i == pos) {
				Node<T> newNode = new Node();
				newNode.data = e;
				trav1.next = newNode;
				newNode.next = trav2;
				return;
			} else {
				i++;
				trav1 = trav2;
				trav2 = trav2.next;
			}

		}
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {

			Node<T> ele = head;

			@Override
			public boolean hasNext() {
				if (ele == null) {
					return false;
				} else {
					ele = ele.next;
					return true;
				}

			}

			@Override
			public T next() {

				return ele.data;
			}
		};
	}
}

class Node<T> {
	T data;
	Node<T> next;

}
