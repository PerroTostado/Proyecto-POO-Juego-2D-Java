
package Utileria;

public class Validacion {
    
    private Validacion(){}
    
        public static void validateString(String string){
        if(!string.matches("[a-z A-Z]+")){
            throw new IllegalArgumentException("La cadena de caracteres no es valida");
        }
    }
    
        public static void validateInt(int entero){
        if(entero<0){
            throw new IllegalArgumentException("El numero debe ser positivo");
        }
    }
    
        public static void validateDouble(double decimal){
        if(decimal<0){
            throw new IllegalArgumentException("El numero debe ser positivo");
        }
    }
        public static void validateName(String name){
            if(!name.matches("[a-z A-Z]+ [0-9]")){
                throw new IllegalArgumentException("El nombre no es valido");
            }
        }
}
