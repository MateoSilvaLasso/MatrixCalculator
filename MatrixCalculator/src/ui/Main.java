package ui;

import java.util.ArrayList;
import java.util.Scanner;

import model.MatrixCalculator;

public class Main {
	
	private Scanner sc;
	private MatrixCalculator calculator;
	private MatrixCalculator cal;
	
	public Main(){
		sc= new Scanner(System.in);
		init p= new init();
		calculator = new MatrixCalculator(p.inicializar());
	//	cal = new MatrixCalculator(p.inicializar());

	}

	public static void main(String[] args) {
		
		System.out.println("Welcome to the matrix calculator");
		Main ppal= new Main();
		
		int option=0;
		
		do{
			option= ppal.showMenu();
			ppal.executeOperation(option);
			
		}while (option!=0);
		
	}
	
	public int showMenu() {
		int option=0;

		System.out.println(
				"Main menu, please pick an option\n" +
				"(1) Create a matrix \n" +
				"(2) Show the contents of all matrices \n"+
				"(3) Numeric matrices\n"+
				"(4) String matrices\n" +
				"(5) Add Student\n"+
				"(6) student exist?\n"+
				"(7) students information\n"+
				"(8) add notes\n" +
				"(9) show notes\n"+ 
				"(10) show average\n"+
				"(0) To leave the application"
				);
		option= sc.nextInt();
		sc.nextLine();
		return option;
	}
	
	public void executeOperation(int operation) {
		
		switch(operation) {
		case 0:
			System.out.println("Bye!");
			break;
		case 1:
			createMatrix();
			break;
		case 2:
			System.out.println(calculator.showMatrices());
			break;
	
		case 3:
			createNumericMatrix();
			break;

		case 4:
			createStringMatrix();
			break;
		case 5:
			registerStudent();
			break;
		case 6:
			knowStudent();
			break;
		case 7:
			table();
			break;
		case 8: 
			registerNoteSubject();
			break;
		case 9: 
			showInformation();
			break;
		case 10: 
			ShowAverage();
			break;
		default:
			System.out.println("Error, wrong option");
		
		}
	

	}

	private void createMatrix() {
		System.out.println("Please select the type of matrix \n (1) Numeric matrix\n (2) String's matrix");
		int type= sc.nextInt();
		sc.nextLine();
		
		System.out.println("Please digit the number of rows");
		int rows= sc.nextInt();
		sc.nextLine();
		
		System.out.println("Please digit the number of columns");
		int columns= sc.nextInt();
		sc.nextLine();
		
		System.out.println("new matrix");
		System.out.println(calculator.createMatrix(type, rows, columns));
	}
	
	public void createNumericMatrix() {
		
		int row, col, num;
		
		System.out.println("Digite el num de filas");
		row= sc.nextInt();
		sc.nextLine();
		
		System.out.println("Digite el num de columnas");
		col= sc.nextInt();
		sc.nextLine();
		
		int [][] tmp= new int[row][col];

		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				System.out.println( "What is the number you want to register in the " + i + 
					" " + j + " pos");
				num= sc.nextInt();
				sc.nextLine();
				tmp[i][j]=num;
			}
		}
		calculator.addNumeric(tmp);
		
		
	}

	public void createStringMatrix(){
		int row, col;
		String value;
		
		System.out.println("Digite el num de filas");
		row= sc.nextInt();
		sc.nextLine();
		
		System.out.println("Digite el num de columnas");
		col= sc.nextInt();
		sc.nextLine();
		
		String [][] tmp= new String[row][col];

		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				System.out.println( "What is the character you want to register in the " + i + 
					" " + j + " pos");
				value= sc.next();
				sc.nextLine();
				tmp[i][j]=value;
			}
		}
		calculator.addString(tmp);
	}

	public void registerStudent(){
		 String name;
		 int age;
		
		 String studentId;

		System.out.println("type the name");
		name= sc.nextLine();
		System.out.println("type the age");
		age=sc.nextInt();
		
		System.out.println("type the Student id");
		sc.nextLine();
		studentId= sc.nextLine();
		System.out.println(studentId);
		calculator.addStudent(name, age, studentId);
	}

	public void knowStudent(){
		System.out.println("type the id");
		String id= sc.nextLine();

		if(calculator.existStudent(id)){
			System.out.println("the student exist");
		}else{
			System.out.println("the student doesnt exist");
		}

	}

	public void table(){
		ArrayList<String> table= calculator.table();
		int c=0;
		System.out.println("-------------------------------");
		System.out.println("          name| age| average| id");
		
			for(int j=0; j<table.size(); j++){
				if(table.get(j)!=null){ 
					System.out.println("student "+c+ "| "+table.get(j));
					c++;
				}
				
			}
		

	}

	public void registerNoteSubject(){
		
		System.out.println("type the id of the student");
		String id= sc.nextLine();
		String findId="";
		String [][] search= calculator.getStudents();
		for(int i=0; i<search.length; i++){
			for(int j=0; j<search[0].length; j++){
				if(search[i][j]!=null && search[i][j].equalsIgnoreCase(id)){
					findId=search[i][j];
				}
			}
		}

		if(!findId.equalsIgnoreCase("")){
			System.out.println("type the name of the subject");
			String nameSubject= sc.nextLine();
			String [] nameNote= new String[3];
			double [] note= new double[3];
			for(int i=0; i<3; i++){
				if(i!=0){
				System.out.println("type the nameNote " + (i+1));
				sc.nextLine();
				nameNote[i]=sc.nextLine();
				System.out.println("type the note ");
				note[i]=sc.nextDouble();
				}else{
					System.out.println("type the nameNote " + (i+1));
					nameNote[i]=sc.nextLine();
					System.out.println("type the note ");
					note[i]=sc.nextDouble();
					
				}
			}

			System.out.println("type the credits of subject");
			int credits= sc.nextInt();
			calculator.addNoteSubjectInStudent(id, nameNote, note, nameSubject, credits);
		}



	}

	public void showInformation(){
		System.out.println("type the id");
		String id= sc.nextLine();
		ArrayList<String> out= calculator.printNotes(id);
		for(int i=0; i<out.size(); i++){
			System.out.print(out.get(i));
		}
		
	}

	public void ShowAverage(){
		System.out.println("type the id");
		String id= sc.nextLine();
		if(calculator.studentAverage(id)>=3.5){
		System.out.println("El promedio ponderado es: "+ calculator.studentAverage(id)+" el estudiante aprobo");
		}else{
			System.out.println("El promedio ponderado es: "+ calculator.studentAverage(id)+" el estudiante reprobo");
		}
	}
}
