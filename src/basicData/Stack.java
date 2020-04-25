package basicData;

public class Stack<T> {
	
	private int[] p = new int[1000000];
    private int t=-1;
    
    public void push(int n){
        t++;
        p[t]=n;
    }
    
    public int pop(){
        int temp=t;
        t--;
        return p[temp];
    }
    
    public boolean isEmpty(){
        if(t==-1){
            return true;
        }else{
            return false;
        }
    }
	
}
