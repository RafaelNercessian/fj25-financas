package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.ContaDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TestaPesquisaIDConta {
	public static void main(String[] args) {
		EntityManager manager=new JPAUtil().getEntityManager();
		ContaDao dao=new ContaDao(manager);
		manager.getTransaction().begin();
		Conta contaPesquisar=new Conta();
		contaPesquisar.setId(1);
		Conta contaRetornada=dao.pesquisaId(contaPesquisar);
		manager.close();
		System.out.println(contaRetornada.getTitular());
	}
}
