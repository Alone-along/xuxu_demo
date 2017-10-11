package com.alone.xiangqin.service;

import com.alone.xiangqin.pojo.User;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;
import java.util.List;
import java.util.Map;


/* 用户的 业务层接口*/
public interface UserService {

    /**
     * 根据用户名,查找并且返回找到的用户数量
     * @param userName 需要检查的用户名
     * @return 返回用户数量
     */
    int getUserCountForRegist(String userName);

    /**
     * 保存一个用户信息
     * @param user
     * @throws SolrServerException
     * @throws IOException
     */
    void saveUser(User user) throws SolrServerException, IOException;

    /**
     * 根据用户名,和密码.登陆一个User
     * @param userForm 想要登陆的用户
     * @return Null 表示没有登陆成功. User 实体类 表示登陆成功了
     */
    User getUserForLogin(User userForm);


    /**
     * 更新一个用户信息
     * @param user 需要跟新的用户信息
     * @throws SolrServerException
     * @throws IOException
     */
    void updateUser(User user) throws SolrServerException, IOException;

    /**
     * 根据主键查询,并且返回一个User
     * @param userId
     * @return 查询到的user 信息
     */
    User getUserById(Integer userId);

    /**
     * 使用Solr 中做搜索操作
     * @param keywords
     * @return
     * @throws SolrServerException
     */
    List<Map<String, String>> getDataFromSolrIndex(String keywords) throws SolrServerException;
}
