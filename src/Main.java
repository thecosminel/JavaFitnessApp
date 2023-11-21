
import UI.Terminal;
import dao.DatabaseConnection;
import dao.PersonDao;
import dao.interaces.EmployeeDao;
import domain.persons.Employee;
import domain.persons.Gender;
import repository.exceptions.ObjectAlreadyContained;
import repository.exceptions.ObjectNotContained;

import java.sql.SQLException;
import java.time.LocalDate;

public class Main {
//    Projekt: Java-Konsolenanwendung
    public static void main(String[] args){
        // Connect to database
        try {
            DatabaseConnection.setConnection("jdbc:mysql://localhost:3306/javaapp", "coders", "ThisIsOurDatabase.2023");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }

        EmployeeDao dao = EmployeeDao.getInstance();

//        System.out.println(dao.keyNameInRepo("bgy99"));

//        System.out.println(dao.searchByKeyName("bgy99"));

//        System.out.println(dao.generateNextId());

//        System.out.println(dao.searchById(2));

//        System.out.println(dao.idInRepo(2));

//        dao.equipmentItemDeleted(new EquipmentItem(10));

//        try {
//            dao.addEntity(new Employee("yone", "ionel", LocalDate.of(2000, 10, 10), Gender.male, 1000));
//        } catch (ObjectAlreadyContained e) {
//            System.out.println(e.getMessage());
//        }

        try {
            dao.deleteEntity(new Employee("yone"));
        } catch (ObjectNotContained e) {
            System.out.println(e.getMessage());
        }

//        try {
//            dao.updateEntity(new Employee("yone", "ionelulBoss", LocalDate.of(2999, 12, 5), Gender.male, 10002));
//        } catch (ObjectNotContained e) {
//            System.out.println(e.getMessage());
//        }

        Terminal.getInstance().printArrayList(dao.getAllEntities());

        //        MainUI mainUI = MainUI.getInstance();
        //        mainUI.runUi();
    }
}