import java.util.*;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> ints = new MyArrayList<>(List.of(8,12,-5,1004,22,-1000, 1,0));

        System.out.println(ints);

        ints = MyQuickSort.sort(ints);

        System.out.println(ints);
    }
}