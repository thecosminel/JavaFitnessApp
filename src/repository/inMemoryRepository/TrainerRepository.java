package repository.inMemoryRepository;

import domain.persons.Gender;
import domain.persons.Person;
import domain.persons.Trainer;
import repository.Repository;
import repository.interfaces.ITrainerRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class TrainerRepository extends Repository<Trainer> implements ITrainerRepository
{
    private static TrainerRepository instance;

    private TrainerRepository()
    {
        Trainer trainer1 = new Trainer("bgy99", "BogdanTrainer", LocalDate.of(1995, 1, 1), Gender.male);
        Trainer trainer2 = new Trainer("bgyClone", "BogdanTrainerClone", LocalDate.of(1995, 1, 1), Gender.male);
        arrayList.add(trainer1);
        arrayList.add(trainer2);
    }

    public static TrainerRepository getInstance()
    {
        if (instance == null) instance = new TrainerRepository();
        return instance;
    }

    @Override
    public Boolean keyNameInRepo(String keyName) {
        for (Person person : arrayList)
        {
            if (keyName.equals(person.getUsername())) return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public ArrayList<Trainer> searchByPartialKeyName(String keyName) {
        ArrayList<Trainer> result = new ArrayList<>();
        for (Trainer trainer : arrayList)
        {
            if (trainer.getUsername().contains(keyName)) result.add(trainer.copy());
        }
        return result;
    }

    @Override
    public Trainer searchByKeyName(String keyName) {
        for (Trainer trainer : arrayList)
        {
            if (trainer.getUsername().contains(keyName)) return trainer.copy();
        }
        return new Trainer();
    }
}
