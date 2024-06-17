import java.util.Scanner;

public class Q1 {

	public static boolean Q2(List<Integer> l) {
		Node<Integer> pos = l.getFirst();
		int sum = 0;
		while (pos != null && pos.getNext() != null) {
			System.out.println("the sum is: " + sum);
			System.out.println("the data of the current node is: " + pos.getData());
			System.out.println("the data of the next node is: " + pos.getNext().getData());
			System.out.println("---------------");
			if ((pos.getData() + sum) != pos.getNext().getData()) {
				return false;
			}
			sum += pos.getData();
			pos = pos.getNext();
		}
		return true;
	}

	public static boolean Q1(List<Integer> l) {
		Node<Integer> pos = l.getFirst();
		int sum = pos.getData();
		while (pos != null && pos.getNext() != null) {
			System.out.println("the sum is: " + sum);
			System.out.println("the current data is: " + pos.getData());
			System.out.println("the data for next node is: " + pos.getNext().getData());
			System.out.println("------------------");
			if (pos.getData() / 2 != pos.getNext().getData()) {
				return false;
			} else {
				sum -= pos.getNext().getData();
			}
			if (sum != 0 && pos == null) {
				return false;
			}
			pos = pos.getNext();
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		List<Integer> l = new List<Integer>();
		l.insert(null, 1);
		l.insert(null, 2);
		l.insert(null, 4);
		l.insert(null, 8);
		l.insert(null, 16);
		l.insert(null, 32);
		boolean res = Q1(l);
//      System.out.println(res);
		List<Integer> l2 = new List<Integer>();
		l2.insert(null, 32);
		l2.insert(null, 1);
		l2.insert(null, 8);
		l2.insert(null, 4);
		l2.insert(null, 2);
		l2.insert(null, 1);
		System.out.println(Q2(l2));

		// Testing the Memory class
		Memory memory = new Memory(1000);
		memory.printMemory();
		memory.search(100);
		memory.printMemory();
		memory.free(100);
		memory.printMemory();
	}
}
