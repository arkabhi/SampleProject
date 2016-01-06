package com;

import junit.framework.TestCase;

public class NewStringBufferTest extends TestCase {

	public void testAppend() {
		NewStringBuffer buf = new NewStringBuffer();
		// check for empty string
		assertEquals("", buf.toString());

		// Check single char append
		buf.append("a");
		assertEquals("a", buf.toString());

		// Check append beyond capacity
		buf.append("bcdefghijklmnopqrst");
		assertEquals("abcdefghijklmnopqrst", buf.toString());

		// Check the length
		assertEquals(20, buf.getLength());

		int len = buf.getLength();

		StringBuffer defaultBuffer = new StringBuffer(buf.toString());
		while (len < 1000000) {
			buf.append("+");

			defaultBuffer.append("+");
			len++;
		}

		assertEquals(defaultBuffer.toString(), buf.toString());
		assertEquals(len, buf.getLength());
	}

	// Test the capacity constructor flow
	public void testNewStringBufferInt() {
		NewStringBuffer strBuf = new NewStringBuffer(10);
		assertEquals(0, strBuf.getLength());

		// Basic case for initial capacity flow
		strBuf.append("qwerty");
		assertEquals("qwerty", strBuf.toString());
		assertEquals(6, strBuf.getLength());

		// Corner case, same as the capactiy
		strBuf.append("qwerty");
		assertEquals("qwertyqwerty", strBuf.toString());
		assertEquals(12, strBuf.getLength());

		// For the capacity flow, testing the beyond capactiy
		strBuf.append("qwerty");
		assertEquals("qwertyqwertyqwerty", strBuf.toString());
		assertEquals(18, strBuf.getLength());

	}
}
