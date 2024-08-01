package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends MainPageObject {

    private static final String
            TITLE = "//*[@text='Java (programming language)']",
            FOOTER_ELEMENT = "//*[resource-id= 'pcs-footer-container-legal']//*[@text='View article in browser']",
            SAVE_BUTTON = "org.wikipedia:id/page_save",
            ADD_TO_LIST_BUTTON = "org.wikipedia:id/snackbar_action",
            NAME_OF_THE_LIST_INPUT = "//*[@text ='Name of this list']",
            MY_LIST_OK_BUTTON = "android:id/button1";





    //Иницилизируем аппиум драйвер из mainPageObject
    public ArticlePageObject(AppiumDriver driver) {
        super(driver); //Таким образов мы берем драйвер из MainPageObject
    }

    //Метод для ожидания статьи
    public WebElement waitForTitleElement() { //так как тут не очень удобно писать икспас, то напишем выше метод
        return this.waitForElementPresent(By.xpath(TITLE), "Cannot find title on page", 10);
    }

    //Метод для получения названия статьи
    public String getArticleTitle() {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");

    }

    //Метод свайпа до поиска футера
    public void swipeToFooter()
    {
        this.swipeUpToFindeElement(
                By.xpath(FOOTER_ELEMENT),
                "Can not fin footer element",
                50
        );
    }


    //метод для добавления стать в мой список Урок 5-06
    public void addArticleTpMyList(String name_of_folder)
    {
        //Ищем кнопку Save в таббаре
        this.waitForElementForClick(
                By.id(SAVE_BUTTON),
                "Cannot find button Save tabbar",
                20
        );
        //Ищем и тапаем по кнопке Add to list
        this.waitForElementForClick(
                By.id(ADD_TO_LIST_BUTTON),
                "Cannot find button Add to  list",
                15
        );
        //Очищаем поле ввода
        this.waitForElementAndClear(
                By.xpath(NAME_OF_THE_LIST_INPUT),
                "Cannot find field Name of this list",
                15
        );

        //Тапаем в поле ввода и вводим заголовок топика "Learning programming"
        this.waitForElementSendKeys(
                By.xpath(NAME_OF_THE_LIST_INPUT),
                name_of_folder,
                "Can not put title Lergning programming",
                10
        );

        //Тапаем по кнопке Ок
        this.waitForElementForClick(
                By.id(MY_LIST_OK_BUTTON),
                "Can not tap to Ok",
                10
        );

    }


}
