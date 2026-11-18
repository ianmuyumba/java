import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
    public static List<Integer> withoutNegatives(List<Integer> input) {
        List<Integer> values = new ArrayList<>(input);
        Iterator<Integer> iterator = values.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() < 0) iterator.remove();
        }
        return values;
    }

    public static void main(String[] args) {
        System.out.println(withoutNegatives(Arrays.asList(-1, -2, 3, -4, 5)));
    }
}
