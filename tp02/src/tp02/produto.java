//KAUE DE JESUS LIVIO CB3005461
//PEDRO PAULO DOS REIS FARIA CB3007278

package tp02;

public class produto {
	
	private int id, unidadeCompra;
	private String nome, descricao;
	private double qtdPrevistoMes, precoMaxComprado;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getUnidadeCompra() {
		return unidadeCompra;
	}
	
	public void setUnidadeCompra(int unidadeCompra) {
		this.unidadeCompra = unidadeCompra;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getQtdPrevistoMes() {
		return qtdPrevistoMes;
	}
	
	public void setQtdPrevistoMes(double qtdPrevistoMes) {
		this.qtdPrevistoMes = qtdPrevistoMes;
	}
	
	public double getPrecoMaxComprado() {
		return precoMaxComprado;
	}
	
	public void setPrecoMaxComprado(double precoMaxComprado) {
		this.precoMaxComprado = precoMaxComprado;
	}
}
