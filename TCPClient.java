import java.io.*;
import java.net.*;


public class TCPClient {
  public static void main(String... args) {
    String serverUrl = args[0];
    int port = Integer.valueOf(args[1]);

    try (Socket socket = new Socket(serverUrl, port)) {
      // Socket socket = new Socket(serverUrl, port); // Original?
      InputStream input = socket.getInputStream();

      int exists = input.read();
      // if input.read() == -1, end of stream
      while (exists != -1) {
        System.out.write(exists);
        exists = input.read();
      }
      socket.close();

    } catch (IOException e) {
      // if any errors occur with socket connection
      e.printStackTrace();
    }

  }
}
