public class A2Exercises {

	/*
	 * Purpose: get the number of students in the given course  	
	 *          with a grade above the given grade threshold
	 * Parameters: UvicCourse course
	 *             int gradeThreshold 
	 * Returns: int - the number of enrolled students with 	
	 *                a grade above gradeThreshold
	 */
	public static int countAbove(UvicCourse course, int gradeThreshold) {
		int count = 0;
		Student[] GivenClass = course.getClassList();

	for(int i =0; i<GivenClass.length; i++){
		if(GivenClass[i].getGrade()>gradeThreshold){
			count++;
		}
	}
		return count; 
	 // so it compiles
	}
	
	/*
	 * Purpose: get the name of the class with the highest average
	 * Parameters: UvicCourse[] courses - the array of courses
	 * Returns: String - the name of the course with the highest average
	 * Precondition: the array has at least one course in it
	 * NOTE: if there are two are more courses with the same class average 
	 *       which is the highest value of all courses in the array,
	 *       the name of course that comes first in the array is returned
	 */
	public static String highestAverage(UvicCourse[] courses) {
		//
		double Avg1 = courses[0].averageGrade();
		double Avg2= 0;
		int postion = 0;

		for(int i =1; i<courses.length; i++){	
			Avg2 = courses[i].averageGrade();
				if(Avg2>Avg1){
					Avg1 = Avg2;
					postion = i;
				}
		}
		String courseName = courses[postion].getName();
		//
		// TODO: implement this	
		return courseName; // so it compiles
	}
	
	/*
	 * Purpose: get the average grade of the student with given sid
	 *          across all courses the student is enrolled in
	 * Parameters: UvicCourse[] courses - an array of courses
	 *             String sid - the sid of the student for which 
	 *                          to calculate the average grade for
	 * Returns: double - the average grade of the student with given sid
	 *                   -1 if the student is not in any of the courses	 
	 *
	 * Note: the student is not necessarily enrolled in the courses
	 *       found in the given array
	 */
	public static double studentAverage(UvicCourse[] courses, String sid) {
		double Average = 0;
		int count = 0;
		Student[] Student = courses[0].getClassList();	
		for(int i =0; i<courses.length; i++){
			Student = courses[i].getClassList();

			for(int k = 0; k<Student.length; k++){
			if(Student[k].getSid() == sid){
				Average = Average + Student[k].getGrade();
				count++;
				}
			}
		}
		if(count!=0){
			Average = Average/count;
		}
		return Average; // so it compiles
	}
	
}