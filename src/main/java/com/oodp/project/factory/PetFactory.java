package com.oodp.project.factory;

import com.oodp.project.Cat;
import com.oodp.project.Dog;
import com.oodp.project.Pet;

public class PetFactory {
    public Pet getPet(String petType) {
        if(petType==null)
            return null;
        if(petType.equalsIgnoreCase("DOG")){
            Pet pet = new Dog();
            pet.setPetType("Dog");
            return pet;
        }
        if(petType.equalsIgnoreCase("CAT")){
            Pet pet = new Cat();
            pet.setPetType("Cat");
            return new Cat();
        }
        return null;
    }
}