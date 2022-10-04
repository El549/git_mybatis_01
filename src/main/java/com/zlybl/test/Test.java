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



        //主界面功能选择
        int flag = 1;
        while (flag > 0){
            System.out.println("欢迎进入图书管理系统：");
            System.out.println("1.全查");
            System.out.println("2.添加");
            System.out.println("3.删除");
            System.out.println("4.修改");
            System.out.println("0.退出");
            System.out.println("请选择：");
            Scanner scan = new Scanner(System.in);
            flag = scan.nextInt();
            switch (flag){
                case 0:
                    break;
                case 1:
                    // 使用代理mapper对象查询全部的用户信息
                    List<Book> list = mapper.selectAll();
                    //输出内容
                    System.out.println(list);
                    break;
                case 2:
                case 3:
                case 4:
                    System.out.println("还未开发");
                    break;
            }
            if(flag != 0) {
                System.out.println("请选择是否要继续：");
                System.out.println("任意数字继续，输入0退出");
                flag = scan.nextInt();
            }
        }
    }
}
