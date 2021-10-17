package com.wangyu.io;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile的使用
 * 1.RandomAccessFile直接继承于java.lang.Object类，实现了DataInput和DataOutput接口
 * 2.RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
 * 3.如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建。
 *   如果写出到的文件存在，则会对原有文件内容进行覆盖。（默认情况下，从头覆盖）
 */
public class RandomAccessFileTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFileTest randomAccessFileTest = new RandomAccessFileTest();
//        randomAccessFileTest.test();
        randomAccessFileTest.test2();
    }
    public void test(){

        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("01_java_core/1.jpg"),"r");
            raf2 = new RandomAccessFile(new File("01_java_core/1-1.jpg"),"rw");

            byte[] buffer = new byte[1024];
            int len;
            while((len = raf1.read(buffer)) != -1){
                raf2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(raf1 != null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(raf2 != null){
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void test2() throws IOException {

        RandomAccessFile raf1 = new RandomAccessFile("01_java_core/hello.txt","rw");

        raf1.seek(3);
        raf1.write("xyz".getBytes());

        raf1.close();

    }
}
