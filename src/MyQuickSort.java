import java.util.Arrays;
import java.util.Comparator;

public class MyQuickSort {
    public static <T extends Comparable<T>> MyArrayList<T> sort(MyArrayList<T> values) {
        int size = values.getSize();
        if (size < 2) {
            return values;
        }

        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = values.get(i);
        }

        arrSort(array, 0, size-1);

        MyArrayList<T> sortedList = new MyArrayList<T>();
        for (int i = 0; i < array.length; i++) {
            sortedList.add((T) array[i]);
        }

        return sortedList;

    }

    private static <T extends Comparable<T>>  void arrSort(Object[] arr, int low, int high) {
        if (low < high) {
            int median = split(arr, low, high);

            arrSort(arr, low, median - 1);
            arrSort(arr, median + 1, high);
        }
    }

    private static <T extends Comparable<T>> int split(Object[] arr, int low, int high) {
        int middle = low + (high - low) / 2;
        T pivot = (T) arr[middle];

        T temp = (T) arr[middle];
        arr[middle] = arr[high];
        arr[high] = temp;

        int i = (low - 1);
        for (int j = low; j < high; j++) {
            T tempj = (T) arr[j];
            if (tempj.compareTo(pivot) < 0) {
                i++;

                temp = (T) arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        temp = (T) arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
