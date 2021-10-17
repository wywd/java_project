package com.wangyu.io;

import java.io.*;

/**
 * class FileInputOutputStreamTest
 * 测试FileInputStream和FileOutputStream的使用
 **
  * method 结论：
  *  1. 对于文本文件(.txt,.java,.c,.cpp)，使用字符流处理
  *  2. 对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt,...)，使用字节流处理
  *
  **/
public class FileInputOutputStreamTest {
    public static void main(String[] args) throws IOException {
        FileInputOutputStreamTest fileInputOutputStreamTest = new FileInputOutputStreamTest();
//        fileInputOutputStreamTest.testFileInputStream();
//        fileInputOutputStreamTest.testFileInputOutputStream();
        fileInputOutputStreamTest.testCopyFile();
    }

    public void testFileInputStream() throws IOException {
        // 1. 造文件
        File file = new File("01_java_core/hello.txt");
        // 2. 造流
        FileInputStream fis = new FileInputStream(file);
        // 3. 读数据
        byte[] buffer = new byte[5];
        int len;  // 每次记录读取的字节个数
        while ((len = fis.read(buffer)) != -1) {
            String str = new String(buffer, 0, len);
            System.out.print(str);
        }
        // 4. 关闭资源
        fis.close();
    }

    /**
     * 实现对图片的复制操作
     */
    public void testFileInputOutputStream() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //1.造文件
            File srcFile = new File("01_java_core/1.jpg");
            File destFile = new File("01_java_core/2.jpg");

            //2.造流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //3.复制的过程
            byte[] buffer = new byte[5];
            int len;
            //4.读数据
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                //5.关闭资源
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public void copyFile(String srcPath, String destPath) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            //
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //复制的过程
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                //
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public void testCopyFile(){

        long start = System.currentTimeMillis();

        String srcPath = "C:\\Users\\wangyu\\Desktop\\公司数据反馈\\output.mp4";
        String destPath = "C:\\Users\\wangyu\\Desktop\\公司数据反馈\\output1.mp4";

//        String srcPath = "01_java_core/hello.txt";
//        String destPath = "01_java_core/hello3.txt";

        copyFile(srcPath,destPath);

        long end = System.currentTimeMillis();

        System.out.println("复制操作花费的时间为：" + (end - start) + "ms"); // 4915ms
    }
}