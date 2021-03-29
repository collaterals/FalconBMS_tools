package bms;

import bms.controller.KeyBindingController;
import bms.domain.KeyBinding;
import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * This Main class starts a "Javalin" server and you can access it by opening localhost:7000 in your browser
 */
public class Main {

    public Main(Integer port) throws Exception {
        init(port);
    }

    public static void main(String[] args) throws Exception {

        if (args.length > 0) {
            new Main(Integer.parseInt(args[0]));
        } else {
            new Main(null);
        }
    }

    private void init(Integer port) throws Exception {

        if (port == null) {
            port = 7000;
        }

        Javalin app = Javalin.create(config -> {
            if ("true".equals(System.getenv("developmentMode"))) {
                config.addStaticFiles("src/main/resources/public", Location.EXTERNAL);
            } else {
                config.addStaticFiles("/public", Location.CLASSPATH);
            }
        }).start(port);

        app.get("/keyBinding/:file", KeyBindingController.loadKeyBinding);

        //openBrowser("http:/localhost:"+ port);
    }

    public KeyBinding loadKeyBinding(String filePath) {
        return null;
    }

    private void openBrowser(String url) {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec("xdg-open " + url);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }


}
