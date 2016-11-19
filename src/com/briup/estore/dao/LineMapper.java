package com.briup.estore.dao;

import java.util.List;

import com.briup.estore.bean.Line;

public interface LineMapper {
	
	List<Line> findById(long id);
	
	void insertLine(Line line);

}
