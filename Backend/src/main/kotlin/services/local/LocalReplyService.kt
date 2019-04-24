package services.local

import models.Reply
import services.interfaces.IReplyService


class LocalReplyService : LocalCrudService<Reply>(), IReplyService
