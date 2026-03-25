package za.ac.cput.factory;
import org.apache.commons.validator.routines.EmailValidator;
import za.ac.cput.domain.*;

public class StudentFactory {

    public static Student createStudent(String studentNumber, String studentName, GenderType studentGender, Address address, ContactDetails contactDetails) {

        EmailValidator validator = EmailValidator.getInstance();
        boolean isValidEmail= validator.isValid(contactDetails.getStudentEmail());
        if (isValidEmail == false) {
            return null;
        }

        return new Student.Builder()
                .setStudentNumber(studentNumber)
                .setStudentName(studentName)
                .setContactDetails(contactDetails)
                .setGender(studentGender)
                .setAddress(address)
                .build();
    }

}
