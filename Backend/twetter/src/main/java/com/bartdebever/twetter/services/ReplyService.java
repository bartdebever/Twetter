package com.bartdebever.twetter.services;

import com.bartdebever.twetter.models.Reply;
import com.bartdebever.twetter.services.interfaces.IReplyService;

import java.util.List;

/**
 * Service to perform Crud actions for the Reply object.
 */
public class ReplyService extends CrudService<Reply> implements IReplyService {
    @Override
    public Reply getById(int id) {
        return getEntityManager().find(Reply.class, id);
    }

    @Override
    public List<Reply> getAll() {
        return null;
    }
}
