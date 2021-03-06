package com.wangyu.io;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * 处理流之二：转换流的使用
 * 1.转换流：属于字符流
 *      InputStreamReader：将一个字节的输入流转换为字符的输入流
 *      OutputStreamWriter：将一个字符的输出流转换为字节的输出流
 *
 * 2.作用：提供字节流与字符流之间的转换
 *
 * 3.解码：字节、字节数组  --->字符数组、字符串
 *   编码：字符数组、字符串 ---> 字节、字节数组
 *
 * 4.字符集
 */
public class InputStreamReaderTest {
    public static void main(String[] args) throws IOException {
        InputStreamReaderTest inputStreamReaderTest = new InputStreamReaderTest();
//        inputStreamReaderTest.test();
        inputStreamReaderTest.test2();
    }
    /**
     * 此时处理异常的话，仍然应该使用try-catch-finally
     * InputStreamReader的使用，实现字节的输入流到字符的输入流的转换
     */
    public void test() throws IOException {

        FileInputStream fis = new FileInputStream("01_java_core/hello.txt");
//        InputStreamReader isr = new InputStreamReader(fis);//使用系统默认的字符集
        //参数2指明了字符集，具体使用哪个字符集，取决于文件dbcp.txt保存时使用的字符集
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);//使用系统默认的字符集

        char[] cbuf = new char[20];
        int len;
        while ((len = isr.read(cbuf)) != -1) {
            String str = new String(cbuf, 0, len);
            System.out.print(str);
        }

        isr.close();
    }

    /**
     * 此时处理异常的话，仍然应该使用try-catch-finally
     * 综合使用InputStreamReader和OutputStreamWriter
     */
    public void test2() throws IOException {
        //1.造文件、造流
        File file1 = new File("01_java_core/hello.txt");
        File file2 = new File("01_java_core/hello_gbk.txt");

        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);

        InputStreamReader isr = new InputStreamReader(fis,"utf-8");
        OutputStreamWriter osw = new OutputStreamWriter(fos,"gbk");

        //2.读写过程
        char[] cbuf = new char[20];
        int len;
        while((len = isr.read(cbuf)) != -1){
            osw.write(cbuf,0,len);
        }

        //3.关闭资源
        isr.close();
        osw.close();
    }
}