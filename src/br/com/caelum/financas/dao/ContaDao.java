package br.com.caelum.financas.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;

public class ContaDao {

	private EntityManager manager;
	
	public ContaDao(EntityManager manager){
		this.manager=manager;
	}
	
	public void grava(Conta conta){
		manager.persist(conta);
	}
	
	public List<Conta> listaContas(){
		return this.manager.createQuery("select c from Conta c", Conta.class).getResultList();
	}
	
	public void remove(Conta conta){
		manager.remove(conta);
	}
	
	public Conta pesquisaId(Conta conta){
		return manager.find(Conta.class, conta.getId());
	}
	
	public Conta altera (Conta conta){
		return manager.merge(conta);
	}
}
