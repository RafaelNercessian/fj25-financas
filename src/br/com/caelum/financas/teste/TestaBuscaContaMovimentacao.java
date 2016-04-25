package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TestaBuscaContaMovimentacao {
	public static void main(String[] args) {
		Movimentacao movimentacao=new Movimentacao();
		movimentacao.setId(4);
		EntityManager manager=new JPAUtil().getEntityManager();
		MovimentacaoDao dao=new MovimentacaoDao(manager);
		Movimentacao movimentacaoBuscada=dao.pesquisaId(movimentacao);
		System.out.println(movimentacaoBuscada.getConta().getTitular());
	}
}
