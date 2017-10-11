package com.alone.xiangqin.service.impl;

import com.alone.xiangqin.mapper.UserMapper;
import com.alone.xiangqin.pojo.User;
import com.alone.xiangqin.service.UserService;
import com.github.abel533.entity.Example;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    /**
     * 添加依赖关系,User 依赖
     */
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SolrServer solrServer;


    /**
     * 根据用户名,查找并且返回找到的用户数量
     *
     * @param userName 需要检查的用户名
     * @return 返回用户数量
     */
    @Override
    public int getUserCountForRegist(String userName) {

        Example example = new Example(User.class);

        Example.Criteria criteria = example.createCriteria();

        criteria.andEqualTo("userName", userName);

        int resultCount = userMapper.selectCountByExample(example);

        return resultCount;
    }

    /**
     * 保存一个用户信息
     *
     * @param user
     * @throws SolrServerException
     * @throws IOException
     */
    @Override
    public void saveUser(User user) throws SolrServerException, IOException {
        //添加到数据库中啊
        userMapper.insert(user);


        //添加到Solr 中
        //将用户信息保存到索引库中
        //1.创建文档对象
        SolrInputDocument solrInputDocument = new SolrInputDocument();

        //2.添加必要的字段
        solrInputDocument.addField("id",user.getUserId());
        solrInputDocument.addField("user_nick",user.getUserNick());

        //3.使用SolrServer对象执行文档的添加操作
        solrServer.add(solrInputDocument);
        solrServer.commit();
    }

    /**
     * 根据用户名,和密码.登陆一个User
     *
     * @param userForm 想要登陆的用户
     * @return Null 表示没有登陆成功. User 实体类 表示登陆成功了
     */
    @Override
    public User getUserForLogin(User userForm) {
        return null;
    }

    /**
     * 更新一个用户信息
     *
     * @param user 需要跟新的用户信息
     * @throws SolrServerException
     * @throws IOException
     */
    @Override
    public void updateUser(User user) throws SolrServerException, IOException {
        //先修改数据库中的数据
        userMapper.updateByPrimaryKeySelective(user);

        //修改solr中的数据
        
    }

    /**
     * 根据主键查询,并且返回一个User
     *
     * @param userId
     * @return 查询到的user 信息
     */
    @Override
    public User getUserById(Integer userId) {
        return null;
    }

    /**
     * 使用Solr 中做搜索操作
     *
     * @param keywords
     * @return
     * @throws SolrServerException
     */
    @Override
    public List<Map<String, String>> getDataFromSolrIndex(String keywords) throws SolrServerException {
        return null;
    }
}
