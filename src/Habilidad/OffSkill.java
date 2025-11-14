package Habilidad;


public abstract class OffSkill extends Habilidades{
    private int damage;

public OffSkill(){
    
}
public OffSkill(int stamina, int obtainProb, int damage){
    this.damage=damage;
}
final protected void setDamage(int damage){
    this.damage=damage;
}
public int getDamage(){
    return this.damage;
}
@Override
public abstract void showDetails();
public abstract void functionality();
}
