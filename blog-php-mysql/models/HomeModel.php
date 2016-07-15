<?php

class HomeModel extends BaseModel
{
    public function getLastPosts(int $maxCount = 5) : array
    {
        $statement = self::$db->query(
            "Select posts.id, title, content, date, full_name ".
            "From posts Left join users on posts.user_id = users.id ".
            "Order by date Desc Limit $maxCount");
        return $statement->fetch_all(MYSQLI_ASSOC);
    }
}
