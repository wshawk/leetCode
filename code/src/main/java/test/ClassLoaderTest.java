package test;

import java.lang.reflect.Method;

/**
 * @author hawk
 * @package test
 * @desc
 * @date 2022/4/21
 */
public class ClassLoaderTest {
    public static void main(String[] args) {
        MyClassLoader myClassLoader = new MyClassLoader("D:\\CODE\\GitHub\\leetCode\\code\\src\\main\\java\\test");
        try {
            Class cl = myClassLoader.loadClass("test.Say");
            if (cl != null){
                try {
                    Object o = cl.newInstance();
                    Method method = cl.getDeclaredMethod("say", null);
                    method.invoke(o, null);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
