package com.company.Interface;

public interface IAVLTree<T> {

	void insert(T key);
	boolean delete(T key);
	boolean search(T key);
	int height();
	INode<T> getTree();
}
