package com.br.loucademia.application.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.br.loucademia.application.util.StringUtils;
import com.br.loucademia.application.util.ValidationException;
import com.br.loucademia.domain.acesso.Acesso;
import com.br.loucademia.domain.acesso.AcessoRepository;
import com.br.loucademia.domain.acesso.TipoAcesso;
import com.br.loucademia.domain.aluno.Aluno;
import com.br.loucademia.domain.aluno.AlunoRepository;

@Stateless
public class AcessoService {

	@EJB
	private AcessoRepository acessoRepository;
	
	@EJB
	private AlunoRepository alunoRepository;
	
	public TipoAcesso registrarAcesso(String matricula, Integer rg) {
		if(StringUtils.isEmpty(matricula) && rg == null){
			throw new ValidationException("É preciso fornecer a Matricula ou o RG do aluno");
		}
		
		Aluno aluno;
		
		if(StringUtils.isEmpty(matricula)) {
			aluno = alunoRepository.findByRG(rg);
		}else{
			aluno = alunoRepository.findByMatricula(matricula);
		}
		
		if(aluno == null) {
			throw new ValidationException("O aluno não foi encontrado");
		}
		
		Acesso ultimoAcesso = acessoRepository.findUltimoAcesso(aluno);
		TipoAcesso tipoAcesso;
		
		if(ultimoAcesso == null || ultimoAcesso.isEntradaSaidaPreenchidas()) {
			ultimoAcesso = new Acesso();
			ultimoAcesso.setAluno(aluno);	
			tipoAcesso = ultimoAcesso.registrarAcesso();
			acessoRepository.store(ultimoAcesso);
		}else {
			tipoAcesso = ultimoAcesso.registrarAcesso();
		}
		
		
		return tipoAcesso;
	}
}
