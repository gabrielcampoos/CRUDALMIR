package com.fema.almir.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fema.almir.model.Funcionario;
import com.fema.almir.repository.FuncionarioRepository;


@Service
public class FuncionarioService {

	@Autowired private FuncionarioRepository funcionarioRepository;
	
	public List<Funcionario> listarTodos() {
		return funcionarioRepository.findAll();
	}

	public List<Funcionario> listarfuncionarioNome(String nome) {
		return funcionarioRepository.findByNomeContaining(nome);
	}
	
	public Funcionario listarfuncionarioUnico(String nome) {
		return funcionarioRepository.findByNome(nome);
	}


	public Funcionario editar(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	public void remover(Integer id) {
		funcionarioRepository.deleteById(id);
	}

	public Funcionario salvar(Funcionario funcionario) {
		Funcionario funcionarioSalvar = new Funcionario();
		
		BeanUtils.copyProperties(funcionario, funcionarioSalvar);
		return funcionarioRepository.save(funcionarioSalvar);
	}
	
}
