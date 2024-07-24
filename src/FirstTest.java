import io.appium.java_client.TouchAction;
import lib.CoreTestCase;
import lib.ui.MainPageObject;
import lib.ui.SearchPageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class FirstTest  extends CoreTestCase {

    private MainPageObject MainPageObject;

    protected void setUp() throws Exception
    {
        super.setUp();
        MainPageObject = new MainPageObject(driver);
    }

   @Test
        public void testSearch() {
//       //Ищем кнопку "Skip" и тапаем по ней
//       MainPageObject.waitForElementForClick(
//               By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
//               "Not find button Skip",
//               15
//       );
//       //Ищем поле ввода и тапаем по нему
//       MainPageObject.waitForElementForClick(
//               By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//               "Java",
//               15
//       );
//       //Ищем поле ввода и вводим в него текст
//       MainPageObject.waitForElementSendKeys(
//               By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
//               "Java",
//               "Cannot search input",
//               15
//       );
//       //Ждем и проверяем что результат поиска есть на странице
//       MainPageObject.waitForElementPresent(
//               By.xpath("//*[@text='Object-oriented programming language']"),
//               "Cannot find 'Object-oriented programming language' topic search by Java",
//               15
//       );

       SearchPageObject SearchPageObject = new SearchPageObject(driver);

       SearchPageObject.initSkipButton();
       SearchPageObject.initSearchInput();
       SearchPageObject.typeSearchLine("Java");
       SearchPageObject.waitForSearchResult("Object-oriented programming language");


   }


    @Test  ///Тест на проверку, что больше нет какого-то элемента на странице/экране
    public void testCancelSearch()
    {    //Пропускаем страницу онбординка по кнопке Skip
        MainPageObject.waitForElementForClick(
                By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
                "Not find button Skip",
                15
        );
        //Ищем поле ввода и кликаем по нему
        MainPageObject.waitForElementForClick(
                By.id("org.wikipedia:id/search_container"),
                "Can not find input id 'org.wikipedia:id/search_container'",
                5);

        //Ищем кнопку "Стрелка-назад" и тапаем по ней
        MainPageObject.waitForElementForClick(
               By.xpath("//*[@content-desc='Navigate up']"),
                "Can not find input id 'org.wikipedia:id/search_close_btn'",
                5);

        // проверяем что элемента больше нет на экране
        MainPageObject.waitForElementNotPresent(
                By.id("org.wikipedia:id/search_close_bt"),
                "X is still present on page",
                5);
    }



      @Test
    public void testCompareArticleTitle()
    {
        //Ищем кнопку "Skip" и тапаем по ней
        MainPageObject.waitForElementForClick(
                By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
                "Not find button Skip",
                15
        );
        //Ищем поле ввода и тапаем по нему
        MainPageObject.waitForElementForClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Java",
                15
        );
        //Ищем поле ввода и вводим в него текст
        MainPageObject.waitForElementSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Java",
                "Cannot search input",
                15
        );
/*        //Проверяем что срабботал поиск и есть результат
        MainPageObject.waitForElementPresent(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find 'Object-oriented programming language' topic search by Java",
                15
        );*/

        //Ищем нашу статью и тапаем по ней
        MainPageObject.waitForElementForClick(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Not find статья",
                15
        );

        //Ждем и проверяем что статья появилась
        WebElement title_element = MainPageObject.waitForElementPresent(
                By.xpath("//*[@text='Java (programming language)']"),
                "Not find Title in page",
                15
        );
        // теперь получил текст из заголовка присвоив его новой переменной
        String article_title = title_element.getAttribute("text");

        //Пишем ассерт используя в нем нашу переменную с тесктом заголовка
        Assert.assertEquals(
                "Тест упал на сравнении",
                "Java (programming language)",
                article_title
        );


