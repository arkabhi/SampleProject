# SampleProject
Classes
NewStringBuffer - mimics the append and toString() functionality of the String Buffer
NewStringBufferTest - The Junit 3 compliant testcases

Algorithm:

Using a character array to represent the String
The array will have an initial size of 5
To make it mutable, the character array is resizable, that is the size will increase when required
The size of the array grows like 5, 10, 20 etc
The apppend method is synchromized to dissalow multiple threads asccessing it at once.



