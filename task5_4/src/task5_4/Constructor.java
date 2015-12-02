package task5_4;

class Person{
	private String cardID;
	String name;
	String getCardID(){
		return cardID;
	}
	public Person(String id){
		cardID=id;
	}
}

class Student extends Person{
	private String studentID;
	String getStudentID(){
		return studentID;
	}
	public Student(String cID, String sID) {
		super(cID);
		studentID = sID;
	}
}

public class Constructor {

	public static void main(String[] args) {
		Student student = new Student("330623780", "971115");
		student.name="yly";
		System.out.println(student.name + "'s cardID is :" + student.getCardID());
		System.out.println(student.name + "'s studentID is :" + student.getStudentID());
	}

}
