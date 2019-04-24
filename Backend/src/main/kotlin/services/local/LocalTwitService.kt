package services.local

import models.Twit
import services.interfaces.ITwitService


class LocalTwitService : LocalCrudService<Twit>(), ITwitService
