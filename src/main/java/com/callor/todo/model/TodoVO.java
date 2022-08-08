package com.callor.todo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TodoVO {
	
	private int t_id;
	private String todo;
	private String t_date;
	private String t_time;
	private String t_compdate;
	private String t_comptime;
	private boolean t_comp;
	

}