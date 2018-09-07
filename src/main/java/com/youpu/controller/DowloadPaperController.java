package com.youpu.controller;

import com.youpu.Util.CreateHTML;
import com.youpu.Util.ExtractPathFromPattern;
import com.youpu.Util.HttpClientUtil;
import com.youpu.entity.PaperInfo;
import com.youpu.service.DowloadService;
import net.sf.json.JSONObject;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
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
    public String dowloadPaper2(@PathVariable("uid") String uid,@PathVariable("paperid") String paperid) {
        //get score info(远程调用接口)  测试地址http://120.27.195.10:8090/das/paper/manage/previewCommon?sid=603a8acc-94d1-4a2e-8d1a-148c1161e283&uid=1070777126&paperinfoid=7124
        String url = "http://localhost:8080/detector/api/view/v51/getPaperDetail";
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        if (!StringUtils.isEmpty(uid)) {
            params.add(new BasicNameValuePair("uid", uid));
        }
        if (!StringUtils.isEmpty(paperid)) {
            params.add(new BasicNameValuePair("paperinfoid", paperid));
        }
        //JSONObject转成对象
        JSONObject jsonObject = HttpClientUtil.getJSONObject(url, params);
        //Map<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> map = (Map<String, Object>) JSONObject.toBean(jsonObject,Map.class);
        //用过渲染引擎将模板渲染成静态页面
        String htmlPath = CreateHTML.createHtml(map);
        //生成word
        String objectKey = dowloadService.dowloadPaper(htmlPath);
        //call(远程调用接口)
        return objectKey;
    }
}