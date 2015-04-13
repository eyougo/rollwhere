package com.eyougo.rollwhere.web;

import com.eyougo.rollwhere.dao.UrlDao;
import org.apache.commons.lang3.math.NumberUtils;
import org.codehaus.jackson.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;

/**
 * User: mei
 * Date: 5/17/14
 * Time: 17:31
 */
@Controller
@RequestMapping
public class WebController {

    protected MessageSource messageSource;

    @Autowired
    @Required
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Autowired
    private UrlDao urlDao;

    @RequestMapping("/")
    public String index(Model model){
        Long urlCount = urlDao.getUrlCount();
        model.addAttribute("urlCount", urlCount);
        return "index.ftl";
    }

    @RequestMapping("/roll")
    @ResponseBody
    public Map<String, String> roll(){
        String url = urlDao.getRandomUrl();
        Map<String, String> map = new HashMap<String, String>();
        map.put("url", url);
        return map;
    }
}
