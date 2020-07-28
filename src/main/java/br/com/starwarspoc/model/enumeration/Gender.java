package br.com.starwarspoc.model.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum Gender {

    MALE("male", "Male"),
    FEMALE("female", "Female"),
    HERMAPHRODITE("hermaphrodite", "Hermaphrodite"),
    NONE("none", "None"),
    UNDEFINED("n/a", "N/A");

    private String gender;
    private String camelCaseGender;

    public static String getfromString(String enumeration){
        return Stream.of(values())
          .filter(value -> value.getGender().equals(enumeration))
          .map(Gender::getCamelCaseGender)
          .findFirst().orElseThrow(() -> new RuntimeException());
    }

}
