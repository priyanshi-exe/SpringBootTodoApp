package com.springboot.myfirstwebapp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.springboot.myfirstwebapp.model.ToDo;

@Service
public class ToDoService {
	private static List<ToDo> todos = new ArrayList<>(); // dynamic list of values
	private static int todosCount=0;
	static {
		todos.add(new ToDo(++todosCount, "Priyanshi Agarwal", "Learn Spring", LocalDate.now().plusYears(1), false));
		todos.add(new ToDo(++todosCount, "Priyanshi Agarwal", "Learn MERN Stack", LocalDate.now().plusYears(2), false));
		todos.add(new ToDo(++todosCount, "Priyanshi Agarwal", "Learn Full Stack Development", LocalDate.now().plusYears(3), false));
	}
	
	public static List<ToDo> findByUsername(String username){
		return todos;
	}
	
	public void addTodo(String userName, String description, LocalDate targetDate, boolean done) {
		ToDo todo = new ToDo(++todosCount, userName, description, targetDate, done);
		todos.add(todo);
	}
}
