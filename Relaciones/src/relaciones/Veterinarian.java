
package relaciones;
import java.util.ArrayList;

public class Veterinarian {
    
    private String idVet;
    private String name;
    private int experience;
    private ArrayList <Animal> animals;
    
    public Veterinarian(){
    }
    
    public Veterinarian(String idVet, String name, int experience){
        this.idVet = idVet;
        this.setName(name);
        this.setExperience(experience);
        this.animals = new ArrayList<>();
    }
    
    public void setName(String name){
        ValidationClass.validateName(name);
        this.name = name;
    }
    
    public void setExperience(int experience){
        ValidationClass.validateExperience(experience);
        this.experience = experience;
    }
    
    public void addAnimal(Animal animal){
        this.animals.add(animal);
    }
    
    public String getIdVet(){
        return this.idVet;
    }
    
    @Override
    public String toString(){
        String str = "Id Vet: " + this.idVet + "\n";
        str += "Vet Name: " + this.name + "\n";
        str += "Vet experience: " + this.experience + "\n";
        if(this.animals.size()>0){
            str += "Animals in charge: \n";
            for(Animal a: this.animals){
                str += a.toString() + "\n";
            }
        }else{
            str += "No animals in charge\n";
        }
        return str;
    }
    
}
