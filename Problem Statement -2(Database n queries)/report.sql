/*1 Count no of retailers*/
select count(*) from retailers;

/*2 Count Shoppers*/
select fname,lname,scount from retailers;

/*3 All shoppers count*/
select sum(scount) from retailers;

/*4 Purchase amount per day wrt a retailer*/
select sum(amount) from transaction
where remail="#retailer_email" and date=curdate();

/*5 Top retailer*/
select fname, lname , scount from retailers
having scount = max(scount);

/*6 Loyal shopper*/
select * from
(select * from transaction where remail= "#retailer_email") as a
group by a.semail
having count(a.semail) > 5;

/* checking for only one transaction per day condition*/
select * from stores where email not in(select remail from transaction where semail="#shopper_email" and date = CURDATE());