USE QuanLynghiduongFurama;

-- 2.	Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select * from nhan_vien
where substring_index(ho_ten,' ',-1) regexp '^[HTK]' and char_length(ho_ten) <=15;
-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select * from khach_hang 
where (timestampdiff(year,ngay_sinh,now()) between 18 and 50) and (dia_chi like '% Đà Nẵng' or dia_chi like '% Quảng Trị');
-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select ho_ten, count(ho_ten) from khach_hang kh
join hop_dong hd on hd.ma_khach_hang = kh.ma_khach_hang
join loai_khach l on l.ma_loai_khach = kh.ma_loai_khach
where l.ten_loai_khach = 'Diamond'
group by ho_ten
order by count(ho_ten);
-- 5.	Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc, tong_tien 
-- (Với tổng tiền được tính theo công thức như sau: Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, 
-- hop_dong_chi_tiet) cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra).
select kh.ma_khach_hang, ho_ten, ten_loai_khach, hd.ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong, ngay_ket_thuc
-- , so_luong, gia, chi_phi_thue
,sum(so_luong * gia + chi_phi_thue)
from khach_hang kh
left join hop_dong hd on hd.ma_khach_hang = kh.ma_khach_hang
left join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = hd.ma_hop_dong
left join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
left join loai_khach lk on lk.ma_loai_khach = kh.ma_loai_khach
left join dich_vu dv on dv.ma_dich_vu = hd.ma_dich_vu
group by ho_ten;

-- 6.	Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại dịch vụ 
-- chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
select dv.ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu  from khach_hang kh
join hop_dong hd on hd.ma_khach_hang = kh.ma_khach_hang
join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
join loai_dich_vu ldv on ldv.ma_loai_dich_vu = dv.ma_loai_dich_vu
where dv.ma_dich_vu not in (
	select ma_dich_vu from hop_dong 
    where year(ngay_lam_hop_dong) = 2021 and (month(ngay_lam_hop_dong) between 1 and 3)
);
-- 7.	Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue, 
-- ten_loai_dich_vu của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020 
-- nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
SELECT 
    dv.ma_dich_vu,
    ten_dich_vu,
    dien_tich,
    so_nguoi_toi_da,
    chi_phi_thue,
    ten_loai_dich_vu
FROM dich_vu dv 
	join hop_dong hd on hd. ma_dich_vu = dv.ma_dich_vu
	JOIN loai_dich_vu ldv ON ldv.ma_loai_dich_vu = dv.ma_loai_dich_vu
where year(ngay_lam_hop_dong) = 2020
	and	dv.ma_dich_vu not in (
	select ma_dich_vu from hop_dong where year(ngay_lam_hop_dong) = 2021
);
-- 8.	Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên.
-- C1 
select distinct ho_ten from khach_hang join hop_dong where hop_dong.ma_khach_hang = khach_hang.ma_khach_hang;
-- C2
select ho_ten from khach_hang
where ma_khach_hang in (select ma_khach_hang from hop_dong);
-- C3
select ho_ten from khach_hang join hop_dong where hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
group by ho_ten;

-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 
-- thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select month(ngay_lam_hop_dong), count(*) from hop_dong 
where year(ngay_lam_hop_dong) = 2021
group by month(ngay_lam_hop_dong)
order by month(ngay_lam_hop_dong);

-- 10.	Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, 
-- so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
select hd.ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc, 
sum(so_luong) from hop_dong hd
left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
left join dich_vu_di_kem dv on dv.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
group by hd.ma_hop_dong
order by hd.ma_hop_dong;

-- 11.	Hiển thị thông tin các dịch vụ đi kèm đã được sử dụng bởi những khách hàng 
-- có ten_loai_khach là “Diamond” và có dia_chi ở “Vinh” hoặc “Quảng Ngãi”.
select ten_dich_vu_di_kem from khach_hang kh
join hop_dong hd on hd.ma_khach_hang = kh.ma_khach_hang
join loai_khach l on l.ma_loai_khach = kh.ma_loai_khach
join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = hd.ma_hop_dong
join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
where l.ten_loai_khach = 'Diamond' and (dia_chi like '% Vinh' or dia_chi like '% Quảng Ngãi');

