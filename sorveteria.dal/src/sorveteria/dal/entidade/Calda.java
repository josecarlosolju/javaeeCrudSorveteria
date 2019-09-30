package sorveteria.dal.entidade;

import javax.persistence.*;
import java.util.*;

@Entity
public class Calda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short idCalda;
	
	private String descricao;
	
	@OneToMany(mappedBy = "calda")
	private List<Produto> produtos;

	public Short getIdCalda() {
		return idCalda;
	}

	public void setIdCalda(Short idCalda) {
		this.idCalda = idCalda;
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
		result = prime * result + ((idCalda == null) ? 0 : idCalda.hashCode());
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
		Calda other = (Calda) obj;
		if (idCalda == null) {
			if (other.idCalda != null)
				return false;
		} else if (!idCalda.equals(other.idCalda))
			return false;
		return true;
	}

		
	
}
