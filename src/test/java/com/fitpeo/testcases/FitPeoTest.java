package com.fitpeo.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fitpeo.pages.FitPeoHomePage;
import com.fitpeo.pages.RevenueCalculatorPage;

import om.fitpeo.base.BaseClass;

public class FitPeoTest extends BaseClass {

	 @Test
	    public void testRevenueCalculator() {
	        // Navigate to Revenue Calculator Page
	        FitPeoHomePage homePage = new FitPeoHomePage(driver);
	        RevenueCalculatorPage calculatorPage = homePage.goToRevenueCalculator();

	        // Scroll to the slider section
	        calculatorPage.scrollToSlider();

	        // Adjust slider to 820
	        calculatorPage.adjustSlider(820);
	        String sliderValueAfterAdjust = driver.findElement(By.xpath("//input[@type='range']")).getAttribute("value");
	        Assert.assertEquals(sliderValueAfterAdjust, "820", "Slider value did not update to 820.");

	        // Update the text field to 560
	        calculatorPage.updateTextField(560);
	        String sliderValueAfterTextFieldUpdate = driver.findElement(By.xpath("//input[@type='range']")).getAttribute("value");
	        Assert.assertEquals(sliderValueAfterTextFieldUpdate, "560", "Slider value did not update to 560 after text field entry.");

	        // Select CPT codes
	        calculatorPage.selectCPTCodes();

	        // Validate total recurring reimbursement
	        String totalReimbursement = calculatorPage.getTotalReimbursement();
	        Assert.assertTrue(totalReimbursement.contains("$110700"), "Total Reimbursement value is incorrect.");
	    }
}
