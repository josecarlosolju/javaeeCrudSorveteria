package sorveteria.dal.dao.interfaces;

import sorveteria.dal.entidade.*;
import sorveteria.dal.generics.*;

import java.util.*;

public interface IFornecedorDAO
		extends IGenericDAO<Fornecedor, Short>{

	public List<Fornecedor> findByFornecedor(String nomeFornecedor);
}
