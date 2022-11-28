import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class testCreateNewP {
    
    @test
    public void patientListIsNotEmpty(){
        ManagePatients patients = new ManagePatients();
        Patient pat = null;
        String cpf = "123.456.789-10";
        String name = "Leuson";
        String healthPlan = "UNIMED";
        pat = new PatientWithInsurance(cpf, name, healthPlan);
        patients.insertPatient(pat);
        boolean trueOrFalse = patients.isEmpty();
        boolean expected = false;
        Assetions.assertEquals(expected, trueOrFalse);
    }

}
