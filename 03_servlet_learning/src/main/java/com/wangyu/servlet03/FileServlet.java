package com.wangyu.servlet03;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * class FileServlet
 *
 * @Description //下载文件的例子
 * @Author wangyu
 * @Date 2021/9/7 16:16
 **/
public class FileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 获取下载文件的路径
        String realPath = "D:\\study\\codeProjects\\java_project\\servlet_learning\\src\\main\\resources\\1.jpg";
        System.out.println("下载文件路径： " + realPath);
        // 2. 下载的文件名是啥
        String fileName = realPath.substring(realPath.lastIndexOf("\\") + 1);
        // 3. 设置想办法让浏览器支持下载我们的资源
        resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName,"UTF-8"));
        // 4. 获取下载文件的输入流
        FileInputStream inputStream = new FileInputStream(realPath);
        // 5. 创建缓冲区
        int len = 0;
        byte[] buffer = new byte[1024];
        // 6. 获取OutputStream对象
        ServletOutputStream outputStream = resp.getOutputStream();
        // 7. 将FileInputStream流写入到buffer缓冲区; 8. 使用OutputStream将缓冲区的数据输出到客户端
        while ((len = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, len);
        }
        // 9. 关闭输入输出流
        inputStream.close();
        outputStream.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