-- 12.	Hiển thị thông tin ma_hop_dong, ho_ten (nhân viên), ho_ten (khách hàng), so_dien_thoai (khách hàng), 
-- ten_dich_vu, so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem), tien_dat_coc 
-- của tất cả các dịch vụ đã từng được khách hàng đặt vào 3 tháng cuối năm 2020 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2021.
select hd.ma_hop_dong, nv.ho_ten, kh.ho_ten, kh.so_dien_thoai, ten_dich_vu, sum(so_luong), tien_dat_coc from hop_dong hd -- 
join nhan_vien nv on nv.ma_nhan_vien = hd.ma_nhan_vien
join khach_hang kh on kh.ma_khach_hang = hd.ma_khach_hang
join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = hd.ma_hop_dong
join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
join dich_vu dv on dv.ma_dich_vu = hd.ma_dich_vu
where quarter(ngay_lam_hop_dong) = 4 and year(ngay_lam_hop_dong) = 2020 
and ten_dich_vu not in (
	select ten_dich_vu from hop_dong 
    join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
    where quarter(ngay_lam_hop_dong) in (3,4) and year(ngay_lam_hop_dong) = 2021)  
group by ten_dich_vu_di_kem, hd.ma_hop_dong, nv.ho_ten, kh.ho_ten, kh.so_dien_thoai, tien_dat_coc;

-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
select dvdk.ma_dich_vu_di_kem, ten_dich_vu_di_kem, sum(so_luong) from dich_vu_di_kem dvdk 
join hop_dong_chi_tiet hdct on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
join hop_dong hd on hd.ma_hop_dong = hdct.ma_hop_dong
group by dvdk.ma_dich_vu_di_kem, ten_dich_vu_di_kem
having sum(so_luong) = (select sum(so_luong) from dich_vu_di_kem dvdk 
	join hop_dong_chi_tiet hdct on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
	join hop_dong hd on hd.ma_hop_dong = hdct.ma_hop_dong
	group by ten_dich_vu_di_kem
    order by sum(so_luong) desc limit 1
    );

-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. Thông tin hiển thị 
-- bao gồm ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, so_lan_su_dung (được tính dựa trên việc count các ma_dich_vu_di_kem).
select distinct hd.ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem, count(ten_loai_dich_vu) -- , sum(so_luong)
from dich_vu_di_kem dvdk
join hop_dong_chi_tiet hdct on hdct.ma_dich_vu_di_kem = dvdk.ma_dich_vu_di_kem
join hop_dong hd on hd.ma_hop_dong = hdct.ma_hop_dong
join dich_vu dv on dv.ma_dich_vu = hd.ma_dich_vu
join loai_dich_vu ldv on ldv.ma_loai_dich_vu = dv.ma_loai_dich_vu
group by hd.ma_hop_dong, ten_loai_dich_vu, ten_dich_vu_di_kem-- , so_luong
having count(ten_loai_dich_vu) = 1
order by hd.ma_hop_dong asc;

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi
-- mới chỉ lập được tối đa 3 hợp đồng từ năm 2020 đến 2021.
select nv.ma_nhan_vien, ho_ten, ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi
from nhan_vien nv
join trinh_do td on td.ma_trinh_do = nv.ma_trinh_do
join bo_phan bp on bp.ma_bo_phan = nv.ma_bo_phan
join hop_dong hd on hd.ma_nhan_vien = nv.ma_nhan_vien
where year(ngay_lam_hop_dong) in (2020,2021)
group by hd.ma_nhan_vien
having count(*) <= 3;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2019 đến năm 2021.
delete from nhan_vien
where ma_nhan_vien not in (
	select ma_nhan_vien from (
		select nv.ma_nhan_vien as ma_nhan_vien
		from nhan_vien nv
		join hop_dong hd on hd.ma_nhan_vien = nv.ma_nhan_vien
		where year(ngay_lam_hop_dong) in (2019,2020,2021)
		group by hd.ma_nhan_vien
    ) as c
);

-- 17.	Cập nhật thông tin những khách hàng có ten_loai_khach từ Platinum lên Diamond, chỉ cập nhật những khách hàng 
-- đã từng đặt phòng với Tổng Tiền thanh toán trong năm 2021 là lớn hơn 10.000.000 VNĐ.
update khach_hang set ma_loai_khach = '4' 
where ma_loai_khach = '3' and ma_khach_hang in (
	select ma_khach_hang from (
		select hd.ma_khach_hang from hop_dong hd
		join khach_hang kh on kh.ma_khach_hang = hd.ma_khach_hang
		join dich_vu dv on dv.ma_dich_vu = hd.ma_dich_vu
		group by hd.ma_khach_hang
		having sum(chi_phi_thue) >= 10000000
    ) as c
);

-- 18.	Xóa những khách hàng có hợp đồng trước năm 2021 (chú ý ràng buộc giữa các bảng).
-- delete from hop_dong 
-- where ma_khach_hang in (
-- 	select ma_khach_hang  from (
-- 		select kh.ma_khach_hang 
-- 		from khach_hang kh
-- 		join hop_dong hd on hd.ma_khach_hang = kh.ma_khach_hang
-- 		where year(ngay_lam_hop_dong) < 2021
-- 		group by hd.ma_khach_hang 
-- 	) as c
-- );

