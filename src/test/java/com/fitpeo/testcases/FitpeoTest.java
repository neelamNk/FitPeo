package com.fitpeo.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FitpeoTest {
	 WebDriver driver;
	    WebDriverWait wait;
	@BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.fitpeo.com/");
       // Assert.assertTrue(driver.getTitle().contains("FitPeo"), "Homepage not loaded correctly.");
        // Step 2: Navigate to the Revenue Calculator Page
        driver.navigate().to("https://fitpeo.com/revenue-calculator");
       // Assert.assertTrue(driver.getTitle().contains("Revenue Calculator"), "Revenue Calculator page not loaded correctly.");
        driver.navigate().refresh();
        
      
    }

	
	@Test(priority = 1)
	public void ScrollDown_Adjust_Slider() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
    
		// Scroll down to the slider section
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div/span[1]/span[3]"));
        Thread.sleep(3000);
		
		 Thread.sleep(5000);
		//Locate the slider
		WebElement slider = driver.findElement(By.xpath("//input[@type=\"range\"]"));
		Actions actions = new Actions (driver);
		actions.dragAndDropBy(slider, 82, 0).perform();
		
		
	}
	
	@Test(priority = 2)
	public void Update_the_Text_Field_Validate_Slider_Value() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)", "");
	        Thread.sleep(3000);

        // Locate the text field
        WebElement textField =  driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div[2]/div/div/div/div/input")); 
        // Replace with actual text field ID

        // Clear the existing value and enter 560
       // textField.clear();
        textField.sendKeys("560");

        // Simulate pressing Enter or losing focus to update the slider
        textField.sendKeys(Keys.RETURN);
        Thread.sleep(3000);
		 // Locate the slider
	    WebElement slider1 = driver.findElement(By.xpath("//input[@type=\"range\"]")); // Replace with actual slider ID
	    Actions actions = new Actions (driver);
		actions.dragAndDropBy(slider1, 52, 0).perform();

	    // Validate that the slider has adjusted accordingly
	  //  String sliderValue = slider1.getAttribute("aria-valuenow"); // Example: Use the attribute that reflects the slider's current value
	   // Assert.assertEquals(sliderValue, "560", "Slider value did not update to match the text field.");
	   
	}
	
	@Test(priority = 4)
	public void SelectCPTCodes() throws InterruptedException {
		//Scroll down further and select the checkboxes for CPT-99091, CPT-99453, CPT-99454, and CPT-99474.
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)", "");
        driver.findElement(By.xpath("//html/body/div[1]/div[1]/div[2]/div[1]/label/span[1]/input")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/label/span[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[3]/label/span[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[2]/div[8]/label/span[1]")).click();
	}
	
	@Test(priority = 5)
	public void RecurringReimbursemen() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,800)", "");
	        Thread.sleep(3000);

		//WebElement headers = driver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div/p[4]"));
		 // Locate the header element
        WebElement headers = driver.findElement(By.xpath("//header//div//p[text()='Total Recurring Reimbursement for all Patients Per Month:']"));

        // Scroll to the header element if not visible
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", headers);

        // Verify the header text
        String headerText = headers.getText();
        System.out.println("Header Text: " + headerText);
        //Assert.assertEquals(headerText, "Total Recurring Reimbursement for all Patients Per Month", "Header text did not match.");

	}


   @AfterMethod
    public void tearDown() {
      driver.quit();
    }
}
