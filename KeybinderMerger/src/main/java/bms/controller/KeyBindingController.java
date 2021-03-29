package bms.controller;

import bms.domain.KeyBinding;
import io.javalin.http.Handler;
import org.apache.commons.io.FileUtils;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Objects;
import java.io.File;

public class KeyBindingController {

    public static String FILE_PATH = "file";

    public static Handler loadKeyBinding = ctx -> {

        System.out.println(ctx.path());
        String filePath = URLDecoder.decode(Objects.requireNonNull(ctx.pathParam(FILE_PATH)));
        File file = new File(filePath);
        List<String> lines = FileUtils.readLines(file, "UTF-8");

        ctx.json(new KeyBinding(file.getAbsolutePath(), lines));
    };
}
