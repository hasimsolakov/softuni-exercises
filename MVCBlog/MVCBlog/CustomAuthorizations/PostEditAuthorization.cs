using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace MVCBlog.CustomAuthorizations
{
    using System.Net.Configuration;
    using System.Security.Principal;
    using System.Web.Mvc;
    using Microsoft.AspNet.Identity;
    using Models;
    using Utils;

    public class PostEditAuthorization : AuthorizeAttribute
    {
        private ApplicationDbContext db = new ApplicationDbContext();

        protected override bool AuthorizeCore(HttpContextBase httpContext)
        {        
            var authorized = base.AuthorizeCore(httpContext);
            if (!authorized)
            {
                return false;
            }

            var username = httpContext.User.Identity.Name;
            var userId = HttpContext.Current.User.Identity.GetUserId(); 
            bool isAdmin = RolesChecker.IsAdmin(this.db.Roles,userId);
            if (isAdmin)
            {
                return true;
            }
            
            var routeData = httpContext.Request.RequestContext.RouteData;

            var id = routeData.Values["id"];
            int postId = Convert.ToInt32(id);

            Post post = this.db.Posts.Single(p => p.Id == postId);
            if (post.Author_Id == null)
            {
                return false;
            }

            return post.Author_Id == userId;
        }
    }
}