package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import _AVLTree.AVLTree;
import dictionaryIf.IDictionary;

public class Dictionary implements IDictionary {

	private int size;
	private AVLTree<String> dicTree;

	public Dictionary() {
		// TODO Auto-generated constructor stub
		size = 0;
		dicTree = new AVLTree<>(false);
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public void load(File file) {
		// TODO Auto-generated method stub
		Scanner scan = null;
		try {
			scan = new Scanner(file);
			while (scan.hasNext()) {
				insert(scan.next());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File Not Found");
		} finally {
			scan.close();
		}

	}

	@Override
	public boolean insert(String word) {
		// TODO Auto-generated method stub
		dicTree.insert(word);
		if (dicTree.getDoneMsg()) {
			size++;
		} else {
			System.out.println("ERROR: Word already in the dictionary!");
		}
		return dicTree.getDoneMsg();
	}

	@Override
	public boolean exists(String word) {
		// TODO Auto-generated method stub
		return dicTree.search(word);
	}

	@Override
	public boolean delete(String word) {
		// TODO Auto-generated method stub
		dicTree.delete(word);
		if (dicTree.getDoneMsg()) {
			size--;
		}
		return dicTree.getDoneMsg();
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return getSize();
	}

	@Override
	public int height() {
		// TODO Auto-generated method stub
		return dicTree.height();
	}

}
