package com.springboot.myfirstwebapp.service;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.springboot.myfirstwebapp.model.ToDoModel;

import jakarta.validation.Valid;

@Service
public class ToDoService {
	private static List<ToDoModel> toDoList = new ArrayList<>(); // dynamic list of values
	private static int todosCount=0;
	static {
		toDoList.add(new ToDoModel(++todosCount, "Priyanshi Agarwal", "Learn Spring", LocalDate.now().plusYears(1), false));
		toDoList.add(new ToDoModel(++todosCount, "Priyanshi Agarwal", "Learn MERN Stack", LocalDate.now().plusYears(2), false));
		toDoList.add(new ToDoModel(++todosCount, "Priyanshi Agarwal", "Learn Full Stack Development", LocalDate.now().plusYears(3), false));
	}
	
	public static List<ToDoModel> findByUsername(String username){
		return toDoList;
	}
	
	public void addTodo(String userName, String description, LocalDate targetDate, boolean done) {
		ToDoModel todo = new ToDoModel(++todosCount, userName, description, targetDate, done);
		toDoList.add(todo);
	}
	
	public void deleteById(int id) {
		Predicate<? super ToDoModel> predicate = todo-> todo.getId() == id;
		toDoList.removeIf(predicate);
	}

	public ToDoModel findById(int id) {
		Predicate<? super ToDoModel> predicate = todo-> todo.getId() == id;
		ToDoModel todo = toDoList.stream().filter(predicate).findFirst().get();
		return todo;
	}
	
	public void updateTodo(@Valid ToDoModel todo) {
		deleteById(todo.getId());
		toDoList.add(todo);
	}
}
