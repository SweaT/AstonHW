import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.processing.SupportedAnnotationTypes;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class MyArrayList<T> {
    private T[] initialArray;
    private int size;
    private final static int DEFAULT_CAPACITY = 16;

    public MyArrayList() {
        initialArray = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("capacity can't be <= 0");
        else
            initialArray = (T[]) new Object[capacity + DEFAULT_CAPACITY];

    }

    public MyArrayList(@NotNull Collection<T> collection) {
        this();
        addAll(collection);
    }

    public void addAll(@NotNull Collection<T> collection) {
        prepareToInsert(collection.size());
        T[] temp = (T[]) collection.toArray();
        elementsAdd(temp, size);
        this.size += temp.length;
    }

    public void add(@NotNull T item) {
        prepareToInsert(1);
        initialArray[size] = item;
        this.size++;
    }

    public void add(@NotNull T item, int index) {
        checkIndex(index);
        prepareToInsert(1);
        for (int i = size; i > index; i--) {
            initialArray[i] = initialArray[i - 1];
        }
        initialArray[index] = item;
        this.size++;
    }

    public void remove(int index) {
        checkIndex(index);

        for (int i = index; i < size; i++) {
            try {
                initialArray[i] = initialArray[i + 1];
            } catch (IndexOutOfBoundsException e) {
                initialArray[i] = null;
            }
        }
        this.size--;
    }

    public T get(int index) {
        checkIndex(index);

        return initialArray[index];
    }


    public T getLast() {
        if (size > 0) {
            return initialArray[size - 1];
        } else return null;
    }

    public T getfirst() {
        if (size > 0) {
            return initialArray[0];
        } else return null;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        for (var item : initialArray) {
            if (item != null) {
                stringBuilder.append(item);
                stringBuilder.append(", ");
            } else break;
        }
        stringBuilder.delete(stringBuilder.length() - 1, stringBuilder.length());
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    // --- Приватные методы для удобочитаемости основного кода ---

    // расширяет существующий массив на int quantity
    private void arrayExpand(int quantity) {
        T[] tempArray = (T[]) new Object[initialArray.length + quantity];
        System.arraycopy(initialArray, 0, tempArray, 0, initialArray.length);
        initialArray = tempArray;
    }

    // отсекает конец массива по первому с конца не null элементу
    // и возвращает количество оставшихся элементов
    private int calculateSize() {
        for (int i = initialArray.length - 1; i >= 0; i--) {
            if (initialArray[i] != null)
                return (i + 1);
        }
        return 0;

    }

    private int getAvailableSpace() {
        return (initialArray.length - size);
    }

    // данный метод гарантирует, что после его вызова
    // initialArray будет иметь необходимое
    // количество свободных ячеек для вставки в него
    // всех элементов int size
    private void prepareToInsert(int size) {
        if ((getAvailableSpace() - size) < 0)
            arrayExpand(size + DEFAULT_CAPACITY);
    }

    private void elementsAdd(T[] array, int index) {
        System.arraycopy(array, 0, initialArray, index, array.length);
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index is out of bounds");
    }
}
