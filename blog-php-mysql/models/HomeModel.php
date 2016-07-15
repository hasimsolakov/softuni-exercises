<?php

class HomeModel extends BaseModel
{
    public function getLastPosts(int $maxCount = 5) : array
    {
        $statement = self::$db->query(
            "Select posts.id, title, content, date, full_name " .
            "From posts Left join users on posts.user_id = users.id " .
            "Order by date Desc Limit $maxCount");
        return $statement->fetch_all(MYSQLI_ASSOC);
    }

    public function getPostById(int $id)
    {
        $statement = self::$db->prepare(
        "select posts.id, title, content, date, full_name ".
        "from posts Left join users on posts.user_id = users.id ".
        "where posts.id = ?");
        $statement->bind_param("i", $id);
        $statement->execute();
        $result = $statement->get_result()->fetch_assoc();
        return $result;
    }
}
