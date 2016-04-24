package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaRemoveConta {
	public static void main(String[] args) {
		Conta contaARemover=new Conta();
		contaARemover.setId(1);
		EntityManager manager=new JPAUtil().getEntityManager();
		ContaDao dao=new ContaDao(manager);
		manager.getTransaction().begin();
		Conta contaSeraRemovida=dao.pesquisaId(contaARemover);
		dao.remove(contaSeraRemovida);
		manager.getTransaction().commit();
		manager.close();
		System.out.println("Conta removida com sucesso!");
	}
}
