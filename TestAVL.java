package avltree;

public class TestAVL {

	public static void main(String[] args) {
		AVLTree<Integer> tree = new AVLTree<>();

        // RSR (Rotación Simple Derecha)
        tree.insert(30);
        tree.insert(20);
        tree.insert(10); // Provoca RSR en 30

        // RSL (Rotación Simple Izquierda)
        tree.insert(40);
        tree.insert(50); // Provoca RSL en 30

        // RDR (Rotación Doble Derecha)
        tree.insert(5);
        tree.insert(8); // Provoca RDR en 10

        // RDL (Rotación Doble Izquierda)
        tree.insert(60);
        tree.insert(55); // Provoca RDL en 50

        System.out.println("\nÁrbol AVL construido con rotaciones:");
        print(tree.root, "");
    }

    // Método auxiliar para imprimir el árbol
    public static void print(Object nodeObj, String indent) {
        if (nodeObj == null) return;
        AVLTree.NodeAVL node = (AVLTree.NodeAVL) nodeObj;
        print(node.right, indent + "   ");
        System.out.println(indent + node);
        print(node.left, indent + "   ");
    }
}
