package controller;
import comparator.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;
import java.util.Stack;

import model.*;
import exceptions.*;

public class QLSV implements IChucNang {
	Scanner sc = new Scanner(System.in);
	IList list = null;
	@Override
	public void chonDataStructureLuuTru(String fileName) {
		// TODO Auto-generated method stub
		try (BufferedReader in = new BufferedReader(new FileReader(fileName))) {
				System.out.println("------------- Danh sách cấu trúc ----------");
				System.out.println("|1.Array                                  |");
				System.out.println("|2.Singly Linked List                     |");
				System.out.println("|3.Doubly Linked List                     |");
				System.out.println("|4.Circular Linked List                   |");
				System.out.println("-------------------------------------------");
				int i;
				i = sc.nextInt();
				switch (i) {
				case 1: {
					list = new ArrayList();
					System.out.println("Nhập dữ liệu thành công");
					break;
				}
				case 2: {
					list = new SinglyLinkedList();
					System.out.println("Nhập dữ liệu thành công");
					break;
				}
				case 3: {
					list = new DoublyLinkedList();
					System.out.println("Nhập dữ liệu thành công");
					break;
				}
				case 4: {
					list = new CircularLinkedList();
					System.out.println("Nhập dữ liệu thành công");
					break;
				}
				default:
					System.out.println("Nhập giá trị không đúng vui lòng nhập lại từ 1 - 4!!!");
				}
				String line;
				while((line = in.readLine()) != null) {
					String [] str = line.split(",");
					list.add(new Student(Integer.parseInt(str[0]),str[1],str[2],str[3],str[4],Integer.parseInt(str[5])));
				}
		} catch (IOException ioe) {
			// TODO: handle exception
			System.err.println(ioe);
		}
		
	}
	
	@Override
	public void inRaDuLieu() {
		if(list == null) {
			
			System.out.println("                   Không có dữ liệu                  ");
		}else {
			list.display();
//			for(int i = 0; i < list.size() ; i++) {
//				String ho = list.get(i).getHoSV().substring(0,list.get(i).getHoSV().indexOf(" "));
//				System.out.println(ho);
//			}
		}
	}
	
	@Override
	public void saveDuLieuRaFile(String fileName) {
		// TODO Auto-generated method stub
		try (BufferedWriter out = new BufferedWriter(new FileWriter(fileName))) {
			String data = "";
			String line;
			for(int i = 0; i < list.size() - 1; i++) {
				 line = list.get(i).getStt()+","+list.get(i).getHoSV()+","+list.get(i).getTenSV()+","+list.get(i).getMaSV()+","+list.get(i).getLop()+","+list.get(i).getDiemGPA();
				 data += line + "\n";
			}
			line = list.get(list.size()-1).getStt()+","+list.get(list.size()-1).getHoSV()+","+list.get(list.size()-1).getTenSV()+","+list.get(list.size()-1).getMaSV()+","+list.get(list.size()-1).getLop()+","+list.get(list.size()-1).getDiemGPA();
			data += line;
			out.write(data);
			System.out.println("Lưu vào file thành công");
		} catch (IOException ioe) {
			// TODO: handle exception
			System.err.println(ioe);
		}
		
	}

