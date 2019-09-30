package sorveteria.test;

import java.util.*;	
import javax.ejb.embeddable.*;
import javax.naming.*;

import sorveteria.dal.entidade.*;
import sorveteria.dal.dao.interfaces.IFornecedorDAO;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Properties p = new Properties();
		p.put("sorveteriaDB", "new://Resource?type=DataSource");
		p.put("sorveteriaDB.JdbcDriver", "com.mysql.jdbc.Driver");
		p.put("sorveteriaDB.JdbcUrl","jdbc:mysql://localhost:3306/sorveteria");
		p.put("sorveteriaDB.userName","root");
		p.put("sorveteriaDB.password","root");
		
		
		Context context = EJBContainer.createEJBContainer(p).getContext();
		
		IFornecedorDAO FornecedorDAO = (IFornecedorDAO) context
				.lookup("java:global/sorveteria.dal/FornecedorDAO");
		
		List<Fornecedor> Fornecedores = FornecedorDAO.findByFornecedor("Uberlandia Refrescos");
		
		for (Fornecedor Fornecedor : Fornecedores) {
			System.out.println(Fornecedor.getDescricao());
			System.out.println(Fornecedor.getMarca().getDescricao());
		}
		
		
		
	
	}
}
