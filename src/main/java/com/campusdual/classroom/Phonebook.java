package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.util.HashMap;
import java.util.Map;

public class Phonebook {
    Map<String, Contact> contacts;

    public Phonebook() {
        this.contacts = new HashMap<>();
    }

    public Map<String, Contact> getData() {
        return this.contacts;
    }

    public void addContact() {
        String name = Utils.string("Introduce el nombre del nuevo contacto: ");
        String surnames = Utils.string("Introduce los apellidos del nuevo contacto: ");
        String teléfono = Utils.string("Introduce el teléfono del nuevo contacto: ");

        Contact c = new Contact(name, surnames, teléfono);

        if (this.contacts.get(c.getCode()) != null) {
            System.out.println("El contacto ya existe ");
        } else if (this.addContact(c) != null) {
            System.out.println("Contacto agregado correctamente " + c.getCode());
        } else {
            System.out.println("Se ha producido un error. no se agregó el nuevo contacto. ");
        }
    }

    public Contact addContact(Contact c) {
        this.contacts.put(c.getCode(), c);
        return this.contacts.get(c.getCode());
    }

    public void deleteContact() {
        this.deleteContact(Utils.string("Introduce el código de contacto a eliminar: "));
    }

    public void deleteContact(String code) {
        this.contacts.remove(code);
    }

    public void selectContact() {
        this.showPhonebook();
        String cSelected = Utils.string("Introduce el código del contacto a seleccionar: ");
        if (this.getData().containsKey(cSelected)) {
            this.getData().get(cSelected).showContactMenu();
        } else {
            System.out.println("No existe un contacto con código " + cSelected);
        }
    }

    public void showPhonebook() {
        if (this.contacts.isEmpty()) {
            System.out.println("El directorio telefónico esta vacío ");
        } else {
            System.out.println("## Contactos en la agenda  ##");
            for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
                System.out.println("\t" + entry.getValue().toString());
            }
        }
        System.out.println();
    }

    private String generateMenuOptions() {
        StringBuilder sb = new StringBuilder();
        sb.append("Introduce la opción deseada:\n");
        sb.append("1 - Añadir contacto\n");
        sb.append("2 - Mostrar contactos\n");
        sb.append("3 - Seleccionar contacto\n");
        sb.append("4 - Eliminar contacto\n");
        sb.append("0 - Finalizar programa\n");
        sb.append("Introduce una opción");
        return sb.toString();
    }

    public void showMenu() {
        System.out.println("## Menú de directorio ##");
        int option;
        do {
            option = Utils.integer(this.generateMenuOptions());
            System.out.println();

            switch (option) {
                case 1:
                    this.addContact();
                    break;
                case 2:
                    this.showPhonebook();
                    break;
                case 3:
                    this.selectContact();
                    break;
                case 4:
                    this.deleteContact();
                    break;
                case 0:
                    System.out.println("Saliendo del programa... ");
                    break;
                default:
                    System.out.println("La opción seleccionada no es válida ");
                    break;
            }
        } while (option != 0);
    }

}
