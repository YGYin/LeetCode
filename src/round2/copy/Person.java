package round2.copy;

public class Person implements Cloneable {
    private Address address;

    @Override
    public Person clone() {
        try {
            Person person = (Person) super.clone();
            person.address = person.address.clone();
            return person;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
