import Pages.FormPage;
import Pages.User;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class FormTest extends BaseTest {
    private static Logger log = LoggerFactory.getLogger("FormTest.class");
    FormPage formPage = new FormPage(driver);


    @Test
    public void shouldFillFormWithSuccess() {
        formPage.fillForm(User.getDataForForm());
//        formPage.setFirstName(System.getProperty("firstName"))
//                .setLastName(System.getProperty("lastName"))
//                .setEmail(System.getProperty("email"))
//                .chooseSex()
//                .setAge(System.getProperty("age"))
//                .chooseExperience()
//                .chooseProfession(Integer.parseInt(System.getProperty("profession")))
//                .selectContinent(System.getProperty("continent"))
//                .selectSeleniumComands(System.getProperty("seleniumCommand1"), System.getProperty("seleniumCommand2"))
//                .attachFile(System.getProperty("path"));
        formPage.submitForm();
        String msg = formPage.getValidatorMsg();
        log.info("Validator message is: " + msg);
        assertThat(msg, equalTo(System.getProperty("expectedMsg")));
    }

}