/*        //Очищаем поле ввода
        MainPageObject.waitForElementPresent(
                By.id("org.wikipedia:id/search_src_text"),
                "Cannot find 'Search' field whith text",
                15
        );

        //Ищем кнопку "Стрелка-назад" и тапаем по ней
        MainPageObject.waitForElementForClick(
                By.xpath("//*[@content-desc='Navigate up']"),
                "Can not find input id 'org.wikipedia:id/search_close_btn'",
                15
        );

        // проверяем что элемента больше нет на экране
        MainPageObject.waitForElementNotPresent(
                By.id("org.wikipedia:id/search_close_bt"),
                "X is still present on page",
                15
        );*/
    }

    @Test
    public void testSwipeArticleTitle()
    {
        //Ищем кнопку "Skip" и тапаем по ней
        MainPageObject.waitForElementForClick(
                By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
                "Not find button Skip",
                15
        );
        //Ищем поле ввода и тапаем по нему
        MainPageObject.waitForElementForClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Java",
                15
        );
        //Ищем поле ввода и вводим в него текст
        MainPageObject.waitForElementSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Java",
                "Cannot search input",
                15
        );
/*        //Проверяем что срабботал поиск и есть результат
        MainPageObject.waitForElementPresent(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find 'Object-oriented programming language' topic search by Java",
                15
        );*/

        //Ищем нашу статью и тапаем по ней
        MainPageObject.waitForElementForClick(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Not find статья",
                30
        );

        //Ждем и проверяем что статья появилась
        MainPageObject.waitForElementPresent(
                By.xpath("//*[@text='Java (programming language)']"),
                "Not find Title in page",
                30
        );
        //Делаем свайп
        // swipeUp(2000);

        //Делайем свайп, ищем элемент и свайпаем дальше
        MainPageObject.swipeUpToFindeElement(
                By.xpath("//*[resource-id= 'org.wikipedia:id/page_contents_container']//*[@content-desc='View article in browser']"),
                "Не нашли наш футер",
                40
        );
    }


        //Напишем тест по уроку 4.3
        @Test
        public void testSafeFirstArticleToMyList()
    {
        //Ищем кнопку "Skip" и тапаем по ней
        MainPageObject.waitForElementForClick(
                By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
                "Not find button Skip",
                15
        );
        //Ищем поле ввода и тапаем по нему
        MainPageObject.waitForElementForClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Не нашли поле поиска",
                5
        );
        //Ищем поле ввода и вводим в него текст
        MainPageObject.waitForElementSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Java",
                "Cannot search input",
                15
        );

        //Ищем нашу статью и тапаем по ней
        MainPageObject.waitForElementForClick(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Not find статья",
                15
        );

        //Ждем и проверяем что статья появилась
        MainPageObject.waitForElementPresent(
                By.xpath("//*[@text='Java (programming language)']"),
                "Not find Title in page",
                40
        );

        //Ищем кнопу Три точки и кликаем по ней
//        MainPageObject.waitForElementForClick(
//                By.xpath("//android.widget.ImageView[@content-desc = 'More options']"),
//                "Cannot find More option button",
//                5
//        );

        //Ищем кнопку Save в таббаре
        MainPageObject.waitForElementForClick(
                By.id("org.wikipedia:id/page_save"),
                "Cannot find button Save tabbar",
                20
        );
        //Ищем и тапаем по кнопке Add to list
        MainPageObject.waitForElementForClick(
                By.id("org.wikipedia:id/snackbar_action"),
                "Cannot finde button Add to  list",
                15
        );

