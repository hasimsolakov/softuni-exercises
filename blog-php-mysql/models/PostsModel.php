<?php

/**
 * Created by PhpStorm.
 * User: Hashim
 * Date: 15.7.2016 г.
 * Time: 14:42
 */
class PostsModel extends BaseModel
{
    public final function getAll() :array 
    {
        $statement = self::$db->query(
            "select * from posts order by date desc");
        return $statement->fetch_all(MYSQLI_ASSOC);
        
    }
    
    public final function getById(int $id)
    {
        $statement = self::$db->prepare(
        "Select * from posts where id = ?");
        $statement->bind_param("i", $id);
        $statement->execute();
        $result = $statement->get_result()->fetch_assoc();
        return $result;
    }
    
    public final function create(string $title, string $content, int $user_id) : bool
    {
        $statement = self::$db->prepare(
            "insert into posts(title, content, user_id) values(?, ?, ?)");
        $statement->bind_param("ssi", $title, $content, $user_id);
        $statement->execute();
        return $statement->affected_rows == 1;
    }
    
    public final function edit(string $id, string $title, string $content, 
string $date, int $user_id) : bool
    {
        $statement = self::$db->prepare(
            "update posts set title=?, ".
            "content = ?, date = ?, user_id = ? where id = ?");
        $statement->bind_param("sssii", $title, $content, $date, $user_id, $id);
        $statement->execute();
        return $statement->affected_rows >= 0;
    }
    
    public final function delete(int $id) : bool
    {
        $statement = self::$db->prepare(
            "delete from posts where id = ?");
        $statement->bind_param("i", $id);
        $statement->execute();
        return $statement->affected_rows == 1;
    }
}