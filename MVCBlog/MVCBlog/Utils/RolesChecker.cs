using System.Collections.Generic;
using System.Linq;

namespace MVCBlog.Utils
{
    using System.ComponentModel.Design.Serialization;
    using System.Web.Security;
    using Microsoft.AspNet.Identity.EntityFramework;
    using Models;

    public class RolesChecker
    {
        private const string AdminRoleName = "Administrators";
        private static readonly ApplicationDbContext Db = new ApplicationDbContext();

        public static bool IsAdmin(string userName)
        {
            bool isAdmin = Roles.IsUserInRole(userName, AdminRoleName);
            return isAdmin;
        }

        public static bool IsOwnerOfThePost(int postId, string userId)
        {
            Post post = Db.Posts.Single(p => p.Id == postId);
            if (post.Author_Id == null)
            {
                return false;
            }

            return post.Author_Id == userId;

        } 
    }
}