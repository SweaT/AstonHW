import java.util.*;

public class Main {
    public static void main(String[] args) {
        // затестить isEmpty() and Clear() and GetIndex() remove(T obj)

        MyArrayList<String> myAL = new MyArrayList<>(List.of("asd", "123", "Cool Beavers", "Norman", "Gerbert"));

        System.out.println(myAL);
        System.out.println(myAL.getSize());

        myAL.remove("123");
        System.out.println(myAL);
        System.out.println(myAL.getSize());
        myAL.remove("gerbert");

        System.out.println(myAL);
        System.out.println(myAL.getSize());




    }
}