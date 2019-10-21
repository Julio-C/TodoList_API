package com.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.model.TarefaModel;
import com.api.repository.TarefaRepository;

@RestController
@RequestMapping(value="/api")
public class TarefaController {
	
	@Autowired
	TarefaRepository tarefaRepository;
	
	@GetMapping("/todo/list")
	public List<TarefaModel> todoList(){
		return tarefaRepository.findAll();
	}
	
	@GetMapping("/todo/{id}")
	public TarefaModel todoId(@PathVariable(value="id") long id){
		return tarefaRepository.findById(id);
	}
	
	@DeleteMapping("/todo")
	public void deleteTodo(@RequestBody TarefaModel tarefa){
		tarefaRepository.delete(tarefa);
	}
	
	@PostMapping("/todo")
	public TarefaModel save(@RequestBody TarefaModel tarefa) {
		return tarefaRepository.save(tarefa);
	}
	
	@PutMapping("/todo")
	public TarefaModel update(@RequestBody TarefaModel tarefa) {
		return tarefaRepository.save(tarefa);
	}	
	
}
