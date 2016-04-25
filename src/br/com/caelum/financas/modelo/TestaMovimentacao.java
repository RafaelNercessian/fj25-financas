package br.com.caelum.financas.modelo;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.util.JPAUtil;

public class TestaMovimentacao {
	public static void main(String[] args) {
		EntityManager manager=new JPAUtil().getEntityManager();
		Movimentacao movimentacao=new Movimentacao();
		manager.getTransaction().begin();
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Conta água");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal(100));
		manager.persist(movimentacao);
		manager.getTransaction().commit();
		manager.close();
	}

}
