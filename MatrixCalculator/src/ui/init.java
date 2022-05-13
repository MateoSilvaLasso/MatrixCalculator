package ui;

import model.*;

public class init{

    public Student[][] inicializar(){

        double notes[] = new double[3];
        notes[0]=1;
        notes[1]=2;
        notes[2]=3;
        String nameNote[] = new String[3];
    
        nameNote[0]="parcia 1";
        nameNote[1]="quiz 4  ";
        nameNote[2]="parcia 3";
        NoteSubject subject1=new NoteSubject("aplicadas",4,nameNote,notes);
        
        nameNote=null;
        nameNote=new String[3];
        notes=null;
        notes=new double[3];
    
        nameNote[0]="seguimiento";
        nameNote[1]="quiz 4     ";
        nameNote[2]="parcia 3   ";
        notes[0]=5;
        notes[1]=5;
        notes[2]=0.3;
        NoteSubject subject2=new NoteSubject("apo", 3,nameNote,notes);
    
        nameNote=null;
        nameNote=new String[3];
        notes=null;
        notes=new double[3];

        nameNote[0]="parcia 1";
        nameNote[1]="parcial 2";
        nameNote[2]="parcia 3";
        notes[0]=2.9;
        notes[1]=3.7;
        notes[2]=2.1;
        NoteSubject subject3=new NoteSubject("coe", 2,nameNote,notes );
    



        
        NoteSubject[][] noteSubject=new NoteSubject[3][3];
    
        noteSubject[0][0]=subject1;
        noteSubject[0][1]=subject2;
        noteSubject[0][2]=subject3;
    
        Student student1 = new Student("mateo", 19, "1", noteSubject);
    
        
    
    
    
    
        notes=null;
        notes=new double[3];
        
        notes[0]=1.7;
        notes[1]=4;
        notes[2]=2.3;
        NoteSubject subject4=new NoteSubject("economia", 3,nameNote,notes);
    
        notes=null;
        notes=new double[3];
    
        notes[0]=3.2;
        notes[1]=2.5;
        notes[2]=0.7;
        NoteSubject subject5=new NoteSubject("ingesoft", 3,nameNote,notes);
    
        notes=null;
        notes=new double[3];
        notes[0]=4.9;
        notes[1]=1.7;
        notes[2]=3.1;
        NoteSubject subject6=new NoteSubject( "coe", 2,nameNote,notes);
    
        NoteSubject[][] noteSubject2=new NoteSubject[3][3];
    
        noteSubject2[0][0]=subject4;
        noteSubject2[0][1]=subject5;
        noteSubject2[0][2]=subject6;
    
        Student student2 = new Student("marcos", 18, "2", noteSubject2);
    
        Student[][] students = new Student[10][10];
    
        students[0][1]=student2;
    
        students[0][2]=student1;

        return students;

    }

}