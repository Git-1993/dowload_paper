package com.youpu.controller;

import com.youpu.Util.CreateHTML;
import com.youpu.Util.ExtractPathFromPattern;
import com.youpu.Util.HttpClientUtil;
import com.youpu.service.DowloadService;
import net.sf.json.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class DowloadPaperController {
    @Autowired
    private DowloadService dowloadService;

    @RequestMapping(value = "/dowload/**", method = RequestMethod.GET)
    public String dowloadPaper(HttpServletRequest request) {
        String url = ExtractPathFromPattern.extractPathFromPattern(request);
        String objectKey = dowloadService.dowloadPaper("http://" + url);
        return objectKey;
    }

    @RequestMapping(value = "/dowload/{uid}/{paperid}", method = RequestMethod.GET)
    public void dowloadPaper2(@PathVariable("uid") String uid,@PathVariable("paperid") String paperid,HttpServletResponse response) {
        //get score info(远程调用接口)  测试地址http://120.27.195.10:8090/das/paper/manage/previewCommon?sid=603a8acc-94d1-4a2e-8d1a-148c1161e283&uid=1070777126&paperinfoid=7124
        String url = "http://120.27.195.10:8090/das/paper/manage/detail";
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        if (!StringUtils.isEmpty(uid)) {
            params.add(new BasicNameValuePair("uid", uid));
        }
        if (!StringUtils.isEmpty(paperid)) {
            params.add(new BasicNameValuePair("paperinfoid", paperid));
        }
        //JSONObject转成对象
        JSONObject jsonObject = HttpClientUtil.getJSONObject(url, params);
        System.out.println(jsonObject.toString());
        //Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> map = (Map<String, Object>) JSONObject.toBean(jsonObject,Map.class);
        //用过渲染引擎将模板渲染成静态页面
        String htmlPath = CreateHTML.createHtml(map);
        //生成word
        String shijuanPath = dowloadService.dowloadPaper(htmlPath);
        //StringBuffer url = request.getRequestURL();
        //String url="http://192.168.1.142:8888/ws/dowload/http://cs.emingren.com:9100/decision/views/myPages/examinationService/preView.html";
        //String objectName = get(url);
        //OssUtil.testDowload(objectKey,"D:\\ww2.doc");
        File file = new File(shijuanPath);
        //响应文件下载
        response.setHeader("Content-Disposition", "attachment; filename=\"" +file.getName());
        response.setContentType("application/msword;charset=UTF-8");
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(file);
            out = response.getOutputStream();
            // 写文件
            int b;
            //byte[] bytes = new byte[1024];
            while ((b = in.read()) != -1) {
                out.write(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            file.delete();
        }
    }
    @RequestMapping(value = "/dowload", method = RequestMethod.GET)
    public String dowloadPaperTest() {
        //JSONObject转成对象
        File file = new File("C:\\file\\paperInfo.txt");
        FileReader reader = null;//定义一个fileReader对象，用来初始化BufferedReader
        BufferedReader bReader = null;
        try {
//            reader = new FileReader(file);
//            reader.getEncoding();
              bReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //BufferedReader bReader = new BufferedReader(reader);//new一个BufferedReader对象，将文件内容读取到缓存
        StringBuilder sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中
        String s = "";
        try {
            while ((s =bReader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
                sb.append(s + "\n");//将读取的字符串添加换行符后累加存放在缓存中
                System.out.println(s);
            }
            bReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = sb.toString();
        JSONObject jsonObject = JSONObject.fromObject(str);
        Map<String, Object> map = (Map<String, Object>) JSONObject.toBean(jsonObject,Map.class);
        //用过渲染引擎将模板渲染成静态页面
        String htmlPath = CreateHTML.createHtml(map);
        //生成word
        String objectKey = dowloadService.dowloadPaper(htmlPath);
        //call(远程调用接口)
        return objectKey;
    }
}