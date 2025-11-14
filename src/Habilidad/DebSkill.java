package Habilidad;


public abstract class DebSkill extends Habilidades {
    private int attDeb;
    private int resDeb;
public DebSkill(){
    
}   
public DebSkill(int stamina, int obtainProb, int attDeb, int resDeb){
    super(stamina, obtainProb);
    this.attDeb=attDeb;
    this.resDeb=resDeb;
}
protected final void setAttDeb(int attDeb){
    this.attDeb=attDeb;
}
protected final void setResDeb(int resDeb){
    this.resDeb=resDeb;
}
public int getAttDeb(){
    return this.attDeb;
}
public int getResDeb(){
    return this.resDeb;
}
@Override
abstract public void showDetails();  
public abstract void functionality();
}
