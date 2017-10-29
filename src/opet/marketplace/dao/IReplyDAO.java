package opet.marketplace.dao;

import java.util.List;

import opet.marketplace.vo.Reply;

public abstract interface IReplyDAO
{
  public abstract Reply create(Reply paramReply);

  public abstract Reply recovery(int paramInt);

  public abstract Reply update(Reply paramReply);

  public abstract boolean delete(int paramInt);

  public abstract List<Reply> search();

  public abstract List<Reply> searchByContent(String paramString);

  public abstract List<Reply> searchByUser(int paramInt);

  public abstract List<Reply> searchByTopic(int paramInt);
}

