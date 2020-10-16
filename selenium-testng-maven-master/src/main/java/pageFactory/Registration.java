package pageFactory;

//Imports 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 * Registration Class acts as factory for Web elements for  
 * registration page and provide logic for getting elements
 * and actions to be performed on those elements 
 */
public class Registration {

    WebDriver driver;
   
    //Element locators using page factory
    @FindBy(id = "first_4")
    WebElement FirstNameField;    

    @FindBy(id = "middle_4")
    WebElement MiddleNameField;
    
    @FindBy(id = "last_4")
    WebElement LastNameField;
   
    @FindBy(id = "input_6")
    WebElement EmailField;
       
    @FindBy(id = "input_46")
    WebElement CourseDropDown;
    
    @FindBy(xpath=" //*[@id=\"input_46\"]/option[10]")
    WebElement Course;
    
    @FindBy(id = "input_20")
    WebElement SubmitButton;
    
    @FindBy(id = "header_1")
    WebElement RegisterFormHeader;
    
    //Initialize elements using current driver
    public Registration(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }   
    
    // Get the First Name Field element   
    public WebElement getFirstNameField(){
    	
    	return FirstNameField;   	
    }
    
    //Get the Middle Name Field element 
    public WebElement getMiddleNameField(){
    	
    	return MiddleNameField; 	
    }
    
   //Get the Last Name Field element
    public WebElement getLastNameField(){
    	
    	return LastNameField;	
    }
    
   //Get the Email Field element
    public WebElement getEmailField(){
    	
    	return EmailField;	
    }
    
    //Get the Course Field element and click on required course
    public WebElement getCourse(){
    	
    	JavascriptExecutor js = (JavascriptExecutor) this.driver;	
    	
        js.executeScript("arguments[0].scrollIntoView();", CourseDropDown);
        
        CourseDropDown.click();
        
        Course.click();
    	
        return Course;	
    }
    
    //Submit form and return form header after redirect 
    public WebElement getRegistrationForm(){
    	
    	SubmitButton.click();
    	
    	WebDriverWait wait = new WebDriverWait(driver, 10);
    	
    	wait.until(ExpectedConditions.visibilityOf(FirstNameField));
    	
    	JavascriptExecutor js = (JavascriptExecutor) this.driver;		
        
    	js.executeScript("arguments[0].scrollIntoView();", RegisterFormHeader);
    	
    	return RegisterFormHeader;	
    }
    
    
    
}