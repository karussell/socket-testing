public class Helper {
    String str;

    public Helper(String str) {
        this.str = str;
    }

    public int count(String substring) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.startsWith(substring, i))
                count++;
        }
        return count;
    }
}
