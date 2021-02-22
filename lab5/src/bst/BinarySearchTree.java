package bst;

import java.util.ArrayList;
import java.util.Comparator;


public class BinarySearchTree<E> {
  BinaryNode<E> root;  // Används också i BSTVisaulizer
  int size;            // Används också i BSTVisaulizer
  private Comparator<E> comparator;
    
	/**
	 * Constructs an empty binary search tree.
	 */
	public BinarySearchTree() {
		this.size = 0;
		this.root = null;
		this.comparator = (a,b) -> ((Comparable<E>) a).compareTo(b);
	}
	
	/**
	 * Constructs an empty binary search tree, sorted according to the specified comparator.
	 */
	public BinarySearchTree(Comparator<E> comparator) {
		this.comparator = comparator;
		this.size = 0;
		this.root = null;
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		if (root == null) {
			root = new BinaryNode<E>(x);
			this.size+=1;
			return true;
		} else {
			return recAdd(x, root);
		}
	}
	private boolean recAdd(E x, BinaryNode<E> node) {
		if (x.equals(node.element)) {
			return false;
		} else if (comparator.compare(x, node.element)<0) {
			if (node.left!=null) {
				return recAdd(x,node.left);
			} else {
				node.left = new BinaryNode<E>(x);
				this.size+=1;
				return true;
			}
			
		} else {
			if (node.right!=null) {
				return recAdd(x,node.right);
			} else {
				node.right = new BinaryNode<E>(x);
				this.size+=1;
				return true;
			}
		} 
	}
	
	/**
	 * Computes the height of tree.
	 * @return the height of the tree
	 */
	public int height() {
		return recHeight(root);		
	}
	
	private int recHeight(BinaryNode<E> node) {
		if (node==null) {
			return 0;
		} else {
			return 1 + Math.max(recHeight(node.left), recHeight(node.right));
		}
	}
	
	/**
	 * Returns the number of elements in this tree.
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Removes all of the elements from this list.
	 */
	public void clear() {
		this.root=null;
	}
	
	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		if (root==null) {
			System.out.println("Empty");
		} else {
			recPrintTree(root);
		}
	}
	private void recPrintTree(BinaryNode<E> node) {
		if (node!=null) {
			recPrintTree(node.left);
			System.out.println(node.element);
			recPrintTree(node.right);
		}
	}

	/** 
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {

	}
	
	/*
	 * Adds all elements from the tree rooted at n in inorder to the list sorted.
	 */
	private void toArray(BinaryNode<E> n, ArrayList<E> sorted) {
	
	}
	
	/*
	 * Builds a complete tree from the elements from position first to 
	 * last in the list sorted.
	 * Elements in the list a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(ArrayList<E> sorted, int first, int last) {
		return null;
	}
	


	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
			this.left = null;
			this.right = null;
		}	
	}
}