	@Override
	public void timKiemTheoTieuChi() {
		// TODO Auto-generated method stub
		System.out.println("-----Hãy nhập tiêu chí muốn tìm kiếm-----");
		System.out.println("|1.Tìm kiếm theo mã số sinh viên         |");
		System.out.println("|2.Tìm kiếm theo họ của sinh viên        |");
		System.out.println("|3.Tìm kiếm theo tên của sinh viên       |");
		System.out.println("|4.Tìm kiếm theo lớp sinh viên           |");
		System.out.println("|5.Tìm kiếm theo điểm gpa của sinh viên  |");
		System.out.println("------------------------------------------");
		int c = sc.nextInt();
		switch (c) {
		case 1: {
			//Nhập mã sinh viên
			try {
				sc.nextLine();
				System.out.println("Nhập mã số sinh viên muốn tìm kiếm: ");
				String regex = "^[N]{1}\\d{2}DC[A-Z]{2}\\d{3}$";
				String mssv = sc.nextLine();
				long begin = Calendar.getInstance().getTimeInMillis();
				if((mssv.toUpperCase().matches(regex) == true) && (checkMSSV(mssv)!=-1)) {
					Student tmp = list.get(list.indexOf(mssv));
					String fullName = tmp.getHoSV() + tmp.getTenSV();
					StringBuilder str = reverse(fullName);
					System.out.println(tmp.toString() + "\t" + str);
					long end = Calendar.getInstance().getTimeInMillis();
					System.out.println("Thời gian tìm kiếm: "+ (end - begin)+" mili giây");
				} else {
					throw new InvalidException("Nhập sai hoặc sinh viên không tồn tại");
				}
			} catch (InvalidException e) {
				// TODO: handle exception
				System.err.println(e);
			}
			break;
		}
		case 2: {
			sc.nextLine();
			System.out.println("Vui lòng nhập họ sinh viên muốn tìm kiếm");
			String hoSinhVien = sc.nextLine();
			long begin = Calendar.getInstance().getTimeInMillis();
			for(int i = 0; i < list.size() ; i++) {
				String ho = list.get(i).getHoSV().substring(0,list.get(i).getHoSV().indexOf(" "));
				if(hoSinhVien.equalsIgnoreCase(ho)) {
					String fullName = list.get(i).getHoSV() + list.get(i).getTenSV();
					StringBuilder str = reverse(fullName);
					System.out.println(list.get(i).toString()+ "\t" + str);
				}
				else {
					continue;
				}
			}
			long end = Calendar.getInstance().getTimeInMillis();
			System.out.println("Thời gian tìm kiếm: "+ (end - begin)+" mili giây");
			break;
		}
		case 3: {
			sc.nextLine();
			System.out.println("Vui lòng nhập tên sinh viên muốn tìm kiếm: ");
			String tenSinhVien = sc.nextLine();
			long begin = Calendar.getInstance().getTimeInMillis();
			for(int i = 0; i < list.size() ; i++) {
				if(tenSinhVien.equalsIgnoreCase(list.get(i).getTenSV())) {
					String fullName = list.get(i).getHoSV() + list.get(i).getTenSV();
					StringBuilder str = reverse(fullName);
					System.out.println(list.get(i).toString()+ "\t" + str);
				}
				else {
					continue;
				}
			}
			long end = Calendar.getInstance().getTimeInMillis();
			System.out.println("Thời gian tìm kiếm: "+ (end - begin)+" mili giây");
			break;
		}
		case 4: {
			sc.nextLine();
			System.out.println("Nhập lớp sinh viên muốn tìm kiếm: ");
			String regex = "^D\\d{2}CQ[A-Z]{2,4}\\d{2}-N$";
			String lop = sc.nextLine();
			long begin = Calendar.getInstance().getTimeInMillis();
			try {
				for(int i = 0; i < list.size(); i++) {
					if((lop.matches(regex)== true)) {
						if( (list.get(i).getLop().equalsIgnoreCase(lop)==true)) {
							String fullName = list.get(i).getHoSV() + list.get(i).getTenSV();
							StringBuilder str = reverse(fullName);
							System.out.println(list.get(i).toString()+ "\t" + str);
						}else {
							continue;
						}
					}else {
						throw new InvalidException("Nhập sai hoặc sinh viên không tồn tại");
					}
				} 
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println(e);
			}
			long end = Calendar.getInstance().getTimeInMillis();
			System.out.println("Thời gian tìm kiếm: "+ (end - begin)+" mili giây");
			break;
		}
		case 5: {
			sc.nextLine();
			System.out.println("Nhập điểm sinh viên muốn tìm kiếm: ");
			String regex = "^\\b([0-9]|10)\\b$";
			String diem = sc.nextLine();
			long begin = Calendar.getInstance().getTimeInMillis();
			try {
				for(int i = 0; i < list.size(); i++) {
					if((diem.matches(regex)== true)) {
						if( (list.get(i).getDiemGPA()==Integer.parseInt(diem))) {
							String fullName = list.get(i).getHoSV() + list.get(i).getTenSV();
							StringBuilder str = reverse(fullName);
							System.out.println(list.get(i).toString()+ "\t" + str);
						}
					}else {
						throw new InvalidException("Nhập sai số điểm cho phép");
					}
				} 
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println(e);
			}
			long end = Calendar.getInstance().getTimeInMillis();
			System.out.println("Thời gian tìm kiếm: "+ (end - begin)+" mili giây");
			break;
		}
		default:
			System.err.println("Không nhập đúng định dạng vui lòng nhập lại");
		}
	}
	private StringBuilder reverse(String fullName) {
	       Stack<Character> stack = new Stack<>();
	       for (int i = 0; i < fullName.length(); i++) {
	           stack.push(fullName.charAt(i));
	       }
	       StringBuilder str = new StringBuilder();
	       int size = stack.size();
	       for (int i = 0; i < size; i++) {
	           str.append(stack.pop());
	       }
	       return str;
	}

