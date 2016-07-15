<?php $this->title = "Post Title" ?>

<?php $this->title = $this->post['title'];?>
<main id="posts">
    <article>
        <div class="date"><i>Posted on</i>
        <?=(new DateTime($this->post['date']))->format('d-M-Y')?>
            <i>by</i>
            <?=htmlentities($this->post['full_name'])?>
        </div>
        <p class="content"><?= $this->post['content']?></p>
    </article>
</main>
