package com.automation.pages.quotation;

import com.automation.pages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CalculatorPage extends BasePage {

    private String TRAVEL_TYPE_TEMPLATE = "//button[contains(text(),'%s')]";
    private String DESTINATION_COUNTRY_TEMPLATE = "//div[contains(@id,'react-select-')][contains(text(),'%s')]";
    private String DATE_PICKER_LOCATOR =
            "//div[@aria-disabled='false'][not (contains(@class, 'datepicker__day--outside-month'))]";

    @FindBy(css = "button[type=submit]")
    private WebElement calculateBudgetButton;

    @FindBy(id = "coverage-type")
    private WebElement coverageTypeDropdown;

    @FindBy(id = "dropdownValues")
    private WebElement destinationDropdown;

    @FindBy(id = "date-range")
    private WebElement dateInput;


    @FindBy(xpath = "//div[@class='react-datepicker__month-container'][1]//div[@aria-disabled='false'][not (contains(@class, 'datepicker__day--outside-month'))]")
    private WebElement currentMonth;

    @FindBy(css = ".modal-error__info > p")
    private WebElement modalErrorMessage;

    public CalculatorPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    @Override
    protected void pageLoadedElement() {
        getActions().waitElementForVisibility(calculateBudgetButton);
    }

    public void navigateToCalculatorPage() {
        getActions().waitAndClick(calculateBudgetButton);
    }

    public void selectTravelType(String travelType) {
        getActions().waitAndClick(By.xpath(String.format(TRAVEL_TYPE_TEMPLATE, travelType)));
    }

    public void selectDestination(String destination) {
        getActions().waitAndClick(destinationDropdown);
        getActions().waitAndClick(By.xpath(String.format(DESTINATION_COUNTRY_TEMPLATE, destination)));
    }

    public void enterDateRange(int startDate, int endDate) {
        getActions().waitAndClick(dateInput);
        List<WebElement> dates = getDriver().findElements(By.xpath(DATE_PICKER_LOCATOR));
        getActions().waitAndClick(dates.get(startDate));
        getActions().waitAndClick(dates.get(endDate));
    }

    public void enterDateRange(String fullDate) {
        getActions().enterText(dateInput, fullDate);
    }

    public void clickOnViewBudget() {
        getActions().waitAndClick(calculateBudgetButton);
    }

    public boolean isErrorMessageVisible(){
        return getActions().isElementPresent(modalErrorMessage);
    }

}