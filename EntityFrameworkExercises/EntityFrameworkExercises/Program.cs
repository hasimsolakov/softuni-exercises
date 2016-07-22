using System;
using System.Collections.Generic;
using System.Linq;

namespace EntityFrameworkExercises
{
    class Program
    {
        static void Main()
        {
            BlogDbContext blogDbContext = new BlogDbContext();
            RunAllReadOperations(blogDbContext);
            CreateData(blogDbContext);
            UpdateData(blogDbContext);
            RunAllDeleteOperations(blogDbContext);

        }

        private static void RunAllReadOperations(BlogDbContext blogDbContext)
        {
            ListAllPosts(blogDbContext);
            ListAllUsers(blogDbContext);
            ListTitleBodyFromPosts(blogDbContext);
            OrderData(blogDbContext);
            OrderByTwoColumns(blogDbContext);
            SelectAuthors(blogDbContext);
            JoinsAuthorsWithTitles(blogDbContext);
            SelectAuthorOfSpecificPost(blogDbContext);
            OrderPostsAuthors(blogDbContext);
        }

        private static void RunAllDeleteOperations(BlogDbContext blogDbContext)
        {
            try
            {
                DeletePostWithId(blogDbContext);
            }
            catch (InvalidOperationException)
            {
                Console.WriteLine("The provided id or the default id  for the Post to delete is not existing please change it");
            }

            try
            {
                DeleteCommentWithId(blogDbContext);
            }
            catch (InvalidOperationException)
            {
                Console.WriteLine("The provided id or the default id  for the Comment to delete is not existing please change it");
            }

        }

    #region Delete data
        private static void DeletePostWithId(BlogDbContext blogDbContext, int id = 30)
        {
            Console.WriteLine();
            Console.WriteLine("Delete Post with id = {0}", id);

            Post postInfo = blogDbContext.Posts.Single(post => post.Id == id);

            blogDbContext.Comments.RemoveRange(postInfo.Comments);
            postInfo.Tags.Clear();

            blogDbContext.Posts.Remove(postInfo);
            blogDbContext.SaveChanges();

            Console.WriteLine("Post #{0} deleted successfully", postInfo.Id);
        }

        private static void DeleteCommentWithId(BlogDbContext blogDbContext, int id = 1)
        { 
            Console.WriteLine();
            Console.WriteLine("Delete Comment with id = {0} ...", id);

            Comments commentInfo = blogDbContext.Comments.Single(comment => comment.Id == id);

            blogDbContext.Comments.Remove(commentInfo);
            blogDbContext.SaveChanges();

            Console.WriteLine(@"Comment #{0} deleted", commentInfo.Id);
        }
#endregion

        private static void UpdateData(BlogDbContext blogDbContext)
        {
            Console.WriteLine();
            Console.WriteLine("Update Data...");

            User userInfo = blogDbContext.Users.Single(user => user.UserName == "GBotev");

            string oldName = userInfo.FullName;

            userInfo.FullName = "Georgi Botev";
            blogDbContext.SaveChanges();

            Console.WriteLine(@"User '{0}' has been renamed to '{1}'", oldName, userInfo.FullName);
        }

        private static void CreateData(BlogDbContext blogDbContext)
        {
            Console.WriteLine();
            Console.WriteLine("Create Data...");

            Post post = new Post()
            {
                AuthorId = 2,
                Title = "Random Title",
                Body = "Random Content",
                Date = DateTime.Now
            };

            blogDbContext.Posts.Add(post);
            blogDbContext.SaveChanges();

            Console.WriteLine("Post #{0} Created!", post.Id);
        }

    #region Read data
            private static void OrderPostsAuthors(BlogDbContext blogDbContext)
            {
                var postAuthors = blogDbContext.Posts.Select(post => new
                {
                    post.User.UserName,
                    post.User.FullName,
                    Id = post.AuthorId
                })
                .Where(author => author.Id != null)
                .Distinct()
                .OrderByDescending(author => author.Id);

                foreach (var author in postAuthors)
                {
                    Console.WriteLine("Username: {0}", author.UserName);
                    Console.WriteLine("Full Name: {0}", author.FullName);
                    Console.WriteLine();
                }
            }

