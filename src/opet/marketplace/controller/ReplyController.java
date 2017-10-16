package opet.marketplace.controller;

import java.util.List;

import opet.markeplace.model.ReplyModel;
import opet.marketplace.vo.Reply;

public class ReplyController {

	private ReplyModel ReplyModel = new ReplyModel();

	// Método para criar um usuário
	public boolean create(Reply pReply) {
		if (pReply == null) {
			System.out.println("Tentativa de inserir um usuário nulo");
			return false;
		}

		// chama o model.

		boolean SucessBoolean = ReplyModel.create(pReply);

		// se verdadeiro, sucesso, caso contrário, falha
		if (SucessBoolean) {
			System.out.println("Usuário Inserido com sucesso.");
			return true;
		} else {
			System.out.println("Falha na inserção de usuário.");
			return false;
		}
	}

	// Método para recuperar um usuário

	public Reply recovery(int pInt) {
		if (pInt < 0) {
			System.out.println("Id do usuário inválido.");
			return null;
		}

		// Chama o model.

		Reply SucessReply = ReplyModel.recovery(pInt);

		// Se o usuário for nulo, falha. Caso contrário, sucesso.

		if (SucessReply == null) {
			System.out.println("Falha na recuperação do usuário.");
			return null;
		} else {

			return SucessReply;

		}

	}

	// Método para alterar um usuário
	public boolean update(Reply pReply) {
		if (pReply == null) {
			System.out.println("Tentativa de alterar usuário com dados nulos");
			return false;
		}

		// chama o model.

		boolean SucessBoolean = ReplyModel.update(pReply);

		// se verdadeiro, sucesso, caso contrário, falha
		if (SucessBoolean) {
			System.out.println("Usuário alterado com sucesso.");
			return true;
		} else {
			System.out.println("Falha na alteração de usuário.");
			return false;
		}
	}

	// Método para deletar um usuário
	public boolean delete(int pInt) {

		if (pInt < 0) {
			System.out.println("Id do usuário inválido.");
			return false;
		}

		// chama o model.

		boolean SucessBoolean = ReplyModel.delete(pInt);

		// se verdadeiro, sucesso, caso contrário, falha
		if (SucessBoolean) {
			System.out.println("Usuário deletado com sucesso.");
			return true;
		} else {
			System.out.println("Falha na deleção de usuário.");
			return false;
		}
	}

	// Método para pesquisar todos os contatos
	public List<Reply> search() {

		// Chama o model.

		List<Reply> SucessList = ReplyModel.search();

		// Se a lista for nula, falha. Caso contrário, sucesso.

		if (SucessList == null) {
			System.out.println("Falha na pesquisa de usuários.");
			return null;
		} else {

			return SucessList;

		}

	}

	public List<Reply> searchByTopic(int pInt) {

		// Chama o model.

		List<Reply> SucessList = ReplyModel.searchByTopic(pInt);

		// Se a lista for nula, falha. Caso contrário, sucesso.

		if (SucessList == null) {
			System.out.println("Falha na pesquisa por nome de usuários.");
			return null;
		} else {

			return SucessList;

		}

	}

	public List<Reply> searchByUser(int pInt) {

		// Chama o model.

		List<Reply> SucessList = ReplyModel.searchByUser(pInt);

		// Se a lista for nula, falha. Caso contrário, sucesso.

		if (SucessList == null) {
			System.out.println("Falha na pesquisa por email de usuários.");
			return null;
		} else {

			return SucessList;

		}

	}

	
}
