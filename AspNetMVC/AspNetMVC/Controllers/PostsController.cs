namespace AspNetMVC.Controllers
{
    using System.Data.Entity;
    using System.Linq;
    using System.Net;
    using System.Web.Mvc;
    using Models;

    public class PostsController : Controller
    {
        private readonly BlogDBContext db = new BlogDBContext();

        // GET: Posts
        public ActionResult Index()
        {
            var posts = this.db.Posts.Include(p => p.Users);
            return this.View(posts.ToList());
        }

        // GET: Posts/Details/5
        public ActionResult Details(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            var posts = this.db.Posts.Find(id);
            if (posts == null)
            {
                return this.HttpNotFound();
            }
            return this.View(posts);
        }

        // GET: Posts/Create
        public ActionResult Create()
        {
            this.ViewBag.AuthorID = new SelectList(this.db.Users, "ID", "Username");
            return this.View();
        }

        // POST: Posts/Create
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Create([Bind(Include = "ID,Title,Body,Date,AuthorID")] Posts posts)
        {
            if (this.ModelState.IsValid)
            {
                this.db.Posts.Add(posts);
                this.db.SaveChanges();
                return this.RedirectToAction("Index");
            }

            this.ViewBag.AuthorID = new SelectList(this.db.Users, "ID", "Username", posts.AuthorID);
            return this.View(posts);
        }

        // GET: Posts/Edit/5
        public ActionResult Edit(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            var posts = this.db.Posts.Find(id);
            if (posts == null)
            {
                return this.HttpNotFound();
            }
            this.ViewBag.AuthorID = new SelectList(this.db.Users, "ID", "Username", posts.AuthorID);
            return this.View(posts);
        }

        // POST: Posts/Edit/5
        // To protect from overposting attacks, please enable the specific properties you want to bind to, for 
        // more details see http://go.microsoft.com/fwlink/?LinkId=317598.
        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "ID,Title,Body,Date,AuthorID")] Posts posts)
        {
            if (this.ModelState.IsValid)
            {
                this.db.Entry(posts).State = EntityState.Modified;
                this.db.SaveChanges();
                return this.RedirectToAction("Index");
            }
            this.ViewBag.AuthorID = new SelectList(this.db.Users, "ID", "Username", posts.AuthorID);
            return this.View(posts);
        }

        // GET: Posts/Delete/5
        public ActionResult Delete(int? id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            var posts = this.db.Posts.Find(id);
            if (posts == null)
            {
                return this.HttpNotFound();
            }
            return this.View(posts);
        }

        // POST: Posts/Delete/5
        [HttpPost, ActionName("Delete")]
        [ValidateAntiForgeryToken]
        public ActionResult DeleteConfirmed(int id)
        {
            var post = this.db.Posts.Find(id);
            this.db.Posts.Remove(post);
            this.db.SaveChanges();
            return this.RedirectToAction("Index");
        }

        protected override void Dispose(bool disposing)
        {
            if (disposing)
            {
                this.db.Dispose();
            }
            base.Dispose(disposing);
        }
    }
}