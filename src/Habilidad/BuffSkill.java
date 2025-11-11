package Habilidad;


abstract public class BuffSkill extends Habilidades{
    private int moodInc;
    private int resInc;
    private int attInc;
    private int stamInc;
    
public BuffSkill(){
    
}   
public BuffSkill(int stamina, int obtainProb, int moodInc, int resInc, int attInc, int stamInc){
    this.attInc=attInc;
    this.moodInc=moodInc;
    this.resInc=resInc;
    this.stamInc=stamInc;
}
protected final void setAttInc(int attInc){
    this.attInc=attInc;
}
protected final void setResInc(int resInc){
    this.resInc=resInc;
}
protected final void setMoodInc(int moodInc){
    this.moodInc=moodInc;
}
protected final void setStamInc(int stamInc){
    this.stamInc=stamInc;
}
public int getAttInc(){
    return this.attInc;
}
public int getResInc(){
    return this.resInc;
}
public int getMoodInc(){
    return this.moodInc;
}
public int getStamInc(){
    return this.stamInc;
}
@Override
public abstract void showDetails();
public abstract void functionality();
}
