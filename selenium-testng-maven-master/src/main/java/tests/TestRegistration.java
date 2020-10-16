package tests;

//Imports
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageFactory.Registration;


/*
 * Test Registration Class holds all test cases related to registration form testing
 * Call to the tests in managed in testng.xml file
 */
public class TestRegistration {

    WebDriver driver;

    Registration objRegistrationPage; 
    
	String path = System.getProperty("user.dir");   

	String driverPath = path + "\\chromedriver\\chromedriver.exe"; 
 
    // Setup the driver and Switch to the form view
    @BeforeTest
    public void setup(){

        System.setProperty("webdriver.chrome.driver", driverPath);
        
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.jotform.com/form-templates/class-registration-3");
        
        driver.manage().window().maximize();
        
        driver.switchTo().frame(this.driver.findElement(By.xpath("//*[@id=\"formPreviewArea\"]")));

    }

    // Test First Name Field is displayed on the Registration Form
    @Test(priority = 0)
    public void testFirstname(){

    objRegistrationPage = new Registration(driver);

	    WebElement registrationFirstName = objRegistrationPage.getFirstNameField();
		
	    boolean isPresent = registrationFirstName.isDisplayed();
	    
	    Assert.assertEquals(true, isPresent);
	    
	    if (isPresent) {
	    	
	    	registrationFirstName.sendKeys("Kanwar");
	    	
	    	}	
    }

    // Test Middle Name Field is displayed on the Registration Form
    @Test(priority = 0)
    public void testMiddlename(){

	    objRegistrationPage = new Registration(driver);
	
	    WebElement registrationMiddleName = objRegistrationPage.getMiddleNameField();
		
	    boolean isPresent = registrationMiddleName.isDisplayed();
	    
	    Assert.assertEquals(true, isPresent);
	    
	    if (isPresent) {
	    	
	    	registrationMiddleName.sendKeys("Pal");
	    	
	    	}	
    }    
    
    // Test Last Name Field is displayed on the Registration Form
    @Test(priority = 0)
    public void testLastname(){

	    objRegistrationPage = new Registration(driver);
	    
	    WebElement registrationLastName = objRegistrationPage.getLastNameField();
	    
	    boolean isPresent = registrationLastName.isDisplayed();
	    
	    Assert.assertEquals(true, isPresent);
	    
	    if (isPresent) {
	    	
	    	registrationLastName.sendKeys("Sandhu");
	    	
	    	}	
    }
    
    // Test Email Field is displayed on the Registration Form
    @Test(priority = 1)
    public void testEmail(){

	    objRegistrationPage = new Registration(driver);
	
	    WebElement registrationEmail = objRegistrationPage.getEmailField();
		
	    boolean isPresent = registrationEmail.isDisplayed();
	    
	    Assert.assertEquals(true, isPresent);
	    
	    if (isPresent) {
	    	
	    	registrationEmail.sendKeys("kanwar.sandhu505@gmail.com");
	    	
	    	}	
    }

    // Test required Course is displayed on the Registration Form
    @Parameters({ "course" })
    @Test(priority = 2)
    public void tesCourse(String course) {

    	objRegistrationPage = new Registration(driver);
    	
    	WebElement registrationCourse = objRegistrationPage.getCourse();
    	
    	String value = registrationCourse.getAttribute("value");
    	
    	System.out.print(value);
    	
    	Assert.assertTrue(value.equals(course));
    	
    }
    
    // Test redirect lands back on the Registration Form
    @Test(priority = 3)
    public void tesStudentRegisterForm() {

    	objRegistrationPage = new Registration(driver);
    	
        WebElement registrationForm = objRegistrationPage.getRegistrationForm();
    	
        boolean isPresent = registrationForm.isDisplayed();
        
        Assert.assertEquals(true, isPresent);
    }   
    	
    // Close the driver and browser after testing 
    @AfterClass(alwaysRun = true)
    protected void tearDown() {
    	
    	driver.quit();
    
    }
      
}
    
