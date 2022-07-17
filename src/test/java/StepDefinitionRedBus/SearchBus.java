package StepDefinitionRedBus;

import PageFactoryModel.RedBus;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.util.List;

import static org.codehaus.plexus.util.StringUtils.isNumeric;

public class SearchBus {
    public static WebDriver driver;
    //driver = new void ChromeDriver();
    @Given("User Enters the Destination and To and Date and Search")
    public void user_enters_the_destination_and_to_and_date_and_search() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//input[@id='autosuggest']")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//input[@id='autosuggest']")).sendKeys("Ind");
//        Thread.sleep(3000);
//
//        List<WebElement> options= driver.findElements(By.cssSelector("li[class=\"ui-menu-item\"]"));
//        for(WebElement option:options)
//        {
//            System.out.println("The Options are:"+option.getText());
//        }
        System.out.println("Welcome Shubham Kumar");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        RedBus obj = new RedBus(driver);
        obj.visitWebsite();
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement selectFrom = driver.findElement(By.id("src"));
        selectFrom.click();
        Thread.sleep(2000);
        selectFrom.sendKeys("Banglore");
        Thread.sleep(4000);

        List<WebElement> options = driver.findElements(By.xpath("//ul[@class='autoFill homeSearch']/li"));
        for(WebElement option : options)
        {
            //System.out.println("The elements are :"+option.getText());
            if(option.getText().equalsIgnoreCase("Bangalore Airport, Bangalore"))
            {
                option.click();
                break;
            }
        }

        //Selecting the To
        driver.findElement(By.id("dest")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("dest")).sendKeys("Pune");
        Thread.sleep(2000);
        List<WebElement> optionss = driver.findElements(By.xpath("//ul[@class='autoFill homeSearch']/li"));
        for(WebElement option : optionss)
        {
            //System.out.println("The elements are :"+option.getText());
            if(option.getText().equalsIgnoreCase("Pune"))
            {
                option.click();
                break;
            }
        }


        //System.out.println("Successfully Logout");
        WebElement selectDate = driver.findElement(By.cssSelector("input[id=\"onward_cal\"]"));

        selectDate.click();
        Thread.sleep(1000);
        //button to move next in calendar

        WebElement nextLink = driver.findElement(By.className("next"));
        nextLink.click();
        Thread.sleep(1000);

        //button to click in center of calendar header

        //WebElement midLink = driver.findElement(By.className("monthTitle"));
        WebElement midLink = driver.findElement(By.xpath("//td[@class=\"monthTitle\"]"));
        //midLink.click();
        Thread.sleep(500);
        //button to move previous month in calendar
        //System.out.println("Level1");
        WebElement previousLink = driver.findElement(By.className("prev"));
        //previousLink.click();
        Thread.sleep(500);
        //System.out.println("Level 2");

        //System.out.println("Level 3");
        LocalDate date = LocalDate.now();
        String dd = date.toString();
        //System.out.println("The date is :"+dd);
        driver.findElement(By.xpath("//td[normalize-space()='14']")).click();
        Thread.sleep(500);

        WebElement searchButton= driver.findElement(By.id("search_btn"));
        searchButton.click();
        Thread.sleep(3000);

//        WebElement element = driver.findElement(By.xpath("//div[@class='gotIt']"));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//        Thread.sleep(500);
//
//        driver.findElement(By.cssSelector("//div[@class='gotIt']")).click();
//        Thread.sleep(5000);
//        List<WebElement> optionsFrom = driver.findElements(By.cssSelector("div[class=\"w-15 fl f-12 d-color\"]"));
//        for(WebElement optionFrom:optionsFrom)
//        {
//            System.out.println("The Sort Otpion optionFrom :"+optionFrom.getText());
//            if(optionFrom.getText().equalsIgnoreCase("Fare")){
//                optionFrom.click();
//            }
//        }

//        Select sortOptions = new Select(driver.findElement(By.cssSelector("div[class=\"w-15 fl f-12 d-color\"]")));
//        sortOptions.selectByValue("Fare");
//        System.out.println("Click the Sort Method");
//        Thread.sleep(3000);


        //String parent = "//div[@class=\"clearfix bus-item\"]";
        String parent = "//div[@class=\"clearfix bus-item\"]";
        // origionalString child1 = "//span[@class=\"f-19 f-bold\"]/text()";
        String child1 = "//span[@class=\"f-19 f-bold\"]";//bus ticket
        String child2 = "//div[@class=\"travels lh-24 f-bold d-color\"]";//busname
        String busFare = parent+" "+child1;
        String busName = parent+" "+child2;
        //System.out.println("Combined string is :"+busFare);
//        if(busFare.equalsIgnoreCase("//div[@class=\"clearfix bus-item\"] //span[@class=\"f-19 f-bold\"]/text()")){
//            //System.out.println("Equal");
//        }
//        if(busName.equalsIgnoreCase("//div[@class=\"clearfix bus-item\"] //div[@class=\"travels lh-24 f-bold d-color\"]")){
//            //System.out.println("Equal");
//        }
//        else{
//            System.out.println("False busName");
//        }



        Thread.sleep(3000);
        //List<WebElement> busFarePrice = driver.findElements(By.xpath(busFare.toString()));
        //List<WebElement> busFarePrice = driver.findElements(By.xpath("//li[@class=\"row-sec clearfix\"] //span[@class=\"f-19 f-bold\" ]"));
        List<WebElement> busFarePrice = driver.findElements(By.xpath("//span[contains(@class,'f-19 f-bold')]"));
        //System.out.println("Bus Ticket ");
        for (WebElement busFarePriceOption : busFarePrice)
        {
            //System.out.println("The busFarePrice :"+busFarePriceOption.getText());
            int busPPrice=Integer.parseInt(busFarePriceOption.getText());
            System.out.println(busPPrice);
           // System.out.println("The Bus Ticket Prices are :"+busPPrice);
            if(busPPrice>=2000 && busPPrice<=3000)
            {
                System.out.println("The Bus Ticket Price is :"+busPPrice);
                System.out.println("The busName is :"+driver.findElement((By.xpath(busName.toString()))).getText());
                Thread.sleep(100);
            }
        }

    }

    @When("User Select the Sort by Price")
    public void user_select_the_sort_by_price() {
        System.out.println("Welcome");
    }

    @Then("User Selects the Price Ticket Between {int} to {int}")
    public void user_selects_the_price_ticket_between_to(Integer int1, Integer int2) {
        System.out.println("I am quiting");
        //System.out.println("Quit");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.quit();

    }



}