//        //Ищем и тапаем по кнопке +
//        MainPageObject.waitForElementForClick(
//                By.id("org.wikipedia:id/create_button"),
//                "Cannot finde button +",
//                15
//        );

        //Очищаем поле ввода
        MainPageObject.waitForElementAndClear(
                By.xpath("//*[@text ='Name of this list']"),
                "Cannot find field Name of this list",
                15
        );

        //Тапаем в поле ввода и вводим заголовок топика "Learning programming"
        MainPageObject.waitForElementSendKeys(
                By.xpath("//*[@text ='Name of this list']"),
                "Learning programming",
                "Can not put title Lergning programming",
                10
        );

        //Тапаем по кнопке Ок
        MainPageObject.waitForElementForClick(
        By.id("android:id/button1"),
        "Can not tap to Ok",
        10
        );

        //Тапаем по кнопке "View list"
        MainPageObject.waitForElementForClick(
                By.id("org.wikipedia:id/snackbar_action"),
                "Can not fine and tap to View list ",
                15
        );

//        //Тапаем по кнопке Назад 2 раза
//        MainPageObject.waitForElementForClick(
//                By.xpath("//*android.widget.ImageButton[@content-desc='Navigate up']"),
//                "Cannot find field button Up1",
//                15
//        );
//        MainPageObject.waitForElementForClick(
//                By.xpath("//*android.widget.ImageButton[@content-desc='Navigate up']"),
//                "Cannot find field button Up2",
//                15
//        );
//
//        //Тапаем по кнопке сохраненок в таббаре
//        MainPageObject.waitForElementForClick(
//                By.id("org.wikipedia:id/nav_tab_reading_lists"),
//                "Can not find and tap to Save tabbar",
//                15
//        );

        //Тапаем по нашей статье
        MainPageObject.waitForElementForClick(
                By.xpath("//*[@text='Learning programming']"),
                "Can not fine save topic",
                20
        );

        //проверяем что топик есть
        MainPageObject.waitForElementPresent(
                By.xpath("//*[@text='Java (programming language)']"),
                "Not find топик",
                20
        );
        //ДЕЛАЕМ СВАЙП ДЛЯ УДАЛЕНИЯ
        MainPageObject.swipeElementToLeft(
                By.xpath("//*[@text='Java (programming language)']"),
                "Not delete топик"
        );

        //проверяем что статья отсутсвует
        MainPageObject.waitForElementNotPresent(
                By.xpath("//*[@text='Java (programming language)']"),
                " топик not delete",
                15
        );

    }

    //L4 Урок 5 Assert Bassic
    @Test //Проверяем что колличество элементов поиска больше чем 0, и если это так, то тест успешно завершится
    public void testAmountOfNotEmptySearch() {
        //Ищем кнопку "Skip" и тапаем по ней
        MainPageObject.waitForElementForClick(
                By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
                "Not find button Skip",
                15
        );
        //Ищем поле ввода и тапаем по нему
        MainPageObject.waitForElementForClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Не нашли поле поиска",
                5
        );
        //Ищем поле ввода и вводим в него текст
        String search_line = "Linkin Park Discography";
        MainPageObject.waitForElementSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                search_line,
                "Cannot search input",
                15
        );

        String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']//*[@resource-id='org.wikipedia:id/page_list_item_title']";
        MainPageObject.waitForElementPresent(
                By.xpath(search_result_locator),
                "Can not find enything by the request " + search_line,
                15
        );

        //Получаем колличество найденных элементов через метод getAmountElements
        int amount_of_search_results = MainPageObject.getAmountElements(
                By.xpath(search_result_locator)
        );
        //Проверяем, что колличество найденных элементов больше нуля через assertTrue
        Assert.assertTrue(
                "We found too few results",
                amount_of_search_results > 0

        );
    }

    //L4 Урок 6  Assert: assertion error
        @Test //Тест для проверки того что результат поиска пустой
        public void testAmountEmptySearch() {
            //Ищем кнопку "Skip" и тапаем по ней
            MainPageObject.waitForElementForClick(
                    By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
                    "Not find button Skip",
                    15
            );
            //Ищем поле ввода и тапаем по нему
            MainPageObject.waitForElementForClick(
                    By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                    "Не нашли поле поиска",
                    5
            );
            //Ищем поле ввода и вводим в него текст
            String search_line = "JHVkhs";
            MainPageObject.waitForElementSendKeys(
                    By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                    search_line,
                    "Cannot search input",
                    15
            );

            String search_result_locator = "//*[@resource-id='org.wikipedia:id/search_results_list']//*[@resource-id='org.wikipedia:id/page_list_item_title']";
            String empty_result_search = "//*[@text='No results']";

            MainPageObject.waitForElementPresent(
                    By.xpath(empty_result_search),
                    "Can not find empty results by the request " + search_line,
                    15
            );

            MainPageObject.assertElementNotPresent(
                    By.xpath(search_result_locator),
                    "We have found some results by request " + search_line
            );
        }
            //L4 Урок 7  Rotation
            @Test //Тест для проверки после поворота экрана название статьи не изменилось
            public void testChangeScreenOrientationOnSearchResults()
            {
                //Ищем кнопку "Skip" и тапаем по ней
                MainPageObject.waitForElementForClick(
                        By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
                        "Not find button Skip",
                        15
                );
                //Ищем поле ввода и тапаем по нему
                MainPageObject.waitForElementForClick(
                        By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                        "Не нашли поле поиска",
                        5
                );
                //Ищем поле ввода и вводим в него текст
                String search_line = "Java";
                MainPageObject.waitForElementSendKeys(
                        By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                        search_line,
                        "Cannot search input",
                        15
                );
                //Ищем стать и комкаем по ней
                MainPageObject.waitForElementForClick(
                    By.xpath("//*[@text='Object-oriented programming language']"),
                    "Cannot find 'Object-oriented programming language' topic search by " + search_line,
                    15
                );
                String title_before_rotation = MainPageObject.waitForElementAndGetAttribute(
                        By.xpath("//android.widget.TextView[@text= 'Java (programming language)']"),
                        "text",
                        "Cannot find title article",
                        15
                );
                driver.rotate(ScreenOrientation.LANDSCAPE);
                String title_after_rotation = MainPageObject.waitForElementAndGetAttribute(
                        By.xpath("//android.widget.TextView[@text= 'Java (programming language)']"),
                        "text",
                        "Cannot find title article",
                        15
                );

                Assert.assertEquals(
                        "Article title have been changed after screen rotation",
                        title_before_rotation,
                        title_after_rotation
                );

                driver.rotate(ScreenOrientation.PORTRAIT);
                String title_after_second_rotation = MainPageObject.waitForElementAndGetAttribute(
                        By.xpath("//android.widget.TextView[@text= 'Java (programming language)']"),
                        "text",
                        "Cannot find title article",
                        15
                );
                Assert.assertEquals(
                        "Article title have been changed after screen rotation",
                        title_before_rotation,
                        title_after_second_rotation
                );

            }

    //L4 Урок 8  Бэкграунд
    @Test
    public void testCheckSearchArtticleInBackground()
    {
        //Ищем кнопку "Skip" и тапаем по ней
        MainPageObject.waitForElementForClick(
                By.id("org.wikipedia:id/fragment_onboarding_skip_button"),
                "Not find button Skip",
                15
        );
        //Ищем поле ввода и тапаем по нему
        MainPageObject.waitForElementForClick(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                "Не нашли поле поиска",
                5
        );
        //Ищем поле ввода и вводим в него текст
        String search_line = "Java";
        MainPageObject.waitForElementSendKeys(
                By.xpath("//*[contains(@text, 'Search Wikipedia')]"),
                search_line,
                "Cannot search input",
                15
        );
        //Проверяем что срабботал поиск и есть результат
        MainPageObject.waitForElementPresent(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find 'Object-oriented programming language' topic search by " + search_line,
                15
        );

       driver.runAppInBackground(2);
        //Проверяем что статья все еще есть
        MainPageObject.waitForElementPresent(
                By.xpath("//*[@text='Object-oriented programming language']"),
                "Cannot find article after returnig from background",
                15
        );

    }

}















