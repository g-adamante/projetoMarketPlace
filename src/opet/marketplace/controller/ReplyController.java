package opet.marketplace.controller;

import java.util.List;

import opet.markeplace.model.ReplyModel;
import opet.marketplace.vo.Reply;

public class ReplyController {

	private ReplyModel ReplyModel = new ReplyModel();

	// M�todo para criar um usu�rio
	public boolean create(Reply pReply) {
		if (pReply == null) {
			System.out.println("Tentativa de inserir um usu�rio nulo");
			return false;
		}

		// chama o model.

		boolean SucessBoolean = ReplyModel.create(pReply);

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

	public Reply recovery(int pInt) {
		if (pInt < 0) {
			System.out.println("Id do usu�rio inv�lido.");
			return null;
		}

		// Chama o model.

		Reply SucessReply = ReplyModel.recovery(pInt);

		// Se o usu�rio for nulo, falha. Caso contr�rio, sucesso.

		if (SucessReply == null) {
			System.out.println("Falha na recupera��o do usu�rio.");
			return null;
		} else {

			return SucessReply;

		}

	}

	// M�todo para alterar um usu�rio
	public boolean update(Reply pReply) {
		if (pReply == null) {
			System.out.println("Tentativa de alterar usu�rio com dados nulos");
			return false;
		}

		// chama o model.

		boolean SucessBoolean = ReplyModel.update(pReply);

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

		boolean SucessBoolean = ReplyModel.delete(pInt);

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
	public List<Reply> search() {

		// Chama o model.

		List<Reply> SucessList = ReplyModel.search();

		// Se a lista for nula, falha. Caso contr�rio, sucesso.

		if (SucessList == null) {
			System.out.println("Falha na pesquisa de usu�rios.");
			return null;
		} else {

			return SucessList;

		}

	}

	public List<Reply> searchByTopic(int pInt) {

		// Chama o model.

		List<Reply> SucessList = ReplyModel.searchByTopic(pInt);

		// Se a lista for nula, falha. Caso contr�rio, sucesso.

		if (SucessList == null) {
			System.out.println("Falha na pesquisa por nome de usu�rios.");
			return null;
		} else {

			return SucessList;

		}

	}

	public List<Reply> searchByUser(int pInt) {

		// Chama o model.

		List<Reply> SucessList = ReplyModel.searchByUser(pInt);

		// Se a lista for nula, falha. Caso contr�rio, sucesso.

		if (SucessList == null) {
			System.out.println("Falha na pesquisa por email de usu�rios.");
			return null;
		} else {

			return SucessList;

		}

	}

	
}
