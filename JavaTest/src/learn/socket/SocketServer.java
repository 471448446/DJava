package learn.socket;

import java.io.IOException;

/**
 * Created by better on 2017/4/9.
 */
public class SocketServer {
    public static final int port=6666;
    public static void main(String[] args){
        try {
            new SocketService(port).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
