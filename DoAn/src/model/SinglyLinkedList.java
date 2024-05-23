package model;

import java.util.Comparator;

public class SinglyLinkedList implements IList{
	//Head
	protected Node Head;

	//Contructor
	public SinglyLinkedList() {
		Head = null;
	}
	
	//Method
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return Head == null;
	}

	@Override
	public void add(Student data) {
		// TODO Auto-generated method stub
		Node tmp = new Node(data);
		if(this.isEmpty()) {
			Head = tmp;
		} else {
			tmp.next = Head;
			Head = tmp;
		}
	}

	public Student get(int index) {
	    try {
	        if (index < 0 || index >= size()) {
	            throw new IndexOutOfBoundsException("Index out of bounds");
	        }
	        Node tmp = Head;
	        for (int i = 0; i < index; i++) {
	            tmp = tmp.next;
	        }
	        return tmp.data;
	    } catch (IndexOutOfBoundsException e) {
	        System.err.println("Error: " + e.getMessage());
	        return null;
	    }
	}

	@Override
	public void remove(int index) {
	    try {
	        if (index < 0 || index >= size()) {
	            throw new IndexOutOfBoundsException("Index out of bounds");
	        }
	        Node tmp = Head;
	        for (int i = 0; i < index - 1; i++) {
	            tmp = tmp.next;
	        }
	        tmp.next = tmp.next.next;
	    } catch (IndexOutOfBoundsException e) {
	        System.err.println("Error: " + e.getMessage());
	    }
	}

	@Override
	public int size() {
	    try {
	        int i = 0;
	        for (Node j = Head; j != null; j = j.next) {
	            i++;
	        }
	        return i;
	    } catch (Exception e) {
	        System.err.println("Error: " + e.getMessage());
	        return 0; 
	    }
	}
	@Override
	public void display() {
		for(int i = 0; i < this.size() ; i++) {
			System.out.println(this.get(i).toString());
		}
	}
	@Override
	public int indexOf(String msv) {
		// TODO Auto-generated method stub
		Node tmp = Head;
		for(int i = 0 ; i < size() ;i++) {
			if(msv.equalsIgnoreCase(get(i).getMaSV())) {
				return i;
			}
			tmp=tmp.next;
		}
		return -1;
	}

	public Node getNode(int index) {
        if (isEmpty() || index < 0) {
            return null;
        }
        Node current = Head;
        for (int i = 0; i <= index; i++) {
            if (current == null) {
                return null;
            }
            current = current.next;
        }
        return current;
    }
	
	@Override
	public void BubbleSort(Comparator<Student> comparator) {
	    if (isEmpty() || size() == 1) {
	        return;
	    }
	    for (int i = 0; i < size(); i++) {
	        Node tmp = Head;
	        for (int j = 0; j < size() - i - 1; j++) {
	            if (comparator.compare(tmp.data, tmp.next.data) > 0) {
	                Student temp = tmp.data;
	                tmp.data = tmp.next.data;
	                tmp.next.data = temp;
	            }
	            tmp = tmp.next;
	        }
	    }
	}

	@Override
	public void MergeSort(Comparator<Student> comparator) {
	    mergeSort(0, size() - 2, comparator);
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
	        leftArr[i] = getNode(left + i).data;
	    }
	    for (int j = 0; j < n2; j++) {
	        rightArr[j] = getNode(mid + 1 + j).data;
	    }

	    int i = 0, j = 0, k = left;
	    while (i < n1 && j < n2) {
	        if (comparator.compare(leftArr[i], rightArr[j]) <= 0) {
	            getNode(k).data = leftArr[i];
	            i++;
	        } else {
	            getNode(k).data = rightArr[j];
	            j++;
	        }
	        k++;
	    }

	    while (i < n1) {
	        getNode(k).data = leftArr[i];
	        i++;
	        k++;
	    }

	    while (j < n2) {
	        getNode(k).data = rightArr[j];
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
		while(Index < size() - 1) {
			Current = getNode(Index).data;
			Pos = Index - 1;
			while(Pos >= 0) {
				if(comparator.compare(Current, getNode(Pos).data) < 0) {
					getNode(Pos+1).data = getNode(Pos).data;
					Pos--;
				}
				else break;
			}
			getNode(Pos+1).data = Current;
			Index++;
		}
		
	}

	@Override
	public void QuickSort(Comparator<Student> comparator) {
	    quickSort(0, size() - 2, comparator);
	}

	private void quickSort(int low, int high, Comparator<Student> comparator) {
	    if (low < high) {
	        int pi = partition(low, high, comparator);
	        quickSort(low, pi - 1, comparator);
	        quickSort(pi + 1, high, comparator);
	    }
	}

	private int partition(int low, int high, Comparator<Student> comparator) {
	    Student pivot = getNode(high).data;
	    int i = low - 1;
	    for (int j = low; j < high; j++) {
	        if (comparator.compare(getNode(j).data, pivot) <= 0) {
	            i++;
	            Student temp = getNode(i).data;
	            getNode(i).data = getNode(j).data;
	            getNode(j).data = temp;
	        }
	    }
	    Student temp = getNode(i+1).data;
	    getNode(i+1).data = getNode(high).data;
	    getNode(high).data = temp;
	    return i + 1;
	}

	@Override
	public void SelectionSort(Comparator<Student> comparator) {
		// TODO Auto-generated method stub
		for(int i = 0; i < size()  ; i++) {
			int min = i;
			for(int j = i + 1; j < size() - 1 ; j++) {
				if(comparator.compare(getNode(min).data, getNode(j).data) > 0) {
					min = j;
				}
			}
			if( i != min ) {
				Student tmp = getNode(i).data;
				getNode(i).data = getNode(min).data;
				getNode(min).data = tmp;
			}
		}
	}

	@Override
	public void HeapSort(Comparator<Student> comparator) {
	    for (int i = (size() - 1) / 2 - 1; i >= 0; i--) {
	        heapify(size() - 1 , i, comparator);
	    }
	    for (int i = size() - 2; i >= 0; i--) {
	        Student temp = getNode(0).data;
	        getNode(0).data = getNode(i).data;
	        getNode(i).data = temp;
	        heapify(i, 0, comparator);
	    }
	}

	private void heapify(int n, int i, Comparator<Student> comparator) {
	    int largest = i;
	    int left = 2 * i + 1;
	    int right = 2 * i + 2;

	    if (left < n && comparator.compare(getNode(left).data, getNode(largest).data) > 0) {
	        largest = left;
	    }
	    if (right < n && comparator.compare(getNode(right).data, getNode(largest).data) > 0) {
	        largest = right;
	    }
	    if (largest != i) {
	        Student temp = getNode(i).data;
	        getNode(i).data = getNode(largest).data;
	        getNode(largest).data = temp;
	        heapify(n, largest, comparator);
	    }
	}
	
  }
