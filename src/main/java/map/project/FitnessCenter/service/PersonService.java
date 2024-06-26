package map.project.FitnessCenter.service;

import map.project.FitnessCenter.data.exceptions.ObjectAlreadyContained;
import map.project.FitnessCenter.data.exceptions.ObjectNotContained;
import map.project.FitnessCenter.data.model.Person;

import map.project.FitnessCenter.data.repository.Jpa.PersonRepository;
import map.project.FitnessCenter.data.repository.intefaces.IRepository;

import java.util.Optional;


/**
 * Service class for managing the stored personal accounts of users of the fitness center.
 */
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public abstract class PersonService<PersonType extends Person> extends BaseService<PersonType, String> {
    private final PersonRepository personRepository;

    public PersonService(IRepository<PersonType, String> repository, PersonRepository personRepository) {
        super(repository);
        this.personRepository = personRepository;
    }

    protected boolean personUsernameExists(String username) {
        return personRepository.personUsernameExists(username);
    }

    public Optional<PersonType> add(PersonType object) throws ObjectAlreadyContained {
        String username = object.getUsername();
        if (personUsernameExists(username)) throw new ObjectAlreadyContained();
        repository.save(object);
        return Optional.of(object);
    }

    @Override
    public Optional<PersonType> delete(String id) throws ObjectNotContained {
        if (!repository.existsById(id)) throw new ObjectNotContained();
        Optional<PersonType> oldObject = repository.findById(id);
        repository.deleteById(id);
        return oldObject;
    }
}
