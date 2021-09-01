import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Check {

    public static String cleanStr(String str){
        char quotes = '"';
        int count = 0;
        StringBuilder builder = new StringBuilder();
        for(int i = 0 ; i < str.length() ; i++){
            if(str.charAt(i) == quotes){
                count++;
            }

            if(count < 2){
                builder.append(str.charAt(i));
            }
            if(count == 2){
                count = 0;
            }
        }
        return new String(builder);
    }


    public static void writeCleanDataToFile() throws IOException {
        File file = new File("src/main/resources/orderLinesss.txt");
        FileWriter writer = new FileWriter("src/main/resources/cleanData.txt");

        BufferedReader br = new BufferedReader(new FileReader(file));

        String st;

        while ((st = br.readLine()) != null){
            writer.write(cleanStr(st));
            writer.write("\n");
           /* BufferedWriter wr = new BufferedWriter(new FileWriter(cleanData));
            wr.write(cleanStr(st));*/
        }

        writer.close();
    }

    public static void main(String[] args) throws IOException {
        String check ="\"\"kjhawdkjhawd\"\"";
        System.out.println(cleanStr("{\"\"prefillData\"\":{\"\"versionNumber\"\":\"\"1.0\"\",\"\"applicationData\"\":{\"\"primaryApplicant\"\":{\"\"name\"\":{\"\"first\"\":\"\"John\"\",\"\"last\"\":\"\"Tester\"\"},\"\"address\"\":{\"\"streetAddress1\"\":\"\"34 King \"\",\"\"city\"\":\"\"Plano\"\",\"\"state\"\":\"\"TX\"\",\"\"zipCode\"\":\"\"75075\"\"},\"\"primaryPhone\"\":\"\"4199598999\"\",\"\"emailAddress\"\":\"\"r@r.com\"\",\"\"employmentInformation\"\":{\"\"status\"\":\"\"RTRD\"\"},\"\"housingInformation\"\":{\"\"monthlyPayment\"\":\"\"0\"\",\"\"status\"\":\"\"OWN\"\"},\"\"financialInformation\"\":{\"\"annualIncome\"\":\"\"54555\"\"},\"\"ssn\"\":\"\"666922929\"\",\"\"birthDate\"\":\"\"03/03/1970\"\"},\"\"recourseEligibilityFlag\"\":\"\"Y\"\",\"\"referral\"\":{\"\"employeeId\"\":\"\"Darshan Pate\"\",\"\"partnerLocationId\"\":\"\"2222\"\"},\"\"partnerParams\"\":{\"\"pudf1\"\":\"\"1009924237\"\",\"\"pudf2\"\":\"\"-99\"\"}}}}\n"));
    }
}
