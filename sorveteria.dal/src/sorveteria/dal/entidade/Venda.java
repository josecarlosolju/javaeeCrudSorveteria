package sorveteria.dal.entidade;

import javax.persistence.*;

import java.util.*;

@Entity
public class Venda {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idVenda;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@ManyToOne
	@JoinColumn(name="idPessoa")
	private Pessoa pessoa;
	
	@OneToMany(mappedBy = "venda")
	private List<VendaProduto> vendaProdutos;

	public Integer getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Integer idVenda) {
		this.idVenda = idVenda;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<VendaProduto> getVendaProdutos() {
		return vendaProdutos;
	}

	public void setVendaProdutos(List<VendaProduto> vendaProdutos) {
		this.vendaProdutos = vendaProdutos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVenda == null) ? 0 : idVenda.hashCode());
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
		Venda other = (Venda) obj;
		if (idVenda == null) {
			if (other.idVenda != null)
				return false;
		} else if (!idVenda.equals(other.idVenda))
			return false;
		return true;
	}
	
	
	
}
