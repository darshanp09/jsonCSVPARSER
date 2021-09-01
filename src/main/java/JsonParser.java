import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.json.*;
import java.io.IOException;

public class JsonParser {

    public static void main(String[] args) throws IOException {

        JsonNode jsonTree = new ObjectMapper().readTree(new File("src/main/resources/orderLines.json"));
        CsvSchema.Builder csvSchemaBuilder = CsvSchema.builder();
        JsonNode firstObject = jsonTree.elements().next();
        firstObject.fieldNames().forEachRemaining(fieldName -> {
            csvSchemaBuilder.addColumn(fieldName);
        });
        CsvSchema csvSchema = csvSchemaBuilder.build().withHeader();

        CsvMapper csvMapper = new CsvMapper();
        csvMapper.writerFor(JsonNode.class)
                .with(csvSchema)
                .writeValue(new File("src/main/resources/orderLines.csv"), jsonTree);

        /*String jsonArrayString = "{\"fileName\": [{\"first name\": \"Ravi\",\"last name\": \"Chandra\",\"location\": \"Bangalore\"}]}";
        JSONObject output;
        try {
            output = new JSONObject(jsonArrayString);
            JSONArray docs = output.getJSONArray("fileName");
            File file = new File("EmpDetails.csv");
            String csv = CDL.toString(docs);
            FileUtils.writeStringToFile(file, csv);
            System.out.println("Data has been Sucessfully Writeen to "+ file);
            System.out.println(csv);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }*/
    }
}
