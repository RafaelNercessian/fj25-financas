package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;

public class TestaInsereConta {
	

	public static void main(String[] args) {
		long inicio=System.currentTimeMillis();
		Conta conta = new Conta();
		conta.setAgencia("0139");
		conta.setBanco("Itau");
		conta.setNumero("87680-0");
		conta.setTitular("Rafael");
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("controlefinancas");
		EntityManager manager = entityManagerFactory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(conta);
		manager.getTransaction().commit();
		manager.close();
		long fim=System.currentTimeMillis();
		System.out.println("Conta gravada com sucesso!");
		System.out.println("Demorou "+(fim-inicio)+" ms");
	}
}
