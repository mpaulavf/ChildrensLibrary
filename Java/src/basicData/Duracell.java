package basicData;

public class Duracell<T> {
    private int top;
    private int size;
    private T[] ar;

    public Duracell(int size){
        this.size = size;
        top = 0;
        ar = (T[]) new Object [size];
    }

    public Duracell(){
        size = 10;
        top = 0;
        ar = (T[]) new Object [size];
    }

    public boolean isFull (){
        return (top == size - 1);
    }

    public boolean isEmpty(){
        return (top == 0);
    }

    public void push (T item) throws Exception{
        if (isFull()) throw new Exception("La pila está llena");

        ar[top] = item;
        top++;

    }

    public T pop () throws Exception{
        if(isEmpty())throw new Exception("La pila está vacía");

        top --;
        return ar[top];
    }

    public T peek() throws Exception{
        if(isEmpty())throw new Exception("La pila está vacía");

        return ar[top-1];
    }
}
