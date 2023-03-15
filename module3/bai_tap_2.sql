create database bai_tap_2;
use bai_tap_2;
create table phieu_xuat(
	so_px int primary key,
    ngay_xuat date
);
create table vat_tu(
	ma_vt int primary key,
    ten_vt varchar(255)
);
create table phieu_xuat_vat_tu(
	so_px int,
    ma_vt int,
	dg_xuat int,
    sl_xuat int,
    foreign key (so_px) references phieu_xuat(so_px),
    foreign key (ma_vt) references vat_tu(ma_vt)
);
create table phieu_nhap (
	so_pn int primary key,
    ngay_nhap date
);
create table phieu_nhap_vat_tu(
	ma_vt int,
    so_pn int,
	dg_nhap int,
    sl_nhap int,
	foreign key (so_pn) references phieu_nhap(so_pn),
    foreign key (ma_vt) references vat_tu(ma_vt)
);

create table nha_cung_cap(
	ma_ncc int primary key,
    ten_ncc varchar(255),
    dia_chi varchar(255)
);
create table sdt(
	ma_sdt int primary key,
    ngay_cap date,
    sdt int,
    ma_ncc int,
    foreign key (ma_ncc) references nha_cung_cap(ma_ncc)
);
create table don_dh(
	so_dh int primary key,
    ngay_dh date,
	ma_ncc int,
	foreign key (ma_ncc) references nha_cung_cap(ma_ncc)
);	
create table don_dh_vat_tu(
	so_dh int,
	ma_vt int,
	foreign key (so_dh) references don_dh(so_dh),
    foreign key (ma_vt) references vat_tu(ma_vt)
);