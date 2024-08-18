import org.jetbrains.annotations.NotNull;

public class TestClass implements Comparable<TestClass> {

    String a;

    TestClass(String a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "MyTestClass{" +
                "a='" + a + '\'' +
                '}';
    }

    @Override
    public int compareTo(@NotNull TestClass o) {
        return this.a.compareTo(o.a);
    }
}
