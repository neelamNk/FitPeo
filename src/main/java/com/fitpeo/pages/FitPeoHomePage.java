package com.fitpeo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

;

	public class FitPeoHomePage {
	    private WebDriver driver;

	    // Locator for Revenue Calculator link
	    private By revenueCalculatorLink = By.linkText("Revenue Calculator");

	    // Constructor
	    public FitPeoHomePage(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Method to navigate to Revenue Calculator page
	    public RevenueCalculatorPage goToRevenueCalculator() {
	        driver.findElement(revenueCalculatorLink).click();
	        return new RevenueCalculatorPage(driver);
	    }
	}

   
 
