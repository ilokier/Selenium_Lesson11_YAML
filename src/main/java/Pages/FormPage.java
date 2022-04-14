package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Random;


public class FormPage {
    private WebDriverWait wait;
    @FindBy(id = "validator-message")
    WebElement validatorMsg;
    @FindBy(css = "#inputFirstName3")
    private WebElement firstName;
    @FindBy(id = "inputLastName3")
    private WebElement lastName;
    @FindBy(css = "#inputEmail3")
    private WebElement eMail;
    @FindBy(id = "inputAge3")
    private WebElement age;
    @FindBy(id = "gridRadios1")
    private List<WebElement> yearsOfExp;
    @FindBy(id = "gridRadiosMale")
    private List<WebElement> sex;
    @FindBy(css = ".checkbox-profession")
    private List<WebElement> professionList;
    @FindBy(id = "gridCheckAutomationTester")
    private WebElement proFessionAutomate;
    @FindBy(id = "selectContinents")
    private WebElement selectContinent;
    @FindBy(id = "selectSeleniumCommands")
    private WebElement seleniumComands;
    @FindBy(id = "chooseFile")
    private WebElement fileInput;
    @FindBy(id = "additionalInformations")
    private WebElement additionalInformation;
    @FindBy(css = ".btn-secondary")
    private WebElement testFileDownloadButton;
    @FindBy(css = ".btn-primary")
    private WebElement signInButton;

    private static Logger log = LoggerFactory.getLogger("FormPage.class");

    public FormPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public String getValidatorMsg() {
        String msg = validatorMsg.getText();
        log.info("Validator message is: " + msg);
        return msg;
    }


    public FormPage attachFile(String path) {
        File file = new File(path);
        fileInput.sendKeys(file.getAbsolutePath());
        return this;
    }

    public FormPage submitForm() {
        signInButton.click();
        return this;
    }

    public WebElement getRandomElement(List<WebElement> elements) {
        return elements.get(new Random().nextInt(elements.size()));
    }

    public void chooseSelectOption(String value, WebElement el) {
        Select sel = new Select(el);
        sel.selectByValue(value);
    }

    public Pages.FormPage fillForm(ModelForm modelForm) {
        firstName.sendKeys(modelForm.getName());
        lastName.sendKeys(modelForm.getLastName());
        eMail.sendKeys(modelForm.getEmail());
        getRandomElement(sex).click();
        age.clear();
        age.sendKeys(modelForm.getAge());
        getRandomElement(yearsOfExp).click();
        professionList.get(modelForm.getProfession()).click();
        chooseSelectOption(modelForm.getContinent(), selectContinent);
        chooseSelectOption(modelForm.getSeleniumCommand1(), seleniumComands);
        chooseSelectOption(modelForm.getSeleniumCommand2(), seleniumComands);
        attachFile(modelForm.getPath());

        return this;
    }

}




