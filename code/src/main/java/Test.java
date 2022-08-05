import binarytree.TreeNode;
import com.sun.xml.internal.bind.v2.model.core.ID;
import sun.misc.Launcher;
import sun.rmi.runtime.Log;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author hawk
 * @package PACKAGE_NAME
 * @desc
 * @date 2021/11/11
 */
public class Test {
    public static void main(String[] args) {
        WeakReference<Object> weakReference = new WeakReference<>(new Object());
        System.out.println("before gc: " + weakReference.get());
        System.gc();
        System.out.println("after gc: " + weakReference.get());


        Object obj = new Object();
        WeakReference<Object> weakReference2 = new WeakReference<>(obj);
        System.out.println("before gc: " + weakReference2.get());
        System.gc();
        System.out.println("after gc: " + weakReference2.get());
    }
}

