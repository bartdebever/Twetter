package services.Local

import models.Twit
import services.interfaces.ITwitService
import javax.enterprise.context.RequestScoped

@RequestScoped
class LocalTwitService : LocalCrudService<Twit>(), ITwitService
