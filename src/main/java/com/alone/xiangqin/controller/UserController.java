package com.alone.xiangqin.controller;

import com.alone.xiangqin.pojo.User;
import org.apache.solr.client.solrj.SolrServerException;
import org.csource.common.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@Controller
public class UserController {
    @RequestMapping("/demo/user/search_detail/{userId}")
    public String searchDetail(@PathVariable("userId") Integer userId, Map<String, Object> map) {

        return null;
    }

    @RequestMapping("/demo/user/search")
    public String search(@RequestParam("keywords") String keywords, Model model) throws SolrServerException {
        return null;
    }

    @RequestMapping("/demo/user/update")
    public String update(User user, @RequestParam("headPicture") MultipartFile headPicture, HttpSession session) throws IOException, MyException, SolrServerException {
        return null;
    }

    @RequestMapping("/demo/user/logout")
    public String logout(HttpSession session) {
        return null;
    }

    @RequestMapping("demo/user/login")
    public String login(User userForm, HttpSession session, Map<String,Object> map) {
        return null;
    }

    @RequestMapping("/demo/user/regist")
    public String regist(User user, Map<String,Object> map) throws SolrServerException, IOException {
        return null;
    }
}
