package com.addressbook;
import java.io.*;
import java.util.ArrayList;
import com.google.gson.Gson;
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

    public boolean save(String fileName, ArrayList<PersonDetails> personDetails) throws AddressBookException {
            try {
                if (fileName.length() == 0)
                    throw new AddressBookException("File Name Cannot be empty", AddressBookException.ExceptionType.ENTERED_EMPTY);
                File file = new File("./src/main/java/com/bridgelabz/addressbook/json/" + fileName);
                if (file.exists()) {
                    Gson gson = new Gson();
                    String json = gson.toJson(personDetails);
                    FileWriter writer = null;
                    writer = new FileWriter("./src/main/java/com/bridgelabz/addressbook/json/" + fileName);
                    writer.write(json);
                    writer.close();
                    return true;
                }

            } catch (IOException e) {
                throw new AddressBookException("Cannot Save in the File", AddressBookException.ExceptionType.NO_FILE_FOUND);
            } catch (AddressBookException e) {
                e.printStackTrace();
            }
            return false;
        }

    public ArrayList<PersonDetails> readPersonInfo(String fileName) throws AddressBookException, AddressBookException {
        try {
            if (fileName.length() == 0)
                throw new AddressBookException("File Name Cannot be empty", AddressBookException.ExceptionType.ENTERED_EMPTY);
            File file = new File("./src/main/java/com/bridgelabz/addressbook/json/" + fileName);
            if (file.exists()) {
                Gson gson = new Gson();
                BufferedReader br = null;
                br = new BufferedReader(new FileReader(file));
                PersonDetails[] personDetails = gson.fromJson(br, PersonDetails[].class);
                for (int i = 0; i < personDetails.length; i++) {
                    personInformation.add(personDetails[i]);
                }
            }

        } catch (NullPointerException e) {
            throw new AddressBookException("File Name Cannot be Null", AddressBookException.ExceptionType.ENTERED_NULL);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return personInformation;
    }

    public boolean checksizeofList(List<PersonDetails> list) {
        if (list.size() != 0)
            return true;
        return false;
    }

    public boolean deletingPersonDetails(String fileName, String firstName) throws AddressBookException {
        try {
            if (fileName.length() == 0)
                throw new AddressBookException("File Name Cannot be empty", AddressBookException.ExceptionType.ENTERED_EMPTY);
            File file = new File("./src/main/java/com/bridgelabz/addressbook/json/" + fileName);
            List<PersonDetails> personDetailsList = readPersonInfo(fileName);
            for (PersonDetails personDetails1 : personDetailsList) {
                if (personDetails1.getFirstName().equals(firstName)) {
                    personDetailsList.remove(personDetails1);
                    Gson gson = new Gson();
                    String json = gson.toJson(personDetailsList);
                    FileWriter writer = new FileWriter(file);
                    writer.write(json);
                    writer.close();
                    return true;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean editingPersonDetails(String phoneNumber, String fileName, PersonDetails personDetails) throws AddressBookException {
        List<PersonDetails> personList = readPersonInfo(fileName);
        File file = new File("./src/main/java/com/bridgelabz/addressbook/json/" + fileName);
        try {
            for (PersonDetails person : personList) {
                if (person.getPhoneNumber().equals(phoneNumber)) {
                    person.AssignFirstName(personDetails.getFirstName());
                    person.AssignLastName(personDetails.getLastName());
                    person.AssignAddress(personDetails.getAddress());
                    person.AssignCity(personDetails.getCity());
                    person.AssignState(personDetails.getState());
                    person.AssignZip(personDetails.getZip());
                    person.AssignPhoneNumber(personDetails.getPhoneNumber());
                    Gson gson = new Gson();
                    String json = gson.toJson(personList);
                    FileWriter writer = null;
                    writer = new FileWriter(file);
                    writer.write(json);
                    writer.close();
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}

