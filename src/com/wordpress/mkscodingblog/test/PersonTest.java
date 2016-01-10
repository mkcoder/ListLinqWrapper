package com.wordpress.mkscodingblog.test;

import com.wordpress.mkscodingblog.impl.ListWrapperImpl;
import com.wordpress.mkscodingblog.wrapper.ListWrapper;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PersonTest {
    List<PersonMock> people;
    ListWrapper<PersonMock> personMockListWrapper;

    @Before
    public  void init() {
        people = new ArrayList<PersonMock>();
        people.add(new PersonMock("Paul", "Abdul", (byte)23, 999999999L));
        people.add(new PersonMock("John", "Doe", (byte)34, 999999991L));
        people.add(new PersonMock("Mark", "Long", (byte)42, 999999999L));
        people.add(new PersonMock("Pat", "Long", (byte)48, 999999992L));
        people.add(new PersonMock("Amy", "Lu", (byte)36, 9999999993L));
        people.add(new PersonMock("Amy", "Lu", (byte)84, 9999999993L));
        personMockListWrapper = new ListWrapperImpl<>(people);
    }

    @Test
    public void SelectForEachLambdaTest() {
        assert people.size() > 0;
        assert personMockListWrapper != null;
        personMockListWrapper.select((p) -> p.age >= 40).forEach(p -> System.out.println(p));
        personMockListWrapper.forEach(p -> p.age());
        personMockListWrapper.forEach(p -> System.out.println(p));
    }
}

class PersonMock {
    String firstName;
    String lastName;
    byte age;
    long ssn;
    boolean dead = false;

    public PersonMock(String firstName, String lastName,
                      byte age, long ssn) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.ssn = ssn;
    }

    public void age() {
        if ( !dead )
        {
            this.age++;
            if ( age >= 85 ) dead = true;
            else if ( ((int)(Math.random() * 86)) == age)  { dead = true; }
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public long getSsn() {
        return ssn;
    }

    public void setSsn(long ssn) {
        this.ssn = ssn;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    @Override
    public String toString() {
        return "PersonMock{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", ssn=" + ssn +
                ", dead=" + dead +
                '}';
    }
}