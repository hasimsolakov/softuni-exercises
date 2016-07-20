<?php
    $mysql = new mysqli('localhost', 'root', '','mysql_exercise');
    $mysql->set_charset("utf8");
    if ($mysql->connect_errno){
        die ('Cannot connect to Mysql');
    }

    if (isset($_GET['id'])){
        $id = htmlspecialchars($_GET['id']);
        $statement = $mysql->prepare("Delete from posts where id = ?");
        $statement->bind_param("i", $id);
        $statement->execute();
        if ($statement->affected_rows == 1) {
            echo "Post deleted";
        }
        else{
            die("Delete post failed.");
        }
    }

    $result = $mysql->query("Select id, title from posts");
    while ($row = $result->fetch_assoc()){
        $title = htmlspecialchars($row['title']);
        $deleteLink = 'delete-post.php?id=' .$row['id'];
        echo "<p><a href='$deleteLink'>Delete post '$title'.</a>";
    }