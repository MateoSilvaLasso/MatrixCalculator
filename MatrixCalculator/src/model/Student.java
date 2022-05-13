package model;

import java.util.ArrayList;

public class Student {
    
    private String name;
    private int age;
    private double average;
    private String studentId;
    private NoteSubject [][] notes;

    public Student(String name, int age, String studentId) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
        this.notes=new NoteSubject[3][3];
        this.average=ponderate();
    }

    
    public Student(String name, int age, String studentId, NoteSubject[][] noteSubject) {
        this.name = name;
        this.age = age;
        this.studentId = studentId;
        this.notes=new NoteSubject[3][3];
        this.notes=noteSubject;
        this.average=ponderate();
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

    public double ponderate(){
        double p=0;
        double s=0;
        for(int i=0; i<notes.length ; i++){
            for(int j=0; j<notes[0].length; j++){
                if(notes[i][j]!=null){
                    p+=notes[i][j].average();
                    s+=notes[i][j].getCreditsSubject();
                }
            }
        }

        double k=p/s;
        return k;
    }
    
    public ArrayList<String> notesTable(){
         ArrayList<String>out= new ArrayList<>();
         String c="";
        for(int i=0; i<notes.length; i++){
            for(int j=0; j<notes[0].length; j++){
                if(notes[i][j]!=null){
                    int k=0;
                    String [] s= notes[i][j].getNameNote();
                    double [] p= notes[i][j].getValueNote();
                    c="         "+notes[i][j].getNameSubject()+"\n"+s[k]+"|"+p[k]+"\n"+s[k+1]+"|"+p[k+1]+"\n"+s[k+2]+"|"+p[k+2]+"\n"+"\n";
                    out.add(c);

                }
            }
        }

        return out;
    }

    
    /** 
    public String[][] notesTable(){
         String[][]out= new String[3][3];
        for(int i=0; i<notes.length; i++){
            for(int j=0; j<notes[0].length; j++){
                if(notes[j][i]!=null && notes[i][j]!=null){
                    int k=0;
                    String [] s= notes[i][j].getNameNote();
                    double [] p= notes[i][j].getValueNote();
                    out[j][i]+=notes[j][i].getValueNote()[j];

                }
            }
        }

        return out;
    }
    */

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

    public NoteSubject[][] getNotes() {
        return this.notes;
    }

    public void setNotes(NoteSubject[][] notes) {
        this.notes = notes;
    }

}
