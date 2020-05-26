package com.addressbook;

public class AddressBookException extends Throwable {
    public enum ExceptionType {
        CANNOT_CREATE_FILE,ENTERED_EMPTY,NO_FILE_FOUND,ENTERED_NULL;
    }
    ExceptionType type;

    public AddressBookException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }

}
