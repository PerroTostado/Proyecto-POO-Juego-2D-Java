
package relaciones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public final class UtilityClass {
    
    private UtilityClass(){}
    
    public static void printMenu(){
        System.out.println("\n\nAVAILABLE OPTIONS");
        System.out.println("1. Print animals' information");
        System.out.println("2. Print veterinarians' information");
        System.out.println("3. Modify an existing animal");
        System.out.println("4. Modify an existing veterinarian");
        System.out.println("5. Create a new animal");
        System.out.println("6. Create a new veterinarian");
        System.out.println("7. Create report file");
        System.out.println("8. End the program");
    }
    
    
    public static ArrayList<Veterinarian> readVeterinarian(String filePath){
        
        ArrayList <Veterinarian> vets = new ArrayList<>();
        
        String line = "";
        String idVet = "";
        String name = "";
        int experience = 0;
        
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine();
            
            while((line=reader.readLine())!=null){
                
                String[] parts = line.split(",");
                
                try{
                        if(parts.length>=3){
                            idVet = parts[0].trim();
                            name = parts[1].trim();
                            experience = Integer.parseInt(parts[2].trim());

                            vets.add(new Veterinarian(idVet,name,experience));
                        }else{
                            System.out.println("Incomplete data to create the object");
                        }
                    }catch(Exception e){
                        System.out.println("Error creating the object: " + e.getMessage());
                    }
            }
            reader.close();    
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return vets;
    }
   
    public static ArrayList<Animal> readAnimal(String filePath, ArrayList<Veterinarian> vets){
        
        ArrayList <Animal> animals = new ArrayList<>();
        
        String line = "";
        String idAnimal = "";
        String name = "";
        int age = 0;
        String idVet = "";
        Animal tempA;
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            reader.readLine();
            
            while((line=reader.readLine())!=null){
                
                String[] parts = line.split(",");
                
                try{
                    if(parts.length>=4){
                        idAnimal = parts[0].trim();
                        name = parts[1].trim();
                        age = Integer.parseInt(parts[2].trim());
                        idVet = parts[3].trim();
                   
                        tempA = new Animal(idAnimal,name,age);
                        animals.add(tempA);
                        
                        for(Veterinarian v: vets){
                            if(idVet.equals(v.getIdVet())){
                                v.addAnimal(tempA);
                            }
                        }
                    }else{
                        System.out.println("No hay suficientes datos para crear el objeto");
                    }    
                }catch(Exception e){
                    System.out.println("Error creating the object: " + e.getMessage());
                }
                
                
            }
            reader.close();    
        }catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        return animals;
    }
    
    public static void createReport(String filePath, ArrayList<Animal> animals,ArrayList<Veterinarian> vets){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            
            writer.write("ANIMALS INFORMATION\n");
            writer.newLine();
            //Writing animals information
            String line = "";
            for(Animal a: animals){
                line = a.toString();
                writer.write(line);
                writer.newLine();
            }
            
            writer.write("\nVETERINARIANS INFORMATION\n");
            writer.newLine();
            
            //Writing veterinarians information
            line = "";
            for(Veterinarian v: vets){
                line = v.toString();
                writer.write(line);
                writer.newLine();
            }
            
            //Closing BufferedWriter
            writer.close();
            System.out.println("The file was created: " + filePath);
            
        }catch(IOException e){
            System.err.println("Error: File could not be created" + e.getMessage());
        }
        
    }
    
}
