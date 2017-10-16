package opet.marketplace.controller;

import java.util.List;

import opet.markeplace.model.UserModel;
import opet.marketplace.vo.User;

public class UserController {

	private UserModel UserModel = new UserModel();

	// M�todo para criar um usu�rio
	public boolean create(User pUser) {
		if (pUser == null) {
			System.out.println("Tentativa de inserir um usu�rio nulo");
			return false;
		}

		// chama o model.

		boolean SucessBoolean = UserModel.create(pUser);

		// se verdadeiro, sucesso, caso contr�rio, falha
		if (SucessBoolean) {
			System.out.println("Usu�rio Inserido com sucesso.");
			return true;
		} else {
			System.out.println("Falha na inser��o de usu�rio.");
			return false;
		}
	}

	// M�todo para recuperar um usu�rio

	public User recovery(int pInt) {
		if (pInt < 0) {
			System.out.println("Id do usu�rio inv�lido.");
			return null;
		}

		// Chama o model.

		User SucessUser = UserModel.recovery(pInt);

		// Se o usu�rio for nulo, falha. Caso contr�rio, sucesso.

		if (SucessUser == null) {
			System.out.println("Falha na recupera��o do usu�rio.");
			return null;
		} else {

			return SucessUser;

		}

	}

	// M�todo para alterar um usu�rio
	public boolean update(User pUser) {
		if (pUser == null) {
			System.out.println("Tentativa de alterar usu�rio com dados nulos");
			return false;
		}

		// chama o model.

		boolean SucessBoolean = UserModel.update(pUser);

		// se verdadeiro, sucesso, caso contr�rio, falha
		if (SucessBoolean) {
			System.out.println("Usu�rio alterado com sucesso.");
			return true;
		} else {
			System.out.println("Falha na altera��o de usu�rio.");
			return false;
		}
	}

	// M�todo para deletar um usu�rio
	public boolean delete(int pInt) {

		if (pInt < 0) {
			System.out.println("Id do usu�rio inv�lido.");
			return false;
		}

		// chama o model.

		boolean SucessBoolean = UserModel.delete(pInt);

		// se verdadeiro, sucesso, caso contr�rio, falha
		if (SucessBoolean) {
			System.out.println("Usu�rio deletado com sucesso.");
			return true;
		} else {
			System.out.println("Falha na dele��o de usu�rio.");
			return false;
		}
	}

	// M�todo para pesquisar todos os contatos
	public List<User> search() {

		// Chama o model.

		List<User> SucessList = UserModel.search();

		// Se a lista for nula, falha. Caso contr�rio, sucesso.

		if (SucessList == null) {
			System.out.println("Falha na pesquisa de usu�rios.");
			return null;
		} else {

			return SucessList;

		}

	}

	public List<User> searchByName(String pString) {

		// Chama o model.

		List<User> SucessList = UserModel.searchByName(pString);

		// Se a lista for nula, falha. Caso contr�rio, sucesso.

		if (SucessList == null) {
			System.out.println("Falha na pesquisa por nome de usu�rios.");
			return null;
		} else {

			return SucessList;

		}

	}

	public List<User> searchByEmail(String pString) {

		// Chama o model.

		List<User> SucessList = UserModel.searchByEmail(pString);

		// Se a lista for nula, falha. Caso contr�rio, sucesso.

		if (SucessList == null) {
			System.out.println("Falha na pesquisa por email de usu�rios.");
			return null;
		} else {

			return SucessList;

		}

	}

	
}