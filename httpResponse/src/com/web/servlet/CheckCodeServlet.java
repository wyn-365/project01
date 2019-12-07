package com.web.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int width=100;
        int height=50;
        //1创建一个对象，在呢村中画一个图，验证图片对象
        BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //2美化图片
          //填充背景色
        Graphics g = image.getGraphics();
        g.setColor(Color.PINK);//画笔颜色
        g.fillRect(0,0,width,height);

          //画边框
        g.setColor(Color.BLUE);
        g.drawRect(0,0,width-1,height-1);


        String str = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuioplkjhgfdsazxcvbnm0123456789";
        //创建随机类、
        Random ran = new Random();
        //验证码
        g.setColor(Color.BLUE);

        for (int i = 1; i <=4 ; i++) {
            int index = ran.nextInt(str.length());
            //获取字符
            char ch = str.charAt(index);
            g.drawString(ch+"",width/5*i,height/2);
        }



        //画干扰线
        g.setColor(Color.GREEN);

        for (int i = 1; i <=10 ; i++) {
            //随机生成坐标点
            int x1 = ran.nextInt(width);
            int x2 = ran.nextInt(width);
            int y1 = ran.nextInt(height);
            int y2 = ran.nextInt(height);
            g.drawLine(x1,x2,y1,y2);
        }




        //3将图片输出到页面上展示  输出流
        ImageIO.write(image,"jpg",response.getOutputStream());




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
