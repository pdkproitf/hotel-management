create table nhanVien_tbl(
  nv_id number not null,
  nv_ten varchar(50),
  nv_ngaySinh varchar(20),
  nv_gioiTinh VARCHAR2(10),
  nv_diaChi VARCHAR2(50),
  nv_dienThoai number,
  nv_congViec VARCHAR(50)
)
--desc nhanVien_tbl
create table phong_tbl(
  p_id number not null,
  p_so number,
  p_loai varchar2(50),
  p_gia number,
  p_sucChua number,
  p_tinhTrang varchar2(50),
  p_ngayThue varchar(20),
  p_ngayTra varchar(20),
  p_soNguoi number,
  p_kh_id number
)

--alter table phong_tbl add p_ngayTra date
--desc phong_tbl
create table khachHang_tbl(
  kh_id number not null,
  kh_ten varchar2(50) not null,
  kh_gioiTinh varchar2(10) not null,
  kh_cmnd number not null,
  kh_dienThoai number,
  kh_tinhTrang varchar2(50),
  kh_p_id number,
  kh_ngayDen varchar2(10),
  kh_ngayDi varchar2(10),
  kh_songuoidicung number
)
--desc khachHang_tbl
create table dichVu_tbl(
  dv_id number not null,
  dv_ten varchar2(50) not null,
  dv_gia number,
  dv_thoiGian varchar2(20),
  dv_kh_id number,
  dv_p_id number,
  dv_tinhTrang varchar2(50)
)
--desc dichVu_tbl
--tao bang user
create table user_tbl(
  u_id number not null,
  u_ten varchar2(50) not null,
  u_matKhau varchar2(50)
)
--desc USER_TBL
--add cac constraint khoa chinh
alter table nhanVien_tbl add constraint pk_nv primary key (nv_id)
alter table phong_tbl add constraint pk_p primary key (p_id)
alter table khachHang_tbl add constraint pk_kh primary key (kh_id)
alter table dichVu_tbl add constraint dv_kh primary key (dv_id)
--add cac constraint khoa phu giua cac bang voi nhau
alter table khachHang_tbl add constraint fk_p_kh foreign key (kh_p_id) references phong_tbl(p_id)
alter table dichVu_tbl add constraint fk_dv_kh foreign key (dv_kh_id) references khachHang_tbl(kh_id)
alter table dichVu_tbl add constraint fk_dv_p foreign key (dv_p_id) references phong_tbl(p_id)
--them du lieu bang nhan vien
--alter table phong_tbl drop constraint fk_p_kh
--tao sequence cho id nhan vien
create sequence nv_sq
increment by 1
start with 1
nocache
nocycle
--
desc nhanvien_tbl

insert into nhanVien_tbl (nv_id,nv_ten,nv_ngaySinh,nv_gioiTinh,nv_diachi,nv_dienthoai,nv_congviec)
values(1,'hoan lac thien','13/02/1994','nam','tien tho',01699346949,'quan ly')

insert into nhanVien_tbl (nv_id,nv_ten,nv_ngaySinh,nv_gioiTinh,nv_diachi,nv_dienthoai,nv_congviec)
values(nv_sq.nextval,'bui quang thang','13/02/1994','nam','tien tho',01699346949,'quan ly')

insert into nhanVien_tbl (nv_id,nv_ten,nv_ngaySinh,nv_gioiTinh,nv_diachi,nv_dienthoai,nv_congviec)
values(nv_sq.nextval,'ho ngoc son','13/02/1994','nam','tien tho',01699346949,'quan ly')

insert into nhanVien_tbl (nv_id,nv_ten,nv_ngaySinh,nv_gioiTinh,nv_diachi,nv_dienthoai,nv_congviec)
values(nv_sq.nextval,'pham hoan long','13/02/1994','nam','tien tho',01699346949,'quan ly')

insert into nhanVien_tbl (nv_id,nv_ten,nv_ngaySinh,nv_gioiTinh,nv_diachi,nv_dienthoai,nv_congviec)
values(nv_sq.nextval,'huyet mi','13/02/1994','nam','tien tho',01699346949,'quan ly')

