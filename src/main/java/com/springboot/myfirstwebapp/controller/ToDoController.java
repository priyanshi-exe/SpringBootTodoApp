package com.springboot.myfirstwebapp.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.myfirstwebapp.model.ToDo;
import com.springboot.myfirstwebapp.service.ToDoService;

@Controller
@SessionAttributes("name")
public class ToDoController {
	
	private ToDoService toDoService;
	
	public ToDoController(ToDoService toDoService) {
		super();
		this.toDoService = toDoService;
	}

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		List<ToDo> todos  = toDoService.findByUsername("Priyanshi Agarwal");
		model.addAttribute("todos", todos);
		return "listTodos";
	}

	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewTodoPage() {
		return "todo";
	}
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodoPage(@RequestParam String description, ModelMap model) {
		String userName = (String)model.get("name");
		toDoService.addTodo(userName, description, LocalDate.now().plusYears(2), false);
		return "redirect:list-todos";
	}
}
