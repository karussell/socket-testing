import java.util.List;

public class Helper implements Sorter {

    @Override
    public void sort(List<Integer> list) {
        boolean unsorted = false;

        while(!unsorted) {
            unsorted = true;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i - 1) > list.get(i)) {
                    Integer tmp = list.get(i - 1);
                    list.set(i - 1, list.get(i));
                    list.set(i, tmp);
                    unsorted = false;
                }
            }
        }
    }
}
