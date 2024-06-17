public class Memory {
	private Node<Data> start;

	public Memory(int totalSize) {
		this.start = new Node<Data>(new Data(totalSize));
	}

	public boolean memoryFree() {
		return start.getData().isFree();
	}

	public boolean isDanger() {
		int totalSize = start.getData().getSize();
		int freeSize = 0;
		Node<Data> pos = start;
		while (pos != null) {
			if (pos.getData().isFree()) {
				freeSize += pos.getData().getSize();
			}
			pos = pos.getNext();
		}
		return freeSize < 0.1 * totalSize;
	}

	public void search(int num) {
		if (isDanger()) {
			System.out.println("Memory is in a dangerous state. Cannot allocate.");
			return;
		}
		Node<Data> pos = start;
		while (pos != null) {
			if (pos.getData().isFree() && pos.getData().getSize() >= num) {
				allocate(pos, num);
				return;
			}
			pos = pos.getNext();
		}
		System.out.println("No suitable memory block found.");
	}

	private void allocate(Node<Data> pos, int num) {
		Data data = pos.getData();
		data.setFree(false);
		if (data.getSize() > num) {
			int remainingSize = data.getSize() - num;
			data.setSize(num);
			Node<Data> newNode = new Node<>(new Data(remainingSize));
			newNode.setNext(pos.getNext());
			pos.setNext(newNode);
		}
		System.out.println("Memory block allocated.");
	}

	public void free(int num) {
		Node<Data> pos = start;
		while (pos != null) {
			if (pos.getData().getSize() == num && !pos.getData().isFree()) {
				pos.getData().setFree(true);
				System.out.println("Memory block freed.");
				return;
			}
			pos = pos.getNext();
		}
		System.out.println("Memory block not found or already free.");
	}

	public void printMemory() {
		Node<Data> pos = start;
		while (pos != null) {
			System.out.println("Size: " + pos.getData().getSize() + ", Free: " + pos.getData().isFree());
			pos = pos.getNext();
		}
	}
}
