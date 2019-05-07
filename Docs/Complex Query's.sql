
/* 
    Get's the Twits for a user based on his timeline.
    Checks if the Twit's author is in the following list or if it's the user himself.
    Paginates the results with a LIMIT and OFFSET

    Params:
    - ?userId: The id of the user where the timeline is requested for.
    - ?pageLimit: The amount of results that should be gotten.
    - ?offset: The offset of Twits that have been seen by the user.
 */
SELECT *
FROM Twit t
WHERE t.authorId IN
(
    SELECT u.followingId
    FROM USERS_USERS u
    WHERE u.userId = ?userId
)
OR t.authorId = ?userId
LIMIT ?pageLimit
OFFSET ?offset