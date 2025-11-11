
package relaciones;

public final class ValidationClass {
    
    private ValidationClass(){}
    
    public static void validateName(String name){
        if(!name.matches("[a-z A-Z]+")){
            throw new IllegalArgumentException("The name is not valid");
        }
    }
    
    public static void validateAge(int age){
        if(age<0){
            throw new IllegalArgumentException("The age must be positive");
        }
    }
    
    public static void validateExperience(int experience){
        if(experience<0){
            throw new IllegalArgumentException("The experience must be positive");
        }
    }
    
}
