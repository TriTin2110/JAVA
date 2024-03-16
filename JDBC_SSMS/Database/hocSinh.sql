create database JDBC
use JDBC
create table hocSinh(
	maHocSinh int primary key Identity(1, 1),
	hoTenHocSinh nvarchar(50),
	gioiTinh char(1),
	diemTB float
)
insert into hocSinh 
values (N'Nguyễn Trí Tín', 'M', 9)
select * from hocsinh

