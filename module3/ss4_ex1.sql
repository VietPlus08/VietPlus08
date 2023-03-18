-- Hiển thị tất cả các thông tin môn học (bảng subject) có credit lớn nhất.
select * from subject where credit = (select max(credit) from subject);
-- Hiển thị các thông tin môn học có điểm thi lớn nhất.
select subname, mark.Mark  from subject 
join mark on subject.SubId = mark.SubId
where mark.Mark = (select max(Mark) from mark);
-- Hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên, xếp hạng theo thứ tự điểm giảm dần
select StudentName, avg(mark.Mark) from student 
join mark on student.studentid = mark.studentid
group by studentname;