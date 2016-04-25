package br.com.caelum.financas.dao;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Movimentacao;

public class MovimentacaoDao {

	private EntityManager manager;

	public MovimentacaoDao(EntityManager manager){
		this.manager=manager;
	}
	
	public void grava(Movimentacao movimentacao){
		manager.persist(movimentacao);
	}
	
	public Movimentacao pesquisaId(Movimentacao movimentacao){
		return manager.find(Movimentacao.class, movimentacao.getId());
	}
}
