package avltree;


public class AVLTree<E extends Comparable<E>> extends BSTree<E> {

	class NodeAVL extends Node<E> {
		protected int bf;

		public NodeAVL(E data) {
			super(data);
			this.bf = 0;
		}

		public String toString() {
			return super.toString() + " (BF: " + bf + ")";
		}
	}

	private boolean height;

	public AVLTree() {
		super();
		this.height = false;
	}
	
	public void insert(E data) {
        root = insertAVL((NodeAVL) root, data);
    }

    private NodeAVL insertAVL(NodeAVL node, E data) {
        if (node == null) {
            height = true;
            return new NodeAVL(data);
        }

        int cmp = data.compareTo(node.data);

        if (cmp < 0) { 
            node.left = insertAVL((NodeAVL) node.left, data);
            if (height) {
                switch (node.bf) {
                    case 1:
                        node.bf = 0;
                        height = false;
                        break;
                    case 0:
                        node.bf = -1;
                        break;
                    case -1:
                        node = balanceToRight(node);
                        height = false;
                        break;
                }
            }
        } else if (cmp > 0) { // Insertar por la derecha
            node.right = insertAVL((NodeAVL) node.right, data);
            if (height) {
                switch (node.bf) {
                    case -1:
                        node.bf = 0;
                        height = false;
                        break;
                    case 0:
                        node.bf = 1;
                        break;
                    case 1:
                        node = balanceToLeft(node);
                        height = false;
                        break;
                }
            }
        } else {
            System.out.println("Elemento duplicado: " + data);
            height = false;
        }

        return node;
    }

    private NodeAVL balanceToLeft(NodeAVL node) {
        NodeAVL rightChild = (NodeAVL) node.right;
        switch (rightChild.bf) {
            case 1:
                node.bf = 0;
                rightChild.bf = 0;
                node = rotateSL(node);
                break;
            case -1:
                NodeAVL grandChild = (NodeAVL) rightChild.left;
                switch (grandChild.bf) {
                    case -1:
                        node.bf = 0;
                        rightChild.bf = 1;
                        break;
                    case 0:
                        node.bf = 0;
                        rightChild.bf = 0;
                        break;
                    case 1:
                        node.bf = 1;
                        rightChild.bf = 0;
                        break;
                }
                grandChild.bf = 0;
                node.right = rotateSR(rightChild);
                node = rotateSL(node);
        }
        return node;
    }

    private NodeAVL balanceToRight(NodeAVL node) {
        NodeAVL leftChild = (NodeAVL) node.left;
        switch (leftChild.bf) {
            case -1:
                node.bf = 0;
                leftChild.bf = 0;
                node = rotateSR(node);
                break;
            case 1:
                NodeAVL grandChild = (NodeAVL) leftChild.right;
                switch (grandChild.bf) {
                    case 1:
                        node.bf = 0;
                        leftChild.bf = -1;
                        break;
                    case 0:
                        node.bf = 0;
                        leftChild.bf = 0;
                        break;
                    case -1:
                        node.bf = -1;
                        leftChild.bf = 0;
                        break;
                }
                grandChild.bf = 0;
                node.left = rotateSL(leftChild);
                node = rotateSR(node);
        }
        return node;
    }

    private NodeAVL rotateSL(NodeAVL node) {
        NodeAVL newRoot = (NodeAVL) node.right;
        node.right = newRoot.left;
        newRoot.left = node;
        return newRoot;
    }

    private NodeAVL rotateSR(NodeAVL node) {
        NodeAVL newRoot = (NodeAVL) node.left;
        node.left = newRoot.right;
        newRoot.right = node;
        return newRoot;
    }
    
	public void delete(E data) {
		root = deleteAVL((NodeAVL) root, data);
	}

	private NodeAVL deleteAVL(NodeAVL node, E data) {
		if (node == null) {
			System.out.println("Elemento no encontrado: " + data);
			height = false;
			return null;
		}

		int cmp = data.compareTo(node.data);

		if (cmp < 0) {
			node.left = deleteAVL((NodeAVL) node.left, data);
			if (height)
				node = adjustAfterLeftDelete(node);
		} else if (cmp > 0) {
			node.right = deleteAVL((NodeAVL) node.right, data);
			if (height)
				node = adjustAfterRightDelete(node);
		} else {

			if (node.left == null || node.right == null) {
				node = (NodeAVL) ((node.left != null) ? node.left : node.right);
				height = true;
			} else {

				NodeAVL successor = findMin((NodeAVL) node.right);
				node.data = successor.data;
				node.right = deleteAVL((NodeAVL) node.right, successor.data);
				if (height)
					node = adjustAfterRightDelete(node);
			}
		}

		return node;
	}

	private NodeAVL adjustAfterLeftDelete(NodeAVL node) {
		switch (node.bf) {
		case -1:
			node.bf = 0;
			break;
		case 0:
			node.bf = 1;
			height = false;
			break;
		case 1:
			NodeAVL rightChild = (NodeAVL) node.right;
			if (rightChild.bf >= 0) {
				node = rotateSL(node);
				if (rightChild.bf == 0) {
					node.bf = -1;
					((NodeAVL) node.left).bf = 1;
					height = false;
				} else {
					node.bf = 0;
					((NodeAVL) node.left).bf = 0;
				}
			} else {
				node = balanceToLeft(node);
			}
			break;
		}
		return node;
	}

	private NodeAVL adjustAfterRightDelete(NodeAVL node) {
		switch (node.bf) {
		case 1:
			node.bf = 0;
			break;
		case 0:
			node.bf = -1;
			height = false;
			break;
		case -1:
			NodeAVL leftChild = (NodeAVL) node.left;
			if (leftChild.bf <= 0) {
				node = rotateSR(node);
				if (leftChild.bf == 0) {
					node.bf = 1;
					((NodeAVL) node.right).bf = -1;
					height = false;
				} else {
					node.bf = 0;
					((NodeAVL) node.right).bf = 0;
				}
			} else {
				node = balanceToRight(node);
			}
			break;
		}
		return node;
	}

	private NodeAVL findMin(NodeAVL node) {
		while (node.left != null) {
			node = (NodeAVL) node.left;
		}
		return node;
	}
	
	public void bfsRecursive() {
		int h = height();
		for (int i = 0; i <= h; i++) {
			printLevel((NodeAVL) root, i);
		}
	}

	private void printLevel(NodeAVL node, int level) {
		if (node == null)
			return;
		if (level == 0) {
			System.out.print(node + " ");
		} else {
			printLevel((NodeAVL) node.left, level - 1);
			printLevel((NodeAVL) node.right, level - 1);
		}
	}
	
	public void preOrder() {
		preOrder((NodeAVL) root);
		System.out.println();
	}

	private void preOrder(NodeAVL node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		preOrder((NodeAVL) node.left);
		preOrder((NodeAVL) node.right);
	}
}
