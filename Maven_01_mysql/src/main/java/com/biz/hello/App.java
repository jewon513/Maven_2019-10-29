package com.biz.hello;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.biz.hello.config.DBConnection;
import com.biz.hello.dao.ScoreDao;
import com.biz.hello.persistence.ScoreDTO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	SqlSession sqlSession = DBConnection.getsqlSessionFactory().openSession(true);
    	
        System.out.println( "Hello World!" );
        
        ScoreDao scoreDao = sqlSession.getMapper(ScoreDao.class);
        
        List<ScoreDTO> list = scoreDao.selectAll();
        
        for (ScoreDTO scoreDTO : list) {
			System.out.println(scoreDTO);
		}
    }
}
