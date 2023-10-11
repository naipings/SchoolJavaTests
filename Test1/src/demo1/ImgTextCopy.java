package src.demo1;

import java.io.*;

import static src.demo1.FileCompare.arrayList1;
import static src.demo1.FileCopyer.arrayList;

public class ImgTextCopy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileCopyer copyer = new FileCopyer();

		String sourcePath = "http://10.122.7.154/javaweb/data/images-url.txt";
		String targetPath = "E:\\IntelliJ_IDEA\\schoolStudy\\Test1\\text\\text.txt";
		try {
			copyer.copyFromWeb(sourcePath, targetPath);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		try {
			copyer.testReadFile(targetPath);
			for ( int i=1; i< arrayList.size()+1; i++ ) {
				String targetPath0 = String.format("C:\\images\\www.swu.edu.cn\\xywh\\zhanbanzongban\\0%d.jpg", i);
				copyer.copyFromWeb(arrayList.get(i-1), targetPath0);
			}

		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		FileCompare fileCompare = new FileCompare();
		String s = "C:\\images\\www.swu.edu.cn\\xywh\\zhanbanzongban\\";
		fileCompare.orderByLength(s);
		String[] strings = new String[arrayList1.size()];
		try {
			String targetPath1 = "C:\\images\\images-sorted.txt";
			for ( int i=0; i< arrayList1.size(); i++ ) {
				//System.out.println(s+arrayList1.get(i));
				strings[i] = s+arrayList1.get(i);
			}
			copyer.testWriteFile(strings, targetPath1);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}


	}

}
