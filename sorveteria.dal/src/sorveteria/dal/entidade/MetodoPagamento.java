package sorveteria.dal.entidade;

import javax.persistence.*;	
import java.util.*;

@Entity
public class MetodoPagamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short idPagamento;
	
	private String descricao;
	
	@OneToMany(mappedBy = "pagamento")
	private List<Produto> produtos;

	public Short getIdPagamento() {
		return idPagamento;
	}

	public void setIdPagamento(Short idPagamento) {
		this.idPagamento = idPagamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPagamento == null) ? 0 : idPagamento.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MetodoPagamento other = (MetodoPagamento) obj;
		if (idPagamento == null) {
			if (other.idPagamento != null)
				return false;
		} else if (!idPagamento.equals(other.idPagamento))
			return false;
		return true;
	}

	
		
	
}
