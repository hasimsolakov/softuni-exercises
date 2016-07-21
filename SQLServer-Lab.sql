	Select * from [BlogDB].[dbo].[Posts];
	Select * from [BlogDB].[dbo].[Users];
	Select title, body from [BlogDB].[dbo].[Posts];
	Select username, fullname from [BlogDB].[dbo].[Users] order by username asc;
	Select username, fullname from [BlogDB].[dbo].[Users] order by fullname desc, username desc;
	Select * from [BlogDB].[dbo].[Users] where ID in (Select AuthorId from [BlogDB].[dbo].[Posts]);
	Select [BlogDB].[dbo].[Users].Username, [BlogDB].[dbo].[Posts].Title from
		[BlogDB].[dbo].[Users] join [BlogDB].[dbo].[Posts] on [BlogDB].[dbo].[Users].id = [BlogDB].[dbo].[Posts].AuthorId;
	Select username, fullname from [BlogDB].[dbo].[Users] where id in(select authorid from
		[BlogDB].[dbo].[Posts] where id = 4);
    Select Username, FullName from [BlogDB].[dbo].[Users] as u where id in(select authorid from [BlogDB].[dbo].[Posts]) order by id desc;

	insert into [BlogDB].[dbo].[Posts] ([AuthorId], [Title], [Body], [Date])
		values(2, 'Random Title', 'Random Content', CAST('2016-07-13T11:30:00' AS DateTime));

	update [BlogDB].[dbo].[Posts] set title = 'New Title' where id = 9;
		select * from [BlogDB].[dbo].[Posts];

	delete from [BlogDB].[dbo].[Posts] where id = 9;
		select * from [BlogDB].[dbo].[Posts];

	select count(*) as Posts_Count from [BlogDB].[dbo].[Posts];
	select count([BlogDB].[dbo].[Posts].authorId) as Posts_Count from [BlogDB].[dbo].[Posts]
		where [BlogDB].[dbo].[Posts].authorId = 2;

	select min(AuthorId) as Min_Value from [BlogDB].[dbo].[Posts];
	select min(date) as Min_Value from [BlogDB].[dbo].[Posts];

	select max(authorid) as Max_Value from [BlogDB].[dbo].[Posts];
	select max(id) as Max_Value from [BlogDB].[dbo].[Tags];

	select sum(id) as Sum_Ids from [BlogDB].[dbo].[Tags];

	Select Count(u.ID) as Users_Count from [BlogDB].[dbo].[Users] as u where id in(select authorid from [BlogDB].[dbo].[Posts] 		as posts where posts.Date >= '2016-06-14' and posts.Date <= '2016-06-14 23:59:59.999');

	Select * from [BlogDB].[dbo].[Posts] as posts where posts.Date >= '2016-06-14' and posts.Date <= '2016-06-14 23:59:59.999' 		order by posts.AuthorID asc;

	Select * from [BlogDB].[dbo].[Posts] as posts where posts.date in(select Min(posts.Date) from posts where posts.AuthorID = 2);

	Select * from [BlogDB].[dbo].[Comments] as comments order by comments.AuthorName asc, comments.ID desc;