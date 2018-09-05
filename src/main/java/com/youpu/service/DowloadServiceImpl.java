package com.youpu.service;


import com.youpu.Util.MSOfficeGeneratorUtils;
import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

@Service
public class DowloadServiceImpl implements DowloadService {

    public String dowloadPaper(String url) {
        MSOfficeGeneratorUtils officeUtils = new MSOfficeGeneratorUtils(false); // 将生成过程设置为不可见
        int imgIndex = 1;
        Map<String, String> imgMap = new HashMap<String, String>(); //存放图片标识符及物理路径  {"image_1","D:\img.png"};
        try {
            Document document = Jsoup.connect(url).timeout(60000).get();
            Elements elements = document.select("img");

            for (Element img : elements){
                img.after("${image_" + imgIndex + "}"); // 为img添加同级p标签，内容为<p>${image_imgIndexNumber}</p>
                String src = img.attr("src");
                System.out.println(src);
                // 下载图片到本地
                download(src,"image_"+imgIndex,"D:\\imgs\\");
                // 保存图片标识符及物理路径
                imgMap.put("${image_" + imgIndex++ + "}", src);
                // 删除Img标签
                img.remove();
            }
            // 将html代码写到html文件中
            FileWriter fw = new FileWriter("D:\\tt.html");
            fw.write(document.html(), 0, document.html().length());// 写入文件
            fw.flush();
            fw.close();

            String newFileName = "D:\\ww.doc";
            // temp_A3_2L.doc为A3两栏的模板，这里模板不动，复制了一个副本 用于写入数据
            FileUtils.copyFile(new File("D:\\temp_A3_2L1.docx"),new File(newFileName));
            // html文件转为word
            officeUtils.html2Word("D:\\tt.html",newFileName);


            // 替换标识符为图片
            for (Map.Entry<String, String> entry : imgMap.entrySet()){
                officeUtils.replaceText2Image(entry.getKey(), entry.getValue());
            }
            officeUtils.saveAs(newFileName);    // 保存
            officeUtils.close(); // 关闭Office Word创建的文档
            officeUtils.quit(); // 退出Office Word程序

            // 这里可以删除本地图片 略去

            imgIndex = 1;
            imgMap.clear();

        } catch (IOException e) {
            e.printStackTrace();
        }
        //返回试卷下载链接
        return "123";
    }


    /**
     * 下载图片
     * @param urlString  路径
     * @param filename   保存的文件名
     * @param savePath   保存路径
     */
    public static void download(String urlString, String filename, String savePath) {
        InputStream is = null;
        OutputStream os = null;
        try {
            // 构造URL
            URL url = new URL(urlString);
            // 打开连接
            URLConnection con = url.openConnection();
            //设置请求超时为5s
            con.setConnectTimeout(5*1000);
            // 输入流
            is = con.getInputStream();

            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流
            File sf=new File(savePath);
            if(!sf.exists()){
                sf.mkdirs();
            }
            os = new FileOutputStream(sf.getPath() + "\\" + filename);
            // 开始读取
            while ((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            // 完毕，关闭所有链接
            os.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 查1



//    public User queryOne(@PathParam("uid") int uid,@PathParam("id") int id) {
//        System.out.println("in restful server... uid=" + uid +", id=" + id);
//        return new User(uid, "张三");
//    }/queryOne/{uid}/{id}"
}
