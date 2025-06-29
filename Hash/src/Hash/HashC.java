package Hash;

public class HashC {
	private static class Element {
		Register register;
		boolean isAvailable;

		public Element() {
			this.register = null;
			this.isAvailable = true;
		}
	}

	private Element[] table;
	private int size;

	public HashC(int size) {
		this.size = size;
		this.table = new Element[size];

		for (int i = 0; i < size; i++) {
			table[i] = new Element();
		}
	}

	private int hash(int key) {
		return key % size;
	}

	public void insert(Register reg) {
		int index = hash(reg.getKey());
		int originalIndex = index;
		boolean inserted = false;
		boolean tableFull = true;

		do {
			if (table[index].isAvailable
					|| (table[index].register != null && table[index].register.getKey() == reg.getKey())) {

				table[index].register = reg;
				table[index].isAvailable = false;
				inserted = true;
				tableFull = false;
				break;
			}
			index = (index + 1) % size;
		} while (index != originalIndex);

		if (tableFull) {
			System.out.println("Error: La tabla hash está llena. No se puede insertar el registro " + reg);
		}
	}

	public Register search(int key) {
		int index = hash(key);
		int originalIndex = index;

		do {
			if (!table[index].isAvailable && table[index].register != null && table[index].register.getKey() == key) {
				return table[index].register;
			}
			if (table[index].isAvailable && table[index].register == null) {
				return null;
			}
			index = (index + 1) % size;
		} while (index != originalIndex);

		return null;
	}

	public void delete(int key) {
		int index = hash(key);
		int originalIndex = index;

		do {
			if (!table[index].isAvailable && table[index].register != null && table[index].register.getKey() == key) {

				table[index].isAvailable = true;
				System.out.println("Registro con clave " + key + " eliminado lógicamente.");
				return;
			}
			if (table[index].isAvailable && table[index].register == null) {
				break;
			}
			index = (index + 1) % size;
		} while (index != originalIndex);

		System.out.println("Registro con clave " + key + " no encontrado para eliminar.");
	}

	public void printTable() {
		System.out.println("Estado actual de la tabla hash:");
		for (int i = 0; i < size; i++) {
			if (table[i].register != null && !table[i].isAvailable) {
				System.out.println("Índice " + i + ": " + table[i].register);
			} else if (table[i].isAvailable && table[i].register != null) {
				System.out.println("Índice " + i + ": " + table[i].register + " (eliminado lógicamente)");
			} else {
				System.out.println("Índice " + i + ": Vacío");
			}
		}
		System.out.println();
	}
}
