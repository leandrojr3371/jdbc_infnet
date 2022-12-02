package br.edu.infnet.pedido.model.entidade;

public class PedidoLiberacao {
	
	private Long id;
	
	private double valorTotal;
	
	private String operacao;
	
	private Long idCliente;
	
	private String nomeCliente;
	
	public PedidoLiberacao() {
		
	}
	
	public PedidoLiberacao(double valorTotal, String operacao, Long idCliente, String nomeCliente) {
		super();
		this.valorTotal = valorTotal;
		this.operacao = operacao;
		this.idCliente = idCliente;
		this.nomeCliente = nomeCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	@Override
	public String toString() {
		return "PedidoLiberacao [id=" + id + ", valorTotal=" + valorTotal + ", operacao=" + operacao + ", idCliente="
				+ idCliente + "]";
	}
	
}
