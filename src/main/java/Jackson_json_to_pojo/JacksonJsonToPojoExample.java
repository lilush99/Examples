package Jackson_json_to_pojo;

import java.io.File;
import java.io.IOException;
import java.net.*;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonJsonToPojoExample {

    public static void main(String[] args) {
        JacksonJsonToPojoExample obj = new JacksonJsonToPojoExample();
        obj.run();
    }

    private void run() {
        ObjectMapper mapper = new ObjectMapper();

        try {

            // Convert JSON string from file to Object
            Staff staff = mapper.readValue(new File("staff.json"), Staff.class);
            System.out.println(staff);

            // Convert JSON string to Object
            String jsonInString = "{\"name\":\"Eyal\",\"salary\":7500,\"skills\":[\"java\",\"Sql\"]}";
            Staff staff1 = mapper.readValue(jsonInString, Staff.class);
            System.out.println(staff1);

            //JSON from URL to Object
            //Staff staff2 = mapper.readValue(new URL("http://mkyong.com/api/staff.json"), Staff.class);
            //System.out.println("From URL:\n" + staff2);

            //Pretty print
            String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff1);
            System.out.println(prettyStaff1);

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
