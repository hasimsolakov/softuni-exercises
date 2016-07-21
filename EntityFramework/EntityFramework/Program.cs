using System;
using System.Linq;

namespace EntityFramework
{

    class Program
    {
        static void Main()
        {
            var db = new BlogDbContext();
            Test(db);
            Console.WriteLine();
            Query(db);
            Console.WriteLine();
            CreatePost(db);
            CascadingInsert(db);
            UpdateData(db);
            DeleteData(db);
            ExecuteNativeSql(db);
        }
    #region CRUD
        private static void ExecuteNativeSql(BlogDbContext db)
        {
            Console.WriteLine();
            Console.WriteLine("Execute Native SQL ...");
            var startDate = new DateTime(2016, 05, 19);
            var endDate = new DateTime(2016, 06, 14);

            var posts = db.Database.SqlQuery<PostData>(
                @"SELECT Id, Title, Date From Posts
                    Where convert(date, Date) between {0} and {1} order by
                    Date", startDate, endDate);
            foreach (var postData in posts)
            {
                Console.WriteLine($"#{postData.Id}: {postData.Title} ({postData.Date})");
            }
        }

        private static void DeleteData(BlogDbContext db)
        {
            Console.WriteLine();
            Console.WriteLine("Delete data...");
            var lastPost = db.Posts
                .OrderByDescending(p => p.Id)
                .First();
            db.Comments.RemoveRange(lastPost.Comments);
            lastPost.Tags.Clear();
            db.Posts.Remove(lastPost);
            db.SaveChanges();
            Console.WriteLine($"Delete post #{lastPost.Id}");
        }

        private static void UpdateData(BlogDbContext db)
        {
            Console.WriteLine();
            Console.WriteLine("Update Data ...");
            var user = db.Users.Where(u=> u.UserName == "admin")
                .First();
            user.PasswordHash = Guid.NewGuid().ToByteArray();
            db.SaveChanges();
            Console.WriteLine("User #{0} ({1}) has a new random password.",user.Id, user.UserName);
        }

        private static void CascadingInsert(BlogDbContext db)
        {
            Console.WriteLine();
            Console.WriteLine("Cascading Insert ...");

            var post = new Post()
            {
                Title = "New Post Title",
                Date = DateTime.Now,
                Body = "This post have comments and tags",
                User = db.Users.First(),
                Comments = new Comment[]
                {
                    new Comment() {Text = "Comment 1", Date = DateTime.Now},
                    new Comment() {Text = "Comment 2", Date = DateTime.Now, User = db.Users.First()}
                },
                Tags = db.Tags.Take(3).ToList()
            };

            db.Posts.Add(post);
            db.SaveChanges();
        }

        private static void Test(BlogDbContext db)
        {    
            foreach (var user in db.Users)
            {
                Console.WriteLine(user.UserName);
            }
        }

        private static void Query(BlogDbContext db)
        {
            var posts = db.Posts.Select(post => new
            {
                post.Id,
                post.Title,
                CommentsCount = post.Comments.Count,
                TagsCount = post.Tags.Count
            });

            Console.WriteLine("SQL query:\n{0}\n",posts);

            foreach (var post in posts)
            {
                Console.WriteLine($"{post.Id} {post.Title} ({post.CommentsCount} comments, {post.TagsCount} tags)");
            }
        }

        private static void CreatePost(BlogDbContext db)
        {
            Console.WriteLine("Create post ...");
            Console.WriteLine();
            var post = new Post()
            {
                Title = "New Title",
                Body = "New Post Body",
                Date = DateTime.Now
            };

            db.Posts.Add(post);
            db.SaveChanges();
            Console.WriteLine("Post #{0} created.", post.Id);
        }
#endregion

    }
}
