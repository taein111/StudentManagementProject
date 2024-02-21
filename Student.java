package Student;

public class Student { //vo 클래스
	private String studentId;
	private String name;
	private String major;
	private String telNumber;
	private String sexValue ;
	private int grade;
	
	

	public Student(String name, String major, String telNumber, String studentId, String sexValue, int grade ) {
	 this.name = name;
	 this.grade = grade;
	 this.studentId = studentId;
	 this.sexValue =sexValue;
	 this.major = major;
	 this.telNumber = telNumber;
	}

	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getTelNumber() {
		return telNumber;
	}

	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}

	public String getSexValue() {
		return sexValue;
	}



	public void setSexValue(String sexValue) {
		this.sexValue = sexValue;
	}



	public int getGrade() {
		return grade;
	}



	public void setGrade(int grade) {
		this.grade = grade;
	}

	
	
}
