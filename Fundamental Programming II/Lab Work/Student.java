/*
Student.java 

The File for Part 2

*/
public class Student {

    public String sID;
    public int grade;
	
	public Student(){}
	
    public Student(String id, int studentGrade) {
        sID = id;
        grade = studentGrade;
    }

    public String getSID() {
        return sID;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int studentGrade) {
        grade = studentGrade;
    }

	public String toString(){
		String result = sID + ":" + grade;
        return result;
	}
	
	public boolean equals(Student s){
		
	return s.getSID() == sID;}
}