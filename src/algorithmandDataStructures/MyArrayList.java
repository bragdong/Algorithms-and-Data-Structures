package algorithmandDataStructures;

public class MyArrayList {
    private Object[] things;
    private int arraySize;
    
    public MyArrayList() {
        this.things = new Object[3];
        this.arraySize = 0;
    }
    public int getSize() {
        return this.arraySize;
    }
    public int append(Object o) {
        if (this.arraySize == things.length) {
        	System.out.println("expanding array.");
            this.expand(this.arraySize);
        }
        this.things[this.arraySize] = o;
        this.arraySize++;
        return this.arraySize;
    }
    public static void displayArray(MyArrayList a){
        System.out.println("Array size = "+a.getSize());        
    	System.out.println("Queue object: "+java.util.Arrays.toString(a.things).replace(",", " "));
	
    }
    public Object getThing(int idx) throws IndexOutOfBoundsException {
        if (idx < 0 || idx >= this.arraySize) {
            IndexOutOfBoundsException e = new IndexOutOfBoundsException("Invalid index supplied");
            throw e;
        }
        return this.things[idx];
    }
    public void setThing(Object o, int idx) throws IndexOutOfBoundsException{
        if (idx < 0 || idx >= this.arraySize) {
            IndexOutOfBoundsException e = new IndexOutOfBoundsException("Invalid index supplied");
            throw e;
        }
        things[idx] = o;
    }
    //
    public void expand(int toSize) {
        if (this.arraySize + toSize > this.things.length) {
            Object[] newArray = new Object[(this.arraySize + toSize) * 2];
            for (int i = 0; i < this.things.length; i++) {
                newArray[i] = this.things[i];
            }
            this.things = newArray;
        }

    }
    public Object remove(int idx) throws IndexOutOfBoundsException {
        Object o;
        Object [] temp = new Object[this.things.length];
        int ctr = 0;
        if (idx < 0 || idx >= this.arraySize) {
            IndexOutOfBoundsException e = new IndexOutOfBoundsException("Invalid Index");
            throw e;
        } 
        o = this.things[idx];
        for(int i = 0; i < this.things.length; i++){
            if(i != idx)
            {
                temp[ctr] = this.things[i];
                ctr++;
            }
        }
        this.arraySize--;
        this.things = temp;
        return o;
    }
    public static void main(String[] args) {
        MyArrayList aList = new MyArrayList();
        System.out.println(aList.append("first"));
        System.out.println(aList.append("apple"));
        System.out.println(aList.append("banana")); 
        System.out.println("Array size = "+aList.getSize());        
    	System.out.println("Queue object: "+java.util.Arrays.toString(aList.things).replace(",", " "));
    	Object obj = aList.remove(2);
    	System.out.println("Removed "+obj);
        System.out.println("Array size = "+aList.getSize());        
    	System.out.println("Queue object: "+java.util.Arrays.toString(aList.things).replace(",", " "));
        System.out.println(aList.append("banana"));
        System.out.println("Array size = "+aList.getSize());        
    	System.out.println("Queue object: "+java.util.Arrays.toString(aList.things).replace(",", " "));
//    	System.out.println(aList.getThing(-1)); //error test
//    	System.out.println(aList.getThing(5));  // error test
    	System.out.println(aList.getThing(0)); 
        System.out.println(aList.append("expand"));    	
        System.out.println("Array size = "+aList.getSize());        
    	System.out.println("Queue object: "+java.util.Arrays.toString(aList.things).replace(",", " "));
        System.out.println(aList.append("Hi")); 
        System.out.println(aList.append("Bye"));        
        System.out.println("Array size = "+aList.getSize());        
    	System.out.println("Queue object: "+java.util.Arrays.toString(aList.things).replace(",", " "));
    	obj = aList.remove(2);
    	System.out.println("Remove "+ obj.toString());
        System.out.println("Array size = "+aList.getSize());        
    	System.out.println("Queue object: "+java.util.Arrays.toString(aList.things).replace(",", " "));
    	
//        System.out.println(aList.append("pear"));        
//        System.out.println(aList.append("last"));
//        displayArray(aList);
//        System.out.println("Array size = "+aList.getSize());        
//    	System.out.println("Queue object: "+java.util.Arrays.toString(aList.things).replace(",", " "));
//    	Object obj = aList.remove(2);   	
//        System.out.println(aList.getSize());
//        System.out.println(aList.getThing(0));
//        Object o = aList.remove(2);
//        System.out.println(o);
//        System.out.println(aList.getSize());
    }
}
