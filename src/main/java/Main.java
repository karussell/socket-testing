public class Main {
    public static void main(String[] args) {
        String str = "asdsdfsdfs";
        String substring = "s";
        System.out.println(str + " contains " + substring + " : " + new Helper(str).count("s"));

        Server server = new Server();
        server.start();
    }
}
