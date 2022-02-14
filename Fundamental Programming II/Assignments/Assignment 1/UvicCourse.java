public class UvicCourse {
	private String name;
	private Student[] classList;
	
	public UvicCourse(String name, Student[] classList) {
		this.name = name;
		this.classList = classList;
	}
	
	/*
	 * Purpose: get this course's name
	 * Parameters: none
	 * Returns: String - this course's name
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * Purpose: get this course's classlist
	 * Parameters: none
	 * Returns: Student[] - the array of students in this class
	 */
	public Student[] getClassList() {
		return classList;
	}
	
	
	/* 
	 * Purpose: calculate the average grade of all students in this course
	 * Parameters: none
	 * Returns: double - the average grade of all students,
	 *                   or 0.0 if there are no enrolled students
	 */
	public double averageGrade() {
		Student[] students = getClassList();
		double grade = 0;
		double sum = 0;
		int i = 0;

			while(i<students.length){
				grade = students[i].getGrade();	
				sum = sum +grade;
				i++;
			}
		if(sum!=0){
			sum = sum/i;
		}
	
		return sum; // so it compiles	
	}


	/*
	 * Purpose: gets the grade of the student with given sid
	 * Parameters: String sid - the sid of the student to search for
	 * Returns: int - the grade of the students with given sid, 
	 *                or -1 if no student with given sid is in 
	 *                enrolled in this class
	 */
	public int getGrade(String sid) {

		int grade = -1;
		Student[] students = getClassList();
		int SidPos = 0;

		for (int i = 0; i < students.length; i++) {
			if (students[i].getSid() == sid) {
				SidPos = i;
			}
		}
		grade = students[SidPos].getGrade();
		return grade;
	}

	
	/*
	 * Purpose: determines if s is in this course's class list
	 * Parameters: Student s - the student
	 * Returns: boolean - true if this course's class list contains s
	 */
	public boolean hasStudent(Student s) {
		boolean isFound = false;
		Student[] students = getClassList();
		for(int i =0; i<students.length; i++){
			if(s.getSid()==students[i].getSid()){
				return true;
			}
		}
		return isFound; // so it compiles
	}
	
	
	/*
	 * Purpose: updates the grade of the student with given studentSid to
	 *          newGrade if the student is found in this course's class list
	 * Parameters: String studentSid - the sid of the student to update
	 *             int newGrade - the new grade for the student
	 * Returns: void - nothing
	 */
	public void updateGrade(String studentSid, int newGrade) {
		int SidPos = -69;
		Student[] students = getClassList();

		for(int i =0; i < students.length; i++){
			if(students[i].getSid() == studentSid){
				SidPos = i;
			}
		}

		if(SidPos!=-69){
			students[SidPos].setGrade(newGrade);
		}
	}
	

	
	/*
	 * Purpose: add the given student to this course's classlist
	 * Parameters: Strudent newStudent - student to add to class list
	 * Returns: void - nothing
	 * Precondition: newStudent is not already a student in classList
	 */
	public void addStudent(Student newStudent) {
		Student[] updatedList = new Student[classList.length+1];
		// TODO: implement this	
		updatedList[classList.length]= newStudent;
		classList = updatedList;
	}

}