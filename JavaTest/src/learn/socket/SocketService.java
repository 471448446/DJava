package learn.socket;


import common.Utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by better on 2017/4/9.
 */
public class SocketService extends Thread {
    ServerSocket serverSocket;

    public SocketService(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    @Override
    public void run() {
        super.run();
        while (true) {
            try {
                log("wait for connecting:" + serverSocket.getLocalPort());
                Socket server = serverSocket.accept();
                log("connect client success:" + server.getLocalSocketAddress());
                DataInputStream dataInputStream = new DataInputStream(server.getInputStream());
                DataOutputStream dataOutputStream = new DataOutputStream(server.getOutputStream());
                log("get message from client:"+dataInputStream.readUTF());
                log("get message from client:"+dataInputStream.readInt());
                dataOutputStream.writeUTF("you had connected server:" + server.getLocalSocketAddress() + " echo bye!");
                serverSocket.close();
                log("ÍË³öÏß³Ì");
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void log(String s) {
        Utils.log("server_" + s);
    }

}
