package com.zlybl.test;

import com.zlybl.mapper.BookMapper;
import com.zlybl.pojo.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        //读取配置文件mybatis-config.xml
        InputStream config = Resources.getResourceAsStream("config/mybatis-config.xml");
        // 根据配置文件构建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(config);
        // 通过SqlSessionFactory创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 通过SqlSession对象获取BookMapper的代理对象
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);

        // 使用代理mapper对象查询全部的用户信息
        List<Book> list = mapper.selectAll();
        //输出内容
        System.out.println(list);

    }
}
