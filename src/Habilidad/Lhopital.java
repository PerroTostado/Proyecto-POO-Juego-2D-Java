package Habilidad;


public class Lhopital extends DebSkill {
    
public Lhopital(){
    
}    
public Lhopital(int stamina, int obtainProb, int attDeb, int attRes){
    super(stamina, obtainProb, attDeb, attRes);
    
}
@Override
public void showDetails(){
    System.out.println("Debuffs the limit that's selected when this hability is being used");
}
@Override
public void functionality(){
    System.out.println("The limit have been debuffed");
}
}
