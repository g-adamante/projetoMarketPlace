package opet.marketplace.controller;

import opet.marketplace.model.ReplyModel;
import opet.marketplace.vo.Reply;

public class ReplyController
{
    private ReplyModel replyModel;

    public ReplyController()
    {
        this.replyModel = new ReplyModel();
    }

    public boolean create(Reply pReply)
    {
        if (pReply == null)
        {
            System.out.println("Tentativa de inserir um usu�rio nulo");
            return false;
        }

        boolean sucessBoolean = this.replyModel.create(pReply);

        if (sucessBoolean)
        {
            System.out.println("Usu�rio Inserido com sucesso.");
            return true;
        }
        System.out.println("Falha na inser��o de usu�rio.");
        return false;
    }

    public Reply recovery(int pInt)
    {
        if (pInt < 0)
        {
            System.out.println("Id do usu�rio inv�lido.");
            return null;
        }

        Reply sucessReply = this.replyModel.recovery(pInt);

        if (sucessReply == null)
        {
            System.out.println("Falha na recupera��o do usu�rio.");
            return null;
        }

        return sucessReply;
    }

    public boolean update(Reply pReply)
    {
        if (pReply == null)
        {
            System.out.println("Tentativa de alterar usu�rio com dados nulos");
            return false;
        }

        boolean sucessBoolean = this.replyModel.update(pReply);

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

        boolean sucessBoolean = this.replyModel.delete(pInt);

        if (sucessBoolean)
        {
            System.out.println("Usu�rio deletado com sucesso.");
            return true;
        }
        System.out.println("Falha na dele��o de usu�rio.");
        return false;
    }

    public java.util.List<Reply> search()
    {
        java.util.List<Reply> sucessList = this.replyModel.search();

        if (sucessList == null)
        {
            System.out.println("Falha na pesquisa de usu�rios.");
            return null;
        }

        return sucessList;
    }

    public java.util.List<Reply> searchByTopic(int pInt)
    {
        java.util.List<Reply> sucessList = this.replyModel.searchByTopic(pInt);

        if (sucessList == null)
        {
            System.out.println("Falha na pesquisa por nome de usu�rios.");
            return null;
        }

        return sucessList;
    }

    public java.util.List<Reply> searchByUser(int pInt)
    {
        java.util.List<Reply> sucessList = this.replyModel.searchByUser(pInt);

        if (sucessList == null)
        {
            System.out.println("Falha na pesquisa por email de usu�rios.");
            return null;
        }

        return sucessList;
    }
}
