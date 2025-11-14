package Habilidad;


public class Derivar extends OffSkill {
    
public Derivar(){
    
}    
public Derivar(int stamina, int obtainProb, int damage){
    super(stamina, obtainProb, damage);
    
}
@Override
public void showDetails(){
    System.out.println("This hability does damage when used against a limit");
}
@Override
public void functionality(){
    System.out.println("The limit has been damaged");
}
}
