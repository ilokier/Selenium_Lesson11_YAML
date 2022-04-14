import Pages.FormPage;
import Pages.User;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class FormTest extends BaseTest {
    FormPage formPage = new FormPage(driver);

    @Test
    public void shouldFillFormWithSuccess() {
        formPage.fillForm(User.getDataForForm());
        formPage.submitForm();
        assertThat(formPage.getValidatorMsg(), equalTo(System.getProperty("expectedMsg")));
    }
}
