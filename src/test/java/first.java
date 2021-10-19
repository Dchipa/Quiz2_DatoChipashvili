import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Objects;

public class first {

    @Test
    public void main(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions chrome = new ChromeOptions();
        chrome.addArguments("--headless");

        WebDriver driver = new ChromeDriver(chrome);

        String Url = "https://demoqa.com/progress-bar";
        driver.get(Url);
        driver.findElement(By.id("startStopButton")).click();
        System.out.println("Button clicked");

        WebElement progressbar = driver.findElement(By.id("progressBar")).findElement(By.cssSelector("div:first-child"));


        System.out.println("Wait for progress bar");
        WebDriverWait waittime = new WebDriverWait(driver,30);
        waittime.until(ExpectedConditions.attributeContains(progressbar, "aria-valuenow", "100"));

        System.out.println(progressbar.getAttribute("aria-valuenow") + "%");
    }
    @Test
    public void checkboxes(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);

        String url = "https://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html";
        driver.get(url);
        WebElement all_options = driver.findElement(By.id("dropdowm-menu-1"));
        Select select = new Select(all_options);
        select.selectByVisibleText("C#");
        System.out.println("Selected Language is : " + select.getFirstSelectedOption().getText());

        WebElement allcheckboxes = driver.findElement(By.id("checkboxes"));
        List<WebElement> all_checkboxes = allcheckboxes.findElements(By.xpath("//label/input"));

        for (WebElement checkboxes : all_checkboxes) {
            if (!checkboxes.isSelected()){
                checkboxes.click();
                System.out.println("Checked : " + checkboxes.getAttribute("value"));
            }
        }

        WebElement allradios = driver.findElement(By.id("radio-buttons"));
        WebElement yellowradio = allradios.findElement(By.xpath("//input[@value='yellow']"));
        yellowradio.click();
        System.out.println("Yellow radio is clicked : " + yellowradio.isSelected());


        WebElement selected_disabled = driver.findElement(By.id("fruit-selects"));
        boolean is_disabled = ! selected_disabled.findElement(By.xpath("//option[@value='orange']")).isEnabled();
        System.out.println("Orange is disabled:" + is_disabled);

    }
    @Test
    public void textbox() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);

        String url = "http://the-internet.herokuapp.com/iframe";

        driver.get(url);
        System.out.println("Open Browser");

        WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);

        WebElement input = driver.findElement(By.id("tinymce"));
        input.clear();
        input.sendKeys("Here Goes");
        System.out.println("Printed Here Goes");

        driver.switchTo().defaultContent();

        WebElement alignCenter = driver.findElement(By.cssSelector("button[title='Align center']"));
        alignCenter.click();
        System.out.println("Clicked On Allign Center");

    }
}
