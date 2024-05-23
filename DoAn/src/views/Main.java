package views;
import java.util.Scanner;

import controller.QLSV;

public class Main {
	public static void main(String[] args) {
		try (Scanner sc = new Scanner(System.in)) {
			QLSV ql = new QLSV();
			String filePath = "DSSV.csv";
			String filePathOut = "DSSV.csv";
			while(true) {
				System.out.println("----------Quản lý sinh viên-----------");
				System.out.println("|1.Nhập dữ liệu sinh viên từ file    |");
				System.out.println("|2.Lưu dữ liệu sinh viên ra file     |");
				System.out.println("|3.Xuất dữ liệu ra màn hình          |");
				System.out.println("|4.Tìm kiếm thông tin sinh viên      |");
				System.out.println("|5.Thêm mới sinh viên vào hệ thống   |");
				System.out.println("|6.Xóa sinh viên ra khỏi hệ thống    |");
				System.out.println("|7.Thống kê các số liệu của sinh viên|");
				System.out.println("|8.Sắp xếp sinh viên                 |");
				System.out.println("|9.Thoát khỏi chương trình           |");
				System.out.println("--------------------------------------");
				System.out.println("Hãy chọn các tính năng trên: ");
				int c = sc.nextInt();
				switch (c) {
				case 1: {
					ql.chonDataStructureLuuTru(filePath);
					break;
				}
				case 2: {
					ql.saveDuLieuRaFile(filePathOut);
					break;
				}
				case 3: {
					ql.inRaDuLieu();
					break;
				}
				case 4: {
					ql.timKiemTheoTieuChi();
					break;
				}
				case 5: {
					ql.themMoiSinhVien();
					break;
				}
				case 6: {
					ql.xoaSinhVien();
					break;
				}
				case 7: {
					ql.thongKeSinhVien();
					break;
				}
				case 8: {
					ql.sapXepTheoTieuChi();
					break;
				}
				case 9: {
					System.out.println("Đã đóng thành công");
					System.exit(0);
					break;
				}
				default:
					System.err.println("Không có tính năng này vui lòng nhập lại !!!");
				}
			}
		}
	}
}
