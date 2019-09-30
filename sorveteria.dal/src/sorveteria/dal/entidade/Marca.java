package sorveteria.dal.entidade;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.*;

@Entity
@Table(name = "marca")
@NamedQuery(name="marca.count",
	query = "select count(m) from Marca as m")
public class Marca {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Short idMarca;
	
	@Column(name = "descricao")
	@NotNull(message = "Campo descri��o � obrigat�rio")
	@Size(max = 50, message = "O campo descri��o pode ter no m�ximo 50 caracteres")
	private String descricao;
	
	@OneToMany(mappedBy = "marca", fetch = FetchType.LAZY)
	private List<Fornecedor> fornecedor;

	public Short getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(Short idMarca) {
		this.idMarca = idMarca;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Fornecedor> getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(List<Fornecedor> fornecedor) {
		this.fornecedor = fornecedor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idMarca == null) ? 0 : idMarca.hashCode());
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
		Marca other = (Marca) obj;
		if (idMarca == null) {
			if (other.idMarca != null)
				return false;
		} else if (!idMarca.equals(other.idMarca))
			return false;
		return true;
	}
	
	
	
	
	

}
