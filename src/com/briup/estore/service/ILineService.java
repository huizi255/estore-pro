package com.briup.estore.service;

import java.util.List;

import com.briup.estore.bean.Line;

public interface ILineService {
	List<Line> findById(long id);
	
}
