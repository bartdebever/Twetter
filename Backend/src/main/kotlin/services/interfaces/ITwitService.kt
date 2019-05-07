package services.interfaces

import models.Twit

interface ITwitService : ICrudService<Twit> {
    /**
     * Gets the twits for a user's timeline.
     */
    fun getTimelineByUser(id: Int, page: Int): List<Twit>
}