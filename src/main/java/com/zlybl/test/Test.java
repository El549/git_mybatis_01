package com.zlybl.test;

import com.zlybl.mapper.BookMapper;
import com.zlybl.pojo.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws IOException, ParseException {
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
        Scanner in=new Scanner(System.in);
        Book book=new Book();
        System.out.println("需要添加加的书名为：");
        book.setBname(in.next());
        System.out.println("需要增加的书的作者为：");
        book.setAuthor(in.next());
        System.out.println("新书的价格为：");
        book.setPrice(in.nextInt());
        System.out.println("新书的出版社为：");
        book.setPress(in.next());
        System.out.println("新书的出版时间为(格式为yyyy-MM-dd hh:mm:ss)");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        in.useDelimiter("\n");
        String a=in.next();
        Date date = sdf.parse(a);
        book.setSaletime(date);
        int flag= mapper.addBook(book);
        if(flag>0){
            System.out.println("添加成功，请在数据库中查看");
        }else{
            System.out.println("添加失败");
        }

    }
}
