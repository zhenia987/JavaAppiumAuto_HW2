package lib.ui;
//В этом классе будут использоваться методы для поиска

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

//Укажем что этот метод наследуется от MainPageObject
public class SearchPageObject extends MainPageObject{

    //Запишем константы которые используются в поиске
    private static final String
            SEARCH_SKIP = "org.wikipedia:id/fragment_onboarding_skip_button",
            SEARCH_INIT_ELEMENT = "//*[contains(@text, 'Search Wikipedia')]",
            SEARCH_INPUT = "//*[contains(@text, 'Search Wikipedia')]",
            SEARCH_RESULT_BY_SUBSTRING_TPL = "//*[@text='{SUBSTRING}']";



    //Иницилизируем аппиум драйвер из mainPageObject
    public SearchPageObject(AppiumDriver driver)
    {
        super(driver); //Таким образов мы берем драйвер из MainPageObject
    }



    /*Это так называемый метод templated */
    //Напишем еще метод для SUBSTRING
    private static String getResultSearchElement(String substring)
    {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{SUBSTRING}", substring);
    }
    /*Это так называемый метод templated */


    //Напишем метод, который будет тапать по Skip
    public void initSkipButton()
    {
        this.waitForElementForClick(By.id(SEARCH_SKIP),"Can not find Skip button", 5);
    }

    //Напишем метод, который будет инициализировать процесс поиска
    public void initSearchInput()
    {
        this.waitForElementForClick(By.xpath(SEARCH_INIT_ELEMENT), "Error find and click search init element", 5);
        this.waitForElementPresent(By.xpath(SEARCH_INIT_ELEMENT), "Error find search input after clicking search init element");
    }

    //Напишем метод, который будет вводить какое то значение в строку
    public void typeSearchLine(String search_line)
    {
        this.waitForElementSendKeys(By.xpath(SEARCH_INPUT), search_line, "Cannot find and type into search line", 5);
    }

    public void waitForSearchResult(String substring)
    {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath), "Can not find result with substring " + substring);
    }
}
