package com.crawler.webmargic.main;

import com.crawler.model.common.RequestTaskModel;
import com.crawler.service.ICrawlerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 知乎main方法测试
 *
 * @author Liukx
 * @create 2017-03-30 17:01
 * @email liukx@elab-plus.com
 **/
public class ZhiHuTest {

    public static void main(String[] args) throws Exception {
        // 1. 周杰伦歌曲评论地址:http://music.163.com/artist?id=6452
        String[] xml = new String[]{"classpath:root-context.xml"};
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xml);
        ICrawlerService zhiHuService = (ICrawlerService) applicationContext.getBean("zhiHuService");
        RequestTaskModel requestTaskModel = new RequestTaskModel();
        //https://www.zhihu.com/question/27660727?utm_source=com.netease.mobimail&utm_medium=social
        requestTaskModel.setUrl("https://www.zhihu.com/question/19770699");
        zhiHuService.crawler(requestTaskModel);
//        zhiHuService.zhCrawler("周杰伦");
    }
}
