import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public void start() {
        try {
            ServerSocket serverSocket = new ServerSocket(8900);

            while (true) {
                Socket socket1 = serverSocket.accept();
                System.out.println("accepted connection");
                Writer writer = new OutputStreamWriter(socket1.getOutputStream(), "UTF8");
                String text = "hello";
                writer.write("HTTP/1.1 200 OK\n" +
                        "Server: Lowleveling 1\n" +
                        "Content-Length: " + text.getBytes().length + "\n" +
                        "Connection: close\n" +
                        "Content-Type: text/plain\n");
                writer.write(text);
                writer.flush();
                writer.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
