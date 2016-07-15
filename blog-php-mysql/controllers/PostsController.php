<?php

/**
 * Created by PhpStorm.
 * User: Hashim
 * Date: 15.7.2016 г.
 * Time: 14:41
 */
class PostsController extends BaseController
{
    final function onInit()
    {
        $this->authorize();
    }
    
    public final function index()
    {
        $this->posts = $this->model->getAll();
    }
    
    public final function create()  
    {
        if($this->isPost){
            $title = $_POST['post_title'];
            if (strlen($title) < 1){
                $this->setValidationError("post_title", "Title cannot be empty!");
            }

            $content  = $_POST['post_content'];
            if (strlen($content) < 1){
                $this->setValidationError("post_content", "Content cannot be empty!");
            }

            if($this->formValid()){
                $userId = $_SESSION['user_id'];
                if ($this->model->create($title, $content, $userId)){
                    $this->addInfoMessage("Post created.");
                    $this->redirect("posts");
                }
                else{
                    $this->addErrorMessage("Error: cannot create post.");
                }
            }
        }
    }
    
    public final function edit(int $id)
    {
        
    }
    
    public final function delete(int $id)
    {
        if ()
    }
}