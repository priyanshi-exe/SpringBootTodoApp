package com.springboot.myfirstwebapp.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDoModel, Integer>{
	public List<ToDoModel> findByUserName(String userName);
}
