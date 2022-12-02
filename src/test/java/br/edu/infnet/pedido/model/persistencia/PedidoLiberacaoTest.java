package br.edu.infnet.pedido.model.persistencia;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;

import br.edu.infnet.pedido.model.entidade.PedidoLiberacao;

public class PedidoLiberacaoTest {
	
	@Before
	public void inicializar() {
		IDAO pedLibDAO = new PedidoLiberacaoDAO();
		PedidoLiberacao ped = new PedidoLiberacao(); 
		ped.setIdCliente(2L);
		ped.setOperacao("Operacao 0001");
		ped.setValorTotal(800);
		pedLibDAO.salvar(ped);
	}
	
	//@Test
	public void testUpdate() {
		IDAO pedLibDAO = new PedidoLiberacaoDAO();
		List<PedidoLiberacao> lista = pedLibDAO.listarTodos();
		PedidoLiberacao ped = new PedidoLiberacao(500, "Operacao 0005", 2L, "Teste"); 
		boolean validacao = pedLibDAO.atualizar(ped);
		Assert.assertTrue(validacao);
	}
	
	//@Test
	public void testDelete() {
		IDAO pedLibDAO = new PedidoLiberacaoDAO();
		List<PedidoLiberacao> lista = pedLibDAO.listarTodos();
		PedidoLiberacao ped = new PedidoLiberacao(500, "Operacao 0005", 2L, "Teste"); 
		boolean validacao = pedLibDAO.deletar(ped);
		Assert.assertTrue(validacao);
	}
	
	
	//@Test
	public void testListaClientes() {
		IDAO pedLibDAO = new PedidoLiberacaoDAO();
		List<PedidoLiberacao> lista = pedLibDAO.listarTodos();
		Assert.assertTrue(lista.size() > 0);
	}
	

	//@Test
	public void testObterCliente() {
		IDAO pedLibDAO = new PedidoLiberacaoDAO();
		List<PedidoLiberacao> lista = pedLibDAO.listarTodos();
		PedidoLiberacao ped = pedLibDAO.obter(lista.get(0).getId());
		Assert.assertNotNull(ped);
	}
}
