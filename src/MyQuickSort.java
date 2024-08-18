import java.util.Comparator;

public class MyQuickSort {
    public static <T extends Comparable<T>> MyArrayList<T> sort(MyArrayList<T> values) {
        Comparator<T> comparator = Comparable::compareTo;
        Object[] array = new Object[values.getSize()];
        for (int i = 0; i < values.getSize(); i++) {
            array[i] = values.get(i);
        }

        boolean isSorted = false;
        T valueToSave;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (comparator.compare((T) array[i], (T) array[i + 1]) > 0) {
                    isSorted = false;
                    valueToSave = (T) array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = valueToSave;
                }
            }
        }

        MyArrayList<T> sortedList = new MyArrayList<T>();
        for (int i = 0; i < array.length; i++) {
            sortedList.add((T) array[i]);
        }
        return sortedList;
    }
}
