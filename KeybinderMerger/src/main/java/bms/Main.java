package bms;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class Main {

    private int port = 7000;

    public Main(Integer port) throws Exception {
        if (port != null) this.port = port;

        init(port);
    }

    private void init(Integer port) throws Exception {
        Javalin app = Javalin.create(config -> {
            config.addStaticFiles("html", Location.EXTERNAL);
        }).start(7000);
        //openBrowser("http:/localhost:"+ port);
    }

    private void openBrowser(String url) {
        if(Desktop.isDesktopSupported()){
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("xdg-open " + url);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {

        if (args.length > 0) {
         new Main(Integer.parseInt(args[0]));
        } else {
            new Main(null);
        }
    }
}
