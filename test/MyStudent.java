package test;

public class MyStudent {
	String std_name;
	String std_class_grade;
	String std_class;
	String grade_math;
	String grade_eng;
	String grade_kor;
	public MyStudent() {
		this.std_name = "홍길동";
		this.std_class = "1";
		this.std_class_grade = "1";
		this.grade_math = "100";
		this.grade_eng = "100";
		this.grade_kor = "100";
	}
	public MyStudent(String std_name, String std_class_grade, String std_class, String grade_math, String grade_eng,
			String grade_kor) {
		
		this.std_name = std_name;
		this.std_class = std_class;
		this.std_class_grade = std_class_grade;
		this.grade_math = grade_math;
		this.grade_eng = grade_eng;
		this.grade_kor = grade_kor;
	}
	private double calculateAvg(String grade_a, String grade_b, String grade_c ) {
		
		return calculateSum(grade_a,grade_b,grade_c)/3;
		
	}
	private int calculateSum(String grade_a, String grade_b, String grade_c) {
		int a = Integer.valueOf(grade_a);
		int b = Integer.valueOf(grade_b);
		int c = Integer.valueOf(grade_c);
		return a+b+c;
	}
	@Override
	public String toString() {
		return this.std_name +  "\t" + this.std_class_grade + "\t" + this.std_class 
				+ "\t" + this.grade_kor + "\t" + this.grade_eng + "\t" + this.grade_math
				+ "\t" + calculateSum(this.grade_kor,this.grade_eng,this.grade_math) 
				+ "\t" + calculateAvg(this.grade_kor,this.grade_eng,this.grade_math);
	}
	
	public boolean checkNameOfStudent(String n) {
		
		return (this.std_name.equals(n))? true : false;
		
	}
	
	
	
}