            private static void SelectAuthorOfSpecificPost(BlogDbContext blogDbContext)
            {
                var author = blogDbContext.Users.SelectMany(user => user.Posts, (user, post) => new
                {
                    user.UserName,
                    user.FullName,
                    post.Id
                }).Single(post => post.Id == 4);

                Console.WriteLine("Username: {0}", author.UserName);
                Console.WriteLine("Full Name: {0}", author.FullName);
                Console.WriteLine();
            }

            private static void JoinsAuthorsWithTitles(BlogDbContext blogDbContext)
            {
                var users = blogDbContext.Users.SelectMany(user => user.Posts, (user, post) => new
                {
                    user.UserName,
                    post.Title
                });

                foreach (var user in users)
                {
                    Console.WriteLine("Username: {0}", user.UserName);
                    Console.WriteLine("Post Title: {0}", user.Title);
                    Console.WriteLine();
                }
            }

            private static void SelectAuthors(BlogDbContext blogDbContext)
            {
                List<User> users = blogDbContext.Users.Select(user => user)
                    .Where(user => user.Posts.Count > 0)
                    .ToList();

                foreach (User user in users)
                {
                    Console.WriteLine("Username: {0}", user.UserName);
                    Console.WriteLine("Full Name: {0}", user.FullName);
                    Console.WriteLine("Posts Count: {0}", user.Posts.Count);
                    Console.WriteLine();
                }
            }

            private static void OrderByTwoColumns(BlogDbContext blogDbContext)
            {
                var users = blogDbContext.Users.Select(user => new
                {
                    user.UserName,
                    user.FullName
                })
                    .OrderByDescending(user => user.UserName)
                    .ThenByDescending(user => user.FullName)
                    .ToList();

                foreach (var user in users)
                {
                    Console.WriteLine("Username: {0}", user.UserName);
                    Console.WriteLine("Full name: {0}", user.FullName);
                    Console.WriteLine();
                }
            }

            private static void OrderData(BlogDbContext blogDbContext)
            {
                var users = blogDbContext.Users.Select(user => new
                {
                    user.UserName,
                    user.FullName
                })
                .OrderBy(user => user.UserName)
                .ToList();

                foreach (var user in users)
                {
                    Console.WriteLine("Username: {0}", user.UserName);
                    Console.WriteLine("Full name: {0}", user.FullName);
                    Console.WriteLine();
                }
            }

            private static void ListTitleBodyFromPosts(BlogDbContext blogDbContext)
            {
                var posts = blogDbContext.Posts.Select(post => new
                {
                    post.Title,
                    post.Body
                }).ToList();

                foreach (var post in posts)
                {
                    Console.WriteLine("Title: {0}", post.Title);
                    Console.WriteLine("Content: {0}", post.Body);
                    Console.WriteLine();
                }
            }

            private static void ListAllUsers(BlogDbContext blogDbContext)
            {
                List<User> users = blogDbContext.Users.Select(user => user).ToList();

                foreach (User user in users)
                {
                    Console.WriteLine("ID: {0}", user.Id);
                    Console.WriteLine("Name: {0}",user.FullName);
                    Console.WriteLine("Comments Count: {0}", user.Comments.Count);
                    Console.WriteLine("Posts Count: {0}", user.Posts.Count);
                    Console.WriteLine();
                }
            }

            private static void ListAllPosts(BlogDbContext blogDbContext)
            {
                Console.WriteLine();
                Console.WriteLine("List all posts ...");
                List<Post> posts = blogDbContext.Posts.Select(post => post).ToList();

                foreach (Post post in posts)
                {
                    Console.WriteLine("Title: {0}", post.Title);
                    Console.WriteLine("AuthorId: {0}", post.AuthorId);
                    Console.WriteLine("Comments Count: {0}", post.Comments.Count);
                    Console.WriteLine("Tags Count: {0}", post.Tags.Count);
                    Console.WriteLine();
                }
            }
    #endregion

    }
}
