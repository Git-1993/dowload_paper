package com.youpu.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class CreateHTML {
    public static String createHtml(Map<String, Object> map) {
        try {
            //创建一个合适的Configration对象
            Configuration configuration = new Configuration();
            configuration.setDirectoryForTemplateLoading(new File("D:\\dowload_paper\\src\\main\\resources\\templates"));
            configuration.setObjectWrapper(new DefaultObjectWrapper());
            configuration.setDefaultEncoding("UTF-8");   //这个一定要设置，不然在生成的页面中 会乱码
            //获取或创建一个模版。
            Template template = configuration.getTemplate("temp.html");
            Map<String, Object> paramMap = new HashMap<String, Object>();
            List<String> nameList = new ArrayList<String>();
            Map<String, Object> weaponMap = new HashMap<String, Object>();

            Writer writer  = new OutputStreamWriter(new FileOutputStream("success.html"),"UTF-8");
            template.process(paramMap, writer);

            System.out.println("恭喜，生成成功~~");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return "result.html.path";
    }

}
