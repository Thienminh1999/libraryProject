create database LibraryProjectDB
use LibraryProjectDB

create table tblCategory(
CategoryID char(10) PRIMARY KEY,
CreatedDate Date not null,
CreatedBy nvarchar(50) not null,
ModifiedDate Date null,
ModifiedBy nvarchar(50) null,
CategoryName nvarchar(50) not null
)

create table tblBook(
BookID char(10) PRIMARY KEY,
CreatedDate Date not null,
CreatedBy nvarchar(50) not null,
ModifiedDate Date null,
ModifiedBy nvarchar(50) null,
BookName nvarchar(50) not null,
Publisher nvarchar(50) not null,
PublicDate Date not null,
Size char(50) null,
TypeOfCover nvarchar(50) null,
PageNumber int null,
Descriptions ntext null,
CategoryID char(10) foreign key references tblCategory(CategoryID)
)

insert into 
tblBook(BookID, CreatedDate, CreatedBy, BookName, Publisher, PublicDate,Price,Size,TypeOfCover,PageNumber,CategoryID, BookImage)
values('book002', '2020/6/6', 'admin', N'Hành lý hư vô', N'Nhà xuất bản trẻ', '2020/6/6', '25000', '12x20cm', N'Mềm', 500,'cate004', 'resource/img/book/hanh-ly-hu-vo.png')

insert into 
tblBook(BookID, CreatedDate, CreatedBy, BookName, Publisher, PublicDate,Price,Size,TypeOfCover,PageNumber,CategoryID, BookImage)
values('book003', '2020/6/6', 'admin', N'Khói trời lộng lẫy', N'Nhà xuất bản trẻ', '2020/6/6', '27000', '12x20cm', N'Mềm', 500,'cate004', 'resource/img/book/khoi-troi-long-lay.jpg')
insert into 
tblBook(BookID, CreatedDate, CreatedBy, BookName, Publisher, PublicDate,Price,Size,TypeOfCover,PageNumber,CategoryID, BookImage)
values('book004', '2020/6/6', 'admin', N'Mắt biếc', N'Nhà xuất bản trẻ', '2020/6/6', '30000', '12x20cm', N'Mềm', 500,'cate004', 'resource/img/book/mat-biec.jpg')
insert into 
tblBook(BookID, CreatedDate, CreatedBy, BookName, Publisher, PublicDate,Price,Size,TypeOfCover,PageNumber,CategoryID, BookImage)
values('book005', '2020/6/6', 'admin', N'Những đế chế công nghệ số', N'Nhà xuất bản trẻ', '2020/6/6', '27000', '12x20cm', N'Mềm', 500,'cate001', 'resource/img/book/nhung-de-che-cong-nghe-so.jpg')
insert into 
tblBook(BookID, CreatedDate, CreatedBy, BookName, Publisher, PublicDate,Price,Size,TypeOfCover,PageNumber,CategoryID, BookImage)
values('book006', '2020/6/6', 'admin', N'Oxford yêu thương', N'Nhà xuất bản trẻ', '2020/6/6', '25000', '12x20cm', N'Mềm', 500,'cate004', 'resource/img/book/oxford-yeu-thuong.jpg')
insert into 
tblBook(BookID, CreatedDate, CreatedBy, BookName, Publisher, PublicDate,Price,Size,TypeOfCover,PageNumber,CategoryID, BookImage)
values('book007', '2020/6/6', 'admin', N'Tôi nghĩ tôi thích nước Mỹ', N'Nhà xuất bản trẻ', '2020/6/6', '25000', '12x20cm', N'Mềm', 500,'cate004', 'resource/img/book/toi-nghi-toi-thich-nuoc-my.jpg')
insert into 
tblBook(BookID, CreatedDate, CreatedBy, BookName, Publisher, PublicDate,Price,Size,TypeOfCover,PageNumber,CategoryID, BookImage)
values('book008', '2020/6/6', 'admin', N'Tôi thấy hoa vàng trên cỏ xanh', N'Nhà xuất bản trẻ', '2020/6/6', '30000', '12x20cm', N'Mềm', 500,'cate004', 'resource/img/book/toi-thay-hoc-vang-tren-co-xanh.jpg')
insert into 
tblBook(BookID, CreatedDate, CreatedBy, BookName, Publisher, PublicDate,Price,Size,TypeOfCover,PageNumber,CategoryID, BookImage)
values('book009', '2020/6/6', 'admin', N'Văn hóa doanh nghiệp trong thời đại công nghệ số', N'Nhà xuất bản trẻ', '2020/6/6', '30000', '12x20cm', N'Mềm', 500,'cate001', 'resource/img/book/van-hoa-doanh-nghiep-trong-thoi-dai-cong-nghe-so.jpg')

insert into 
tblBook(BookID, CreatedDate, CreatedBy, BookName, Publisher, PublicDate,Price,Size,TypeOfCover,PageNumber,CategoryID, BookImage)
values('book0010', '2020/6/6', 'admin', N'12 xu hướng công nghệ trong thời đại 4.0', N'Nhà xuất bản trẻ', '2020/6/6', '25000', '12x20cm', N'Mềm', 500,'cate004', 'resource/img/book/12-xu-huong-cong-nghe-trong-thoi-dai-4.jpg')
insert into 
tblBook(BookID, CreatedDate, CreatedBy, BookName, Publisher, PublicDate,Price,Size,TypeOfCover,PageNumber,CategoryID, BookImage)
values('book011', '2020/6/6', 'admin', N'Cô gái đến từ hôm qua', N'Nhà xuất bản trẻ', '2020/6/6', '35000', '12x20cm', N'Mềm', 500,'cate004', 'resource/img/book/co-gai-den-tu-hom-qua.png')
insert into 
tblBook(BookID, CreatedDate, CreatedBy, BookName, Publisher, PublicDate,Price,Size,TypeOfCover,PageNumber,CategoryID, BookImage)
values('book012', '2020/6/6', 'admin', N'Cuộc chiến công nghệ số', N'Nhà xuất bản trẻ', '2020/6/6', '25000', '12x20cm', N'Mềm', 500,'cate001', 'resource/img/book/cuoc-chien-cong-nghe-so.jpg')



create table tblUser(
UserID char(10) PRIMARY KEY,
CreatedDate Date not null,
CreatedBy nvarchar(50) not null,
ModifiedDate Date null,
ModifiedBy nvarchar(50) null,
UserName char(50) not null,
Password char(50) not null,
FullName nvarchar(50) not null,
PhoneNumber char(11) null,
Address nvarchar(50) null,
)
alter table tblUser
add Role bit


create table tblRent(
RentID char(10) PRIMARY KEY,
RentDate Date not null,
ReturnDate Date not null,
RealReturnDate Date null,	
UserID char(10) foreign key references tblUser(UserID)
)

create table tblRentDetail(
RentID char(10) foreign key references tblRent(RentID),
BookID char(10) foreign key references tblBook(BookID),
)

create table tblAuthor(
AuthorID char(10) PRIMARY KEY,
AuthorName nvarchar(50) not null
)

create table tblCompose(
AuthorID char(10) foreign key references tblAuthor(AuthorID),
BookID char(10) foreign key references tblBook(BookID)
)
