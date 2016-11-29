package transaction;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Created by yueban on 2016/11/2.
 */
public class CustomFile implements FileMethods {
    private final File file;

    public CustomFile(File file) {
        this.file = file;
    }

    @Override
    public void append(String s) {
        try {
            FileOutputStream outputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void appendWithException(String s) {
    }
}