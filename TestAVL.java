package avltree;

public class TestAVL {

	public static void main(String[] args) {
		 AVLTree<Integer> tree = new AVLTree<>();

	        System.out.println("Insertando nodos...");

	        tree.insert(30);
	        tree.drawBST();
	        tree.insert(20);
	        tree.drawBST();
	        tree.insert(10);  // RSR
	        tree.drawBST();
	        
	        tree.insert(40);
	        tree.drawBST();
	        tree.insert(50);  // RSL
	        tree.drawBST();
	        
	        tree.insert(5);
	        tree.drawBST();
	        tree.insert(8);   // RDL
	        tree.drawBST();
	        
	        tree.insert(60);
	        tree.drawBST();
	        tree.insert(55);  // RDR
	        tree.drawBST();

	        System.out.println("\nEliminando nodos...");

	        tree.delete(8);   // No rotación
	        tree.drawBST();
	        tree.delete(55);  // RSL
	        tree.drawBST();

	        System.out.println("\nRecorrido BFS:");
	        tree.bfsRecursive();

	        System.out.println("\nRecorrido Preorden:");
	        tree.preOrder();
	    }
	}
