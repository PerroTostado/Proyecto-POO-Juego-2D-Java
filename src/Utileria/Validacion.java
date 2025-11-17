
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
        public static String validateName(String name){
        if(name == null){
            throw new IllegalArgumentException("El nombre no puede estar vacio...");
        }
        if(name.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar vacio...");
        }
        if(!name.matches("[A-Z a-z]+")){
            throw new IllegalArgumentException("El nombre solo puede contener letras...");
        }
        if(name.length() > 20){
            throw new IllegalArgumentException("Digita un nombre mas corto...");
        }
        return name;
    }
}
