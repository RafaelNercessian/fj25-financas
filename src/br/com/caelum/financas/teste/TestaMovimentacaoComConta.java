package br.com.caelum.financas.teste;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaMovimentacaoComConta {
	public static void main(String[] args) {
		Conta conta=new Conta();
		Movimentacao movimentacao=new Movimentacao();
		conta.setAgencia("0139");
		conta.setBanco("Banco Itaú");
		conta.setNumero("8768-0");
		conta.setTitular("Nishikori");
		movimentacao.setConta(conta);
		movimentacao.setData(Calendar.getInstance());
		movimentacao.setDescricao("Conta luz");
		movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
		movimentacao.setValor(new BigDecimal("200"));
		EntityManager manager=new JPAUtil().getEntityManager();
		MovimentacaoDao movimentacaoDao=new MovimentacaoDao(manager);
		manager.getTransaction().begin();
		manager.persist(conta);
		movimentacaoDao.grava(movimentacao);
		manager.getTransaction().commit();
		manager.close();
	}
}	
