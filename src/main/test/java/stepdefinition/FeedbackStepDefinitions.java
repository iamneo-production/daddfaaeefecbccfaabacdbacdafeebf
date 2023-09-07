import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class FeedbackStepDefinitions {

    private WebDriver driver;
    private WebDriverWait wait;

    @Given("the user navigates to JavaTpoint.com")
    public void userNavigatesToJavaTpoint() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);

        driver.get("https://www.javatpoint.com/");
    }

    @When("the user clicks on Feedback")
    public void userClicksOnFeedback() {
        WebElement feedbackLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Feedback")));
        feedbackLink.click();
    }

    @Then("the Feedback page opens")
    public void feedbackPageOpens() {
        assertTrue(driver.getTitle().contains("Feedback")); // Modify this assertion as needed
    }

    @When("the user submits feedback message")
    public void userSubmitsFeedbackMessage() {
        // Locate the feedback form elements and fill them out
        WebElement feedbackForm = driver.findElement(By.id("feedback-form"));
        WebElement nameInput = feedbackForm.findElement(By.id("name"));
        WebElement emailInput = feedbackForm.findElement(By.id("email"));
        WebElement messageInput = feedbackForm.findElement(By.id("message"));
        WebElement submitButton = feedbackForm.findElement(By.id("submit-button"));

        // Fill out the form
        nameInput.sendKeys("John Doe");
        emailInput.sendKeys("johndoe@example.com");
        messageInput.sendKeys("This is a test feedback message.");
        submitButton.click();
    }

    @Then("feedback should be received on the admin page")
    public void feedbackReceivedOnAdminPage() {
        // Implement verification that feedback is received on the admin page
        // You may need to navigate to the admin page and check for the submitted feedback.
        WebElement adminPage = driver.findElement(By.id("admin-page"));
        assertTrue(adminPage.getText().contains("New Feedback: This is a test feedback message."));
    }

    @And("admin can reply to the user")
    public void adminCanReplyToUser() {
        // Implement verification that admin can reply to the user's feedback
        // You may need to navigate to the admin page, locate the feedback, and reply to it.
        WebElement adminPage = driver.findElement(By.id("admin-page"));
        WebElement feedbackItem = adminPage.findElement(By.className("feedback-item"));
        WebElement replyButton = feedbackItem.findElement(By.className("reply-button"));
        
        // Click the reply button
        replyButton.click();
        
        // Locate and fill out the reply form elements
        WebElement replyForm = driver.findElement(By.id("reply-form"));
        WebElement replyMessageInput = replyForm.findElement(By.id("reply-message"));
        WebElement sendReplyButton = replyForm.findElement(By.id("send-reply-button"));
        
        // Fill out and send the reply
        replyMessageInput.sendKeys("Thank you for your feedback!");
        sendReplyButton.click();
    }

    // Add cleanup code to close the WebDriver after the scenario completes
    @After
    public void closeBrowser() {
        driver.quit();
    }
}

