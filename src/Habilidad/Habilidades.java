package Habilidad;


public abstract class Habilidades {
    private int stamina;
    private int obtainProb;
    
public Habilidades(){
    
}    
public Habilidades(int stamina, int obtainProb){
    this.stamina=stamina;
    this.obtainProb=obtainProb;
}
protected final void setStamina(int stamina){
    this.stamina=stamina;
}
protected final void setObtainProb(int obtainProb){
    this.obtainProb=obtainProb;
}
public int getStamina(){
    return this.stamina;
}
public int getObtainProb(){
    return this.obtainProb;
}
public abstract void showDetails();

}
