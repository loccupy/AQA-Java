package repoPhoneBook;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {

    private HashMap<String, String> directory;

    public PhoneBook () {
        this.directory = new HashMap<>();
    }

    public void add (String surname, String phoneNumber) {
        directory.put(phoneNumber, surname);
    }

    public HashMap<String, String> getDirectory () {
        return this.directory;
    }

    public void displayDirectory () {
        for (Map.Entry<String, String> tmp : this.directory.entrySet()) {
            System.out.println("surname: " + tmp.getValue() + 
            " // phone number: " + tmp.getKey());
        }
    }

    public void get (String surname) {
        for (Map.Entry<String, String> tmp : this.directory.entrySet()) {
            if(tmp.getValue().equals(surname))
            System.out.println("surname: " + tmp.getValue() + 
            " // phone number: " + tmp.getKey());
        }
    }
}
