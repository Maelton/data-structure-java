package main.data_structures.lists;

public class ListWithArray<T> implements List<T> {

    private Object[] storage;
    private int storageCapacity;
    private int size;

    @Override
    public void addFirst(T element) {
        if( this.isEmpty() ) {
            this.storage[0] = element;
            this.size++;
            
            return;
        }

        if(this.size == this.storageCapacity) this.doubleListCapacity();

        int currentIndex = this.size() - 1;

        for(int i = 0; i < this.size; i++) {
            this.storage[currentIndex + 1] = this.storage[currentIndex];
            currentIndex--;
        }

        this.storage[0] = element;
        this.size++;
    }

    @Override
    public void addLast(T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addLast'");
    }

    @Override
    public void add(int index, T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public T removeFirst() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeFirst'");
    }

    @Override
    public T removeLast() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeLast'");
    }

    @Override
    public T remove(T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public T remove(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remove'");
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public boolean contains(T element) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contains'");
    }

    @Override
    public T search(int index) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }
    
    public void replace(T toBeReplacedElement, T newElement) {}
    
    public void replace(int index, T element) {}

    public void doubleListCapacity() {}

    public void reduceListCapacityBy2() {}

    public String toString() {
        return "";
    }

    public ListWithArray() {
        this.storageCapacity = 10;
        this.storage = new Object[this.storageCapacity];
        this.size = 0;
    }
}
