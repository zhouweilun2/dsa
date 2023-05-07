package dsa.impl;

import dsa.iface.IPosition;
public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {
	
   public boolean insert(T element) {
	    if (element == null) {
	        throw new IllegalArgumentException("Cannot insert null value");
	    }
	    boolean test=super.insert(element);
	    IPosition<T> position=this.find(root, element);
	   updateHeight(position);
	   while (isBalanced(position)) {
		   if (parent(position)==null) {
			   break;
		   }
		   position=parent(position);
		  
	   }
	   if (!isBalanced(position)) {
		   restructure(position);}
      return test;
      }

   private void updateHeight(IPosition<T> position) {
	   if (position == null) return;
		int leftHeight;
		  if (hasLeft(position)==false) {
		      leftHeight = 0;
		  } else {
		      leftHeight = ((AVLPosition)(left(position))).height;
		  }
		  int rightHeight;
		  if (hasRight(position)==false) {
		      rightHeight = 0;
		  } else {
		      rightHeight = ((AVLPosition)(right(position))).height;
		  }	   
		  ((AVLPosition)position).height=(1 + Math.max(leftHeight, rightHeight));
		  IPosition<T> parent = parent(position);
		  updateHeight(parent);
   }
   private boolean isBalanced(IPosition<T> position) {
	   if (position==null) {
		   return true;
	   }
	    int balanceFactor = ((AVLPosition)(right(position))).height -((AVLPosition)(left(position))).height;
	    return balanceFactor == -1 || balanceFactor == 0 || balanceFactor == 1;
	}


@Override
   public boolean contains( T element ) {
	boolean test = super.contains(element);
      // TODO: Implement the contains(...) method.
      return test; // this line is here just so that the class will compile. You should replace it.
      
   }

   @Override
   public boolean remove(T element ) {
	   if (element == null) {
	        throw new IllegalArgumentException("Cannot remove null value");
	    }
	   IPosition<T> position=this.find(root, element);
	   boolean test = super.remove(element);
	   updateHeight(position);
	   while (isBalanced(position)) {
		   if (parent(position)==null) {
			   break;
		   }
		   position=parent(position);
		  
	   }
	   if (!isBalanced(position)) {
		   restructure(position);}
	   return test;
      // TODO: Implement the remove(...) method.
 // this line is here just so that the class will compile. You should replace it.
      
      
   }

   private void restructure(IPosition<T> x) {
	    if ((((AVLPosition)left(x)).height)> (((AVLPosition)right(x)).height)) {
	        if ((((AVLPosition)left(x)).height)> (((AVLPosition)right(x)).height)) {
	        	LLRotate((AVLTree<T>.AVLPosition) x);
	        }
	        else {
	        	LRRotate((AVLTree<T>.AVLPosition) x);
	        }
	    }
	    else{
	    	if ((((AVLPosition)left(left(x))).height)> (((AVLPosition)left(right(x))).height)) {
	    		RLRotate((AVLTree<T>.AVLPosition) x);
	    	}
	    	else {
	    		RRRotate((AVLTree<T>.AVLPosition) x);
	    	}
	    	
	    }
	}

	private AVLTree<T>.AVLPosition LRRotate(AVLPosition x) {
		x.left=RRRotate(x.left);
		x=LLRotate(x);
		return x;
	
}
	private AVLTree<T>.AVLPosition RLRotate(AVLPosition x) {
		x.right=LLRotate(x.right);
		x=RRRotate(x);
		return x;
	
}

	private AVLTree<T>.AVLPosition LLRotate(AVLPosition x) {
		AVLPosition temp=(AVLTree<T>.AVLPosition) left(x);
		x.left=(AVLTree<T>.AVLPosition) right(left(x));
		temp.right=x;
		x.left.parent=x;
		x.parent =temp;
		updateHeight(x); 
		updateHeight(temp);
		return temp;
}
	private AVLTree<T>.AVLPosition RRRotate(AVLPosition x) {
		AVLPosition temp=(AVLTree<T>.AVLPosition) right(x);
		x.right=(AVLTree<T>.AVLPosition) left(right(x));
		temp.left=x;
		x.right.parent=x;
		x.parent=temp;
		updateHeight(x);
		updateHeight(temp);
		return temp;
		
	}

   protected BTPosition newPosition( T element, BTPosition parent ) {
      return new AVLPosition( element, parent );
   }

   /**
    * Define a subclass of BTPosition so that we can also store the height
    *    of each position in its object.
    *
    * This will be more efficient than calculating the height every time
    *    we need it, but we will need to update heights whenever we change
    *    the structure of the tree.
    */
   public class AVLPosition extends BTPosition {
      // store the height of this position, so that we can test for balance
      public int height = 0;
      public AVLPosition left;
      public AVLPosition right;
      public AVLPosition parent;
      
      /**
       * Constructor - create a new AVL node
       * @param element The element to store in the node.
       * @param parent The parent node of this node (or {@code null} if this is the root)
       */
      public AVLPosition( T element, BTPosition parent ) {
         super( element, parent );
      }
   }
}
