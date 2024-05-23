package model;

import java.util.Comparator;

public class CircularLinkedList implements IList {
    private Node Head; 

    public CircularLinkedList() {
        Head = null;
    }

    public boolean isEmpty() {
        return Head == null;
    }

    public void add(Student data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            newNode.next = newNode; 
            Head = newNode;
        } else {
            newNode.next = Head.next; 
            Head.next = newNode; 
            Head = newNode;
        }
    }

    public Student get(int index) {
        if (isEmpty() || index < 0) {
            return null;
        }
        Node current = Head.next;
        for (int i = 0; i < index; i++) {
            if (current == Head) {
                return null; 
            }
            current = current.next;
        }
        return current.data;
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


    public void remove(int index) {
        if (isEmpty() || index < 0) {
            return;
        }
        Node current = Head;
        for (int i = 0; i < index; i++) {
            if (current.next == Head) {
                return; 
            }
            current = current.next;
        }
        if (current.next == Head) {
            Head = null;
        } else {
            current.next = current.next.next;
        }
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        int count = 0;
        Node current = Head.next;
        while (current != Head) {
            count++;
            current = current.next;
        }
        return count + 1;
    }

    @Override
    public void display() {
        Node temp = Head;

        if (Head != null) {
            do {
                System.out.println(temp.data.toString());
                temp = temp.next;
            } while (temp != Head);
        }
    }

    @Override
    public int indexOf(String msv) {
        if (isEmpty()) {
            return -1;
        }
        Node current = Head.next;
        int index = 0;
        do {
            if (current.data.getMaSV().equalsIgnoreCase(msv)) {
                return index;
            }
            current = current.next;
            index++;
        } while (current != Head);
        return -1; 
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
	    mergeSort(0, size() - 1, comparator);
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
	    quickSort(0, size() - 1, comparator);
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
	    for (int i = size() / 2 - 1; i >= 0; i--) {
	        heapify(size(), i, comparator);
	    }
	    for (int i = size() - 1; i >= 0; i--) {
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
