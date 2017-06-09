package algorithmandDataStructures;

public class Queue {   //FIFO or LILO implementation
    
    private int[] items;
    private int start;
    private int count;
    private int next;
    
    public Queue() {
        this.items = new int[2];
        this.start = 0;
        this.count = 0;
        this.next = -1;
    }
    
    public void enqueue(int val) {
    	
        if (this.count >= this.items.length) {
        	System.out.println("Increasing size of Queue.");
            int[] tempArr = new int[this.items.length * 2];
            for (int i = 0; i < this.count; i++) {
                tempArr[i] = this.items[i];
            }
            this.items = tempArr;
        }
        
        this.items[this.start]=val;
        System.out.println(val + " has been placed into the queue.");
        this.count ++;
        this.start++;
        return;
    }
    
    public int dequeue() {
        if (this.next >= this.count-1){
        	throw new RuntimeException("nothing to dequeue");
        }
        this.next++;
    	System.out.println(this.items[this.next]+" was removed from the queue.");
        return this.items[this.next];
    }

    public static void printQState(Queue q){
    	System.out.println("Queue object: "+java.util.Arrays.toString(q.items).replace(",", " "));
    	System.out.println("Queue object capacity = "+q.items.length);
    	System.out.println("Index to place next item on the Queue is "+q.start);
    	System.out.println();
    }
    
    public static void main(String[] args) {
    	Queue q;
    	q = new Queue();
    	printQState(q);
    	q.enqueue(1);
    	printQState(q);    	
    	q.enqueue(2);
    	printQState(q);    	
    	q.enqueue(3);  
    	printQState(q);
    	q.dequeue();
    	printQState(q);    	
    	q.dequeue();
    	printQState(q);    	
    	q.enqueue(5);
    	printQState(q);
    	q.enqueue(7);
    	printQState(q);
    	q.dequeue();
    	printQState(q); 
    	q.dequeue();
    	printQState(q); 
    	q.dequeue();
    	printQState(q); 
    	//attempt to remove from empty queue
    	q.dequeue();
    	printQState(q); 
    }

}