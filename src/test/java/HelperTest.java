import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelperTest {

    @Test
    public void sort() {
        List<Integer> list = Arrays.asList(6, 8, 2, 4, 4, 7, 2, 6, 9);
        Helper.sort(list);
        assertEquals(Arrays.asList(2, 2, 4, 4, 6, 6, 7, 8, 9), list);
    }

    @Test
    public void perfTest() {
        List<Integer> list = createRandomList(1000);

        // warm up
        long sum = 0;
        for (int i = 0; i < 300; i++) {
            Helper.sort(new ArrayList<>(list));
            sum += list.get(0);
        }

        // speed test
        long start = System.nanoTime();
        int COUNT = 1000;
        sum = 0;
        for (int i = 0; i < COUNT; i++) {
            Helper.sort(new ArrayList<>(list));
            sum += list.get(0);
        }
        long end = System.nanoTime();
        System.out.println((end - start) / 1e9 / COUNT);
        System.out.println(sum);
    }

    List<Integer> createRandomList(int size) {
        Random rand = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(rand.nextInt(size / 2));
        }
        return list;
    }
}