package com.austin.ctci.ch03;

import java.awt.*;
import java.util.EmptyStackException;

public class Main {

    public static class MyStack<T> {
        private class StackNode<T> {
            private T data ;
            private StackNode<T> next ;

            public StackNode(T data) {
                this.data = data ;
            }
        }

        private StackNode top ;

        public T pop() {
            if (top == null) throw new EmptyStackException() ;
            T item = (T) top.data;
            top = top.next ;
            return item ;
        }

        public void push(T item) {
            StackNode<T> t = new StackNode<T>(item) ;
            t.next = top ;
            top = t ;
        }

        public T peek() {
            if (top == null) throw new EmptyStackException() ;
            return (T)top.data ;
        }

        public boolean isEmpty() {
            return top == null ;
        }
    }

    public static class MyQueue<T> {
        public class QueueNode<T> {
            private T data ;
            private QueueNode<T> next ;

            public QueueNode(T item) {
                this.data = item ;
            }
        }

        private QueueNode<T> first ;
        private QueueNode<T> last ;

        public void add (T item) {
            QueueNode<T> t = new QueueNode(item) ;
            if (last != null) {
                last.next = t;
            }
            last = t ;
            if (first == null) {
                first = last;
            }
        }

        public T remove () {
            if (first == null) throw new EmptyStackException() ;
            T data = first.data ;
            first = first.next ;
            if (first == null)
                last = first ;
            return data ;
        }

        public T peek () {
            if (first == null) throw new EmptyStackException() ;
            return first.data ;
        }

        public boolean isEmply () {
            return first == null ;
        }
    }

    public static void main(String[] args) {
	// write your code here
        MyStack myStack = new MyStack<Integer>() ;
        myStack.push(12);
        myStack.push(15);
        myStack.push(20);

        System.out.print("stack: " + myStack.peek() + "  " + myStack.pop() + "  " + myStack.pop());

        MyQueue myQueue = new MyQueue<Integer>() ;
        myQueue.add(12);
        myQueue.add(15);
        myQueue.add(20);

        System.out.print("queue: " + myQueue.peek() + "  " + myQueue.remove() + "  " + myQueue.remove());

    }
}
