package opet.marketplace.controller;

import opet.marketplace.model.TopicModel;
import opet.marketplace.vo.Topic;

public class TopicController
{
    private TopicModel topicModel;

    public TopicController()
    {
        this.topicModel = new TopicModel();
    }

    public boolean create(Topic pTopic)
    {
        if (pTopic == null)
        {
            System.out.println("Tentativa de inserir um usu�rio nulo");
            return false;
        }

        boolean sucessBoolean = this.topicModel.create(pTopic);

        if (sucessBoolean)
        {
            System.out.println("Usu�rio Inserido com sucesso.");
            return true;
        }
        System.out.println("Falha na inser��o de usu�rio.");
        return false;
    }

    public Topic recovery(int pInt)
    {
        if (pInt < 0)
        {
            System.out.println("Id do usu�rio inv�lido.");
            return null;
        }

        Topic sucessTopic = this.topicModel.recovery(pInt);

        if (sucessTopic == null)
        {
            System.out.println("Falha na recupera��o do usu�rio.");
            return null;
        }

        return sucessTopic;
    }

    public boolean update(Topic pTopic)
    {
        if (pTopic == null)
        {
            System.out.println("Tentativa de alterar usu�rio com dados nulos");
            return false;
        }

        boolean sucessBoolean = this.topicModel.update(pTopic);

        if (sucessBoolean)
        {
            System.out.println("Usu�rio alterado com sucesso.");
            return true;
        }
        System.out.println("Falha na altera��o de usu�rio.");
        return false;
    }

    public boolean delete(int pInt)
    {
        if (pInt < 0)
        {
            System.out.println("Id do usu�rio inv�lido.");
            return false;
        }

        boolean sucessBoolean = this.topicModel.delete(pInt);

        if (sucessBoolean)
        {
            System.out.println("Usu�rio deletado com sucesso.");
            return true;
        }
        System.out.println("Falha na dele��o de usu�rio.");
        return false;
    }

    public java.util.List<Topic> search()
    {
        java.util.List<Topic> sucessList = this.topicModel.search();

        if (sucessList == null)
        {
            System.out.println("Falha na pesquisa de usu�rios.");
            return null;
        }

        return sucessList;
    }

    public java.util.List<Topic> searchBySubject(String pString)
    {
        java.util.List<Topic> sucessList = this.topicModel.searchBySubject(pString);

        if (sucessList == null)
        {
            System.out.println("Falha na pesquisa por nome de usu�rios.");
            return null;
        }

        return sucessList;
    }

    public java.util.List<Topic> searchByUser(int pInt)
    {
        java.util.List<Topic> sucessList = this.topicModel.searchByUser(pInt);

        if (sucessList == null)
        {
            System.out.println("Falha na pesquisa por email de usu�rios.");
            return null;
        }

        return sucessList;
    }

    public boolean addTopicLawyer(int userId, int topicId)
    {

        if (topicModel.addTopicLawyer(userId, topicId))
        {
            System.out.println("Tópico atribuido com sucesso");
            return true;
        }
        else
        {
            System.out.println("Falha na atribuição do tópico");
            return false;
        }
    }
}
