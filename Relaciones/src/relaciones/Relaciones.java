
package relaciones;
import java.util.ArrayList;
import java.util.Scanner;


public class Relaciones {
    
    public static void main(String[] args) {
        
        int option, addAnimalOpt;
        boolean stop=false;
        String animalId, vetId, name;
        int age, experience;
        Scanner scanner = new Scanner(System.in);
        
        try{
            //Veterinarians arraylist
            ArrayList <Veterinarian> vets = UtilityClass.readVeterinarian("./Veterinarios.txt");

            //animals arraylist
            ArrayList <Animal> animals = UtilityClass.readAnimal("./Animals.txt", vets);
            
            while(!stop){
                //Print menu
                UtilityClass.printMenu();
                System.out.println("Please type the desired option: ");
                option = scanner.nextInt();
                scanner.nextLine();

                //Menu
                switch(option){
                    case 1:
                        //Print animals information
                        System.out.println("ANIMALS INFORMATION");
                        for(Animal a: animals){
                            System.out.println(a.toString());
                        }
                        break;
                    case 2:
                        //Print veterinarians information
                        System.out.println("\nVETERINARIANS INFORMATION");
                        for(Veterinarian v: vets){
                            System.out.println(v.toString()+ "\n");
                        }
                        break;
                    case 3:
                        //Modify an existing animal
                        Animal tempA=null;
                        System.out.println("Please type the id of the animal to modify");
                        animalId = scanner.nextLine();
                        for(Animal a: animals){
                            if(animalId.equals(a.getAnimalId())){
                                tempA = a;
                                break;
                            }
                        }
                        if(tempA!=null){
                            System.out.println("Please type the new name: ");
                            name = scanner.nextLine();
                            tempA.setName(name);
                            System.out.println("Please type the new age: ");
                            age = scanner.nextInt();
                            scanner.nextLine();
                            tempA.setAge(age);
                            
                        }else{
                            System.out.println("Animal not found");
                        }
                        
                        break;
                    case 4:
                        //Modify an existing veterinarian
                        Veterinarian tempV=null;
                        System.out.println("Please type the id of the veterinarian to modify");
                        vetId = scanner.nextLine();
                        for(Veterinarian v: vets){
                            if(vetId.equals(v.getIdVet())){
                                tempV = v;
                                break;
                            }
                        }
                        if(tempV!=null){
                            System.out.println("Please type the new name: ");
                            name = scanner.nextLine();
                            tempV.setName(name);
                            System.out.println("Please type the new experience: ");
                            experience = scanner.nextInt();
                            scanner.nextLine();
                            tempV.setExperience(experience);
                            System.out.println("Type 1 to add an animal, 0 otherwise");
                            addAnimalOpt = scanner.nextInt();
                            scanner.nextLine();
                            if(addAnimalOpt==1){
                                tempA = null;
                                System.out.println("Please type animal ID: ");
                                animalId = scanner.nextLine();
                                for(Animal a: animals){
                                    if(animalId.equals(a.getAnimalId())){
                                        tempA = a;
                                        break;
                                    }
                                }
                                if(tempA!=null){
                                    tempV.addAnimal(tempA);
                                }else{
                                    System.out.println("Animal not found");
                                }
                            }    
                        }else{
                            System.out.println("Animal not found");
                        }
                        break;
                    case 5:
                        //Create a new animal
                        System.out.println("Please type the animal ID: ");
                        animalId = scanner.nextLine();
                        System.out.println("Please type the animal name: ");
                        name = scanner.nextLine();
                        System.out.println("Please type the animal age: ");
                        age = scanner.nextInt();
                        scanner.nextLine();
                        animals.add(new Animal(animalId, name, age));
                        break;
                    case 6:
                        //Create a new veterinarian
                        System.out.println("Please type the veterinarian ID: ");
                        vetId = scanner.nextLine();
                        System.out.println("Please type the veterinarian name: ");
                        name = scanner.nextLine();
                        System.out.println("Please type the veterinarian experience: ");
                        experience = scanner.nextInt();
                        scanner.nextLine();
                        vets.add(new Veterinarian(vetId, name, experience));
                        break;
                    case 7:
                        //Create report file
                        UtilityClass.createReport("./SystemReport.txt", animals, vets);
                        break;
                    case 8:
                        stop = true;
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;

                }
                
            }
         
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        
        
    }
}
