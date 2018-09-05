package com.youpu.controller;

import com.youpu.service.DowloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;

@RestController
public class DowloadPaperController {
    @Autowired
    private DowloadService dowloadService;
    @RequestMapping(value = "/dowload/**" ,method = RequestMethod.GET)
    public String dowloadPaper(HttpServletRequest request){
        String url = extractPathFromPattern(request);
        String dowloadUrl = dowloadService.dowloadPaper("http://"+url);
        return dowloadUrl;
    }

    //    把指定URL后的字符串全部截断当成参数
    //    这么做是为了防止URL中包含中文或者特殊字符（/等）时，匹配不了的问题
    private static String extractPathFromPattern(
            final HttpServletRequest request)
    {
        String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        String bestMatchPattern = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
        return new AntPathMatcher().extractPathWithinPattern(bestMatchPattern, path);
    }
}
