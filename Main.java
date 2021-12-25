import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class Main {
    File output;

    public static void main(String[] args) {
        try {
            new Main();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Main() throws Exception {
        File f = new File(System.getProperty("java.class.path"));
        File jarDir = f.getAbsoluteFile().getParentFile();
        output = new File(jarDir, "output");

        if (!output.mkdir()) {
            throw new Exception();
        }

        File o = new File(output, "output.txt");

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(UUID.randomUUID().toString());
        }

        Files.write(o.toPath(), list, StandardCharsets.UTF_8, StandardOpenOption.CREATE_NEW);
    }
}