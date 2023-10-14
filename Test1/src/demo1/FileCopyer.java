package src.demo1;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static src.demo1.FileCompare.*;

public class FileCopyer {

    protected static ArrayList<String> arrayList = new ArrayList<String>();

    public void doCopy(InputStream inputStream, OutputStream outputStream) throws  IOException {
        System.out.println("do copy");

        long start = (new Date()).getTime();
        int count = -1;
        byte[] data = new byte[1024];
        while ( (count = inputStream.read(data)) != -1 ) {
            outputStream.write(data, 0 , count);
        }
        long end = (new Date()).getTime();
        System.out.println("Time Usage : " + (end-start));
    }

    //从网站读取文件
    public void copyFromWeb(String sourcePath, String targetPath) throws IOException {
        URL url = new URL(sourcePath);
        URLConnection connection = url.openConnection();

        try (InputStream inputstream = connection.getInputStream()) { //try会把 小括号里面 使用完后的对象 自动关闭
            try (FileOutputStream fileoutputstream = new FileOutputStream(targetPath)) {
                this.doCopy(inputstream, fileoutputstream);
            }
        }

    }

    //读取文件内容
    public void testReadFile(String sourcePath) throws IOException {
        try (Scanner sc = new Scanner(new FileReader(sourcePath))) {
            while ( sc.hasNextLine() ) {  //按行读取字符串
                String line = sc.nextLine();
                arrayList.add(line);
                System.out.println(line);
            }
        }
    }

    //读取文件指定内容
    public String testReadFileOrder(String sourcePath, Integer line) throws IOException {
        if ( arrayList.size() == 0 ) {
            testReadFile(sourcePath);
        }

        String rs = "666";
        //System.out.println("rs="+rs);

        //判断str中是否有xywh/子串，为true则说明有。进去if语句
        if ( arrayList.get(line).contains("xywh/") ) {
            System.out.println("yes!");
            //取得子串的初始位置
            int i = arrayList.get(line).indexOf("xywh/");
            //System.out.println("i="+i);
            i = i + 4;
            //根据的要取的内容后多少字符+多少个
            int count = 1;
            String sc = arrayList.get(line).substring(i+count,i+count+1);
            //System.out.println("sc="+sc);
            while ( !sc.equals("/") && i+count < arrayList.get(line).length() ) {
                sc = arrayList.get(line).substring(i+count,i+count+1);
                count++;
            }
            rs = arrayList.get(line).substring(i+1,i+count-1);
            //System.out.println("rs="+rs);
        }
        return rs;
    }

    //文件写入
    public void testWriteFile(String[] source, String targetPath) throws IOException {
        FileWriter fileWriter = new FileWriter(targetPath);

        for ( int i=0; i<arrayList1.size(); i++ ) {
            fileWriter.write(lengthFile.get(i)+" "+source[i]+'\n');
            fileWriter.flush();

        }
        fileWriter.close();
    }








}