delete from khach_hang 
where ma_khach_hang in (
	select ma_khach_hang  from (
		select kh.ma_khach_hang 
		from khach_hang kh
		join hop_dong hd on hd.ma_khach_hang = kh.ma_khach_hang
		where year(ngay_lam_hop_dong) < 2021
		group by hd.ma_khach_hang 
	) as c
);

-- 19.	Cập nhật giá cho các dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2020 lên gấp đôi.
update dich_vu_di_kem set gia = gia * 2
where ma_dich_vu_di_kem in (
	select ma_dich_vu_di_kem from(
    	select dvdk.ma_dich_vu_di_kem from hop_dong_chi_tiet hdct
		join hop_dong hd on hd.ma_hop_dong = hdct.ma_hop_dong
		join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
        where year(ngay_lam_hop_dong) = 2020
		group by ma_dich_vu_di_kem
		having sum(so_luong) > 10) as c
);

-- 20.	Hiển thị thông tin của tất cả các nhân viên và khách hàng có trong hệ thống, thông tin hiển thị 
-- bao gồm id (ma_nhan_vien, ma_khach_hang), ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi.
select ma_nhan_vien, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi from nhan_vien
union
select ma_khach_hang, ho_ten, email, so_dien_thoai, ngay_sinh, dia_chi from khach_hang;












--  	SQL NÂNG CAO

-- 21.	Tạo khung nhìn có tên là v_nhan_vien để lấy được thông tin của tất cả các nhân viên có địa chỉ là “Hải Châu” và đã từng lập hợp đồng cho một hoặc nhiều khách hàng bất kì với ngày lập hợp đồng là “12/12/2019”.
-- 22.	Thông qua khung nhìn v_nhan_vien thực hiện cập nhật địa chỉ thành “Liên Chiểu” đối với tất cả các nhân viên được nhìn thấy bởi khung nhìn này.
-- 23.	Tạo Stored Procedure sp_xoa_khach_hang dùng để xóa thông tin của một khách hàng nào đó với ma_khach_hang được truyền vào như là 1 tham số của sp_xoa_khach_hang.
-- 24.	Tạo Stored Procedure sp_them_moi_hop_dong dùng để thêm mới vào bảng hop_dong với yêu cầu sp_them_moi_hop_dong phải thực hiện kiểm tra tính hợp lệ của dữ liệu bổ sung, với nguyên tắc không được trùng khóa chính và đảm bảo toàn vẹn tham chiếu đến các bảng liên quan.
-- 25.	Tạo Trigger có tên tr_xoa_hop_dong khi xóa bản ghi trong bảng hop_dong thì hiển thị tổng số lượng bản ghi còn lại có trong bảng hop_dong ra giao diện console của database.
-- Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc ghi ở console.
-- 26.	Tạo Trigger có tên tr_cap_nhat_hop_dong khi cập nhật ngày kết thúc hợp đồng, cần kiểm tra xem thời gian cập nhật có phù hợp hay không, với quy tắc sau: Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày. Nếu dữ liệu hợp lệ thì cho phép cập nhật, nếu dữ liệu không hợp lệ thì in ra thông báo “Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày” trên console của database.
-- Lưu ý: Đối với MySQL thì sử dụng SIGNAL hoặc ghi log thay cho việc ghi ở console.
-- 27.	Tạo Function thực hiện yêu cầu sau:
-- a.	Tạo Function func_dem_dich_vu: Đếm các dịch vụ đã được sử dụng với tổng tiền là > 2.000.000 VNĐ.
-- b.	Tạo Function func_tinh_thoi_gian_hop_dong: Tính khoảng thời gian dài nhất tính từ lúc bắt đầu làm hợp đồng đến lúc kết thúc hợp đồng mà khách hàng đã thực hiện thuê dịch vụ (lưu ý chỉ xét các khoảng thời gian dựa vào từng lần làm hợp đồng thuê dịch vụ, không xét trên toàn bộ các lần làm hợp đồng). Mã của khách hàng được truyền vào như là 1 tham số của function này.
-- 28.	Tạo Stored Procedure sp_xoa_dich_vu_va_hd_room để tìm các dịch vụ được thuê bởi khách hàng với loại dịch vụ là “Room” từ đầu năm 2015 đến hết năm 2019 để xóa thông tin của các dịch vụ đó (tức là xóa các bảng ghi trong bảng dich_vu) và xóa những hop_dong sử dụng dịch vụ liên quan (tức là phải xóa những bản gi trong bảng hop_dong) và những bản liên quan khác
