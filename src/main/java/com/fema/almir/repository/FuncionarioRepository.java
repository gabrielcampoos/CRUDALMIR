package com.fema.almir.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fema.almir.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> {

	List<Funcionario> findByNomeContaining(String nome);

	Funcionario findByNome(String nome);

}
