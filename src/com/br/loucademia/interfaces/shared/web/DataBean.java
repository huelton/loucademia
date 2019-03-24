package com.br.loucademia.interfaces.shared.web;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import com.br.loucademia.application.service.DataService;
import com.br.loucademia.domain.aluno.Aluno.Sexo;
import com.br.loucademia.domain.aluno.Aluno.Situacao;
import com.br.loucademia.domain.aluno.Estado;

@Named
@ApplicationScoped
public class DataBean implements Serializable{

	@EJB
	private DataService dataService;
	
	public Sexo[] getSexos() {
		return dataService.getSexos();
	}
	
	public Situacao[] getSituacoes() {
		return dataService.getSituacoes();
	}
	
	public List<Estado> getEstados(){
		return dataService.listEstados();
	}
}