	@Override
	public void themMoiSinhVien() {
		// TODO Auto-generated method stub
		System.out.println("Nhập các dữ liệu của sinh viên mới: ");
		String mssv,tenDem,tenSV,lop,diem;
		//Nhập mã sinh viên
		while(true) {
			try {
				sc.nextLine();
				System.out.println("Nhập mã số sinh viên: ");
				String regex = "^[N]{1}\\d{2}DC[A-Z]{2}\\d{3}$";
				mssv = sc.nextLine();
				if((mssv.toUpperCase().matches(regex) == true) && (checkMSSV(mssv)==-1)) {
					break;
				} else {
					throw new InvalidException("Nhập sai định dạng hoặc đã bị trùng vui lòng nhập lại");
				}
			} catch (InvalidException e) {
				// TODO: handle exception
				System.err.println(e);
			}
		}
		//Nhập tên đệm
		System.out.println("Nhập họ và tên đệm sinh viên: ");
		tenDem = sc.nextLine();
		//Nhập tên sinh viên
		System.out.println("Nhập tên của sinh viên: ");
		tenSV = sc.nextLine();
		//Nhập lớp của sinh viên
		while(true) {
			try {
				System.out.println("Nhập lớp của sinh viên: ");
				String regex = "^D\\d{2}CQ[A-Z]{2,4}\\d{2}-N$";
				lop = sc.nextLine();
				if(lop.toUpperCase().matches(regex) == true) {
					break;
				} else {
					throw new InvalidException("Nhập sai định dạng vui lòng nhập lại");
				}
			} catch (InvalidException e) {
				// TODO: handle exception
				System.err.println(e);
			}
		}
		//Nhập GPA;
		while(true) {
			try {
				System.out.println("Nhập điểm của sinh viên: ");
				String regex = "^\\b([0-9]|10)\\b$";
				diem = sc.nextLine();
				if(diem.matches(regex) == true) {
					break;
				} else {
					throw new InvalidException("Nhập sai định dạng vui lòng nhập lại");
				}
			} catch (InvalidException e) {
				// TODO: handle exception
				System.err.println(e);
			}
		}
		// Thêm sinh viên
		list.add(new Student(list.size()+1,mssv,tenDem,tenSV,lop,Integer.parseInt(diem)));
	}

	@Override
	public void xoaSinhVien() {
		// TODO Auto-generated method stub
		//Nhập mã sinh viên
		while(true) {
			try {
				sc.nextLine();
				System.out.println("Nhập mã số sinh viên muốn xóa: ");
				String regex = "^[N]{1}\\d{2}DC[A-Z]{2}\\d{3}$";
				String maSinhVien = sc.nextLine();
				if((maSinhVien.toUpperCase().matches(regex) == true) && (checkMSSV(maSinhVien)!=-1)) {
					list.remove(checkMSSV(maSinhVien));
					System.out.println("Đã xóa sinh viên "+maSinhVien+ " thành công");
					break;
				} else {
					throw new InvalidException("Nhập sai định dạng hoặc không tồn tại vui lòng nhập lại");
				}
			} catch (InvalidException e) {
				// TODO: handle exception
				System.err.println(e);
			}
		}
	}

