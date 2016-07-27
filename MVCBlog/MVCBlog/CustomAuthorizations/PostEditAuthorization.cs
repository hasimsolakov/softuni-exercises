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

        protected override bool AuthorizeCore(HttpContextBase httpContext)
        {        
            var authorized = base.AuthorizeCore(httpContext);
            if (!authorized)
            {
                return false;
            }

            var username = httpContext.User.Identity.Name;
            bool isAdmin = RolesChecker.IsAdmin(username);
            if (isAdmin)
            {
                return true;
            }
            
            var routeData = httpContext.Request.RequestContext.RouteData;

            var id = routeData.Values["id"];
            int postId = Convert.ToInt32(id);
            string userId = httpContext.User.Identity.GetUserId();
            bool isOwner = RolesChecker.IsOwnerOfThePost(postId, userId);
            return isOwner;  //If is owner access is granted
        }
    }
}