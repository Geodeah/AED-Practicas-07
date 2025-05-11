package Lab06practica.ejercicio04;

public class Application {

	public static boolean symbolBalancing(String s) {
		StackLink<Character> stack = new StackLink<>();

		for (char ch : s.toCharArray()) {
			if (ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
			} else if (ch == ')' || ch == ']' || ch == '}') {
				if (stack.isEmpty()) return false;
				try {
					char top = stack.pop();
					if ((ch == ')' && top != '(') ||
							(ch == ']' && top != '[') ||
							(ch == '}' && top != '{')) {
						return false;
					}
				} catch (ExceptionIsEmpty e) {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}
}

