package com.company.Interface;

public interface INode<T> extends Comparable<T> {

	INode<T> getLeftChild();
	INode<T> getRightChild();
	T getValue();

	void setValue(T value);
}

