package edu.mum.mpp.service;

import edu.mum.mpp.dao.AbstractDao;
import edu.mum.mpp.model.Animal;
import edu.mum.mpp.util.AninalDataUtil;
import edu.mum.mpp.util.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService extends AbstractService<Animal> {

    private final static Logger logger = LoggerFactory.getLogger(AnimalService.class);

    @Autowired
    public AnimalService(@Qualifier("animalDao") AbstractDao<Animal> dao) {
        super(dao);
    }


    public Animal create(Animal animal) {

        AninalDataUtil.addAnimal(animal);
        return animal;
    }

    public boolean checkAnimal(long cellId) {

        long idTemp = cellId;
        try {

            idTemp = AninalDataUtil.displayAnimals().stream()
                    .filter(
                            animal -> animal.getCellId() == cellId)
                    .map(Animal::getCellId)
                    .findAny()
                    .orElse(0L);

        } catch (Exception ex) {
            logger.error(" [checkAnimal()]: " + ex.getMessage());
            LoggerUtil.logError(logger, ex);
        }

        return idTemp == cellId;

    }


    public List<Animal> getAnimals() {
        return AninalDataUtil.displayAnimals();
    }

    public Animal getSingleAnimal(long id) {
        Animal singleAnimal = null;
        try {

            singleAnimal = AninalDataUtil.displayAnimals().stream()
                    .filter(animal -> animal.getId() == id)
                    .findAny().get();

        } catch (Exception ex) {
            logger.error(" [getSingleAnimal()]: " + ex.getMessage());
            LoggerUtil.logError(logger, ex);
        }

        return singleAnimal;
    }


    public Animal editAnimal(Animal animal) {
        AninalDataUtil.editAnimal(animal);
        return animal;

    }
}
