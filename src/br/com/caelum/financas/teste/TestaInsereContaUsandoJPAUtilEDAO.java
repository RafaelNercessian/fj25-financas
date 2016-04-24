package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaInsereContaUsandoJPAUtilEDAO {
	

	public static void main(String[] args) {
		Conta conta = new Conta();
		conta.setAgencia("0139");
		conta.setBanco("Itau");
		conta.setNumero("87680-0");
		conta.setTitular("Chuck");
		EntityManager manager=new JPAUtil().getEntityManager();
		ContaDao dao=new ContaDao(manager);
		manager.getTransaction().begin();
		dao.grava(conta);
		manager.getTransaction().commit();
		manager.close();
		System.out.println("Conta gravada com sucesso!");
	}
}
