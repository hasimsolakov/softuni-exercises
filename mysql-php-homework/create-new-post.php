<form>
    <div>
        Title
    </div>
    <input type="text" name="title">
    <div>Content</div>
    <textarea name="content"></textarea>
    <div><input type="submit" value="Post"></div>
</form>
<?php
    if (isset($_GET['title']) && isset($_GET['content'])){
        $mysql = new mysqli('localhost', 'root', '', 'mysql_exercise');
        $mysql->set_charset("utf8");
        if ($mysql->connect_errno){
            die('Cannot connect to MySQL');
        }

        $title = htmlspecialchars($_GET['title']);
        $content = htmlspecialchars($_GET['content']);
        $date = (new DateTime('now'))->format("Y-m-d H:i:s");
        $userId = 1;
        $statement = $mysql->prepare(
            "Insert into posts(title, content, date, user_id) values(?,?,?,?)");
        $statement->bind_param("sssi", $title, $content, $date, $userId);
        $statement->execute();
        if ($statement->affected_rows == 1){
            echo "Post created.";
        }
        else{
            die("Insert post failed.");
        }
    }
