package eg.edu.alexu.csd.filestructure.test.avl;

import _AVLTree.*;
import _AVLTreeIf.*;
import dictionary.Dictionary;
import dictionaryIf.IDictionary;

public class TestRunner {

	public static IAVLTree getImplementationInstance() {
		return new AVLTree<>(false);
	}

	public static IDictionary getDicImplementationInstance() {
		return new Dictionary();
	}

}
