package opet.marketplace.controller;

import java.util.List;

import opet.markeplace.model.TopicModel;
import opet.marketplace.vo.Topic;

public class TopicController {

	private TopicModel TopicModel = new TopicModel();

	// Método para criar um usuário
	public boolean create(Topic pTopic) {
		if (pTopic == null) {
			System.out.println("Tentativa de inserir um usuário nulo");
			return false;
		}

		// chama o model.

		boolean SucessBoolean = TopicModel.create(pTopic);

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

	public Topic recovery(int pInt) {
		if (pInt < 0) {
			System.out.println("Id do usuário inválido.");
			return null;
		}

		// Chama o model.

		Topic SucessTopic = TopicModel.recovery(pInt);

		// Se o usuário for nulo, falha. Caso contrário, sucesso.

		if (SucessTopic == null) {
			System.out.println("Falha na recuperação do usuário.");
			return null;
		} else {

			return SucessTopic;

		}

	}

	// Método para alterar um usuário
	public boolean update(Topic pTopic) {
		if (pTopic == null) {
			System.out.println("Tentativa de alterar usuário com dados nulos");
			return false;
		}

		// chama o model.

		boolean SucessBoolean = TopicModel.update(pTopic);

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

		boolean SucessBoolean = TopicModel.delete(pInt);

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
	public List<Topic> search() {

		// Chama o model.

		List<Topic> SucessList = TopicModel.search();

		// Se a lista for nula, falha. Caso contrário, sucesso.

		if (SucessList == null) {
			System.out.println("Falha na pesquisa de usuários.");
			return null;
		} else {

			return SucessList;

		}

	}

	public List<Topic> searchBySubject(String pString) {

		// Chama o model.

		List<Topic> SucessList = TopicModel.searchBySubject(pString);

		// Se a lista for nula, falha. Caso contrário, sucesso.

		if (SucessList == null) {
			System.out.println("Falha na pesquisa por nome de usuários.");
			return null;
		} else {

			return SucessList;

		}

	}

	public List<Topic> searchByUser(int pInt) {

		// Chama o model.

		List<Topic> SucessList = TopicModel.searchByUser(pInt);

		// Se a lista for nula, falha. Caso contrário, sucesso.

		if (SucessList == null) {
			System.out.println("Falha na pesquisa por email de usuários.");
			return null;
		} else {

			return SucessList;

		}

	}

	
}
