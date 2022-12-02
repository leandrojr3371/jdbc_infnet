package br.edu.infnet.pedido.model.persistencia;

import java.util.List;

import br.edu.infnet.pedido.model.entidade.Cliente;
import br.edu.infnet.pedido.model.entidade.PedidoLiberacao;

public interface IDAO<T> {

	Boolean salvar(T obj);

	Boolean atualizar(T obj);

	Boolean deletar(T obj);

	PedidoLiberacao obter(Long codigo);

	Cliente obterCliente(Long codigo);
	
	List<T> listarTodos();

}