package service;

import model.Address;
import model.Client;
import model.Employee;
import model.Person;

public class ClientService {

    private Person[] people = new Person[10];
    private int counter = 0;

    public void addClient(int age, String email, String name, String surname, String phone) {
        createPerson(new Client(age, email, name, surname, phone));
    }

    public void addClient(int age, boolean isRegular, String email, String name, String surname, String phone) {
        createPerson(new Client(age, isRegular, email, name, surname, phone));
    }

    public void addEmployee(int age, String email, String name, String surname, String phone) {
        createPerson(new Employee(age, email, name, surname, phone));
    }

    public int getStorageSize() {
        return people.length;
    }

    public Person[] getClients() {
        return people;
    }

    public Person findPersonByEmail(String email) {
        Person result = null;
        for (Person person : people) {
            if (person != null && email.equals(person.getEmail())) {
                result = person;
                break;
            }
        }
        return result;
    }

    private void createPerson(Person person) {
        if (counter >= people.length) {
            Person[] newPeople = new Person[people.length * 2];
            for (int index = 0; index < people.length; index++) {
                newPeople[index] = people[index];
            }
            people = newPeople;
        }
        System.out.println(person.toString());
        people[counter++] = person;
    }

    public Person updatePerson(String email, int age, String name, String surname, String phone) {
        Person toUpdate = findPersonByEmail(email);
        if (toUpdate != null) {
            toUpdate.setAge(age);
            toUpdate.setName(name);
            toUpdate.setSurname(surname);
            toUpdate.setPhone(phone);
        }
        return toUpdate;
    }


}
