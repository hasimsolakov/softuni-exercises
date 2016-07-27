using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Data.Entity;

namespace MVCBlog.Controllers
{
    using System.Web.Security;
    using Microsoft.AspNet.Identity;
    using Models;
    using Utils;

    public class HomeController : Controller
    {
        private ApplicationDbContext db = new ApplicationDbContext();

        //GET: Posts
        public ActionResult Index()
        {
            bool isLoggedIn = this.User.Identity.IsAuthenticated;
            string username= this.User.Identity.Name;
            bool isAdmin = RolesChecker.IsAdmin(username);

            var last3Posts = this.db.Posts.Include(p => p.Author)
                .OrderByDescending(p => p.Date).Take(3);
            var last5Posts = this.db.Posts
            .OrderByDescending(post => post.Date)
                .Take(5)
                .ToList();
            this.ViewBag.SidebarPosts = last5Posts;
            this.ViewBag.IsLoggedIn = isLoggedIn;
            this.ViewBag.IsAdmin = isAdmin;

            return View(last3Posts.ToList());
        }
    }
}