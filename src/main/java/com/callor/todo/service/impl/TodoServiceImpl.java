package com.callor.todo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.callor.todo.model.TodoVO;
import com.callor.todo.persistance.TodoDao;
import com.callor.todo.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService{
	
	@Autowired
	TodoDao todoDao;

	@Override
	public List<TodoVO> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TodoVO findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(TodoVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(TodoVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int create_table_user() {
		// TODO Auto-generated method stub
		return 0;
	}
	


}
