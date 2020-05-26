package com.addressbook;
import java.util.*;

public class SortedByField {
    static Map<Parameter, Comparator> sortParameterComparator=new HashMap<>();

    public enum Parameter {
        FIRST_NAME,ZIP;
    }

    SortedByField(){}

    public static Comparator getParameter(SortedByField.Parameter parameter) {

        Comparator<PersonDetails> firstNameComparator=Comparator.comparing(name->name.FirstName);

        Comparator<PersonDetails> ZipComparator=Comparator.comparing(name->name.Zip);

        sortParameterComparator.put(Parameter.FIRST_NAME,firstNameComparator);

        sortParameterComparator.put(Parameter.ZIP,ZipComparator);


        Comparator<PersonDetails> comparator=sortParameterComparator.get(parameter);
        return comparator;
    }
}
