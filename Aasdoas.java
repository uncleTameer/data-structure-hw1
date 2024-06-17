public class Aasdoas {

	public static boolean Q3(List<Integer> l) {
		Node<Integer> pos = l.getFirst();
		int sum = 0;
		while (pos != null && pos.getNext() != null) {
			System.out.println("the sum is: " + sum);
			System.out.println("the data of the current node is:  " + pos.getData());
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

	public static void main(String[] args) {
		List<Integer> l2 = new List<Integer>();
		l2.insert(null, 32);
		l2.insert(null, 16);
		l2.insert(null, 8);
		l2.insert(null, 4);
		l2.insert(null, 2);
		l2.insert(null, 1);
		l2.insert(null, 1);

		System.out.println(Q3(l2));
	}

}
