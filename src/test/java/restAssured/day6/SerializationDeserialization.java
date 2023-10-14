package restAssured.day6;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.IOException;


//Pojo -SERIALIZATION-> JSON Object -DESERIALIZATION-> Pojo
public class SerializationDeserialization {
    String jsonData;
    @Test(priority = 1)
    void convertPojoToJson() throws JsonProcessingException {

        //Create Java Object using POJO class
        String[] coureArray = {"C#", "Java"};
        Student data = new Student("Hunter", "Da Nang", "0983918891", coureArray);

        //Convert Java Object to JSON Object (Serialization)
        ObjectMapper objectMapper = new ObjectMapper();
        jsonData = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
        System.out.println(jsonData);
    }

    @Test(priority = 2)
    void convertJsonToPojo() throws IOException {

        //Convert JSON Object to Java Object (Deserialization)
        ObjectMapper objectMapper = new ObjectMapper();
        Student student = objectMapper.readValue(jsonData, Student.class);
        student.showStudentInfo();
    }
}
