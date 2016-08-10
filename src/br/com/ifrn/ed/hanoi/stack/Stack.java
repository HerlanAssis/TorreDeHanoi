package br.com.ifrn.ed.hanoi.stack;

public interface Stack<T> {
    public boolean isEmpty();
    public int size();
    public void push(T element);
    public T pop();
    public T peek();    
}
