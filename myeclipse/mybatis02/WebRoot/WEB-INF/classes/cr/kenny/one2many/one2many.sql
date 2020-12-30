create table grades(
    gid int(5) primary key,
    gname varchar(20)
);

create table students(
    sid int(5) primary key,
    sname varchar(10),
    sgid int(5) ,
    constraint sgid_fk foreign key(sgid) references grades(gid)
);

insert into grades(gid,gname) values(1,"java");
insert into students(sid,sname,sgid) values(1,"jackline",1);
insert into students(sid,sname,sgid) values(2,"mary",1);
