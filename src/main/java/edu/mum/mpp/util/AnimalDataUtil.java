package edu.mum.mpp.util;

import edu.mum.mpp.model.Animal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AnimalDataUtil {

    private static List<Animal> animalList = new ArrayList<>();
    public static long lastId;

    public static List<Animal> displayAnimals() {

        if (animalList.size() < 1) {

            for (int k = 1; k <= 10; ++k) {

                Animal newAnimal = new Animal();
                newAnimal.setId(k);
                newAnimal.setName("Animal" + k);
                newAnimal.setCellId(k);
                newAnimal.setBlockId(k * 2);
                newAnimal.setSpecy("Angolo Turaya");
                newAnimal.setTag(newAnimal.getName() + k);
                newAnimal.setDateOfBirth(LocalDate.of(2017, 10, 2));

                lastId = k;

                animalList.add(newAnimal);
            }
        }

        return animalList;
    }


    public static void addAnimal(Animal newAnimal) {
        lastId = lastId + 1;

        newAnimal.setId(lastId);
        animalList.add(newAnimal);
    }

    public static void editAnimal(Animal newAnimal) {
        int idTemp = (int) newAnimal.getId();
        animalList.set(idTemp - 1, newAnimal);
    }
}
