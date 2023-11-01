package ckvasan.dynamic.array;

import java.util.Iterator;

public class ArrayList<T> implements Iterable<T> {

	int capacity;
	int size;
	T arr[];

	public ArrayList() {
		this(10);

	}

	public ArrayList(int capacity) {
		this.capacity = capacity;
		arr = (T[]) new Object[this.capacity];
	}

	public void add(T e) {
		if (size == capacity) {
			this.capacity = this.capacity * 2;
			T[] newArr = (T[]) new Object[this.capacity];
			for (int i = 0; i < arr.length; i++) {
				newArr[i] = arr[i];
			}
			arr = newArr;
		}
		arr[size] = e;
		size++;
	}

	public T remove(int index) {
		T t = null;
		if (index >= size)
			throw new IndexOutOfBoundsException("Array size " + size);
		T[] newArr = (T[]) new Object[this.capacity];
		for (int i = 0, j = 0; i < arr.length; i++, j++) {
			if (i != index) {
				newArr[j] = arr[i];
			} else {
				t = arr[i];
				j--;
			}
		}
		arr = newArr;
		size--;
		return t;
	}
	
	public T remove(T e)
	{
		if (indexOf(e) == -1)
			throw new IllegalArgumentException("The item is not present in the list"+ e);
		return remove(indexOf(e));
		
	}

	public int indexOf(T e) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == e)
				return i;
		}
		return -1;
	}
	
	public int lastIndexOf(T e) {
		for (int i = (arr.length -1); i >= 0 ; i--) {
			if (arr[i] == e)
				return i;
		}
		return -1;
	}

	public boolean contains(T e) {
		return indexOf(e) != -1;
	}

	public T get(int i) {
		return arr[i];
	}

	public boolean isEmpty() {
		return arr.length == 0;
	}

	public int size() {
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<T>() {
			int index= -1;
			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				index++;
				return arr[index] != null;
				
			}

			@Override
			public T next() {
				// TODO Auto-generated method stub
				return arr[index];
			}
		};
	}
}
