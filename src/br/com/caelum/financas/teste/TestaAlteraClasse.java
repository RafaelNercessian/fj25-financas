package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaAlteraClasse {
	public static void main(String[] args) {
		Conta conta=new Conta();
		conta.setId(2);
		EntityManager manager=new JPAUtil().getEntityManager();
		manager.getTransaction().begin();
		ContaDao dao=new ContaDao(manager);
		Conta contaAlterada=dao.pesquisaId(conta);
		contaAlterada.setTitular("Roger Federer");
		manager.getTransaction().commit();
		manager.close();
		
	}
}
