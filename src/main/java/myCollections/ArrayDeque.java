package myCollections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayDeque<E> implements Deque<E> {
    private static final int CAPACITY = 1000;
    
    private E[] data;
    private int f = 0;
    private int sz = 0;
    
    public ArrayDeque(){
        this(CAPACITY);
    }
    
    public ArrayDeque(int capacity){
        data = (E[]) new Object[capacity];
    }
    
    public int size(){
        return sz;
    }
    
    public boolean isEmpty(){
        return sz == 0;
    }
    
    public void addFirst(E e) throws IllegalStateException{
        if(sz == data.length)
            throw new IllegalStateException("Deque está cheia");
        f = (f+data.length-1)%data.length;
        data[f] = e;
        sz++;
    }
    
    public void addLast(E e) throws IllegalStateException{
        if (sz == data.length)
            throw  new IllegalStateException("Deque está cheia");     
        int avail = (f + sz) %data.length;
        data[avail] = e;
        sz++;
    }
    
    public E first(){
        if(isEmpty())
            return null;
        return data[f];
    }
    
    public E last(){
        if(isEmpty())
            return null;
        return data[(f+sz-1)%data.length];
    }
    
    public E removeFirst(){
        if(isEmpty())
            return null;
        E answer = data[f];
        data[f] = null;
        f = (f+1)%data.length;
        sz--;
        return answer;
    }
    
    public E removeLast(){
        if(isEmpty())
            return null;
        int r = (f+sz-1)%data.length;
        E answer = data[r];
        data[r] = null;
        sz--;
        return answer;
    }
    
     //iterator para os elementos
    
    public Iterator<E> iterator(){
        return new ArrayIterator();
    }
    
    private class ArrayIterator implements Iterator<E>{
        private int j;
        
        public ArrayIterator(){
            if(sz==0)
                j = data.length;
            else
                j=f;
        }
        
        public boolean hasNext(){
            return j != data.length;
        }
        
        public E next(){
            if(j == data.length)
                throw new NoSuchElementException("Sem próximo elemento");
            int j_atual = j;
            j = (j + 1) % data.length;
            if(j==(f+sz)%data.length)
                j=data.length;
            return data[j_atual];
            
        }
        
        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
}
