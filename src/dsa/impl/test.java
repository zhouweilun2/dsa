package dsa.impl;

import dsa.iface.IBinarySearchTree;
import dsa.impl.AVLTree.AVLPosition;

public class test {   
	public static void main( String[] args ) {
		
		IBinarySearchTree<Integer> t1 = new AVLTree<>();
		t1.insert(2);
		t1.insert(5);
		t1.insert(1);
		t1.insert(6);
		
		
		
		
		
	      TreePrinter.printTree( t1 );
}
}
