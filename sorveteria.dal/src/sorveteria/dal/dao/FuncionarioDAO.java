package sorveteria.dal.dao;

import sorveteria.dal.dao.interfaces.*;
import sorveteria.dal.entidade.*;
import sorveteria.dal.generics.*;

import javax.enterprise.context.*;

@RequestScoped
public class FuncionarioDAO
	extends JPAGenericDAO<Funcionario, Integer>
	implements IFuncionarioDAO{

}
