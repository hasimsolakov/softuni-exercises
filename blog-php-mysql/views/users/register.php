<?php $this->title = 'Register New User'; ?>

<h1><?= htmlspecialchars($this->title) ?></h1>
<form method="post">
    <div><label for="username">Username:</label></div>
    <input type="text" id="username" name="username"/>
    <div><label for="password">Password:</label></div>
    <input type="password" id="password" name="password"/>
    <div><label for="username">Full name:</label></div>
    <input type="text" id="full_name" name="full_name"/>
    <div><input type="submit" value="Register"/>
        <a href="<?=APP_ROOT?>/users/login">{Go to Login]</a></div>
</form>
