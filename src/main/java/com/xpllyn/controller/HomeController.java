package com.xpllyn.controller;

import com.xpllyn.pojo.Log;
import com.xpllyn.pojo.Message;
import com.xpllyn.service.impl.LogService;
import com.xpllyn.service.impl.MessageService;
import com.xpllyn.utils.BlogUtils;
import com.xpllyn.utils.BookUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class HomeController {

    @Autowired
    BookUtils bookUtil = null;

    @Autowired
    BlogUtils blogUtils = null;

    @Autowired
    MessageService messageService = null;

    @Autowired
    LogService logService = null;

    //首页
    @RequestMapping("/")
    public ModelAndView home(HttpServletRequest request){
        //插入一条访问日志
        Log log = logService.assembleLogObject("visit", request);
        logService.insertLog(log);

        ModelAndView mv = new ModelAndView();

        //获取书本
        List bookList = null;
        try {
            bookList = bookUtil.getFileName("classpath:static/book");
            //bookList = bookUtil.getFileName("/opt/book");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //获取最近文章标题和发表时间和url
        List blogList = null;
        blogList = blogUtils.getBlogInfo();

        //若blog数量小于6，则显示blog实际的篇数，否则显示6篇
        int blogCount = 0;
        if(blogList.size() < 6){
            blogCount = blogList.size();
        }
        else{
            blogCount = 6;
        }

        //获取最近8条评论
        List<Message> messageList = messageService.getAllMessages();
        int messageCount = messageList.size();
        if(messageCount > 8){
            messageCount = 8;
        }

        mv.addObject("blogCount",blogCount);
        mv.addObject("blogList",blogList);
        mv.addObject("bookList", bookList);
        mv.addObject("messageList",messageList);
        mv.addObject("messageCount" ,messageCount);
        mv.setViewName("homepage");
        return mv;
    }
}
