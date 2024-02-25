package data_structures.linked_lists.doubly_linked_list;

import data_structures.linked_lists.ILinkedList;

public class DoublyLinkedList<T> implements ILinkedList<T> {
    
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
            this.size++;
        }
    }

    @Override
    public void add(int index, T element) {
        Node<T> newNode = new Node<T>(element);
        Node<T> previousNode = this.head;

        if(this.isEmpty()) {
            this.addFirst(element);
        } else {
            if(index < 0) {
                if( (index * -1) >= this.size()) {
                    this.addFirst(element);
                } else {
                    int indexDeInsercao = this.size() + index;

                    for(int i = 0; i <= indexDeInsercao; i++) {
                        previousNode = previousNode.getNext();
                    }

                    newNode.setNext(previousNode);
                    previousNode.getPrevious().setNext(newNode);
                    this.size++;
                }
            } else if(index > 0) {
                if(index >= this.size()) {
                    this.addLast(element);
                } else {
                    for(int i = 0; i <= index; i++) {
                        previousNode = previousNode.getNext();
                    }

                    newNode.setNext(previousNode);
                    previousNode.getPrevious().setNext(newNode);
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

        if( this.isEmpty() ) {
            return removedNode;
        } else if( this.size() == 1) {
            this.head = null;
            this.tail = null;
            this.size--;
            return removedNode;
        } else {
            this.head = this.head.getNext();
            this.size--;
            return removedNode;
        }
    }

    @Override
    public Node<T> removeLast() {
        Node<T> removedNode = this.tail;

        if( this.isEmpty() ) {
            return removedNode;
        } else if( this.size() == 1) {
            this.head = null;
            this.tail = null;
            this.size--;
            return removedNode;
        } else {
            removedNode.getPrevious().setNext(null);
            this.size--;
            return removedNode;
        }
    }

    @Override
    public Node<T> remove(T element) {
        if( this.isEmpty() ) {
            return null;
        } else if( this.size() == 1 ) {
            return this.head.equals(element) ? this.removeFirst() : null;
        } else {
            Node<T> currentNode = this.head;

            for(int index = 0; index < this.size(); index++) {
                if(currentNode.equals(element)) {
                    currentNode.getPrevious().setNext(currentNode.getNext());
                    this.size--;
                    return currentNode;
                }
            }
        }

        return null;
    }

    @Override
    public Node<T> remove(int index) {
        Node<T> removedNode = null;

        if( this.isEmpty() ) {
            return removedNode;
        } else {
            if(index < 0) {
                if( (index * -1) > this.size() ) return removedNode;

                int removalIndex = this.size() + index;
                removedNode = this.head;

                for(int i = 0; i < removalIndex; i++) removedNode = removedNode.getNext();

                if(this.tail == removedNode) {
                    //would happen for this.size() == 1
                    if(this.head == removedNode) {
                        this.head = null;
                        this.tail = null;
                        this.size--;
                        
                        return removedNode;
                    }

                    this.tail = removedNode.getPrevious();
                    removedNode.getPrevious().setNext( removedNode.getNext() );
                    this.size--;

                    return removedNode;
                }

                if(this.head == removedNode) {
                    this.head = removedNode.getNext();
                    this.head.setPrevious(null);
                    this.size--;

                    return removedNode;
                }

                removedNode.getPrevious().setNext( removedNode.getNext() );
                removedNode.getNext().setPrevious( removedNode.getPrevious() );
                this.size--;

                return removedNode;
            } else if(index > 0) {

                if( index >= this.size() ) return removedNode;

                removedNode = this.head;

                for(int i = 1; i <= index; i++) removedNode = removedNode.getNext();

                if(this.tail == removedNode) {
                    this.tail = null;
                    removedNode.getPrevious().setNext( removedNode.getNext() );
                    this.size--;
                    return removedNode;
                }

                removedNode.getPrevious().setNext( removedNode.getNext() );
                removedNode.getNext().setPrevious( removedNode.getPrevious() );
                this.size--;
                return removedNode;
            }

            removedNode = this.head;

            if(this.tail == removedNode) {
                this.head = null;
                this.tail = null;
                this.size--;
                return removedNode;
            }

            this.head = removedNode.getNext();
            this.head.setPrevious(null);
            this.size--;
            return removedNode;
        }
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

            for(int i = 1; i <= nodeIndex; i++) foundNode.getNext();
            return foundNode;

        } else if(index > 0) {
            if(index >= this.size()) return foundNode;

            foundNode = this.head;

            for(int i = 1; i <= index; i++)  foundNode = foundNode.getNext();
            return foundNode;
        }

        foundNode = this.head;
        return foundNode;
    }

    @Override
    public String toString() {
        if( this.isEmpty() ) {
            return "[]";
        } else {
            Node<T> currentNode = this.head;
            String output = "[";
            
            for(int index = 0; index < this.size(); index++) {
                String element = (String) currentNode.getData();
                output += element + ", ";
                currentNode = currentNode.getNext();
            }
            
            return output.substring(0, output.length()-2) + "]";
        }
    }

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
}
