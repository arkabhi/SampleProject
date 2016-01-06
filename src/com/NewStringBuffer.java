package com;

public class NewStringBuffer {
	private int capacity = 5;
	private char[] strArray;
	private int length;

	public NewStringBuffer(int capacity) {
		this.capacity = capacity;
		strArray = new char[capacity];
	}

	public NewStringBuffer() {
		// TODO Auto-generated constructor stub
		strArray = new char[capacity];
	}

	@Override
	public String toString() {
		return new String(strArray, 0, length);
	}

	// synchronized to enable thread safety
	public synchronized NewStringBuffer append(String suffix) {

		int newLength = length + suffix.length();
		int index = length;

		// only when there is an overflow, resizing of the array is required
		if (newLength > capacity) {
			while (newLength > capacity) {
				capacity = 2 * capacity;
			}
			char[] newArr = new char[capacity];

			for (index = 0; index < length; index++) {
				newArr[index] = strArray[index];
			}
			strArray = newArr;
		}

		for (char c : suffix.toCharArray()) {
			strArray[index++] = c;
		}

		length = newLength;
		return this;
	}

	public int getLength() {
		return length;
	}
}
