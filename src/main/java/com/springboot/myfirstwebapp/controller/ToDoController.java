package com.springboot.myfirstwebapp.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springboot.myfirstwebapp.model.ToDo;
import com.springboot.myfirstwebapp.service.ToDoService;

import jakarta.validation.Valid;

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
	public String showNewTodoPage(ModelMap model) {
		String userName = (String)model.get("name");
		ToDo todo = new ToDo(0, userName, "", LocalDate.now(), false);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodoPage(ModelMap model, @Valid @ModelAttribute("todo") ToDo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		
		String userName = (String)model.get("name");
		toDoService.addTodo(userName, todo.getDescription(), todo.getTargetDate(), todo.isDone());
		return "redirect:list-todos";
	}

	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		toDoService.deleteById(id);
		return "redirect:list-todos";
	}

//	@RequestMapping(value="update-todo", method=RequestMethod.GET)
	@RequestMapping("update-todo")
	public String showUpdatedTodoPage(@RequestParam int id, ModelMap model) {
		ToDo todo = toDoService.findById(id);
		toDoService.deleteById(todo.getId());// i added
		model.addAttribute("todo", todo);
		return "todo";
	}
	
//	@RequestMapping(value="update-todo", method=RequestMethod.POST)
//	public String updateTodo(ModelMap model, @Valid @ModelAttribute("todo") ToDo todo, BindingResult result) {
//		if(result.hasErrors()) {
//			return "todo";
//		}
//		
//		String userName = (String)model.get("name");
//		todo.setUserName(userName);
//		toDoService.updateTodo(todo);
//		return "redirect:list-todos";
//	}
}
