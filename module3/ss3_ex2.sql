use ss2_ex2;
insert into customer(`name`,age) values ('Teo',8),('Quang', 18), ('Tuan', 28), ('Manh', 22);
insert into `order`(cus_id, order_date) values 
(1,'2023-3-30'),(2,'2023-3-28'),(3,'2023-3-29'),(1,'2023-3-27');
insert into product(name,price) values ('May giat',300),('Tu lanh',510),('Dieu hoa',100),('Quat',50),('Bep dien',300),('Bep gas',150);
insert into order_detail values
(1,2,2),(1,1,3),(1,3,4),(2,4,2),(2,5,5),(2,2,2),(3,2,5),(3,1,12);
-- Hiển thị các thông tin  gồm oID, oDate, oPrice của tất cả các hóa đơn trong bảng Order
select `order`.id, order_date, total_price from `order` ;
-- Hiển thị danh sách các khách hàng đã mua hàng, và danh sách sản phẩm được mua bởi các khách
select c.`name`, p.`name` from customer c 
join `order` o on c.id = o.cus_id
join order_detail od on od.order_id = o.id
join product p on od.product_id = p.id;
-- Hiển thị tên những khách hàng không mua bất kỳ một sản phẩm nào
select * from customer where customer.`name` not in 
	(select c.`name` from customer c 
	join `order` o on c.id = o.cus_id
	join order_detail od on od.order_id = o.id
	join product p on od.product_id = p.id
	);
-- Hiển thị mã hóa đơn, ngày bán và giá tiền của từng hóa đơn (giá một hóa đơn được tính 
-- bằng tổng giá bán của từng loại mặt hàng xuất hiện trong hóa đơn. Giá bán của từng loại được tính = odQTY*pPrice)
select `order`.id, order_date, sum(quantity * price) total_price from `order` 
join order_detail on `order`.id = order_detail.order_id
join product on order_detail.product_id = product.id
group by `order`.id;
