package test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author hawk
 * @package test
 * @desc
 * @date 2022/4/21
 */
public class MyClassLoader extends ClassLoader {

    private final String myLibrariesPath;

    public MyClassLoader(String myLibrariesPath) {
        this.myLibrariesPath = myLibrariesPath;
    }


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String fileName = getFileName(name);
        File file = new File(myLibrariesPath, fileName);
        try (FileInputStream is = new FileInputStream(file);
             ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            int len;
            while ((len = is.read()) != -1) {
                bos.write(len);
            }
            byte[] data = bos.toByteArray();

            return defineClass(name, data, 0, data.length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    private String getFileName(String path) {
        int index = path.indexOf('.');
        if (index == -1) {
            return path + ".class";
        } else {
            return path.substring(index + 1) + ".class";
        }
    }
}
