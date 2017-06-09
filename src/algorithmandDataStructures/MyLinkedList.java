package algorithmandDataStructures;

public class MyLinkedList {
	private Node head;

	public int size() {
		int n = 0;
		Node current = this.head;
		while (current != null) {
			n++;
			current = current.next;
		}
		return n;
	}

	public Object get(int idx) {
		if (idx < 0 || idx > this.size()) {
			throw new IndexOutOfBoundsException();
		}
		int n = 0;
		Node current = this.head;
		while (current != null) {
			if (n == idx) {
				return current.val;
			}
			n++;
			current = current.next;
		}
		System.out.println("Invalid index entered.");
		throw new IndexOutOfBoundsException();
	}

	public void insert(int idx, Object obj) {
		if (idx < 0 || idx > this.size()) {
			System.out.println("Invalid index entered.");
			throw new IndexOutOfBoundsException();
		}
		Node insertNode = new Node();

		if (idx == 0) {
			insertNode.val = obj;
			insertNode.next = this.head;
			this.head = insertNode;
			return;
		}

		Node current = this.head;
		Node prev = null;
		int counter = 0;
		if (idx == this.size()) {
			this.append(obj);
		} else {
			while (counter <= idx) {
				if (counter == idx) {
					insertNode.next = current;
					insertNode.val = obj;
					prev.next = insertNode;
				}
				prev = current;
				current = current.next;
				counter++;
			}
		}
	}

	public void set(int idx, Object o) {
		if (idx < 0) {
			System.out.println("Invalid index entered.");
			throw new IndexOutOfBoundsException();
		}

		int n = 0;
		Node current = this.head;
		while (current != null) {
			if (n == idx) {
				current.val = o;
				return;
			}
			n++;
			current = current.next;
		}
		System.out.println("Invalid index entered.");
		throw new IndexOutOfBoundsException();
	}

	public void remove(int idx) {
		if (idx < 0 || idx > this.size()) {
			System.out.println("Invalid index entered.");
			throw new IndexOutOfBoundsException();
		}

		if (idx == 0) {
			this.head = this.head.next;
			return;
		} else {

			int n = 0;
			Node prev = null;
			Node current = this.head;
			while (current != null) {
				if (n == idx) {
					prev.next = current.next;
					return;
				}
				n++;
				prev = current;
				current = current.next;

			}
		}

	}

	public int append(Object o) {
		if (this.head == null) {
			this.head = new Node();
			this.head.val = o;
			return 1;
		}
		int n = 1;
		Node current = this.head;
		Node prev = null;
		while (current != null) {
			n++;
			prev = current;
			current = current.next;
		}
		prev.next = new Node();
		prev.next.val = o;
		return n;
	}

	public static void main(String[] args) {
		MyLinkedList list = new MyLinkedList();
		// list.insert(-1, "Bad LowIndex");
		// list.insert(100, "Bad HighIndex");
		list.insert(0, "InsertatZeroOk");
		// list.insert(1, "InsertAtEnd");
		// list.insert(100, "InsertPastEnd");
		// list.set(-1, "Bad LowSetIndex");
		// list.set(100, "Bad HighSetIndex");
		list.set(0, "Set ZeroOK");
		list.append("hi");
		list.append("yo");
		list.append("bye");
		list.append("here");
		list.set(3, "au revoir");
		list.insert(4, "Glen");
		// list.remove(-1);
		// list.remove(100);
		list.remove(5);
		list.remove(0);

		int size = list.size();
		System.out.println("Size of linked list = " + size);
		for (int idx = 0; idx < size; idx++) {
			System.out.println(list.get(idx));
		}
	}

}

class Node {
	public Object val;
	public Node next;
}
