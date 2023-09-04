package com.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class ToDoService {
	private static List<ToDo> todos = new ArrayList<>();
	static {
		todos.add(new ToDo(1, "Priyanshi Agarwal", "Learn Spring", LocalDate.now().plusYears(1), false));
		todos.add(new ToDo(2, "Priyanshi Agarwal", "Learn MERN Stack", LocalDate.now().plusYears(2), false));
		todos.add(new ToDo(3, "Priyanshi Agarwal", "Learn Full Stack Development", LocalDate.now().plusYears(3), false));
	}
	
	public static List<ToDo> findByUsername(String username){
		return todos;
	}
}