	@Override
	public void thongKeSinhVien() {
		// TODO Auto-generated method stub
		System.out.println("------------- Số liệu thống kê ------------");
		System.out.println("|1.Danh sách sinh viên có điểm thấp nhất  |");
		System.out.println("|2.Danh sách sinh viên có điểm cao nhất   |");
		System.out.println("|3.Điểm trung bình của lớp                |");
		System.out.println("-------------------------------------------");
		int c;
		c = sc.nextInt();
		switch (c) {
		case 1: {
			//GET MIN GPA
			System.out.println("Danh sách các sinh viên có điểm thấp nhất");
			int min = list.get(0).getDiemGPA();
			for(int i = 0 ; i < list.size(); i++) {
				int tmp = list.get(i).getDiemGPA();
				if(tmp < min) {
					min = tmp;
				}
			}
			for(int i = 0; i < list.size() ; i++) {
				if(list.get(i).getDiemGPA()==min) {
					System.out.println(list.get(i).toString());
				}
			}
			break;
		}
		case 2: {
			//GET MAX GPA
			System.out.println("Danh sách các sinh viên có điểm cao nhất");
			int max = list.get(0).getDiemGPA();
			for(int i = 0 ; i < list.size(); i++) {
				int tmp = list.get(i).getDiemGPA();
				if(tmp > max) {
					max = tmp;
				}
			}
			for(int i = 0; i < list.size() ; i++) {
				if(list.get(i).getDiemGPA()==max) {
					System.out.println(list.get(i).toString());
				}
			}
			break;
		}
		case 3: {
			//AVG GPA
			double avg; int sum = 0;
			for(int i = 0 ; i < list.size();i++) {
				sum+=list.get(i).getDiemGPA();
			}
			avg = sum/list.size();
			System.out.println("Điểm trung bình của lớp là: " + avg);
			break;
		}
		default:
			System.out.println("Nhập giá trị không đúng vui lòng nhập lại từ 1 - 3!!!");
		}
	}

