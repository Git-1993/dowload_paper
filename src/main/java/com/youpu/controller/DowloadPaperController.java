package com.youpu.controller;

import com.youpu.service.DowloadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DowloadPaperController {
    @Autowired
    private DowloadService dowloadService;
    @RequestMapping(value = "/dowload/**" ,method = RequestMethod.GET)
    public String dowloadPaper(@PathVariable("url") String url){
        String dowloadUrl = dowloadService.dowloadPaper(url);
        return dowloadUrl;
    }
}
