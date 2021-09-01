import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Response {
    
    private String partnerLocationId;
    private String employeeId;
    private String primaryPhone;
    private String zipCode;
    private String city;
    private String streetAddress1;
    private String state;
    private String annualIncome;
    private String lastName;
    private String firstName;
    private String employmentInformationStatus;
    private String housingInformationMonthlyPayment;
    private String birthDate;
    private String ssn;
    private String recourseEligibilityFlag;
    private String pudf1;
    private String pudf2;


}
