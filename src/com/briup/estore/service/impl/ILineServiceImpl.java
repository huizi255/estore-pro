package com.briup.estore.service.impl;

import java.util.List;

import com.briup.estore.bean.Line;
import com.briup.estore.dao.LineDao;
import com.briup.estore.service.ILineService;

public class ILineServiceImpl implements ILineService{
	private LineDao lineDao = new LineDao();

	@Override
	public List<Line> findById(long id) {
		List<Line> list = lineDao.findLineById(id);
		return list;
	}

}
