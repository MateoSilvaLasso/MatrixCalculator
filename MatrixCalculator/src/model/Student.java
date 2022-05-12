package model;

public class Student {
    
    private String name;
    private int age;
    private double average;
    private String studentId;
    private NoteSubject [][] notes;

    public Student(String name, int age, double average, String studentId) {
        this.name = name;
        this.age = age;
        this.average = average;
        this.studentId = studentId;
        this.notes=new NoteSubject[3][3];
    }
    public void addNotes(NoteSubject s){
		if(hasSpace()){
			
			boolean p=true;
			for(int i=0; i<notes.length && p; i++){
				for(int j=0; j<notes[0].length && p; j++){
					if(notes[i][j]==null){
						notes[i][j]=s;
						p=false;
					}
				}
			}
		}
	}

    public boolean hasSpace(){
		boolean p=false;
		for(int i=0; i<notes.length && p==false; i++){
			for(int j=0; j<notes[0].length && p==false; j++){
				if(notes[i][j]==null){
					p=true;
				}
			}
		}
		return p;
	}

    public String getName(){
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAverage() {
        return this.average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getStudentId() {
        return this.studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

}
