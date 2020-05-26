package com.addressbook;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AddressBookAnalysis {
    ArrayList<PersonDetails> personInformation = new ArrayList<PersonDetails>();

    public boolean createFile(String fileName) throws AddressBookException {
        try {
            if (fileName.length() == 0)
                throw new AddressBookException("File Name Cannot be empty", AddressBookException.ExceptionType.ENTERED_EMPTY);
            File files = new File("./src/main/java/com/addressbook/json/" + fileName);
            boolean isFileExist = files.exists();
            if (isFileExist) {
                return false;
            }
            files.createNewFile();
            return true;
        } catch (IOException e) {
            throw new AddressBookException("Cannot Create File in path", AddressBookException.ExceptionType.CANNOT_CREATE_FILE);
        }
    }

    public ArrayList<PersonDetails> addPersonDetailsInFile(PersonDetails personDetails) {
        personInformation.add(personDetails);
        return personInformation;
    }
}
