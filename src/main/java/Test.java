import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Test {

    static List<Response> resp = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        int count = 0;
        List<String> list = CrunchifyJSONFlattenerTutorial.flatternJson();

        for(int i = 0 ; i < list.size(); i++){
            JSONObject jObject = new JSONObject(list.get(i));
            HashMap<String, String> map = new HashMap<String, String>();
            Iterator<?> keys = jObject.keys();

            while(keys.hasNext() ){
                String key = (String)keys.next();
                String value = jObject.getString(key);
                map.put(key, value);
            }
            writeDateToCsv(map);


            if (list.size() - 1 == i){
                csvWriter();
            }
        }
    }

    private static void csvWriter() throws IOException {
        File csvOutputFile = new File("src/main/resources/orderLines.csv");

        CsvMapper mapper = new CsvMapper();
        mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);

        CsvSchema schema = CsvSchema.builder().setUseHeader(true)
                .addColumn("partnerLocationId")
                .addColumn("employeeId")
                .addColumn("primaryPhone")
                .addColumn("zipCode")
                .addColumn("city")
                .addColumn("streetAddress1")
                .addColumn("state")
                .addColumn("annualIncome")
                .addColumn("lastName")
                .addColumn("firstName")
                .addColumn("employmentInformationStatus")
                .addColumn("housingInformationMonthlyPayment")
                .addColumn("birthDate")
                .addColumn("ssn")
                .addColumn("recourseEligibilityFlag")
                .addColumn("pudf1")
                .addColumn("pudf2")
                .build();

        ObjectWriter writer = mapper.writerFor(Response.class).with(schema);

        writer.writeValues(csvOutputFile).writeAll(resp);
    }

    private static void writeDateToCsv(HashMap<String, String> map) throws IOException {

        Response res = Response.builder()
                .partnerLocationId(map.get("prefillData.applicationData.referral.partnerLocationId"))
                .employeeId(map.get("prefillData.applicationData.referral.employeeId"))
                .primaryPhone(map.get("prefillData.applicationData.primaryApplicant.primaryPhone"))
                .zipCode(map.get("prefillData.applicationData.primaryApplicant.address.zipCode"))
                .city(map.get("prefillData.applicationData.primaryApplicant.address.city"))
                .streetAddress1(map.get("prefillData.applicationData.primaryApplicant.address.streetAddress1"))
                .state(map.get("prefillData.applicationData.primaryApplicant.address.state"))
                .annualIncome(map.get("prefillData.applicationData.primaryApplicant.financialInformation.annualIncome"))
                .lastName(map.get("prefillData.applicationData.primaryApplicant.name.last"))
                .firstName(map.get("prefillData.applicationData.primaryApplicant.name.first"))
                .employmentInformationStatus(map.get("prefillData.applicationData.primaryApplicant.employmentInformation.status"))
                .housingInformationMonthlyPayment(map.get("prefillData.applicationData.primaryApplicant.housingInformation.monthlyPayment"))
                .birthDate(map.get("prefillData.applicationData.primaryApplicant.birthDate"))
                .ssn(map.get("prefillData.applicationData.primaryApplicant.ssn"))
                .recourseEligibilityFlag(map.get("prefillData.applicationData.recourseEligibilityFlag"))
                .pudf1(map.get("prefillData.applicationData.partnerParams.pudf1"))
                .pudf2(map.get("prefillData.applicationData.partnerParams.pudf2"))
                .build();

        resp.add(res);
    }


    /*{
        "recourseEligibilityFlag":"Y",
            "pudf1":"1009924237",
            "partnerLocationId":"2222",
            "pudf2":"-99",
            "primaryPhone":"4199598999",
            "Tester",
            "prefillData.applicationData.primaryApplicant.address.zipCode":"75075",
            "prefillData.applicationData.primaryApplicant.employmentInformation.status":"RTRD",
            "prefillData.applicationData.referral.employeeId":"Darshan Pate",
            "prefillData.applicationData.primaryApplicant.housingInformation.monthlyPayment":"0",
            "prefillData.applicationData.primaryApplicant.emailAddress":"r@r.com",
            "prefillData.applicationData.primaryApplicant.address.state":"TX",
            "prefillData.applicationData.primaryApplicant.ssn":"666922929",
            "prefillData.applicationData.primaryApplicant.address.city":"Plano",
            "prefillData.applicationData.primaryApplicant.name.first":"John",
            "prefillData.applicationData.primaryApplicant.birthDate":"03/03/1970",
            "prefillData.versionNumber":"1.0",
            "prefillData.applicationData.primaryApplicant.financialInformation.annualIncome":"54555",
            "prefillData.applicationData.primaryApplicant.housingInformation.status":"OWN",
            "prefillData.applicationData.primaryApplicant.address.streetAddress1":"34 King "
    }*/

}
