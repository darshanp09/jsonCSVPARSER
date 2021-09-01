import com.github.wnameless.json.flattener.JsonFlattener;
import com.github.wnameless.json.unflattener.JsonUnflattener;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class CrunchifyJSONFlattener {

    public static List<String> flatternJson(){
        JSONParser parser = new JSONParser();
        List<String> flattenedJsons = new ArrayList<>();
        try {

		/*	crunchify.txt file content

			{
				"Name": "crunchify.com",
				"Author": "App Shah",
				"Address": "New York",
				"Company Services": [{
					"Service": "Site SEO Review",
					"Link": "https://crunchify.com/services/site-seo-review-service/"
				}, {
					"Service": "Full Website Design Service",
					"Link": "https://crunchify.com/services/full-website-design-service/"
				}, {
					"Service": "WordPress Optimization & Consultation",
					"Link": "https://crunchify.com/services/wordpress-optimization-service/"
				}]
			}
		*/
            //BufferedReader br = new BufferedReader(new FileReader("src/main/resources/orderLiness.txt"));
            String st;
                // Put above JSON content to crunchify.txt file and change path location
                Object obj = parser.parse(new FileReader("src/main/resources/orderLines.json"));
                JSONObject jsonObject = (JSONObject) obj;

                // JsonFlattener: A Java utility used to FLATTEN nested JSON objects
                // The String class represents character strings. All string literals in Java programs, such as "abc", are implemented as instances of this class.
                String flattenedJson = JsonFlattener.flatten(jsonObject.toString());

                flattenedJsons.add(flattenedJson);

                Map<String, Object> flattenedJsonMap = JsonFlattener.flattenAsMap(jsonObject.toString());

                // We are using Java8 forEach loop. More info: http://crunchify.me/1VIwm0l
                // flattenedJsonMap.forEach((k, v) -> log(k + " : " + v));

                // Unflatten it back to original JSON
                String nestedJson = JsonUnflattener.unflatten(flattenedJson);
                //System.out.println("\n===== Unflatten it back to original JSON ===== \n" + nestedJson);

                System.out.println(flattenedJson);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return flattenedJsons;
    }

    public static void main(String[] args) {
        flatternJson();
    }
}
