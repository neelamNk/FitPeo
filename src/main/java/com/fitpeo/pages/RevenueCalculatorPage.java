package com.fitpeo.pages;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.JavascriptExecutor;

	public class RevenueCalculatorPage {
	    private WebDriver driver;

	    // Locators
	    private By slider = By.xpath("//input[@type='range']");
	    private By textField = By.xpath("//input[@type='text']");
	    private By cptCode99091 = By.id("CPT-99091");
	    private By cptCode99453 = By.id("CPT-99453");
	    private By cptCode99454 = By.id("CPT-99454");
	    private By cptCode99474 = By.id("CPT-99474");
	    private By totalReimbursementHeader = By.xpath("//h2[contains(text(),'Total Recurring Reimbursement')]");

	    // Constructor
	    public RevenueCalculatorPage(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Scroll to the slider section
	    public void scrollToSlider() {
	        WebElement sliderElement = driver.findElement(slider);
	        ((JavascriptExecutor) driver).executeScript("arguments[0,250].scrollIntoView(true);", sliderElement);
	    }

	    // Adjust slider value
	    public void adjustSlider(int value) {
	        WebElement sliderElement = driver.findElement(slider);
	        sliderElement.sendKeys(String.valueOf(value));
	    }

	    // Update text field value
	    public void updateTextField(int value) {
	        WebElement textFieldElement = driver.findElement(textField);
	        textFieldElement.clear();
	        textFieldElement.sendKeys(String.valueOf(value));
	    }

	    // Select CPT codes
	    public void selectCPTCodes() {
	        driver.findElement(cptCode99091).click();
	        driver.findElement(cptCode99453).click();
	        driver.findElement(cptCode99454).click();
	        driver.findElement(cptCode99474).click();
	    }

	    // Get total recurring reimbursement value
	    public String getTotalReimbursement() {
	        return driver.findElement(totalReimbursementHeader).getText();
	    }
	}

	


