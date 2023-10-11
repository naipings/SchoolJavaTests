package src.demo1;

import java.io.*;
import java.util.*;

public class FileCompare {

    protected static ArrayList<String> arrayList1 = new ArrayList<String>();

    //按照文件大小降序排序
    public static void orderByLength(String filePath) {
        List<File> files = Arrays.asList(new File(filePath).listFiles());
        Collections.sort(files, new Comparator< File>() {
            public int compare(File f1, File f2) {
                long diff = f1.length() - f2.length();
                if (diff < 0) //如果想要升序，就把<改成>
                    return 1;
                else if (diff == 0)
                    return 0;
                else
                    return -1;
            }
            public boolean equals(Object obj) {
                return true;
            }
        });
        for (File f : files) {
            if(f.isDirectory()) continue;
            arrayList1.add(f.getName());
            //System.out.println(arrayList1.get(0));
            System.out.println(f.getName()+": "+f.length()+" type");
        }
    }

}
