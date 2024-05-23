package comparator;
import model.*;
import java.util.Comparator;

public class SortWithGPA implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.getDiemGPA() - o2.getDiemGPA();
	}

}
