package sorveteria.dal.entidade;

import javax.persistence.*;

import java.util.*;

@Entity
public class Sabor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short idSabor;
	
	private String descricao;
	
	
	@ManyToMany(mappedBy = "sabores")
	private List<Produto> produtos;


	public Short getIdSabor() {
		return idSabor;
	}


	public void setIdSabor(Short idSabor) {
		this.idSabor = idSabor;
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
		result = prime * result + ((idSabor == null) ? 0 : idSabor.hashCode());
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
		Sabor other = (Sabor) obj;
		if (idSabor == null) {
			if (other.idSabor != null)
				return false;
		} else if (!idSabor.equals(other.idSabor))
			return false;
		return true;
	}


	
	
	
	
	
	
}