insert into nhanVien_tbl (nv_id,nv_ten,nv_ngaySinh,nv_gioiTinh,nv_diachi,nv_dienthoai,nv_congviec)
values(nv_sq.nextval,'pdkpro','13/02/1994','nam','tien tho',01699346949,'quan ly')

insert into nhanVien_tbl (nv_id,nv_ten,nv_ngaySinh,nv_gioiTinh,nv_diachi,nv_dienthoai,nv_congviec)
values(nv_sq.nextval,'pham van phuc 2 ','13/02/1994','nam','tien tho',01699346949,'quan ly')

insert into nhanVien_tbl (nv_id,nv_ten,nv_ngaySinh,nv_gioiTinh,nv_diachi,nv_dienthoai,nv_congviec)
values(nv_sq.nextval,'pham van phuc 3','13/02/1994','nam','tien tho',01699346949,'quan ly')

insert into nhanVien_tbl (nv_id,nv_ten,nv_ngaySinh,nv_gioiTinh,nv_diachi,nv_dienthoai,nv_congviec)
values(nv_sq.nextval,'pham van phuc 4','13/02/1994','nam','tien tho',01699346949,'quan ly')

insert into nhanVien_tbl (nv_id,nv_ten,nv_ngaySinh,nv_gioiTinh,nv_diachi,nv_dienthoai,nv_congviec)
values(nv_sq.nextval,'pham van phuc 5','13/02/1994','nam','tien tho',01699346949,'quan ly')

insert into nhanVien_tbl (nv_id,nv_ten,nv_ngaySinh,nv_gioiTinh,nv_diachi,nv_dienthoai,nv_congviec)
values(nv_sq.nextval,'pham van phuc 6','13/02/1994','nam','tien tho',01699346949,'quan ly')

select * from nhanVien_tbl

--thêm d? li?u vào phòng
create sequence p_sq
increment by 1
start with 1
nocache
nocycle 

desc phong_tbl
--alter table phong_tbl drop column P_SONGUOI 

insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(1,102,'A',500,4,'có khách')
insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,103,'A',500,4,'có khách')
insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,104,'A',500,5,'có khách')
insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,105,'A',500,4,'có khách')
insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,106,'A',500,5,'có khách')
insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,107,'A',500,4,'có khách')
insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,108,'A',500,5,'bao tri')
insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,109,'A',500,4,'bao tri')
insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,110,'A',500,4,'bao tri')

insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,101,'B',450,3,'con trong')
insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,102,'B',450,3,'bao tri')
insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,103,'B',450,3,'con trong')
insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,104,'B',450,3,'bao tri')
insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,105,'B',450,3,'bao tri')
insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,106,'B',450,3,'bao tri')
insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,107,'B',450,4,'có khách')
insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,108,'B',500,3,'có khách')
insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,109,'B',450,3,'bao tri')

insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,101,'C',350,4,'bao tri')
insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,102,'C',300,2,'có khách')
insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,103,'C',350,2,'có khách')
insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,104,'C',350,2,'bao tri')
insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,105,'C',400,3,'con trong')
insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,106,'C',400,4,'có khách')
insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,107,'C',400,4,'bao tri')
insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,108,'C',300,2,'con trong')
insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,109,'C',400,4,'con trong')

insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,101,'D',250,3,'bao tri')
insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,102,'D',150,2,'con trong')
insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,103,'D',150,2,'bao tri')
insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,104,'D',150,2,'bao tri')
insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,105,'D',350,3,'có khách')
insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,106,'D',350,3,'có khách')
insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,107,'D',250,4,'có khách')
insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,108,'D',200,3,'có khách')
insert into phong_tbl(p_id,p_so,p_loai,p_gia,p_succhua,p_tinhtrang) values(p_sq.nextval,109,'D',250,3,'có khách')

--select * from phong_tbl where p_tinhtrang = 'b?o trì'
--update phong_tbl set p_tinhtrang = 'con trong' where p_tinhtrang = 'còn tr?ng'
--delete phong_tbl

