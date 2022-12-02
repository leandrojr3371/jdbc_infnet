package br.edu.infnet.pedido.model.persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.infnet.pedido.model.entidade.Cliente;
import br.edu.infnet.pedido.model.entidade.PedidoLiberacao;

public class PedidoLiberacaoDAO extends JdbcDAO<PedidoLiberacao>{

	@Override
	public Boolean salvar(PedidoLiberacao ped) {
		String sql = "insert into pedido_liberacao(operacao, valor_total, id_cliente) values (?,?,?)";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, ped.getOperacao()); 
			pstm.setDouble(2, ped.getValorTotal());
			pstm.setLong(3, 2L);
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean atualizar(PedidoLiberacao ped) {
		String sql = "update pedido_liberacao set valor_total = ? where id_cliente = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setDouble(1, ped.getValorTotal()); 
			pstm.setLong(2, ped.getIdCliente()); 
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Boolean deletar(PedidoLiberacao ped) {
		String sql = "delete from pedido_liberacao where id_ped_libr = ?";
		try {
			pstm = con.prepareStatement(sql);
			pstm.setLong(1, ped.getId()); 
			return pstm.executeUpdate() > 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public PedidoLiberacao obter(Long idPedido) {
		String sql = "select * from pedido_liberacao ped "
				+ " inner join cliente c on ped.id_cliente = c.id_cliente where id_ped_libr = ?";
		PedidoLiberacao ped = new PedidoLiberacao();
		try {
			pstm = con.prepareStatement(sql); 
			pstm.setLong(1, idPedido); 
			rs = pstm.executeQuery();
			if(rs.next()) {
				String operacao = rs.getString("operacao");
				Double valorTotal = rs.getDouble("valor_total");
				Long idCliente = rs.getLong("id_cliente");
				String nomeCliente = rs.getString("nome");
				ped = new PedidoLiberacao(valorTotal, operacao, idCliente, nomeCliente);
			}
			return ped;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<PedidoLiberacao> listarTodos() {
		String sql = "select * from pedido_liberacao ped "
				+ " inner join cliente c on ped.id_cliente = c.id_cliente ";
		List<PedidoLiberacao> pedidos = new ArrayList<>();
		try {
			stm = con.createStatement();
			rs = stm.executeQuery(sql);
			while(rs.next()) {
				String operacao = rs.getString("operacao");
				Double valorTotal = rs.getDouble("valor_total");
				Long idCliente = rs.getLong("id_cliente");
				String nomeCliente = rs.getString("nome");
				PedidoLiberacao ped = new PedidoLiberacao(valorTotal, operacao, idCliente, nomeCliente);
				pedidos.add(ped);
			}
			return pedidos;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Cliente obterCliente(Long codigo) {
		// TODO Auto-generated method stub
		return null;
	}

}
