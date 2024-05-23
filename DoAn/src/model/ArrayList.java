package model;

import java.util.Comparator;

public class ArrayList implements IList{
	private Student[] arr;
	private int index;
	//Contructor
	public ArrayList() {
		arr = new Student[200];
		index = 0;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return arr[0] == null ;
	}

	@Override
	public void add(Student data) {
		// TODO Auto-generated method stub
		arr[index] = data;
		index++;
	}

	@Override
	public Student get(int index) {
		// TODO Auto-generated method stub
		return arr[index];
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub
		for(int i = index; i < this.index;i++) {
			arr[index] = arr[index+1];
		}
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.index;
	}

	@Override
	public int indexOf(String msv) {
		// TODO Auto-generated method stub
		for(int i = 0; i < index; i++) {
			if(arr[i].getMaSV().equalsIgnoreCase(msv)) {
				return i;
			}
		}
		return -1;
	}
	@Override
	public void display() {
		for(int i = 0; i < index ; i++) {
			System.out.println(arr[i].toString());
		}
	}

	@Override
	public void BubbleSort(Comparator<Student> comparator) {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < index ; i++) {
			for(int j = 0; j < index -1; j++) {
				 if(comparator.compare(arr[j],arr[j+1]) > 0) {
					 Student tmp = arr[j];
					 arr[j] = arr[j+1];
					 arr[j+1] = tmp;
				 }
			}
		}
	}

	@Override
	public void MergeSort(Comparator<Student> comparator) {
	    mergeSort(0, index - 1, comparator);
	}

	private void mergeSort(int left, int right, Comparator<Student> comparator) {
	    if (left < right) {
	        int mid = (left + right) / 2;
	        mergeSort(left, mid, comparator);
	        mergeSort(mid + 1, right, comparator);
	        merge(left, mid, right, comparator);
	    }
	}

	private void merge(int left, int mid, int right, Comparator<Student> comparator) {
	    
	    int n1 = mid - left + 1;
	    int n2 = right - mid;

	    Student[] leftArr = new Student[n1];
	    Student[] rightArr = new Student[n2];

	    for (int i = 0; i < n1; i++) {
	        leftArr[i] = arr[left + i];
	    }
	    for (int j = 0; j < n2; j++) {
	        rightArr[j] = arr[mid + 1 + j];
	    }

	    int i = 0, j = 0, k = left;
	    while (i < n1 && j < n2) {
	        if (comparator.compare(leftArr[i], rightArr[j]) <= 0) {
	            arr[k] = leftArr[i];
	            i++;
	        } else {
	            arr[k] = rightArr[j];
	            j++;
	        }
	        k++;
	    }

	    while (i < n1) {
	        arr[k] = leftArr[i];
	        i++;
	        k++;
	    }

	    while (j < n2) {
	        arr[k] = rightArr[j];
	        j++;
	        k++;
	    }
	}

	@Override
	public void InsertionSort(Comparator<Student> comparator) {
		// TODO Auto-generated method stub
		int Index = 0;
		Student Current = null;
		int Pos;
		while(Index < this.index) {
			Current = arr[Index];
			Pos = Index - 1;
			while(Pos >= 0) {
				if(comparator.compare(Current, arr[Pos]) < 0) {
					arr[Pos + 1] = arr[Pos];
					Pos--;
				}
				else break;
			}
			arr[Pos + 1] = Current;
			Index++;
		}
		
	}
	//QUICKSORT_______________________________________________________________________
	@Override
	public void QuickSort(Comparator<Student> comparator) {
	    quickSort(0, index - 1, comparator);
	}

	private void quickSort(int low, int high, Comparator<Student> comparator) {
	    if (low < high) {
	        int pi = partition(low, high, comparator);
	        quickSort(low, pi - 1, comparator);
	        quickSort(pi + 1, high, comparator);
	    }
	}

	private int partition(int low, int high, Comparator<Student> comparator) {
	    Student pivot = arr[high];
	    int i = low - 1;
	    for (int j = low; j < high; j++) {
	        if (comparator.compare(arr[j], pivot) <= 0) {
	            i++;
	            Student temp = arr[i];
	            arr[i] = arr[j];
	            arr[j] = temp;
	        }
	    }
	    Student temp = arr[i + 1];
	    arr[i + 1] = arr[high];
	    arr[high] = temp;
	    return i + 1;
	}
	
	//QUICKSORT_______________________________________________________END_______________
	@Override
	public void SelectionSort(Comparator<Student> comparator) {
		// TODO Auto-generated method stub
		for(int i = 0; i < index  ; i++) {
			int min = i;
			for(int j = i + 1; j < index  ; j++) {
				if(comparator.compare(arr[min], arr[j]) > 0) {
					min = j;
				}
			}
			if( i != min ) {
				Student tmp = arr[i];
				arr[i] = arr[min];
				arr[min] = tmp;
			}
		}
	}

	@Override
	public void HeapSort(Comparator<Student> comparator) {
	    for (int i = index / 2 - 1; i >= 0; i--) {
	        heapify(index, i, comparator);
	    }
	    for (int i = index - 1; i >= 0; i--) {
	        Student temp = arr[0];
	        arr[0] = arr[i];
	        arr[i] = temp;
	        heapify(i, 0, comparator);
	    }
	}

	private void heapify(int n, int i, Comparator<Student> comparator) {
	    int largest = i;
	    int left = 2 * i + 1;
	    int right = 2 * i + 2;

	    if (left < n && comparator.compare(arr[left], arr[largest]) > 0) {
	        largest = left;
	    }
	    if (right < n && comparator.compare(arr[right], arr[largest]) > 0) {
	        largest = right;
	    }
	    if (largest != i) {
	        Student temp = arr[i];
	        arr[i] = arr[largest];
	        arr[largest] = temp;
	        heapify(n, largest, comparator);
	    }
	}
}
