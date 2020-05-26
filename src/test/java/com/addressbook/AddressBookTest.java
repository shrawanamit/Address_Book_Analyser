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
}
