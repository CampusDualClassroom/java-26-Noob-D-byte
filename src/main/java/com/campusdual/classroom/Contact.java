package com.campusdual.classroom;

import com.campusdual.util.Utils;

import java.text.Normalizer;


public class Contact implements ICallActions {
    //Properties
    private String name;
    private String surnames;
    private String phone;
    private String code;

    //Constructor
    public Contact(String name, String surnames, String phone) {
        this.name = name;
        this.surnames = surnames;
        this.phone = phone;
        this.code = generateCode(this.name, this.surnames);
    }
//Getters e seetters

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return this.surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    //Métodos suscritos da ICallActions
    @Override
    public void callMyNumber() {
        System.out.println(this.getName() + " " + this.getSurnames() + " se está llamando a sí mismo al número " + this.getPhone());
    }

    @Override
    public void callOtherNumber(String number) {
        System.out.println(this.getName() + " " + this.getSurnames() + " está llamando al número " + number);
    }

    @Override
    public void showContactDetails() {
        System.out.println("Detalles del contacto: ");
        System.out.println("Nombre: " + this.getName());
        System.out.println("Apellidos: " + this.getSurnames());
        System.out.println("Teléfono: " + getPhone());
        System.out.println("Code: " + getCode());
    }

    @Override
    public String toString() {
        return "Código: " + this.getCode() + " " + " Nombre: " + this.getName() + " Apellidos: " + this.getSurnames() + " Teléfono: " + this.getPhone();
    }
//Outros métodos públicos
    public void showContactMenu() {
        int option;

        System.out.println("##Menú de Contacto##");

        do {
            option = Utils.integer(this.generateContactMenuOptions());
            switch (option) {
                case 1:
                    this.callMyNumber();
                    break;
                case 2:
                    this.callOtherNumber(Utils.string("Introduzca el número al que va a llamar: "));
                    break;
                case 3:
                    this.showContactDetails();
                    break;
                case 4:
                    this.updateDefaultPhone();
                    break;
                default:
                    System.out.println("La opción seleccionada no es válida. ");
            }
        } while (option != 0);
    }

//Métodos privados
    private String generateCode(String name, String surnames) {
        StringBuilder sb = new StringBuilder();
        sb.append(normalizeString(name).charAt(0));
        String[] splitedSurnames = normalizeString(surnames).split("\\s+");

        if (splitedSurnames.length == 1) {
            sb.append(splitedSurnames[0]);
        } else {
            sb.append(splitedSurnames[0].charAt(0));
            for (int i = 1; i < splitedSurnames.length; i++) {
                sb.append(splitedSurnames[i]);
            }
        }
        return sb.toString();
    }

    private String normalizeString(String string) {
        return Normalizer.normalize(string, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}", "").toLowerCase();
    }

    private void updateDefaultPhone() {
        this.setPhone(Utils.string("Introduzca el nuevo número principal: "));
    }

    private String generateContactMenuOptions() {

        return "## Menú de Contacto ##\n" +
                "1 - Llamar a mi número\n" +
                "2 - Llamar a otro número\n" +
                "3 - Mostrar detalles del contacto\n" +
                "4 - Actualizar número de teléfono\n" +
                "0 - Volver al menú principal\n" +
                "Introduce una opción:";
    }
}
