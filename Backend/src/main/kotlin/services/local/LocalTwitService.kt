package services.local

import models.Twit
import services.interfaces.ITwitService
import javax.enterprise.context.RequestScoped
import javax.enterprise.inject.Alternative
import javax.inject.Named


@RequestScoped
@Named("TwitTest")
@Alternative
class LocalTwitService : LocalCrudService<Twit>(), ITwitService
