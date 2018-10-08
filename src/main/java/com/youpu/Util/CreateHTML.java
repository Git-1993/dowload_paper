package com.youpu.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.*;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class CreateHTML {
    public static String createHtml(Map<String, Object> map) {
        UUID uuid = UUID.randomUUID();
        String htmlName = uuid.toString();
        File file = new File("C:\\file\\H1" + htmlName + ".html");
        Writer writer = null;
        try {
            //创建一个合适的Configration对象
            Configuration configuration = new Configuration();
            //configuration.setDefaultEncoding("GBK");
            configuration.setDirectoryForTemplateLoading(new File("C:\\file"));
            configuration.setObjectWrapper(new DefaultObjectWrapper());
            configuration.setDefaultEncoding("UTF-8");   //这个一定要设置，不然在生成的页面中 会乱码
            //获取或创建一个模版。
            Template template = configuration.getTemplate("temp.html");
            template.setEncoding("GBK");
            writer  = new OutputStreamWriter(new FileOutputStream(file),"UTF-8");
            template.process(map, writer);
            System.out.println("恭喜，生成成功~~");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            if(writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return file.getPath();
    }

}
