package opet.marketplace.controller;

import java.util.List;

import opet.markeplace.model.TopicModel;
import opet.marketplace.vo.Topic;

public class TopicController {

	private TopicModel TopicModel = new TopicModel();

	// M�todo para criar um usu�rio
	public boolean create(Topic pTopic) {
		if (pTopic == null) {
			System.out.println("Tentativa de inserir um usu�rio nulo");
			return false;
		}

		// chama o model.

		boolean SucessBoolean = TopicModel.create(pTopic);

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

	public Topic recovery(int pInt) {
		if (pInt < 0) {
			System.out.println("Id do usu�rio inv�lido.");
			return null;
		}

		// Chama o model.

		Topic SucessTopic = TopicModel.recovery(pInt);

		// Se o usu�rio for nulo, falha. Caso contr�rio, sucesso.

		if (SucessTopic == null) {
			System.out.println("Falha na recupera��o do usu�rio.");
			return null;
		} else {

			return SucessTopic;

		}

	}

	// M�todo para alterar um usu�rio
	public boolean update(Topic pTopic) {
		if (pTopic == null) {
			System.out.println("Tentativa de alterar usu�rio com dados nulos");
			return false;
		}

		// chama o model.

		boolean SucessBoolean = TopicModel.update(pTopic);

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

		boolean SucessBoolean = TopicModel.delete(pInt);

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
	public List<Topic> search() {

		// Chama o model.

		List<Topic> SucessList = TopicModel.search();

		// Se a lista for nula, falha. Caso contr�rio, sucesso.

		if (SucessList == null) {
			System.out.println("Falha na pesquisa de usu�rios.");
			return null;
		} else {

			return SucessList;

		}

	}

	public List<Topic> searchBySubject(String pString) {

		// Chama o model.

		List<Topic> SucessList = TopicModel.searchBySubject(pString);

		// Se a lista for nula, falha. Caso contr�rio, sucesso.

		if (SucessList == null) {
			System.out.println("Falha na pesquisa por nome de usu�rios.");
			return null;
		} else {

			return SucessList;

		}

	}

	public List<Topic> searchByUser(int pInt) {

		// Chama o model.

		List<Topic> SucessList = TopicModel.searchByUser(pInt);

		// Se a lista for nula, falha. Caso contr�rio, sucesso.

		if (SucessList == null) {
			System.out.println("Falha na pesquisa por email de usu�rios.");
			return null;
		} else {

			return SucessList;

		}

	}

	
}
