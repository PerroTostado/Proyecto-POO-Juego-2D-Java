
package relaciones;

public class Animal {
    
    private String idAnimal;
    private String name;
    private int age;
    
    public Animal(){
    }
    
    public Animal(String idAnimal, String name, int age){
        this.idAnimal = idAnimal;
        this.setName(name);
        this.setAge(age);
    }
    
    public void setName(String name){
        ValidationClass.validateName(name);
        this.name = name;
    }
    
    public void setAge(int age){
        ValidationClass.validateAge(age);
        this.age = age;
    }
    
    public String getAnimalId(){
        return this.idAnimal;
    }
    
    @Override
    public String toString(){
        String str = "Id Animal: " + this.idAnimal + "\t";
        str += "Animal name: " + this.name + "\t";
        str += "Animal age: " + this.age + "\t";
        return str;
    }
}
