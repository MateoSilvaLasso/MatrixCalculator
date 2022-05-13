package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.lang.Math;

public class MatrixCalculator {
	
	private ArrayList<int[][]> numericMatrices;
	private ArrayList<String[][]> stringMatrices;
	private Student[][] students;
	private Random r;
	public MatrixCalculator() {
		int b = (int)(Math.random()*(100-1+1)+1);
		char a = 65;
		String as = ""+a;
		System.out.println( a );
		numericMatrices= new ArrayList<int[][]>() ;
		stringMatrices= new ArrayList<String[][]>();
		students= new Student[10][10];
		r= new Random();
		
	}

	public MatrixCalculator(Student[][] students2) {
		int b = (int)(Math.random()*(100-1+1)+1);
		char a = 65;
		String as = ""+a;
		System.out.println( a );
		numericMatrices= new ArrayList<int[][]>() ;
		stringMatrices= new ArrayList<String[][]>();
		students= new Student[10][10];
		this.students=students2;
		r= new Random();
		
	}

	public void addStudent(String name, int age, String studentId){
		if(hasSpace()){
			Student s= new Student(name, age, studentId);
			boolean p=true;
			for(int i=0; i<students.length && p; i++){
				for(int j=0; j<students[0].length && p; j++){
					if(students[i][j]==null){
						students[i][j]=s;
						p=false;
					}
				}
			}
		}
	}

	public void addNoteSubjectInStudent(String id,String []nameNote, double []valueNote, String nameSubject, int creditsSubject){

		NoteSubject s= new NoteSubject(nameSubject, creditsSubject, nameNote, valueNote);
		boolean p=true;
		for(int i=0; i<students.length && p; i++){
			for(int j=0; j<students[0].length && p; j++){
				if(students[i][j].getStudentId().equalsIgnoreCase(id)){
					students[i][j].addNotes(s);
					p=false;
				}
			}
		}


	}

	public ArrayList<String> printNotes(String id){
		ArrayList<String> out=new ArrayList<>();
		boolean p=true;
		String real="";
		for(int i=0; i<students.length && p;i++){
			for(int j=0; j<students[0].length && p; j++){
				if(students[i][j]!=null && students[i][j].getStudentId().equals(id)){
					out=students[i][j].notesTable();
				}
			}
		}

		

		return out;
	}

	public double studentAverage(String id){
		boolean p=true;
		double real=0;
		for(int i=0; i<students.length && p;i++){
			for(int j=0; j<students[0].length && p; j++){
				if(students[i][j]!=null && students[i][j].getStudentId().equals(id)){
					real=students[i][j].getAverage();
					p=false;
				}
			}
		}

		

		return real;
	}
	public boolean hasSpace(){
		boolean p=false;
		for(int i=0; i<students.length && p==false; i++){
			for(int j=0; j<students[0].length && p==false; j++){
				if(students[i][j]==null){
					p=true;
				}
			}
		}
		return p;
	}



	public String printNames(){
		String out="";
		for(int i=0; i<students.length; i++){
			for(int j=0; j<students[0].length; j++){
				if(students[i][j]!=null){
					out+= students[i][j].getName()+"\n";
				}
			}
		}

		return out;
	}

	public boolean existStudent(String id){
		boolean out=false;
		for(int i=0; i<students.length && out==false; i++){
			for(int j=0; j<students[0].length && out==false; j++){
				if(students[i][j]!=null && students[i][j].getStudentId().equalsIgnoreCase(id)){
					out=true;
				}
			}
		}

		return out;
	}
	
	public String showMatrices() {
		String out="";
		out += "Numeric matrices \n";
		for(int i=0; i< numericMatrices.size(); i++) {
			out+= printNumeric(numericMatrices.get(i));
		}
		out += "String matrices \n";
		for(int i=0; i< stringMatrices.size(); i++) {
			out+= printString(stringMatrices.get(i));
		}
		
		return out;
	}

	private String printString(String[][] matrix) {
		String print ="";
		for (int i=0; i< matrix.length; i++ ) { // filas numbers.length
			for (int j = 0; j < matrix[0].length; j++) { //columnas numbers[0].length
				print += matrix[i][j] + " ";
			}
			print += "\n";
		}

		return print;
	}

	private String printNumeric(int[][] numbers) {
		String print ="";
		for (int i=0; i< numbers.length; i++ ) { // filas numbers.length
			for (int j = 0; j < numbers[0].length; j++) { //columnas numbers[0].length
				print += numbers[i][j] + " ";
			}
			print += "\n";
		}
		return print;
	}
	
	

	public String createMatrix(int type, int rows, int columns) {
		String out="";
		switch(type) {
		case 1: //numeric Matrix
			int [][] newMatrix;
			newMatrix= new int[rows][columns];
			for(int i=0; i<rows; i++){
				for(int j=0; j<columns; j++){
					newMatrix[i][j]= r.nextInt(100);
				}
			}
			numericMatrices.add(newMatrix);
			out = printNumeric(newMatrix);
			
			break;

		case 2:
			String [][] newSMatrix;
			newSMatrix= new String[rows][columns];
			for(int i=0; i<rows; i++){
				for(int j=0; j<columns; j++){
					
					newSMatrix[i][j]= String.valueOf((char) (r.nextInt(26)+'A')); 
				}
			}
			stringMatrices.add(newSMatrix);
			out= printString(newSMatrix);
		}
		
		return out;
		
	}
	
	public void addNumeric (int[][] numMatrix) {
		numericMatrices.add(numMatrix);
	}

	public void addString(String [][] StringMatrix){
		stringMatrices.add(StringMatrix);
	}
	
	public ArrayList<String> table(){
		ArrayList<String> table= new ArrayList<>();
		
		for(int i=0; i<students.length; i++){
			for(int j=0; j<students[0].length; j++){
				if(students[i][j]!=null){
					table.add(students[i][j].getName()+"  | "+students[i][j].getAge()+"  |"+students[i][j].getAverage()+"     | "+students[i][j].getStudentId()); 
				}
			}
		}

		return table;
	}

	public String [][] getStudents(){
		String [][] s= new String[10][10];

		for(int i=0; i<students.length; i++){
			for(int j=0; j<students[0].length; j++){
				if(students[i][j]!=null){
					s[i][j]=students[i][j].getStudentId();
				}
			}
		}
		return s;
	}

}
