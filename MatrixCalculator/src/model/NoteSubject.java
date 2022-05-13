package model;

public class NoteSubject {
    
    private String []nameNote;
    private double []valueNote;
    private String nameSubject;
    private int creditsSubject;


    public NoteSubject(String nameSubject, int creditsSubject,String [] nameNote,double [] valueNote) {
        this.nameNote = new String[3];
        this.valueNote = new double[3];
        this.nameSubject = nameSubject;
        this.creditsSubject = creditsSubject;
        this.nameNote=nameNote;
        this.valueNote=valueNote;
    }

    public double average(){
        double p=0;
        double s=0;
        for(int i=0; i<valueNote.length; i++){
            s+=valueNote[i];
        }
        double s1= (s/valueNote.length)*creditsSubject;
        return s1;
    } 
    public void addNameNote(String [] nameNote){
        this.nameNote=nameNote;
    }

    public void addValueNote(double [] valueNote){
        this.valueNote=valueNote;
    }

    public String getNameSubject() {
        return this.nameSubject;
    }

    public void setNameSubject(String nameSubject) {
        this.nameSubject = nameSubject;
    }

    public int getCreditsSubject() {
        return this.creditsSubject;
    }

    public void setCreditsSubject(int creditsSubject) {
        this.creditsSubject = creditsSubject;
    }


    public String[] getNameNote() {
        return this.nameNote;
    }

    public void setNameNote(String[] nameNote) {
        this.nameNote = nameNote;
    }

    public double[] getValueNote() {
        return this.valueNote;
    }

    public void setValueNote(double[] valueNote) {
        this.valueNote = valueNote;
    }


}
