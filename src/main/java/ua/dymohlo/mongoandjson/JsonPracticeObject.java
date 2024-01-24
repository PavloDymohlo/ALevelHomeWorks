package ua.dymohlo.mongoandjson;

import java.util.Arrays;

public class JsonPracticeObject {
    private String name;
    private int age;

    private String[] address;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getAddress() {
        return address;
    }

    public void setAddress(String[] address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "JsonPracticeObject{" +
               "name='" + name + '\'' +
               ", age=" + age +
               ", address=" + Arrays.toString(address) +
               '}';
    }
}
