import java.io.*;
import java.net.*;


public class TCPClient {
  public static void main(String... args) {
    String serverUrl = args[0];
    int port = Integer.valueOf(args[1]);


    try (Socket socket = new Socket(serverUrl, port)) {

      StringBuilder message = new StringBuilder();
      int numArgs = args.length;

      // check to see if there is a message
      for (int i = 2; i < numArgs; i++) {
        message.append(args[i] + ' ');
      }
      message.append("\n");

      // send message to server
      OutputStream output = socket.getOutputStream();
      output.write(message.toString().getBytes());

      // get response from server
      InputStream input = socket.getInputStream();

      int exists = input.read();
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
