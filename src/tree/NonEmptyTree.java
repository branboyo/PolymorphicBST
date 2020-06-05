package tree;

import java.util.Collection;

/**
 * This class represents a non-empty search tree. An instance of this class
 * should contain:
 * <ul>
 * <li>A key
 * <li>A value (that the key maps to)
 * <li>A reference to a left Tree that contains key:value pairs such that the
 * keys in the left Tree are less than the key stored in this tree node.
 * <li>A reference to a right Tree that contains key:value pairs such that the
 * keys in the right Tree are greater than the key stored in this tree node.
 * </ul>
 * 
 */
public class NonEmptyTree<K extends Comparable<K>, V> implements Tree<K, V> {
	K key;
	V value;
	Tree<K, V> left, right;
	/* Provide whatever instance variables you need */

	/**
	 * Only constructor we need.
	 * 
	 * @param key
	 * @param value
	 * @param left
	 * @param right
	 */
	public NonEmptyTree(K key, V value, Tree<K, V> left, Tree<K, V> right) {
		this.key = key;
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public V search(K key) {
		if (key.equals(this.key)) {
			return this.value;
		} else if (key.compareTo(this.key) < 0) {
			return left.search(key);
		} else {
			return right.search(key);
		}
	}

	public NonEmptyTree<K, V> insert(K key, V value) {
		if (key.compareTo(this.key) == 0) {
			this.value = value;
			return this;
		} else if (key.compareTo(this.key) < 0) {
			left = left.insert(key, value);
			return this;
		} else {
			right = right.insert(key, value);
			return this;
		}

	}

	public Tree<K, V> delete(K key) {
		if(this.key.compareTo(key)==0) {
			try {
				value = search(left.max());
				this.key = left.max();
				left =  left.delete(this.key);
				
				
			} catch (TreeIsEmptyException e) {
				try {
					value = search(right.max());
					this.key = right.max();
					right =  right.delete(this.key);
					
				} catch (TreeIsEmptyException e2) {
					return left.delete(this.key);
				}
			}
		} else if (this.key.compareTo(key) < 0) {
			right = right.delete(key);
		} else {
			left = left.delete(key);
		}
		return this;
	}

	public K max() {
		try {
			return right.max();
		} catch (TreeIsEmptyException e) {
			return this.key;
		}
	}

	public K min() {
		try {
			return left.min();
		} catch (TreeIsEmptyException e) {
			return this.key;
		}
	}

	public int size() {
		return 1 + left.size() + right.size();
	}

	public void addKeysToCollection(Collection<K> c) {
		c.add(this.key);
		left.addKeysToCollection(c);
		right.addKeysToCollection(c);
	}

	public Tree<K, V> subTree(K fromKey, K toKey) {
//test by traversing the whole tree instead
		if (this.key.compareTo(fromKey) < 0) {
			return right.subTree(fromKey, toKey);
		} else if (this.key.compareTo(toKey) > 0) {
			return left.subTree(fromKey, toKey);
		} else {
			return new NonEmptyTree(key, value, this.left.subTree(fromKey, toKey), this.right.subTree(fromKey, toKey));
		}
	}

	public int height() {
		int rheight = right.height();
		int lheight = left.height();
		return rheight >= lheight ? rheight + 1 : lheight + 1;
	}

	public void inorderTraversal(TraversalTask<K, V> p) {

		left.inorderTraversal(p);
		p.performTask(key, value);
		right.inorderTraversal(p);

	}

	public void rightRootLeftTraversal(TraversalTask<K, V> p) {
		right.rightRootLeftTraversal(p);
		p.performTask(key, value);
		left.rightRootLeftTraversal(p);
	}
}