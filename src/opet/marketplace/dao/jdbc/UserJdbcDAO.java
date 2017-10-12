package opet.marketplace.dao.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.List;

import opet.marketplace.dao.IUserDAO;
import opet.marketplace.jdbc.Connector;
import opet.marketplace.vo.Client;
import opet.marketplace.vo.Lawyer;
import opet.marketplace.vo.User;

public class UserJdbcDAO implements IUserDAO {
	// instancia uma conexao com o banco de dados
	private Connection sConnection = new Connector().connect();

	public User create(User pUser) {
		// criando um usuario de retorno
		User tUser = null;
		
		
		try {
			PreparedStatement tPS = null;
			tPS = sConnection.prepareStatement("INSERT INTO USERS"
					+ "(USER_ID, USER_NAME, USER_PASS, USER_EMAIL, USER_CREATION_DATE, USER_TYPE) " 
					+ "VALUES(USER_SEQ.NEXTVAL,?,?,?,?,?)");
			
		// Colocando os par�metros recebidos no comando JDBC
		tPS.setString(1, pUser.getUserName());
		tPS.setString(2, pUser.getUserPass());
		tPS.setString(3, pUser.getUserEmail());
		tPS.setDate(4, new Date(pUser.getUserCreationTime().getTime()));
		if(pUser instanceof Lawyer)
		{
			tPS.setInt(5, 1);			
		}else {
			tPS.setInt(5, 2);
		};

		// Executando o comando de grava��o e salvando o n�mero de
		// registros
		// inclu�dos
		
		int tQtdeReg = tPS.executeUpdate();

		// Verificando se um registro foi incluido
		if (tQtdeReg == 1) {
			// Copiando o contato para o retorno
			tUser = pUser;

			// Recuperando o ID gerado pelo Oracle
			// Algoritmo alternativo pois o indicado no WAR. n�o funcionava.
			// Cria um Statement que usa a funcao SQL currval para encontrar o valor atual de uma sequencia
		
			Statement currvalStatement = null;
			ResultSet currvalResultSet = null;
			String sql_currval = "SELECT USER_SEQ.CURRVAL FROM dual";
			
			currvalStatement = sConnection.createStatement();
		    currvalResultSet = currvalStatement.executeQuery(sql_currval);
		    
		    //se verdadeiro, retorna a ID e coloca como par�metro no usu�rio que esse m�todo retorna
		    if (currvalResultSet.next()) {
		        tUser.setUserId(
		        		
		        		currvalResultSet.getInt(1)
		        		
		        		);
		    }
		    
		    
		}

		// Liberando os recursos JDBC
		
		tPS.close();
		} catch (SQLException tExcept) {
			  opet.marketplace.util.ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo da pesquisa por e-mail dos contatos");
		}
	
		
		return tUser;
	}

	public User recovery(int pUserId) {
		
	        // Definindo o objeto contato de retorno
	        User tUser = null;

	        try
	        {
	            // Criando o comando SQL e o comando JDBC
	        	PreparedStatement tPS = null;
				tPS = sConnection.prepareStatement("SELECT * FROM USERS WHERE USER_ID = ?");

	            // Colocando o par�metro recebido no comando JDBC
	            tPS.setInt(1, pUserId);

	            // Executando o comando e salvando o ResultSet para processar
	            ResultSet tResultSet = tPS.executeQuery();

	            // Verificando se um registro foi lido
	            if (tResultSet.next())
	            {
	                // Salvando o Contato para retornar depois
	                tUser = loadUser(tResultSet);
	            }

	            // Liberando os recursos JDBC
	            tResultSet.close();
	            tPS.close();
	        }
	        catch (SQLException tExcept)
	        {
	            opet.marketplace.util.ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de recupera��o do usu�rio");
	        }

	        // Retornando o objeto Contato
	        return tUser;
	    }

	public User update(User pUser) {
		// Definindo o objeto contato de retorno
        User tUser = null;

        try
        {
        	// Criando o comando SQL e o comando JDBC
        	PreparedStatement tPS = null;
			tPS = sConnection.prepareStatement("UPDATE USERS SET" +
                    " USER_NAME = ?, USER_PASS = ?, USER_EMAIL = ?,USER_TYPE = ?" +
                    " WHERE USER_ID  = ?");

            // Colocando os par�metros recebidos no comando JDBC
            tPS.setString(1, pUser.getUserName());
            tPS.setString(2, pUser.getUserPass());
            tPS.setString(3, pUser.getUserEmail());
            
            //se for lawyer, id � 0
            if(pUser instanceof Lawyer){
            	
            tPS.setInt(4, 1);
            
            }else{
            	 
            	tPS.setInt(4, 2);                              	
            	
            }
            tPS.setInt(5, pUser.getUserId());

            // Executando o comando de atualizar e salvando o n�mero de registros alterados
            int tQtdeReg = tPS.executeUpdate();

            // Verificando se um registro foi alterado
            if (tQtdeReg == 1)
            {
                // Copiando o contato para o retorno
                tUser = pUser;
            }

            // Liberando os recursos JDBC
           
       
            	 tPS.close();
            	 
           
            }
        catch (SQLException tExcept)
        {
            opet.marketplace.util.ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de atualiza��o do usu�rio");
        }
        return tUser;
	}

	public boolean delete(int pUserID) {

        try
        {
            // Criando o comando SQL e o comando JDBC
        	PreparedStatement tPS = null;
			tPS = sConnection.prepareStatement("DELETE FROM USERS" +
                    " WHERE USER_ID  = ?");

            // Colocando o par�metro recebido no comando JDBC
            tPS.setInt(1, pUserID);

            // Executando o comando de remo��o e salvando o n�mero de registros removidos
            int tQtdeReg = tPS.executeUpdate();

            // Liberando os recursos JDBC
            tPS.close();

            // Se excluiu um registro, a remo��o foi efetuada com sucesso
            return tQtdeReg == 1;
        }
        catch (SQLException tExcept)
        {
            opet.marketplace.util.ExceptionUtil.mostrarErro(tExcept, "Erro no m�todo de dele��o do contato");
        }

        // Retornando indicativo de falha de remo��o
        return false;
	}

	public List<User> search() {
		return null;
	}

	public List<User> searchByNome(String pNome) {
		return null;
	}

	public List<User> searchByEmail(String pEmail) {
		return null;
	}
	
	 // M�todo para processar o ResultSet e retornar um Contato
    private User loadUser(ResultSet tResultSet) throws SQLException
    {
  
    	int userId;
    	String userName;
    	String userPass;
    	String userEmail;
    	Date userDate;
    	int userType;
    	
        // Recuperando as informa��es do ResultSet e colocando objeto criado
        userId = tResultSet.getInt("USER_ID");
        userName = tResultSet.getString("USER_NAME");
        userPass = tResultSet.getString("USER_PASS");
        userEmail = tResultSet.getString("USER_EMAIL");
        userDate = tResultSet.getDate("USER_CREATION_DATE");
        userType = tResultSet.getInt("USER_TYPE");

        if (userType == 1) {
        	User tUser = new Lawyer(userId, userName, userPass, userEmail, userDate);
        	return tUser;
        }else
        {
        	User tUser = new Client(userId, userName, userPass, userEmail, userDate);
        	return tUser;
        }       
    }
}
