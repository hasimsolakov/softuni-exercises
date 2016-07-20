<?php

    $mysql = new mysqli('localhost', 'root','','mysql_exercise');
    $mysql->set_charset("utf8");
    if ($mysql->connect_errno){
        die('Cannot connect to MySql');
    }

    $result = $mysql->query("select * from posts order by date");
    if (!$result){
        die('Cannot read posts table from MySql');
    }

    echo "<table>\n";
    echo "<tr><th>Title</th><th>Content</th><th>Date</th></tr>\n";

    while ($row = $result->fetch_assoc()) {
        $title = htmlspecialchars($row['title']);
        $body = htmlspecialchars($row['content']);
        $dateString = htmlspecialchars($row['date']);
        $date = (new DateTime($dateString))->format('d.m.Y');
        echo "<tr><td>$title</td><td>$body</td><td>$date</td></tr>\n";
    }