	@Override
	public void sapXepTheoTieuChi() {
		// TODO Auto-generated method stub
		System.out.println("----------Hãy lựa chọn thuật toán sắp xếp-------");
		System.out.println("|1.Bubble Sort                                 |");
		System.out.println("|2.Selection Sort                              |");
		System.out.println("|3.Insertion Sort                              |");
		System.out.println("|4.Quick Sort                                  |");
		System.out.println("|5.Merge Sort								   |");
		System.out.println("|6.Heap Sort                                   |");
		System.out.println("------------------------------------------------");
		int c = sc.nextInt();
		switch (c) {
		case 1: {
			System.out.println("-----Hãy lựa chọn tiêu chí muốn sắp xếp-----");
			System.out.println("|1.Sắp xếp theo điểm GPA                   |");
			System.out.println("|2.Sắp xếp theo mã số sinh viên            |");
			System.out.println("|3.Sắp xếp theo tên sinh viên              |");
			System.out.println("--------------------------------------------");
			int chon = sc.nextInt();
			switch (chon) {
			case 1: {
				long begin = Calendar.getInstance().getTimeInMillis();
				list.BubbleSort(new SortWithGPA());
				long end = Calendar.getInstance().getTimeInMillis();
				System.out.println("Thời gian sắp xếp: "+ (end - begin)+" mili giây");
				break;
			}
			case 2: {
				long begin = Calendar.getInstance().getTimeInMillis();
				list.BubbleSort(new SortWithMSSV());
				long end = Calendar.getInstance().getTimeInMillis();

				System.out.println("Thời gian sắp xếp: "+ (end - begin)+" mili giây");
				
				break;
			}
			case 3: {
				long begin = Calendar.getInstance().getTimeInMillis();
				list.BubbleSort(new SortWithName());
				long end = Calendar.getInstance().getTimeInMillis();

				System.out.println("Thời gian sắp xếp: "+ (end - begin)+" mili giây");
				
				break;
			}
			default:
				System.err.println("Vui lòng nhập lại đúng từ 1-3");
			}
			break;
		}
		case 2: {
			System.out.println("-----Hãy lựa chọn tiêu chí muốn sắp xếp-----");
			System.out.println("|1.Sắp xếp theo điểm GPA                   |");
			System.out.println("|2.Sắp xếp theo mã số sinh viên            |");
			System.out.println("|3.Sắp xếp theo tên sinh viên              |");
			System.out.println("--------------------------------------------");
			int chon = sc.nextInt();
			switch (chon) {
			case 1: {
				long begin = Calendar.getInstance().getTimeInMillis();
				list.SelectionSort(new SortWithGPA());
				long end = Calendar.getInstance().getTimeInMillis();

				System.out.println("Thời gian sắp xếp: "+ (end - begin)+" mili giây");
				
				break;
			}
			case 2: {
				long begin = Calendar.getInstance().getTimeInMillis();
				list.SelectionSort(new SortWithMSSV());
				long end = Calendar.getInstance().getTimeInMillis();

				System.out.println("Thời gian sắp xếp: "+ (end - begin)+" mili giây");
				
				break;
			}
			case 3: {
				long begin = Calendar.getInstance().getTimeInMillis();
				list.SelectionSort(new SortWithName());
				long end = Calendar.getInstance().getTimeInMillis();

				System.out.println("Thời gian sắp xếp: "+ (end - begin)+" mili giây");
				
				break;
			}
			default:
				System.err.println("Vui lòng nhập lại đúng từ 1-3");
			}
			break;
		}
		case 3: {
			System.out.println("-----Hãy lựa chọn tiêu chí muốn sắp xếp-----");
			System.out.println("|1.Sắp xếp theo điểm GPA                   |");
			System.out.println("|2.Sắp xếp theo mã số sinh viên            |");
			System.out.println("|3.Sắp xếp theo tên sinh viên              |");
			System.out.println("--------------------------------------------");
			int chon = sc.nextInt();
			switch (chon) {
			case 1: {
				long begin = Calendar.getInstance().getTimeInMillis();
				list.InsertionSort(new SortWithGPA());
				long end = Calendar.getInstance().getTimeInMillis();

				System.out.println("Thời gian sắp xếp: "+ (end - begin)+" mili giây");
			
				break;
			}
			case 2: {
				long begin = Calendar.getInstance().getTimeInMillis();
				list.InsertionSort(new SortWithMSSV());
				long end = Calendar.getInstance().getTimeInMillis();

				System.out.println("Thời gian sắp xếp: "+ (end - begin)+" mili giây");
				
				break;
			}
			case 3: {
				long begin = Calendar.getInstance().getTimeInMillis();
				list.InsertionSort(new SortWithName());
				long end = Calendar.getInstance().getTimeInMillis();

				System.out.println("Thời gian sắp xếp: "+ (end - begin)+" mili giây");
				
				break;
			}
			default:
				System.err.println("Vui lòng nhập lại đúng từ 1-3");
			}
			break;
		}
		case 4: {
			System.out.println("-----Hãy lựa chọn tiêu chí muốn sắp xếp-----");
			System.out.println("|1.Sắp xếp theo điểm GPA                   |");
			System.out.println("|2.Sắp xếp theo mã số sinh viên            |");
			System.out.println("|3.Sắp xếp theo tên sinh viên              |");
			System.out.println("--------------------------------------------");
			int chon = sc.nextInt();
			switch (chon) {
			case 1: {
				long begin = Calendar.getInstance().getTimeInMillis();
				list.QuickSort(new SortWithGPA());
				long end = Calendar.getInstance().getTimeInMillis();

				System.out.println("Thời gian sắp xếp: "+ (end - begin)+" mili giây");
				
				break;
			}
			case 2: {
				long begin = Calendar.getInstance().getTimeInMillis();
				list.QuickSort(new SortWithMSSV());
				long end = Calendar.getInstance().getTimeInMillis();

				System.out.println("Thời gian sắp xếp: "+ (end - begin)+" mili giây");
				
				break;
			}
			case 3: {
				long begin = Calendar.getInstance().getTimeInMillis();
				list.QuickSort(new SortWithName());
				long end = Calendar.getInstance().getTimeInMillis();

				System.out.println("Thời gian sắp xếp: "+ (end - begin)+" mili giây");
				
				break;
			}
			default:
				System.err.println("Vui lòng nhập lại đúng từ 1-3");
			}
			break;
		}
		case 5: {
			System.out.println("-----Hãy lựa chọn tiêu chí muốn sắp xếp-----");
			System.out.println("|1.Sắp xếp theo điểm GPA                   |");
			System.out.println("|2.Sắp xếp theo mã số sinh viên            |");
			System.out.println("|3.Sắp xếp theo tên sinh viên              |");
			System.out.println("--------------------------------------------");
			int chon = sc.nextInt();
			switch (chon) {
			case 1: {
				long begin = Calendar.getInstance().getTimeInMillis();
				list.MergeSort(new SortWithGPA());
				long end = Calendar.getInstance().getTimeInMillis();

				System.out.println("Thời gian sắp xếp: "+ (end - begin)+" mili giây");
				
				break;
			}
			case 2: {
				long begin = Calendar.getInstance().getTimeInMillis();
				list.MergeSort(new SortWithMSSV());
				long end = Calendar.getInstance().getTimeInMillis();

				System.out.println("Thời gian sắp xếp: "+ (end - begin)+" mili giây");
				
				break;
			}
			case 3: {
				long begin = Calendar.getInstance().getTimeInMillis();
				list.MergeSort(new SortWithName());
				long end = Calendar.getInstance().getTimeInMillis();

				System.out.println("Thời gian sắp xếp: "+ (end - begin)+" mili giây");
				
				break;
			}
			default:
				System.err.println("Vui lòng nhập lại đúng từ 1-3");
			}
			break;
		}
		case 6: {
			System.out.println("-----Hãy lựa chọn tiêu chí muốn sắp xếp-----");
			System.out.println("|1.Sắp xếp theo điểm GPA                   |");
			System.out.println("|2.Sắp xếp theo mã số sinh viên            |");
			System.out.println("|3.Sắp xếp theo tên sinh viên              |");
			System.out.println("--------------------------------------------");
			int chon = sc.nextInt();
			switch (chon) {
			case 1: {
				long begin = Calendar.getInstance().getTimeInMillis();
				list.HeapSort(new SortWithGPA());
				long end = Calendar.getInstance().getTimeInMillis();

				System.out.println("Thời gian sắp xếp: "+ (end - begin)+" mili giây");
				
				break;
			}
			case 2: {
				long begin = Calendar.getInstance().getTimeInMillis();
				list.HeapSort(new SortWithMSSV());
				long end = Calendar.getInstance().getTimeInMillis();

				System.out.println("Thời gian sắp xếp: "+ (end - begin)+" mili giây");
				
				break;
			}
			case 3: {
				long begin = Calendar.getInstance().getTimeInMillis();
				list.HeapSort(new SortWithName());
				long end = Calendar.getInstance().getTimeInMillis();

				System.out.println("Thời gian sắp xếp: "+ (end - begin)+" mili giây");
				
				break;
			}
			default:
				System.err.println("Vui lòng nhập lại đúng từ 1-3");
			}
			break;
		}
		default:
			System.err.println("Giá trị nhập không hợp lệ vui lòng nhập lại từ 1-6");
		}
		
	}
	
	private int checkMSSV(String mssv) {
		for(int i = 0 ; i < list.size() ; i++) {
			if(mssv.equalsIgnoreCase(list.get(i).getMaSV())) {
				return i;
			}
		}
		return -1;
	}
	
}
