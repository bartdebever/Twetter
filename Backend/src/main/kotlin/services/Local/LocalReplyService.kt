package services.Local

import models.Reply
import services.interfaces.IReplyService
import javax.enterprise.context.RequestScoped

@RequestScoped
class LocalReplyService : LocalCrudService<Reply>(), IReplyService
