<h1>ĐỒ ÁN CẤU TRÚC DỮ LIỆU VÀ GIẢI THUẬT</h1>

<h2>Introduction</h2>

Bài nộp đồ án cuối kì môn cấu trúc dữ liệu và giải thuật, bài nộp bao gồm các bài tập 1 về chương trình quản lý sinh viên, bài tập 2 về bài toán đi tuần và file README.

<h2>Install</h2>

Bước 1: Cài đặt JDK 17 và IDE Java (Netbeans,Eclipse,…)

Bước 2: Tải Source Code và Open Project

Bước 3: Ở package views có file Main.java là file main của đồ án, ấn chuột phải và Run as file main 


<h2>Use</h2>

Các tính năng của chương trình gồm: Nhập, xuất, lưu, tìm kiếm,…

1.Nhập dữ liệu sinh viên từ file
Lúc chưa nhập thì khi yêu cầu xuất ra thông tin thì chương trình sẽ báo ”Không có dữ liệu”, bắt đầu nhập file chương trình sẽ cho chọn cấu trúc muốn lưu trữ

Khi đã chọn được thì sẽ báo “Đã nhập dữ liệu thành công”
2.Lưu dữ liệu thông tin vào file
Khi thêm hay xóa hoặc cập nhật sinh viên ta cần lưu thì sử dụng tính năng này để lưu ra file, khi chọn tính năng sẽ báo lưu thành công
3.Xuất dữ liệu ra màn hình
Chức năng này để xuất toàn bộ thông tin của cấu trúc dữ liệu muốn in ra màn hình nếu không có thông tin thì in ra “Không có dữ liệu”

4.Tìm kiếm thông tin sinh viên
Tính năng cho tìm kiếm theo các tiêu chí dưới:

Bạn phải nhập đúng định dạng mã số sinh viên, lớp, điểm thì chương trình mới nhận. Nếu tìm không thấy hoặc nhập sai định dạng chương trình sẽ throw ra Exception

Kết quả trả về có thể là 1 danh sách hoặc 1 sinh viên cùng kết quả đảo ngược tên ví dụ:

5.Thêm mới sinh viên
Ta phải nhập mã số sinh viên, chương trình sẽ kiểm tra định dạng và xem có trùng với mã số nào với sinh viên đã có hay không nếu không trùng và đúng định dạng ta sẽ nhập các thông tin các cho sinh viên

6.Xóa sinh viên thông qua mã số sinh viên
Ta phải nhập mã số sinh viên, chương trình sẽ kiểm tra định dạng và xem có trùng với mã số nào với sinh viên có thì chương trình sẽ xóa sẽ xóa sinh viên

7.Thống kê sinh viên
Ta có các tính năng liệt kê có sinh viên có điểm thấp nhất, liệt kê sinh viên điểm cao nhất và điểm trung bình của lớp




8.Sắp xếp sinh viên
Ta có thể chọn kiểu sort muốn chọn và sau đó chọn tiêu chí muốn sắp xếp


Ví dụ sort theo GPA

Ví dụ sort theo MSSV ( sort theo 3 số cuối của MSSV)

Ví dụ sort theo tên

9.Thoát khỏi chương trình


* Lưu ý: một số chỗ cần xóa dấu enter tương tự cin.inorge C++ nên đôi lúc cần ấn enter để tiếp tục chương trình

<h2>Technologies Used</h2>
- Ngôn ngữ: Java Core
- Phiên bản: Java 8_JDK 17
- Thư viện util(Calendar để tính thời gian chạy,…)
