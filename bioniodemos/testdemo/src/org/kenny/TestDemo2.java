package org.kenny;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
 


public class TestDemo2 {

	public static void main(String[] args) throws IOException, Exception {
		 
		FileInputStream fis=new FileInputStream("stu.dat");
		ObjectInputStream ois=new ObjectInputStream(fis);
		try {
			while(true) {
			Student stu=(Student) ois.readObject();
			System.out.println(stu);
			}
		} catch (EOFException e) {
			// TODO Auto-generated catch block
			System.out.println("End of file");
		}
	}

}
