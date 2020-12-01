import java.util.List;

public class Helper {
    String str;

    public Helper(String str) {
        this.str = str;
    }

    public static void sort(List<Integer> list) {
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

    public int count(String substring) {
        if (substring == null || substring.isEmpty())
            throw new IllegalArgumentException("substring cannot be null or empty");
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.startsWith(substring, i))
                count++;
        }
        return count;
    }
}
