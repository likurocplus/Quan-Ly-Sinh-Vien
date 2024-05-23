package model;

import java.util.Comparator;

public interface IList {
	public boolean isEmpty();
	public void add(Student data);
	public Student get(int index);
	public void remove(int index);
	public int size();
	public int indexOf(String msv);
	public void display();
	public void BubbleSort(Comparator<Student> comparator);
	public void MergeSort(Comparator<Student> comparator);
	public void InsertionSort(Comparator<Student> comparator);
	public void QuickSort(Comparator<Student> comparator);
	public void SelectionSort(Comparator<Student> comparator);
	public void HeapSort(Comparator<Student> comparator);
}
