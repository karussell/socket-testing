import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(8900);
            ExecutorService service = Executors.newFixedThreadPool(5);

            while (true) {
                Socket socket1 = serverSocket.accept();
                service.submit(() -> {
                    try {
                        System.out.println(new Date() + " accepted connection from client");

                        BufferedOutputStream dataOut = new BufferedOutputStream(socket1.getOutputStream());

                        Thread.sleep(5000);
                        String content = "hello world " + new Date();
                        byte[] bytes = content.getBytes(StandardCharsets.UTF_8);

                        PrintWriter out = new PrintWriter(socket1.getOutputStream());
                        out.println("HTTP/1.1 200 OK");
                        out.println("Server: Simple Server: 1.0");
                        out.println("Date: " + new Date());
                        out.println("Content-type: text/plain");
                        out.println("Content-length: " + bytes.length);
                        out.println(); // blank line between headers and content, very important !
                        out.flush();

                        // send text via bytes
                        dataOut.write(bytes, 0, bytes.length);
                        dataOut.flush();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
