package opet.markeplace.model;

import java.util.List;

import opet.marketplace.dao.jdbc.TopicJdbcDAO;
import opet.marketplace.vo.Topic;

public class TopicModel {

	private TopicJdbcDAO TopicJdbcDAO;

	public boolean create(Topic pTopic) {

		Topic SucessTopic = TopicJdbcDAO.create(pTopic);

		if (SucessTopic == null) {
			return false;
		} else {
			return true;
		}

	};

	public Topic recovery(int pInt) {

		return TopicJdbcDAO.recovery(pInt);

	};

	public boolean update(Topic pTopic) {

		Topic SucessTopic = TopicJdbcDAO.update(pTopic);

		if (SucessTopic == null) {
			return false;
		} else {
			return true;
		}

	};

	public boolean delete(int pInt) {
		return TopicJdbcDAO.delete(pInt);
	}

	public List<Topic> search() {
		return TopicJdbcDAO.search();
	}

	public List<Topic> searchBySubject(String pString) {
		return TopicJdbcDAO.searchBySubject(pString);
	}

	public List<Topic> searchByUser(int pInt) {
		return TopicJdbcDAO.searchByUser(pInt);
	}

}
