package services.Local

import models.Twit
import services.interfaces.ITwitService

class LocalTwitService : LocalCrudService<Twit>(), ITwitService
