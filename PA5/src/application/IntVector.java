package application;

public class IntVector{
    private int[] array;
    private int size;
    private int capacity;

    // Static method to copy elements from source to destination array
    public static int[] copyTo(int[] source, int[] destination, int n) {
        for (int i = 0; i < n; i++) {
            destination[i] = source[i];
        }
        return destination;
    }

    // Static method to double capacity if needed
    public static int doubleIfNeeded(int capacity, int size, int addSize) {
        int newSize = size + addSize;
        if (newSize > capacity) {
            return Math.max(2 * capacity, newSize);
        }
        return capacity;
    }

    // No-arg constructor
    public IntVector() {
        this(10);
    }

    // Constructor with initial capacity
    public IntVector(int initialCapacity) {
        this.capacity = initialCapacity;
        this.size = 0;
        this.array = new int[capacity];
    }

    // Constructor with initial capacity and default value
    public IntVector(int initialCapacity, int defaultValue) {
        this.capacity = initialCapacity;
        this.size = initialCapacity;
        this.array = new int[capacity];
        for (int i = 0; i < size; i++) {
            array[i] = defaultValue;
        }
    }

    // Constructor with an array
    public IntVector(int[] initialArray) {
        this.size = initialArray.length;
        this.capacity = size;
        this.array = new int[capacity];
        System.arraycopy(initialArray, 0, this.array, 0, size);
    }

    // Method to return a string representation of the IntVector
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    // Method to check equality
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        IntVector other = (IntVector) obj;
        if (size != other.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (array[i] != other.array[i]) {
                return false;
            }
        }
        return true;
    }

    // Check if index is valid
    public boolean validIndex(int index) {
        return index >= 0 && index < size;
    }

    // Get size
    public int getSize() {
        return size;
    }

    // Check if empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get capacity
    public int getCapacity() {
        return capacity;
    }

    // Get element at index
    public Integer get(int index) {
        if (validIndex(index)) {
            return array[index];
        }
        return null;
    }

    // Convert to array
    public int[] toArray() {
        int[] result = new int[size];
        System.arraycopy(array, 0, result, 0, size);
        return result;
    }

    // Set element at index
    public void set(int index, int value) {
        if (validIndex(index)) {
            array[index] = value;
        }
    }

    // Reverse the list
    public void reverse() {
        int left = 0;
        int right = size - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    // Ensure capacity
    public void ensureCapacity(int minCapacity) {
        if (minCapacity > capacity) {
            capacity = doubleIfNeeded(capacity, size, 0);
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    // Add element to the end
    public void add(int value) {
        ensureCapacity(size + 1);
        array[size++] = value;
    }

    // Add element at index
    public void add(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity(size + 1);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
    }

    // Add all elements at index
    public void addAll(int index, IntVector other) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity(size + other.size);
        System.arraycopy(array, index, array, index + other.size, size - index);
        System.arraycopy(other.array, 0, array, index, other.size);
        size += other.size;
    }

    // Add all elements to the end
    public void addAll(IntVector other) {
        addAll(size, other);
    }

    // Clear the list
    public void clear() {
        size = 0;
    }

    // Trim capacity to size
    public void trimToSize() {
        if (size < capacity) {
            capacity = size;
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    // Remove and return the last element
    public Integer removeLast() {
        if (isEmpty()) {
            return null;
        }
        int value = array[--size];
        return value;
    }

    // Remove and return element at index
    public Integer remove(int index) {
        if (!validIndex(index)) {
            return null;
        }
        int value = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        size--;
        return value;
    }

    // Remove and return the first occurrence of a value
    public Integer removeFirst(int value) {
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return remove(i);
            }
        }
        return null;
    }

    // Remove all occurrences of a value
    public int removeAll(int value) {
        int count = 0;
        int i = 0;
        while (i < size) {
            if (array[i] == value) {
                remove(i);
                count++;
            } else {
                i++;
            }
        }
        return count;
    }
}

