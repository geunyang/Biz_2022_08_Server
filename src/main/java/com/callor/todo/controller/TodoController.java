package com.callor.todo.controller;

import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.callor.todo.model.TodoVO;
import com.callor.todo.service.TodoService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/todo")
public class TodoController {
	
	@Autowired
	private TodoService todoService;
	
	@RequestMapping(value={"/",""}, method=RequestMethod.GET)
	public String home(Model model, Principal principal) {
		List<TodoVO> list = todoService.selectAllByUser(principal.getName());
		model.addAttribute("LIST", list);
		return "todo/home";
	}
	
	@RequestMapping(value="/input", method=RequestMethod.GET)
	public String input() {
		return null;
	}
	
	@RequestMapping(value="/input", method=RequestMethod.POST)
	public String input(Principal principal, TodoVO todoVO) {
		Date date = new Date(System.currentTimeMillis());
		
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		
		todoVO.setT_date(dayFormat.format(date));
		todoVO.setT_time(timeFormat.format(date));
		todoVO.setUsername(principal.getName());

		todoService.insert(todoVO);
		return "redirect:/todo";
	}

//	@RequestMapping(value="/{t_id}/update",method=RequestMethod.GET)
//	public String update(@PathVariable("seq")String seq, Model model) {
//		
//		long longSeq = Long.valueOf(seq);
	
	@RequestMapping(value="/{t_id}/update", method=RequestMethod.GET)
	public String update(@PathVariable("t_id") String id, Model model) {
		Long longId = Long.valueOf(id);
		TodoVO todo = todoService.findById(longId);
		model.addAttribute("todo", todo);
		return "todo/input";
	}
	
	@RequestMapping(value="/{t_id}/update", method=RequestMethod.POST)
	public String update(TodoVO todoVO) {
		todoService.update(todoVO);
		return "redirect:/todo";
	}
	
	@RequestMapping(value="/{t_id}/complete", method=RequestMethod.GET)
	public String complete(@PathVariable("t_id") String id, Model model) {
		Long longId = Long.valueOf(id);
		TodoVO todo = todoService.findById(longId);
		
		Date date = new Date(System.currentTimeMillis());
		
		SimpleDateFormat dayFormat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		
		todo.setT_compdate(dayFormat.format(date));
		todo.setT_comptime(timeFormat.format(date));
		
		todo.setT_comp(true);
		todoService.update(todo);
		return "redirect:/todo/";
	}
	
	

}
