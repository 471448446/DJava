package learn.socket;

import common.Utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * https://www.tutorialspoint.com/java/java_networking.htm
 * Created by better on 2017/4/9.
 */
public class SocketClient {
    private static String serverName = "localhost";
    private static int port = SocketServer.port;

    public static void main(String[] args) {
        try {
            log("ready_to_connect_Server=" + serverName + "," + port);
            Socket socket = new Socket(serverName, port);
            log("connecting_Server_Success=" + socket.getRemoteSocketAddress());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream.writeUTF("client_send_message_to_server");
            dataOutputStream.writeInt(10);
            log("server_echo=" + dataInputStream.readUTF());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void log(String s) {
        Utils.log("client_" + s);
    }
}
