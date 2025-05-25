package avltree;

public class BSTree<E extends Comparable<E>> {
	protected static class Node<E> {
		protected E data;
		protected Node<E> left, right;

		public Node(E data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		@Override
		public String toString() {
			return data.toString();
		}
	}

	protected Node<E> root;

	public BSTree() {
		root = null;
	}

	public void insert(E data) {
		root = insert(root, data);
	}

	protected Node<E> insert(Node<E> node, E data) {
		if (node == null) {
			return new Node<>(data);
		}
		int cmp = data.compareTo(node.data);
		if (cmp < 0) {
			node.left = insert(node.left, data);
		} else if (cmp > 0) {
			node.right = insert(node.right, data);
		}
		return node;
	}

	public boolean search(E data) {
		return search(root, data);
	}

	protected boolean search(Node<E> node, E data) {
		if (node == null)
			return false;
		int cmp = data.compareTo(node.data);
		if (cmp < 0)
			return search(node.left, data);
		else if (cmp > 0)
			return search(node.right, data);
		else
			return true;
	}

	public int height() {
		return height(root);
	}

	protected int height(Node<E> node) {
		if (node == null)
			return -1;
		return 1 + Math.max(height(node.left), height(node.right));
	}
} 

