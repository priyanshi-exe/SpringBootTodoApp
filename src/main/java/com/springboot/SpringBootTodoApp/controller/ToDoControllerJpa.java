package com.springboot.SpringBootTodoApp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.SpringBootTodoApp.model.ToDoModel;
import com.springboot.SpringBootTodoApp.model.ToDoRepository;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class ToDoControllerJpa {

	private ToDoRepository toDoRepository;
	
	public ToDoControllerJpa(ToDoRepository toDoRepository) {
		super();
		this.toDoRepository = toDoRepository;
	}

	@RequestMapping("list-todos") // GetMapping
	public String listAllTodos(ModelMap model) {
		String userName = getLoggedInUsername(model);
		List<ToDoModel> todos  = toDoRepository.findByUserName(userName);
		model.addAttribute("todos", todos);
		return "listTodos";
	}

	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String userName = getLoggedInUsername(model);
		ToDoModel todo = new ToDoModel(0, userName, "", LocalDate.now(), false);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodoPage(ModelMap model, @Valid @ModelAttribute("todo") ToDoModel todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		
		String userName = getLoggedInUsername(model);
		todo.setUserName(userName);
		toDoRepository.save(todo);
		return "redirect:list-todos";
	}

	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		toDoRepository.deleteById(id);
		return "redirect:list-todos";
	}

	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	public String updateTodoPage(@RequestParam int id, ModelMap model) {
		ToDoModel todo = toDoRepository.findById(id).get();
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="update-todo", method=RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid @ModelAttribute("todo") ToDoModel todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		
		String userName = getLoggedInUsername(model);
		todo.setUserName(userName);
		toDoRepository.save(todo);
		return "redirect:list-todos";
	}
	
	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}

}
