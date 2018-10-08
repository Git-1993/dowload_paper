package com.youpu.test;

import com.sun.image.codec.jpeg.ImageFormatException;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageDecoder;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URL;

/**
 * Created by fitch on 2018/9/20.
 */
public class TestImageMerge {
    @Test
    public void testMergeImage(){
        try {
            //1.jpg是你的 主图片的路径
            File imgs = new File("C:\\Users\\fitch\\Desktop\\haibao.jpg");
            File mergeImage = new File("C:\\Users\\fitch\\Desktop\\haibao2.jpg");
            File headImg = new File("C:\\Users\\fitch\\Desktop\\qrcode.jpg");
            InputStream is = new FileInputStream(imgs);
            //通过JPEG图象流创建JPEG数据流解码器
            JPEGImageDecoder jpegDecoder = JPEGCodec.createJPEGDecoder(is);
            //解码当前JPEG数据流，返回BufferedImage对象
            BufferedImage buffImg = jpegDecoder.decodeAsBufferedImage();
            //得到画笔对象
            Graphics g = buffImg.getGraphics();

            //创建你要附加的图象。
            //小图片的路径
            ImageIcon imgIcon = new ImageIcon(headImg.getPath());

            //得到Image对象。
            Image img = imgIcon.getImage();

            //将小图片绘到大图片上。
            //5,300 .表示你的小图片在大图片上的位置。
            g.drawImage(img,750,1353,212,212,null);
//            g.drawImage(img,400,440,null);

            //设置颜色。
            g.setColor(Color.BLACK);


            //最后一个参数用来设置字体的大小，这是用来在海报上面写上字的方法
           /* Font f = new Font("宋体",Font.PLAIN,30);
            Color mycolor = Color.white;//new Color(0, 0, 255);
            g.setColor(mycolor);
            g.setFont(f);*/

            //10,20 表示这段文字在图片上的位置(x,y) .第一个是你设置的内容。
//            g.drawString(username,180,894);

            //创建你要附加的图象。
            //小图片的路径
//            ImageIcon imgIconPhone = new ImageIcon(headImg.getPath());
//
//            //得到Image对象。
//            Image imgPhone = imgIconPhone.getImage();
//
//            //将小图片绘到大图片上。
//            //5,300 .表示你的小图片在大图片上的位置。
//            g.drawImage(imgPhone,172,866,null);
//            g.drawImage(img,400,440,null);

            //设置颜色。
//            g.setColor(Color.BLACK);

            g.dispose();

            OutputStream os;

            os = new FileOutputStream(mergeImage);
//            String shareFileName = "\\upload\\" + System.currentTimeMillis() + ".jpg";
//            os = new FileOutputStream(shareFileName);
            //创键编码器，用于编码内存中的图象数据。
            JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(os);
            en.encode(buffImg);

            is.close();
            os.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ImageFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Test
    public void test2MergeImage(){
        try {
            //1.jpg是你的 主图片的路径
            File imgs = new File("C:\\Users\\fitch\\Desktop\\xqfxhaibao.jpg");
            File mergeImage = new File("C:\\Users\\fitch\\Desktop\\haibao2.jpg");
            //File headImg = new File("C:\\Users\\fitch\\Desktop\\qrcode.jpg");
            String imgURI = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=gQFh8DwAAAAAAAAAAS5odHRwOi8vd2VpeGluLnFxLmNvbS9xLzAyX3pFT2RWZ21kU2kxMDAwME0wNzAAAgRndqBbAwQAAAAA";
            URL url = new URL(imgURI);
            InputStream is = new FileInputStream(imgs);
            //通过JPEG图象流创建JPEG数据流解码器
            JPEGImageDecoder jpegDecoder = JPEGCodec.createJPEGDecoder(is);
            //解码当前JPEG数据流，返回BufferedImage对象
            BufferedImage buffImg = jpegDecoder.decodeAsBufferedImage();
            //得到画笔对象
            Graphics g = buffImg.getGraphics();
            //创建你要附加的图象。
            //小图片的路径
            ImageIcon imgIcon = new ImageIcon(url);
            //得到Image对象。
            Image img = imgIcon.getImage();

            //将小图片绘到大图片上。
            //5,300 .表示你的小图片在大图片上的位置。
            g.drawImage(img,593,958,203,186,null);
//            g.drawImage(img,400,440,null);

            //设置颜色。
            g.setColor(Color.BLACK);


            //最后一个参数用来设置字体的大小，这是用来在海报上面写上字的方法
           /* Font f = new Font("宋体",Font.PLAIN,30);
            Color mycolor = Color.white;//new Color(0, 0, 255);
            g.setColor(mycolor);
            g.setFont(f);*/

            //10,20 表示这段文字在图片上的位置(x,y) .第一个是你设置的内容。
//            g.drawString(username,180,894);

            //创建你要附加的图象。
            //小图片的路径
//            ImageIcon imgIconPhone = new ImageIcon(headImg.getPath());
//
//            //得到Image对象。
//            Image imgPhone = imgIconPhone.getImage();
//
//            //将小图片绘到大图片上。
//            //5,300 .表示你的小图片在大图片上的位置。
//            g.drawImage(imgPhone,172,866,null);
//            g.drawImage(img,400,440,null);

            //设置颜色。
//            g.setColor(Color.BLACK);

            g.dispose();

            OutputStream os;

            os = new FileOutputStream(mergeImage);
//            String shareFileName = "\\upload\\" + System.currentTimeMillis() + ".jpg";
//            os = new FileOutputStream(shareFileName);
            //创键编码器，用于编码内存中的图象数据。
            JPEGImageEncoder en = JPEGCodec.createJPEGEncoder(os);
            en.encode(buffImg);

            is.close();
            os.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ImageFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
