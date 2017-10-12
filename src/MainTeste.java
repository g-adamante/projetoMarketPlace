import java.util.Date;

import opet.marketplace.dao.jdbc.UserJdbcDAO;
import opet.marketplace.vo.Lawyer;
import opet.marketplace.vo.User;


public class MainTeste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Date date = new Date();

		
		//User joao = new Lawyer(1, "joao", "123", "joao@alterado.com", date);

		UserJdbcDAO teste = new UserJdbcDAO();
		
		if(teste.delete(9)){
			System.out.println("DELETADO");
		}
		
		
		//User joaoId = teste.create(joao);
		
		//System.out.println(joaoId.getUserId());
		
		//User retrieved = teste.update(joao);
		
		//System.out.println(retrieved.getUserEmail());
		//System.out.println(retrieved.getUserId());
		//System.out.println(retrieved.getUserId());
		//System.out.println(retrieved.getUserName());
		//System.out.println(retrieved.getUserPass());
		
		
		
	}

}
