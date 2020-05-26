package com.addressbook;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;


public class AddressBookTest {
    AddressBookAnalysis addressBookAnalyser = new AddressBookAnalysis();

    @Test
    public void givenFileNametoCreate_whenNotExist_shouldCreateFileAndReturnTrue() {
        try {

            Assert.assertEquals(true, addressBookAnalyser.createFile("MyAddress.json"));
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenFileNametoCreate_whenExists_shouldNotCreateFileAndReturnFalse() {
        try {

            Assert.assertEquals(false, addressBookAnalyser.createFile("MyAddress.json"));
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenFile_whenAddPersonDetails_shouldReturnPersonMobileNumber() {
        PersonDetails personDetails=new PersonDetails("amit", "kumar", "patna", "patna", "Bihar", "411048", "7758039722");
        Assert.assertEquals("7758039722", addressBookAnalyser.addPersonDetailsInFile(personDetails).iterator().next().getPhoneNumber());
    }
    @Test
    public void givenFile_whenAddPersonDetails_shouldReturnFullName() {
        PersonDetails personDetails=new PersonDetails("amit", "kumar", "patna", "patna", "Bihar", "411048", "7758039722");
        Assert.assertEquals("amit kumar", addressBookAnalyser.addPersonDetailsInFile(personDetails).iterator().next().getFullName());
    }
    @Test
    public void givenFileName_whenSavePersonDetails_shouldWriteIntoJson() {
        try {
            PersonDetails personDetails = new PersonDetails("Rahul", "Wamankar", "Kondhwa", "Pune", "Maharashtra", "411048", "7758039722");
            Assert.assertEquals(true, addressBookAnalyser.save("MyAddress.json",addressBookAnalyser.addPersonDetailsInFile(personDetails)));
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenFileName_whenReadPersonDetails_shouldReadPersonDetailsFromJson(){
        try {
            List<PersonDetails> list =addressBookAnalyser.readPersonInfo("MyAddress.json");
            Assert.assertEquals(true,addressBookAnalyser.checksizeofList(list));
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenWrongFileName_whenReadPersonDetails_shouldReturnCustomException(){
        try {

            addressBookAnalyser.readPersonInfo("WrongAddress.json");
        } catch (AddressBookException e) {
            Assert.assertEquals(AddressBookException.ExceptionType.NO_FILE_FOUND,e.type);
        }
    }
    @Test
    public void givenEmptyFileName_whenReadPersonDetails_shouldReturnCustomException(){
        try {
            addressBookAnalyser.readPersonInfo("");
        } catch (AddressBookException e) {
            Assert.assertEquals(AddressBookException.ExceptionType.ENTERED_EMPTY,e.type);
        }
    }
    @Test
    public void givenNullFileName_whenReadPersonDetails_shouldReturnCustomException(){
        try {
            addressBookAnalyser.readPersonInfo(null);
        } catch (AddressBookException e) {
            Assert.assertEquals(AddressBookException.ExceptionType.ENTERED_NULL,e.type);
        }
    }
    @Test
    public void givenFileName_whenDeletedPersonDetails_shouldDeletePersonandReturnTrue() {
        try {
            Assert.assertEquals(true,addressBookAnalyser.deletingPersonDetails("MyAddress.json","Rahul"));
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenFileName_whenEditPersonDetails_shouldReturnUpdatedDetails() {
        try {
            PersonDetails personDetails = new PersonDetails("Amit", "umar", "pune", "pune", "Maharashtra", "411048", "8806787166");
            Assert.assertEquals(true, addressBookAnalyser.editingPersonDetails("7758039722", "MyAddress.json", personDetails));
        } catch (AddressBookException e) {
            e.printStackTrace();
        }
    }



}