--thêm d? li?u vào khách hàng
create sequence kh_sq
increment by 1
start with 1
nocache
nocycle 
--
--drop sequence kh_sq
--delete khachhang_tbl
--alter table khachhang_tbl add soNguoiDiCung varchar2(10)
--desc khachHang_tbl
--alter table khachhang_tbl modify soNguoiDiCung number
insert into khachHang_tbl(kh_id,kh_ten,kh_gioitinh,kh_cmnd,kh_dienthoai,kh_tinhtrang,kh_p_id)
values(1,'pham van phuc','nam',205764581,1699346949,'ch?a thanh toán',1)

insert into khachHang_tbl(kh_id,kh_ten,kh_gioitinh,kh_cmnd,kh_dienthoai,kh_tinhtrang,kh_p_id)
values(kh_sq.nextval,'pham van phuc','nam',205764581,1699346949,'ch?a thanh toán',2)

insert into khachHang_tbl(kh_id,kh_ten,kh_gioitinh,kh_cmnd,kh_dienthoai,kh_tinhtrang,kh_p_id)
values(kh_sq.nextval,'pham van phuc','nam',205764581,1699346949,'ch?a thanh toán',3)

insert into khachHang_tbl(kh_id,kh_ten,kh_gioitinh,kh_cmnd,kh_dienthoai,kh_tinhtrang,kh_p_id)
values(kh_sq.nextval,'pham van phuc','nam',205764581,1699346949,'ch?a thanh toán',4)

insert into khachHang_tbl(kh_id,kh_ten,kh_gioitinh,kh_cmnd,kh_dienthoai,kh_tinhtrang,kh_p_id)
values(kh_sq.nextval,'pham van phuc','nam',205764581,1699346949,'ch?a thanh toán',5)

insert into khachHang_tbl(kh_id,kh_ten,kh_gioitinh,kh_cmnd,kh_dienthoai,kh_tinhtrang,kh_p_id)
values(kh_sq.nextval,'pham van phuc','nam',205764581,1699346949,'ch?a thanh toán',6)

insert into khachHang_tbl(kh_id,kh_ten,kh_gioitinh,kh_cmnd,kh_dienthoai,kh_tinhtrang,kh_p_id)
values(kh_sq.nextval,'pham van phuc','nam',205764581,1699346949,'ch?a thanh toán',7)

insert into khachHang_tbl(kh_id,kh_ten,kh_gioitinh,kh_cmnd,kh_dienthoai,kh_tinhtrang,kh_p_id)
values(kh_sq.nextval,'pham van phuc','nam',205764581,1699346949,'ch?a thanh toán',8)

insert into khachHang_tbl(kh_id,kh_ten,kh_gioitinh,kh_cmnd,kh_dienthoai,kh_tinhtrang,kh_p_id)
values(kh_sq.nextval,'pham van phuc','nam',205764581,1699346949,'ch?a thanh toán',9)

insert into khachHang_tbl(kh_id,kh_ten,kh_gioitinh,kh_cmnd,kh_dienthoai,kh_tinhtrang,kh_p_id)
values(kh_sq.nextval,'pham van phuc','nam',205764581,1699346949,'ch?a thanh toán',10)

insert into khachHang_tbl(kh_id,kh_ten,kh_gioitinh,kh_cmnd,kh_dienthoai,kh_tinhtrang,kh_p_id)
values(kh_sq.nextval,'pham van phuc','nam',205764581,1699346949,'ch?a thanh toán',11)

insert into khachHang_tbl(kh_id,kh_ten,kh_gioitinh,kh_cmnd,kh_dienthoai,kh_tinhtrang,kh_p_id)
values(kh_sq.nextval,'pham van phuc','nam',205764581,1699346949,'ch?a thanh toán',12)

insert into khachHang_tbl(kh_id,kh_ten,kh_gioitinh,kh_cmnd,kh_dienthoai,kh_tinhtrang,kh_p_id)
values(kh_sq.nextval,'hoang lac thien','nam',205764581,1699346949,'ch?a thanh toán',13)

insert into khachHang_tbl(kh_id,kh_ten,kh_gioitinh,kh_cmnd,kh_dienthoai,kh_tinhtrang,kh_p_id)
values(kh_sq.nextval,'hoang lac thien 2','nam',205764581,1699346949,'ch?a thanh toán',14)

insert into khachHang_tbl(kh_id,kh_ten,kh_gioitinh,kh_cmnd,kh_dienthoai,kh_tinhtrang,kh_p_id)
values(kh_sq.nextval,'hoang lac thien 3','nam',205764581,1699346949,'ch?a thanh toán',15)

