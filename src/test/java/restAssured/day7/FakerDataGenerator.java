package restAssured.day7;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerDataGenerator {

    @Test
    void testGenerateDummyData(){
        Faker faker = new Faker();
        String fullName = faker.name().fullName();
        String address = faker.address().fullAddress();
        System.out.println("Full Name: " +fullName);
        System.out.println("Address: "+address);
        System.out.println("Username: "+faker.name().username());
        System.out.println("Password: "+faker.internet().password());
        System.out.println("Phone: "+faker.phoneNumber().cellPhone());
        System.out.println("Email: "+faker.internet().safeEmailAddress());
    }
}
