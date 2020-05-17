package test;

import com.sun.jndi.toolkit.url.Uri;
import common.Utils;

import java.net.MalformedURLException;
import java.net.URI;

/**
 * Created by better on 2020/2/23.
 */
public class Url {
    static final String URL = "http://speedtest2.sc.189.cn:80/speedtest/upload.php";

    public static void main(String[] args) {
        try {
            URI url = new URI(URL);
            Utils.log("url", url);
            Utils.log("url resolve", url.resolve("random4000x4000.jpg"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
