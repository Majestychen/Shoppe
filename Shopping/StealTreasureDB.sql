use sys;
drop database if exists StealTreasureDB;
create database StealTreasureDB;
use StealTreasureDB;
create table `user`
(
	uId int primary key auto_increment,
    userName varchar(20) not null,
    pwd varchar(16) not null,
    phone varchar(11) not null,
    idCard varchar(18) not null,
    email varchar(30) not null
);
create table `type`
(
	tId int primary key auto_increment,
    tName varchar(20) not null
);
create table product
(
	pId int primary key auto_increment,
    pName varchar(50) not null,
    tId int, FOREIGN KEY (`tId`) REFERENCES `type` (`tId`),
    price decimal(10,2) not null,
    photo varchar(30),
    pStock int default 50,
    detailed text,
    pState bit default 0,
    pOther int
);
create table buy_cat
(
	cId int primary key auto_increment,
    pId int, FOREIGN KEY (`pId`) REFERENCES `product` (`pId`),
    buy_num int default 1 check(buy_num>0),
    cState bit default 0, 
    uId int,FOREIGN KEY (`uId`) REFERENCES `user` (`uId`)
);
create table address
(
	aId int primary key auto_increment,
    aName varchar(10) not null,
    aPhone varchar(11) not null,
    address varchar(256) not null,
    uId int,FOREIGN KEY (`uId`) REFERENCES `user` (`uId`)
);
create table `order`
(
	oId int primary key auto_increment,
    oNum varchar(20) default '000000000',
    cId int,FOREIGN KEY (`cId`) REFERENCES `buy_cat` (`cId`),
    placeAnOrderDate datetime default now(),	#下单时间
    deliveryDate datetime,						#送货时间
    receiptDate datetime,						#收货时间
    sumPrice decimal(10,2) not null,
    oState int default 0,
    aId int,FOREIGN KEY (`aId`) REFERENCES `address` (`aId`),
    uId int,FOREIGN KEY (`uId`) REFERENCES `user` (`uId`)
);
insert into user(userName,pwd,phone,idcard,email) values('xiaobai','123','18370622009','362401199910072832','849494330@qq.com');
select * from user;

insert into type(tName) values('电脑'),('手机'),('家电'),('家具'),('运动'),('食品'),('办公'),('汽车'),('珠宝'),('玩具');
select * from type;

insert into product(pName,tId,price,photo,pStock,detailed,pState) values
('小米8',2,2700,'xiaomi8.jpg',50,'Xiaomi/小米 小米8年度旗舰全面屏骁龙845双频GPS智能拍照游戏手机刘海屏AI',0),
('apple Mac Book Pro笔记本电脑',1,13388,'apple Mac Book Pro.jpg',20,'Apple/苹果MacBook Pro笔记本电脑13.3英寸笔记本电脑带触控2018款官方正品',0),
('Mac Mini MGEN2CH',1,3280,'Mac Mini MGEN2CH.png',50,'Apple/苹果 Mac Mini MGEN2CH/A MGEQ2CH/A 主机 低中配定制 美版',0),
('iphone',2,5999,'3.jpg',50,'Apple iPhone X (A1865) 64GB 深空灰色 移动联通电信4G手机',0),
('HUAWEI',2,4399,'1.jpg',50,'荣耀10 全面屏AI摄影手机 6GB+64GB 幻影蓝全网通 移动联通电信4G',0),
('vivo',2,2599,'4.jpg',50,'vivo Z1极光特别版 新一代全面屏AI双摄手机 4GB+64GB 移动联通电信全网通4G手机',0),
('millet',2,4999,'2.jpg',50,'小米 红米Note5 全网通版 4GB+64GB 黑色 移动联通电信4G手机 双卡双待',0),
('Meizu',2,2899,'5.jpg',50,'魅族 PRO 7 4GB+64GB 全网通公开版 静谧黑 移动联通电信4G手机 双卡双待',0);
select * from user;
select * from product where pName like '%小米%';

insert into buy_cat(pId,buy_num,cState,uId) value(1,1,0,1);
select sum(buy_num)count from buy_cat where uId = 1;
select * from buy_cat where uId = 1;
select pId,pName,tName,price,photo,pStock,detailed,pState from product p inner join type t on p.tId = t.tId order by pId limit 0,10;


#update buy_cat set buy_num = buy_num+1 where cId = 1 and uId = 1;
select * from buy_cat where uId = 1;

select p.photo,p.detailed,p.price,buy_num from buy_cat b inner join product p on b.pId = p.pId where uId = 1 and cState = 0;


insert into address(aName,aPhone,address,uId) values('郭世棋','18370622009','江西省吉安市青原区','1');
select * from address where uId = 1;

select p.photo,p.detailed,p.price,buy_num from buy_cat b inner join product p on b.pId = p.pId where uId = 1 and cState = 0 and cId =1;

select * from `order` where uId = 1;

select p.photo,p.detailed,p.price,buy_num from `order` o 
inner join buy_cat b on o.cId = b.cId
inner join product p on b.pId = p.pId where o.uId = 1 and o.oState = 0;

select * from user order by uId limit 0,10;



select s.id,r.cityName,p.cityName,s.cityName 
from s_provinces s,s_provinces p,s_provinces r 
where s.parentId = p.id and p.parentId = r.id and r.cityName = '广东省'
union
select p.id,r.cityName,p.cityName,null
from s_provinces s,s_provinces p,s_provinces r 
where p.parentId = r.id and r.cityName = '广东省'





