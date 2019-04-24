package services.local

import models.Reply
import services.interfaces.IReplyService
import javax.enterprise.context.RequestScoped
import javax.enterprise.inject.Alternative
import javax.inject.Named

@RequestScoped
@Named("ReplyTest")
@Alternative
class LocalReplyService : LocalCrudService<Reply>(), IReplyService
