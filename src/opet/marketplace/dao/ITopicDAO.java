package opet.marketplace.dao;

import java.util.List;

import opet.marketplace.vo.Categories;
import opet.marketplace.vo.Topic;

public abstract interface ITopicDAO
{
  public abstract Topic create(Topic paramTopic);

  public abstract Topic recovery(int paramInt);

  public abstract Topic update(Topic paramTopic);

  public abstract boolean delete(int paramInt);

  public abstract List<Topic> search();

  public abstract List<Topic> searchBySubject(String paramString);

  public abstract List<Topic> searchByUser(int paramInt);

  public abstract List<Topic> searchByCategory(Categories paramCategories);
}

