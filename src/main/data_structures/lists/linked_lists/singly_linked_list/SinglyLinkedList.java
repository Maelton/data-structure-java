package main.data_structures.lists.linked_lists.singly_linked_list;

import main.data_structures.lists.linked_lists.LinkedList;

public class SinglyLinkedList<T> implements LinkedList<T> {

    private Node<T> head;
    private int size;

    @Override
    public void addFirst(T element) {
        
        Node<T> newNode = new Node<T>(element);

        if( this.isEmpty() ) {
            this.head = newNode;
            this.size++;
        } else {
            newNode.setNext( this.head );
            this.head = newNode;
            this.size++;
        }
    }

    @Override
    public void addLast(T element) {
        Node<T> newNode = new Node<T>(element);

        if( this.isEmpty() ) {
            this.addFirst(element);
        } else {
            Node<T> previousNode = this.head;

            while(previousNode.getNext() != null) {
                previousNode = previousNode.getNext();
            }

            previousNode.setNext(newNode);
            this.size++;
        }
    }

    @Override
    public void add(int index, T element) {
        Node<T> previousNode = this.head;
        Node<T> newNode = new Node<T>(element);

        if (index < 0 ) {
            if ( (index * -1) >= this.size() ) {
                this.addFirst(element);
            } else {
                int insertionIndex = this.size() + index;

                for (int i = 1; i < insertionIndex; i ++) previousNode = previousNode.getNext();

                newNode.setNext(previousNode.getNext());
                previousNode.setNext(newNode);
                this.size++;
            }

        } else if (index > 0) {
            if ( index >= this.size() ) {
                this.addLast(element);
            } else {
                
                for(int i = 1; i < index; i++) {
                    previousNode = previousNode.getNext();
                }

                newNode.setNext(previousNode.getNext());
                previousNode.setNext(newNode);
                this.size++;
            }

        } else {
            this.addFirst(element);
        }
    }

    @Override
    public Node<T> removeFirst() {
        Node<T> removedNode = null;

        if( this.isEmpty() ) return removedNode;
        
        removedNode = this.head;
        this.head = removedNode.getNext();
        this.size--;
        return removedNode;
    }

    @Override
    public Node<T> removeLast() {
        Node<T> removedNode = null;

        if( this.isEmpty() ) return removedNode;
        if( this.size() == 1 ) return this.removeFirst();

        Node<T> previousNode = this.head;
        removedNode = previousNode.getNext();

        while(removedNode.getNext() != null) {
            previousNode = previousNode.getNext();
            removedNode = previousNode.getNext();
        }
            
        previousNode.setNext(null);
        this.size--;
        return removedNode;
    }

    @Override
    public Node<T> remove(T element) {
        Node<T> removedNode = null;

        if( this.isEmpty() ) return removedNode;
        if( this.head.equals(element) ) return this.removeFirst();
        if( this.size() == 1 ) return removedNode;
        
        do {
            Node<T> currentNode = this.head;
            removedNode = currentNode.getNext();

            if ( removedNode.equals(element) ) {
                currentNode.setNext( removedNode.getNext() );
                this.size--;
                return removedNode;
            }
            currentNode = removedNode;
            
        } while(removedNode.getNext() != null);
    
        removedNode = null;
        return removedNode;
    }

    @Override
    public Node<T> remove(int index) {
        Node<T> previousNode = this.head;
        Node<T> removedNode = null;

        if( this.isEmpty() ) return removedNode;
        if( index < 0) {
            if( (index * -1) > this.size() ) return removedNode;

            int removalIndex = this.size() + index;
            if( removalIndex == 0 ) return this.removeFirst();
            
            for(int i = 0; i < (removalIndex - 1); i++) previousNode = previousNode.getNext();

            removedNode = previousNode.getNext();
            previousNode.setNext( removedNode.getNext() );
            this.size--;
            return removedNode;
        }
        
        if(index > 0) {
            if( index >= this.size() ) return removedNode;

            for(int i = 0; i < (index - 1); i++) previousNode = previousNode.getNext();

            removedNode = previousNode.getNext();
            previousNode.setNext( removedNode.getNext() );
            this.size--;
            return removedNode;
        }

        return this.removeFirst();
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        this.head = null;
        this.size = 0;
    }

    @Override
    public boolean contains(T element) {
        Node<T> currentNode = this.head;
        
        for(int index = 0; index < this.size(); index++) {
            if( currentNode.equals(element) ) return true;

            currentNode = currentNode.getNext();
        }

        return false;
    }

    @Override
    public Node<T> search(int index) {
        Node<T> foundNode = null;

        if( this.isEmpty() ) return foundNode;

        if( index < 0) {
            if( (index * -1) > this.size()) return foundNode;

            int nodeIndex = this.size() + index;
            foundNode = this.head;

            for(int i = 0; i < nodeIndex; i++) foundNode = foundNode.getNext();
            return foundNode;
        }
        
        if(index > 0) {
            if( index >= this.size() ) return foundNode;

            foundNode = this.head;

            for(int i = 0; i < index; i++) foundNode = foundNode.getNext();
            return foundNode;
        }

        foundNode = this.head;
        return foundNode;
    }

    @Override
    public String toString() {
        if( this.isEmpty() ) return "[]";

        Node<T> currentNode = this.head;
        String output = "[";
        
        for(int index = 0; index < this.size(); index++) {
            String element = currentNode.toString();
            output += element + ", ";
            currentNode = currentNode.getNext();
        }
        
        return output.substring(0, output.length()-2) + "]";
    }

    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }   
}
