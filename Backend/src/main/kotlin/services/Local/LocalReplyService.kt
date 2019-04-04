package services.Local

import models.Reply
import services.interfaces.IReplyService

class LocalReplyService : LocalCrudService<Reply>(), IReplyService
