package sample.model.database;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import sample.model.bankClass.Klient;

import java.io.File;
import java.io.IOException;

public class JacksonCoverterToJSON {

    public static void saveJSON(Klient obj){
        ObjectMapper mapper = new ObjectMapper();
        String filename = obj.getStringId();

        try {
            // Convert object to JSON string and save into a file directly
            mapper.writeValue(new File(filename+".json"), obj);

            // Convert object to JSON string
            String jsonInString = mapper.writeValueAsString(obj);
            System.out.println(jsonInString);

            // Convert object to JSON string and pretty print
            jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(obj);
            System.out.println(jsonInString);

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
