package comparator;
import java.util.Comparator;

import model.*;
public class SortWithName implements Comparator <Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.getTenSV().compareToIgnoreCase(o2.getTenSV());
	}
	
}