desc khachhang_tbl
--update khachhang_tbl set kh_tinhtrang = 'ch?a thanh toán' where kh_tinhtrang = 'chua'
--select * from khachHang_tbl where kh_tinhtrang = 'ch?a thanh toán'


--thêm d? li?u vào d?ch v?
desc dichVu_tbl

create sequence dv_sq
increment by 1
start with 1
nocycle
nocache

drop sequence dv_sq
delete dichvu_tbl

insert into dichVu_tbl(dv_id,dv_ten,dv_gia,dv_thoigian,dv_kh_id,dv_p_id,dv_tinhtrang)
values(1,'1 thùng bia',200,'12/1/2015',1,1,'chua thanh toan')

insert into dichVu_tbl(dv_id,dv_ten,dv_gia,dv_thoigian,dv_kh_id,dv_p_id,dv_tinhtrang)
values(dv_sq.nextval,'1 thùng cocal',200,'12/4/2015',2,2,'chua thanh toan')

insert into dichVu_tbl(dv_id,dv_ten,dv_gia,dv_thoigian,dv_kh_id,dv_p_id,dv_tinhtrang)
values(dv_sq.nextval,'?n tr?a',200,'12/1/2015',1,2,'chua thanh toan')

insert into dichVu_tbl(dv_id,dv_ten,dv_gia,dv_thoigian,dv_kh_id,dv_p_id,dv_tinhtrang)
values(dv_sq.nextval,'?n sáng',200,'12/1/2015',2,1,'chua thanh toan')

insert into dichVu_tbl(dv_id,dv_ten,dv_gia,dv_thoigian,dv_kh_id,dv_p_id,dv_tinhtrang)
values(dv_sq.nextval,'1 thùng bia',200,'12/1/2015',5,5,'chua thanh toan')

insert into dichVu_tbl(dv_id,dv_ten,dv_gia,dv_thoigian,dv_kh_id,dv_p_id,dv_tinhtrang)
values(dv_sq.nextval,'1 thùng bia',200,'12/1/2015',6,6,'chua thanh toan')

insert into dichVu_tbl(dv_id,dv_ten,dv_gia,dv_thoigian,dv_kh_id,dv_p_id,dv_tinhtrang)
values(dv_sq.nextval,'1 thùng bia',200,'12/1/2015',7,7,'chua thanh toan')

insert into dichVu_tbl(dv_id,dv_ten,dv_gia,dv_thoigian,dv_kh_id,dv_p_id,dv_tinhtrang)
values(dv_sq.nextval,'1 thùng bia',200,'12/1/2015',8,8,'chua thanh toan')

insert into dichVu_tbl(dv_id,dv_ten,dv_gia,dv_thoigian,dv_kh_id,dv_p_id,dv_tinhtrang)
values(dv_sq.nextval,'1 thùng bia',200,'12/1/2015',9,9,'chua thanh toan')

insert into dichVu_tbl(dv_id,dv_ten,dv_gia,dv_thoigian,dv_kh_id,dv_p_id,dv_tinhtrang)
values(dv_sq.nextval,'1 thùng bia',200,'12/1/2015',12,2,'chua thanh toan')

update phong_tbl set p_tinhtrang = 'con trong',p_succhua = 0,p_gia = 500,p_so = 100 where p_loai = 'A'
--delete phong_tbl where p_gia = 1

select * from khachhang_tbl
select * from dichvu_tbl
select * from phong_tbl
select * from user_tbl
select * from nhanvien_tbl

desc user_tbl
desc nhanvien_tbl
desc khachhang_tbl
desc dichvu_tbl
desc phong_tbl

delete phong_tbl
delete khachhang_tbl
delete dichVu_tbl

select kh_id from khachhang_tbl where kh_p_id = 27 and kh_tinhtrang = 'ch?a thanh toán'

update phong_tbl set p_tinhtrang = 'chua co khach' where p_id = 38
commit




create table emp(
  empid number,
  sal number,
  empst varchar2(50)
)
alter table emp add empst varchar2(50)

insert into emp values (1,100)
insert into emp values (2,100)

select * from emp