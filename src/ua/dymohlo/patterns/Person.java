package ua.dymohlo.patterns;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Cloneable {
    private String firstName;
    private String lastName;
    private Address address;

    public Object clone() {
        Person clonePerson = null;
        try {
            clonePerson = (Person) super.clone();
            clonePerson.address = (Address) address.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return clonePerson;
    }
}
