package edu.app.tests.pojos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.junit.Test;

public class PojosExample {
    @Test
    public void test(){
        //serialization example
        Person person = new Person();
        person.setName("Carlos");
        person.setSurname("OConnor");
        person.setGender("male");
        person.setRegion("United States");
        System.out.println("Printing person object: "+ person);

        Gson gson = new Gson();
        String json = gson.toJson(person);
        System.out.println("Printing json object: " + json );

        //deserialization
        //taking json object and converting it into java object
        String myJasonString = "{\"name\":\"Carlos\"," +
                               "\"surname\":" + "\"OConnor\"," +
                               "\"gender\":\"male\"," +
                              "\"region\":\"United States\"}";

        Person myPerson = gson.fromJson(myJasonString, Person.class);
        System.out.println("Printing new person java object: "+ myPerson );
    }
    @Test
    public void test2() throws JsonProcessingException {
        //jackson databind example with ObjectMapper
        //serialization example
        Person person = new Person();
        person.setName("Carlos");
        person.setSurname("OConnor");
        person.setGender("male");
        person.setRegion("United States");

        System.out.println("Printing person object: "+ person);
        // converting java object into json
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(person);
        System.out.println("printing my json String: " + json);

        //deserialization --> converting json object into java
        String myJasonString = "{\"name\":\"Carlos\"," +
                                "\"surname\":" + "\"OConnor\"," +
                                "\"gender\":\"male\"," +
                                "\"region\":\"United States\"}";

        Person myPerson = objectMapper.readValue(myJasonString,Person.class );
        System.out.println("Printing java person object: "+ myPerson);
    }
}
