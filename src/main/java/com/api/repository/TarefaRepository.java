package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.model.TarefaModel;

public interface TarefaRepository extends JpaRepository<TarefaModel, Long>{
	
	TarefaModel findById(long id);
}
