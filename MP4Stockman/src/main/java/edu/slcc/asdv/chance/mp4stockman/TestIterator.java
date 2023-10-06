/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.slcc.asdv.chance.mp4stockman;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.function.Consumer;

/**
 *
 * @author Chance
 * @param <E>
 */
public class TestIterator <E> {
    
    E[] list = (E[]) new Object[3];
    int i;
    public void add(E e)
    {
       list[i++] = e;
    }
    public Iterator<E> iterator()
    {
        Iterator<E> it =
        new Iterator<E>(){
            int index = 0;
            @Override
            public boolean hasNext() {
                if(index == TestIterator.this.list.length)
                    return false;
                return true;
            }

            @Override
            public E next() {
                return TestIterator.this.list[index++];
            }

            @Override
            public void forEachRemaining(Consumer<? super E> action) {
                  while(hasNext())
                {
                    if (action == null)
                        throw new NullPointerException("Action is Null");
                    else
                        action.accept(next());
                }
            }
        };
        
        return it;
    }   
    
    public ListIterator<E> listIterator()
    {
        
       ListIterator<E> lit = new ListIterator<E>()
       {
           int index;
           @Override
           public boolean hasNext() {
               if(index == TestIterator.this.list.length)
                    return false;
                return true;
           }

           @Override
           public E next() {
               return TestIterator.this.list[index++];
           }

           @Override
           public boolean hasPrevious() {
               if (index == 0)
                   return false;
               return true;
           }

           @Override
           public E previous() {
               return TestIterator.this.list[--index];
           }

           @Override
           public int nextIndex() {
               return index + 1;
           }

           @Override
           public int previousIndex() {
               return index - 1;
           }

           @Override
           public void add(E e) {
               throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
           }

           @Override
           public void remove() {
               throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
           }

           @Override
           public void set(E e) {
               throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
           }
       };
       return lit;
        
    }
    
    public static void main(String[] args) 
    {
        TestIterator<Integer> ti = new TestIterator<Integer>();
        ti.add(1);
        ti.add(2);
        ti.add(3);
        Iterator<Integer> it = ti.iterator();
        
        while(it.hasNext())
        {
            System.out.println(it.next());
        }
        //testing for each
        Consumer<Integer> consumer =
        new Consumer<Integer>(){
            @Override
            public void accept(Integer t) 
            {
                System.out.println(t * 10);
            }
            
        };
        Iterator<Integer> it1 = ti.iterator();
        it1.forEachRemaining(consumer);
    }
}
