package com.briup.estore.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.briup.estore.bean.Line;

public class LineDao extends BaseDao<Line, Long> {
	
	public List<Line> findLineById(long id){
		SqlSession sqlSession = BaseDao.getSqlSessionFactory().openSession();
		LineMapper mapper = sqlSession.getMapper(LineMapper.class);
		List<Line> listLine = mapper.findById(id);
		return listLine;
	}
	
	public void DoinsertLine(Line line){
		SqlSession sqlSession = BaseDao.getSqlSessionFactory().openSession();
		LineMapper mapper = sqlSession.getMapper(LineMapper.class);
		mapper.insertLine(line);
		sqlSession.commit();
	}
}
