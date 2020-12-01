import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HelperTest {

    Sorter sorter = Collections::sort;
    // Sorter sorter = new Helper();

    @Test
    public void sort() {
        List<Integer> list = Arrays.asList(6, 8, 2, 4, 4, 7, 2, 6, 9);
        sorter.sort(list);
        assertEquals(9, list.size());
        assertEquals(Arrays.asList(2, 2, 4, 4, 6, 6, 7, 8, 9), list);
    }

    @Test
    public void edgeCases() {
        List<Integer> list = Arrays.asList();
        sorter.sort(list);
        assertTrue(list.isEmpty());

        list = Arrays.asList(1);
        sorter.sort(list);
        assertEquals(Arrays.asList(1), list);

        list = Arrays.asList(2, 1);
        sorter.sort(list);
        assertEquals(Arrays.asList(1, 2), list);
    }

    @Test
    public void perfTest() {
        List<Integer> list = createRandomList(1000);

        // warm up
        long sum = 0;
        for (int i = 0; i < 300; i++) {
            sorter.sort(new ArrayList<>(list));
            sum += list.get(0);
        }

        // speed test
        long start = System.nanoTime();
        int COUNT = 1000;
        sum = 0;
        for (int i = 0; i < COUNT; i++) {
            sorter.sort(new ArrayList<>(list));
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