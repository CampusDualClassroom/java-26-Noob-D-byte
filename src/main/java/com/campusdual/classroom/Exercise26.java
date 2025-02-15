package com.campusdual.classroom;


public class Exercise26 {
    public static void main(String[] args) {
        Phonebook phonebook = new Phonebook();
        phonebook.addContact(new Contact("Javier", "López", "672345678"));
        phonebook.addContact(new Contact("Carlos", "Fernández-Simón", "689012345"));
        phonebook.addContact(new Contact("Jose Manuel", "Soria", "698765432"));
        phonebook.addContact(new Contact("Santiago", "Fernández Rocha", "675432109"));
        phonebook.addContact(new Contact("Esteban", "Serrano del Río", "687654321"));
        phonebook.addContact(new Contact("Fernando Miguel Juan", "de los Santos Requejo León", "690123456"));

        phonebook.showMenu();
    }


}
