package University;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Avigail on 5/20/2017.
 */
public class Main {
	public static void main(String[] args) {
		List<Course> courses = new LinkedList<Course>() {
			{
				add(new Course(30, "Data Structures", 3.5f));
				add(new Course(32, "Geometry", 6));
				add(new Course(35, "Algebra", 2.5f));
				add(new Course(37, "English", 7));
			}
		};

		List<Student> students = new LinkedList<Student>() {
			{
				add(new Student("Moshe", 21, 1, new LinkedList<Grade>() {
					{
						add(new Grade(courses.stream().filter(c -> c.getId() == 30).findFirst().get(), 67));
						add(new Grade(courses.stream().filter(c -> c.getId() == 32).findFirst().get(), 89));
						add(new Grade(courses.stream().filter(c -> c.getId() == 35).findFirst().get(), 67));
						add(new Grade(courses.stream().filter(c -> c.getId() == 37).findFirst().get(), 89));
					}
				}));
				add(new Student("Yossi", 26, 2, new LinkedList<Grade>() {
					{
						add(new Grade(courses.stream().filter(c -> c.getId() == 30).findFirst().get(), 100));
						add(new Grade(courses.stream().filter(c -> c.getId() == 32).findFirst().get(), 67));
						add(new Grade(courses.stream().filter(c -> c.getId() == 35).findFirst().get(), 89));
					}
				}));
				add(new Student("Natasha", 30, 3, new LinkedList<Grade>() {
					{
						add(new Grade(courses.stream().filter(c -> c.getId() == 30).findFirst().get(), 67));
						add(new Grade(courses.stream().filter(c -> c.getId() == 37).findFirst().get(), 80));

					}
				}));
			}
		};
		// average of all courses for each student
		System.out.println("students and their average in all courses:");
		students.stream().forEach(x -> {
			double avg = x.getGrades().stream().mapToDouble(y -> y.getValue()).average().getAsDouble();
			System.out.println(x.getName() + ": average = " + avg);
		});

		// average of all courses
		System.out.println("\ncourses and their average:");
		courses.stream().forEach(x -> {
			double avg = students.stream()
					.flatMap(y -> y.getGrades().stream()
							.filter(g -> g.getCourse().getName().equals(x.getName())))
					.mapToDouble(z -> z.getValue()).average().getAsDouble();
			System.out.println(x.getName() + ": " + avg);
		});
		
		/**
		 * !!!!!!!!!!!!!!!!!!!!!!!!!
		 * id's: 206094815 311447783
		 * !!!!!!!!!!!!!!!!!!!!!!!!!
		 */
	}
}
