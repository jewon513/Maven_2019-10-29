package com.biz.hello;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.biz.hello.config.DBConnection;
import com.biz.hello.dao.BookDao;
import com.biz.hello.persistence.BookDTO;

public class BookEx_01 {

	public static void main(String[] args) {

		SqlSession sqlSession = DBConnection.getsqlSessionFactory().openSession(true);
    	
        System.out.println( "Hello World!" );
        
        BookDao bookDao = sqlSession.getMapper(BookDao.class);
        
        List<BookDTO> list = bookDao.selectAll();
        
        for (BookDTO bookDTO : list) {
			System.out.println(bookDTO);
		}
	}

}
