package basicData;

public class Queue<T> {
		        
	private int size;
   	private Node<T> front, last;

    Queue(int size) {
           	front=null;
           	last=null;
    }
        
    boolean isEmpty() {
    	if (front == null && last == null) return true;
    	else return false;
    }
        
    boolean isFull() {
    	if (size == 4) return true;
    	else return false;	
    }
       
    void push(T info) {
           Node<T> nodex = new Node<T>(null);
           nodex.data = info;
           nodex.next = null;
           size++;
           if (isEmpty()) {
        	   front = nodex;
        	   last = nodex;                
           } else {
        	   last.next = nodex;
        	   last = nodex;   
           }
    }

    T pop() {
    	size--;
    	if (!isEmpty()){
    		T n = front.data;
    		if (front == last){
    			front = null;
    			last = null;
    		} else {
    			front = front.next;
    		}
           	return n;
       	} else return null;
    }

   	public void parar() {
   		if (!isEmpty()) {
   			Node<T> node1 = front;
   			while (node1!=null) {
   				System.out.print(node1.data+" | ");
   				node1=node1.next;
   			}
            System.out.println();
            }
    }
    
}

