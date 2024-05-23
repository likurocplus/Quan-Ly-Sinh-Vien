package comparator;
import java.util.Comparator;

import model.*;

public class SortWithMSSV implements Comparator<Student>{
	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o2.get3SoCuoiMSV() - o1.get3SoCuoiMSV();
	}
}
