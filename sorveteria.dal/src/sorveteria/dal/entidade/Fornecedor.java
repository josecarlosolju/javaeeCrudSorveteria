package sorveteria.dal.entidade;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.util.*;

@Entity
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short idFornecedor;
	
	@NotNull(message = "Campo descrição é obrigatório")
	@Size(max = 50, message = "O campo descrição pode ter no máximo 50 caracteres")
	private String descricao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idMarca")
	@NotNull(message = "A marca é obrigatória")
	private Marca marca;
	
	@OneToMany(mappedBy = "fornecedor")
	private List<Produto> produtos;

	public Short getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(Short idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
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
		result = prime * result + ((idFornecedor == null) ? 0 : idFornecedor.hashCode());
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
		Fornecedor other = (Fornecedor) obj;
		if (idFornecedor == null) {
			if (other.idFornecedor != null)
				return false;
		} else if (!idFornecedor.equals(other.idFornecedor))
			return false;
		return true;
	}

	
	
}
