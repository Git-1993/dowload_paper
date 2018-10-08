package com.youpu.service;


import com.youpu.Util.DeleteFileUtil;
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
import java.util.UUID;

@Service
public class DowloadServiceImpl implements DowloadService {
    String objectKey = "word_paper";

    public String dowloadPaper(String htmlPath) {
        String newFileName = "";
        File htmlFile = new File(htmlPath);
        String html2Name = UUID.randomUUID().toString();
        File html2File = new File("C:\\file\\" + "H2---+" + html2Name + ".html");
        MSOfficeGeneratorUtils officeUtils = new MSOfficeGeneratorUtils(false); // 将生成过程设置为不可见
        int imgIndex = 1;
        Map<String, String> imgMap = new HashMap<String, String>(); //存放图片标识符及物理路径  {"image_1","D:\img.png"};
        try {
            //本地文件解析
            Document document = Jsoup.parse(htmlFile, "UTF-8");
            //Document document = Jsoup.connect(url).timeout(60000).get();
            Elements elements = document.select("img");
            Elements ps = document.select("p");
            UUID uuid = UUID.randomUUID();
            String imgFolder = uuid.toString();
            for (Element img : elements) {
                img.after("${image_" + imgIndex + "}"); // 为img添加同级p标签，内容为<p>${image_imgIndexNumber}</p>
                String src = img.attr("src");
                System.out.println(src);
                // 下载图片到本地
                download(src, "image_" + imgIndex, "C:\\" + imgFolder + "\\");
                // 保存图片标识符及物理路径
                imgMap.put("${image_" + imgIndex++ + "}", src);
                // 删除Img标签
                img.remove();
            }
            //在图片操作之后防止图片链接删除
            for (Element p : ps) {
                p.after(p.text()); // 删除p标签防止word文件换行，保留p标签内的文本内容
                p.remove();
            }

            // 将html代码写到html2文件中
            FileWriter fw = new FileWriter(html2File);
            fw.write(document.html(), 0, document.html().length());// 写入文件
            fw.flush();
            fw.close();

            String shijuan = UUID.randomUUID().toString();
            newFileName = "C:\\file\\" + shijuan + ".doc";
            // temp_A3_2L.doc为A3两栏的模板，这里模板不动，复制了一个副本 用于写入数据
            FileUtils.copyFile(new File("C:\\file\\temp_A3_2L1.docx"), new File(newFileName));
            // html文件转为word
            officeUtils.html2Word(html2File.getPath(), newFileName);
            // 替换标识符为图片
            for (Map.Entry<String, String> entry : imgMap.entrySet()) {
                officeUtils.replaceText2Image(entry.getKey(), entry.getValue());
            }
            officeUtils.saveAs(newFileName);    // 保存
            officeUtils.close(); // 关闭Office Word创建的文档
            officeUtils.quit(); // 退出Office Word程序
            // 这里可以删除本地图片 略去
            DeleteFileUtil.delFolder("C:\\" + imgFolder + "");
            //删除临时html
//            File file = new File("C:\\file\\tt.html");
//            file.delete();
            //生成的word文件上传到Oss服务器
            //OssUtil.upload(objectKey,"C:\\file\\ww.doc");
//            File file2 = new File("C:\\file\\ww.doc");
//            file2.delete();
            imgIndex = 1;
            imgMap.clear();

        } catch (IOException e) {
            e.printStackTrace();
        }

        htmlFile.delete();
        html2File.delete();

        //返回新文件的路径
        return newFileName;
    }


    /**
     * 下载图片
     *
     * @param urlString 路径
     * @param filename  保存的文件名
     * @param savePath  保存路径
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
            con.setConnectTimeout(5 * 1000);
            // 输入流
            is = con.getInputStream();

            // 1K的数据缓冲
            byte[] bs = new byte[1024];
            // 读取到的数据长度
            int len;
            // 输出的文件流
            File sf = new File(savePath);
            if (!sf.exists()) {
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
