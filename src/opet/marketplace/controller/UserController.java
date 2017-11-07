package opet.marketplace.controller;

import opet.marketplace.model.UserModel;
import opet.marketplace.vo.User;

public class UserController
{
    private UserModel userModel;

    public UserController()
    {
        this.userModel = new UserModel();
    }

    public boolean create(User pUser)
    {
        if (pUser == null)
        {
            System.out.println("Tentativa de inserir um usuario nulo");
            return false;
        }

        boolean sucessBoolean = this.userModel.create(pUser);

        if (sucessBoolean)
        {
            System.out.println("Usu�rio Inserido com sucesso.");
            return true;
        }
        System.out.println("Falha na inser��o de usu�rio.");
        return false;
    }

    public User recovery(int pInt)
    {
        if (pInt < 0)
        {
            System.out.println("Id do usu�rio inv�lido.");
            return null;
        }

        User sucessUser = this.userModel.recovery(pInt);

        if (sucessUser == null)
        {
            System.out.println("Falha na recupera��o do usu�rio.");
            return null;
        }

        return sucessUser;
    }

    public boolean update(User pUser)
    {
        if (pUser == null)
        {
            System.out.println("Tentativa de alterar usu�rio com dados nulos");
            return false;
        }

        boolean sucessBoolean = this.userModel.update(pUser);

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

        boolean sucessBoolean = this.userModel.delete(pInt);

        if (sucessBoolean)
        {
            System.out.println("Usu�rio deletado com sucesso.");
            return true;
        }
        System.out.println("Falha na dele��o de usu�rio.");
        return false;
    }

    public java.util.List<User> search()
    {
        java.util.List<User> sucessList = this.userModel.search();
        if (sucessList == null)
        {
            System.out.println("Falha na pesquisa de usu�rios.");
            return null;
        }
        return sucessList;
    }

    public java.util.List<User> searchByName(String pString)
    {
        java.util.List<User> sucessList = this.userModel.searchByName(pString);

        if (sucessList == null)
        {
            System.out.println("Falha na pesquisa por nome de usu�rios.");
            return null;
        }

        return sucessList;
    }

    public User searchByEmail(String pString)
    {

        User sucessUser = this.userModel.searchByEmail(pString);

        if (sucessUser == null)
        {
            System.out.println("Falha na pesquisa por email de usu�rios.");
            return null;
        }

        return sucessUser;
    }

    public User searchById(int pId) {

        User sucessUser = this.userModel.searchById(pId);

        if (sucessUser == null)
        {
            System.out.println("Falha na pesquisa por email de usuarios.");
            return null;
        }

        return sucessUser;
    }

    public boolean validateLogin(String pUserEmail, String pUserPass)
    {
        boolean sucessBoolean = this.userModel.validateLogin(pUserEmail, pUserPass);

        if (sucessBoolean)
        {
            System.out.println("Login Feito com Sucesso");
            return true;
        }
        System.out.println("Erro de Login");
        return false;
    }
}
