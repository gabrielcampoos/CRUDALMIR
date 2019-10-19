package com.fema.almir.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fema.almir.model.Funcionario;
import com.fema.almir.service.FuncionarioService;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

	@Autowired private FuncionarioService funcionarioService;
	
	@GetMapping
	public ResponseEntity<?> listarTodos() {
		return ResponseEntity.ok().body(funcionarioService.listarTodos());
	}
	
	@GetMapping("/{nome}")
	public ResponseEntity<?> listarFuncionarioNome(@PathVariable String nome) {
		return ResponseEntity.ok().body(funcionarioService.listarfuncionarioNome(nome));
	}
	
	@GetMapping("/nome")
	public ResponseEntity<?> listarFuncionarioUnicoNome(@RequestParam(name = "nome") String nome) {
		return ResponseEntity.ok().body(funcionarioService.listarfuncionarioNome(nome));
	}
	
	@PostMapping
	public ResponseEntity<?> salvarFuncionario(@RequestBody Funcionario funcionario) {
		return ResponseEntity.ok().body(funcionarioService.salvar(funcionario));
	}
	
	@PutMapping
	public ResponseEntity<?> editarFuncionario(@RequestBody Funcionario Funcionario) {
		return ResponseEntity.ok().body(funcionarioService.editar(Funcionario));
	}
	
	
	@DeleteMapping
	public void removerFuncionario(@RequestParam(name = "id") Integer id) {
		funcionarioService.remover(id);
	}
	
}
