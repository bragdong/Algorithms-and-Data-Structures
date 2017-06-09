package algorithmandDataStructures;

public class Stack {  //LIFO or FILO implementation i.e. like a stack of plates

	private int[] items;
	private int count;

	public Stack() {
		// constructor
		this.items = new int[5];
		this.count = 0;
	}

	public int count() {
		return this.count;
	}

	public void push(int val) {
		if (this.count >= this.items.length) { // check to see if we need to
													// copy to bigger array
			int[] newArr = new int[this.items.length * 2];
			for (int i = 0; i < this.count; i++) {
				newArr[i] = this.items[i];
			}
			this.items = newArr;
		}
		this.items[this.count] = val;
		System.out.println("pushed "+val+" onto the stack.");
		this.count++;
		return;
	}

	public int pop() {
		if (this.count <= 0) {
			throw new RuntimeException("Stack is empty. There is nothing to pop.");
		}
		this.count--;
		System.out.println("Popping "+this.items[this.count]+" off the stack.");
		return this.items[this.count];
	}

	public static void main(String[] args) {
		Stack st;
		st = new Stack();
		System.out.println("Stack size = " + st.count());
		System.out.println("Current stack capacity = " + st.items.length);
		// test empty stack
		// System.out.println(st.pop());
		// test push
		st.push(-1);
		st.push(976);
		st.push(0);
		st.push(25);
		st.push(10);
		System.out.println("Stack size = " + st.count());
		System.out.println("Current stack capacity = " + st.items.length);
		// test increasing stack capacity
		st.push(7);
		System.out.println("Stack size = " + st.count());
		System.out.println("Current stack capacity = " + st.items.length);
		// test pop
		st.pop();
		st.pop();
		st.pop();
		st.pop();
		System.out.println("Stack size = " + st.count());
		System.out.println("Current stack capacity = " + st.items.length);
	}
}
