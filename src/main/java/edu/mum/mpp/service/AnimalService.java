package edu.mum.mpp.service;

import edu.mum.mpp.dao.AbstractDao;
import edu.mum.mpp.dao.AnimalDao;
import edu.mum.mpp.model.Animal;
import edu.mum.mpp.model.AnimalReport;
import edu.mum.mpp.model.Page;
import edu.mum.mpp.model.PaymentReport;
import edu.mum.mpp.util.AnimalDataUtil;
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


    public Page<AnimalReport> getAnimals(long pageNum, long pageSize) {
        AnimalDao animalDao = (AnimalDao) dao;
        return animalDao.getAnimals(pageNum, pageSize);
    }

    public Page<PaymentReport> report(long pageNum, long pageSize) {
        AnimalDao animalDao = (AnimalDao) dao;
        return animalDao.report(pageNum, pageSize);
    }



    public long manageAnimal(Animal animal) {


        AnimalDao animalDao = (AnimalDao) dao;
        return animalDao.manageAnimal(animal);
    }


    public Animal create(Animal animal) {

        AnimalDataUtil.addAnimal(animal);
        return animal;
    }


    public boolean checkAnimal(long cellId) {

        long idTemp = cellId;
        try {

            idTemp = getAnimals(1, 20).getContent().stream()
                    .filter(
                            animal -> animal.getCellId() == cellId)
                    .map(AnimalReport::getCellId)
                    .findAny()
                    .orElse(0L);

        } catch (Exception ex) {
            logger.error(" [checkAnimal()]: " + ex.getMessage());
            LoggerUtil.logError(logger, ex);
        }

        return idTemp == cellId;

    }


    public List<Animal> getAnimals() {
        return AnimalDataUtil.displayAnimals();
    }


    public AnimalReport searchAnimal(String AnimalReport) {
        AnimalDao animalDao = (AnimalDao) dao;
        return animalDao.searchAnimal(AnimalReport);
    }


    public AnimalReport searchAnimal2(String name) {
        AnimalReport singleAnimal = null;
        try {

            singleAnimal = getAnimals(1, 20).getContent().stream()
                    .filter(animal -> animal.getSpecy().equals(name))
                    .findAny().get();

        } catch (Exception ex) {
            logger.error(" [searchAnimal()]: " + ex.getMessage());
            LoggerUtil.logError(logger, ex);
        }

        return singleAnimal;
    }



    public AnimalReport getSingleAnimal(long id) {
        AnimalReport singleAnimal = null;
        try {

            singleAnimal = getAnimals(1, 20).getContent().stream()
                    .filter(animal -> animal.getId() == id)
                    .findAny().get();

        } catch (Exception ex) {
            logger.error(" [getSingleAnimal()]: " + ex.getMessage());
            LoggerUtil.logError(logger, ex);
        }

        return singleAnimal;
    }


    public Animal editAnimal(Animal animal) {
        AnimalDataUtil.editAnimal(animal);
        return animal;

    }
}
