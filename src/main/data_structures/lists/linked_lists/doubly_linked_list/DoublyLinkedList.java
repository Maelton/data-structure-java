package main.data_structures.lists.linked_lists.doubly_linked_list;

import main.data_structures.lists.linked_lists.LinkedList;

public class DoublyLinkedList<T> implements LinkedList<T> {
    
    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public void addFirst(T element) {
        Node<T> newNode = new Node<T>(element);

        if( this.isEmpty() ) {
            this.head = newNode;
            this.tail = newNode;
            this.size++;
        } else {
            Node<T> previousHead = this.head;
            newNode.setNext(previousHead);
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
            newNode.setPrevious(this.tail);
            this.tail.setNext(newNode);
            this.tail = newNode;
            this.size++;
        }
    }

    /**
    * Adds an element before index.
    */
    @Override
    public void add(int index, T element) {
        
        Node<T> previousNode = this.head;
        Node<T> newNode = new Node<T>(element);
        
        if(this.isEmpty()) {
            this.addFirst(element);
        } else {
            if(index < 0) {
                if( (index * -1) >= this.size() ) {
                    this.addFirst(element);
                } else {
                    int insertionIndex = this.size() + index;
                    
                    for(int i=0; i < insertionIndex; i++) previousNode = previousNode.getNext();

                    newNode.setNext(previousNode);
                    newNode.setPrevious(previousNode.getPrevious());
                    previousNode.getPrevious().setNext(newNode);
                    previousNode.setPrevious(newNode);
                    this.size++;
                }
            } else if(index > 0) {
                if(index >= this.size()) {
                    this.addLast(element);
                } else {
                    for(int i = 0; i < index; i++) previousNode = previousNode.getNext();

                    newNode.setNext(previousNode);
                    newNode.setPrevious(previousNode.getPrevious());
                    previousNode.getPrevious().setNext(newNode);
                    previousNode.setPrevious(newNode);
                    this.size++;
                }
            } else {
                this.addFirst(element);
            }
        }
    }

    @Override
    public Node<T> removeFirst() {
        Node<T> removedNode = this.head;

        if( this.isEmpty() ) return removedNode;
        if( this.size() == 1) {
            this.head = null;
            this.tail = null;
            this.size--;
            return removedNode;
        }

        this.head.getNext().setPrevious( this.head.getPrevious() );
        this.head = this.head.getNext();
        this.size--;
        return removedNode;
    }

    @Override
    public Node<T> removeLast() {
        Node<T> removedNode = this.tail;

        if( this.isEmpty() ) return removedNode;
        if( this.size() == 1) return this.removeFirst();

        removedNode.getPrevious().setNext( removedNode.getNext() );
        this.tail = removedNode.getPrevious();
        this.size--;
        return removedNode;
    }

    /**
     * Removes first occurrence of element and returns it.
     * Returns null if the element is not present.
     */
    @Override
    public Node<T> remove(T element) {
        if( this.isEmpty() ) return null;
        if( this.size() == 1 ) return this.head.equals(element) ? this.removeFirst() : null;

        Node<T> currentNode = this.head;
        if(currentNode.equals(element)) return this.removeFirst();

        do {
            currentNode = currentNode.getNext();
            
            if(currentNode == this.tail) return currentNode.equals(element) ? this.removeLast() : null;

            if(currentNode.equals(element)) {
                currentNode.getPrevious().setNext( currentNode.getNext() );
                currentNode.getNext().setPrevious( currentNode.getPrevious() );
                this.size--;
                return currentNode;
            }

            currentNode = currentNode.getNext();
        } while(currentNode != null);

        return null;
    }

    @Override
    public Node<T> remove(int index) {
        Node<T> removedNode = null;

        if( this.isEmpty() ) return removedNode;
        if(index < 0) {
            if( (index * -1) > this.size() ) return removedNode;

            int removalIndex = this.size() + index;
            
            if(removalIndex == 0) return this.removeFirst();
            if(removalIndex == this.size()-1) return this.removeLast();

            removedNode = this.head;

            for(int i = 0; i < removalIndex; i++) removedNode = removedNode.getNext();

            removedNode.getPrevious().setNext( removedNode.getNext() );
            removedNode.getNext().setPrevious( removedNode.getPrevious() );
            this.size--;

            return removedNode;
        }

        if(index > 0) {
            if( index >= this.size() ) return removedNode;
            if( index == this.size()-1 ) return this.removeLast();

            removedNode = this.head;

            for(int i = 1; i <= index; i++) removedNode = removedNode.getNext();

            removedNode.getPrevious().setNext( removedNode.getNext() );
            removedNode.getNext().setPrevious( removedNode.getPrevious() );
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
        this.tail = null;
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
        if(index < 0) {
            if( (index * -1) > this.size() ) return foundNode;

            int nodeIndex = this.size() + index;
            foundNode = this.head;

            for(int i = 0; i < nodeIndex; i++) foundNode.getNext();
            
            return foundNode;
        }
        
        if(index > 0) {
            if( index >= this.size() ) return foundNode;

            foundNode = this.head;

            for(int i = 0; i < index; i++)  foundNode = foundNode.getNext();
            return foundNode;
        }

        return this.head;
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

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
}
