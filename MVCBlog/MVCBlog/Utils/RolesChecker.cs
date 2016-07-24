using System.Collections.Generic;
using System.Linq;

namespace MVCBlog.Utils
{
    using Microsoft.AspNet.Identity.EntityFramework;

    public class RolesChecker
    {

        public static bool IsAdmin(IEnumerable<IdentityRole> rolesCollection, string userId)
        {
            var adminRoleId = rolesCollection.Single(role => role.Name == "Administrators");
            bool isAdmin = adminRoleId.Users.Any(u => u.UserId == userId);
            return isAdmin;
        }
    }
}