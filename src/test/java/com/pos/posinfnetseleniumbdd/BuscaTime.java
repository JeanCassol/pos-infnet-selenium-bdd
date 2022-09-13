package com.pos.posinfnetseleniumbdd;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BuscaTime {

    WebDriver driver;

    @Given("^Entra no GE$")
    public void entra_no_GE(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ge.globo.com/");
    }

    @When("^busca por \"([^\"]*)\"$")
    public void he_search_for(String arg1)  {
        driver.navigate().to("https://ge.globo.com/busca/?q=" + arg1 + "&ps=on");
    }

    @When("^seleciona primeiro da lista$")
    public void choose_to_buy_the_first_item() {
        WebElement items = driver.findElement(By.cssSelector(".results__list"));
        List<WebElement> links = items.findElements(By.tagName("li"));
        links.get(0).findElement(By.tagName("div")).findElement(By.tagName("a")).click();
    }

    @Then("^mostra nome do time$")
    public void mostra_nome_do_time() throws Throwable
    {
        String path = new URL(driver.getCurrentUrl()).getPath();
        path = path.replaceFirst("/", "");
        String[] pt = path.split("/");
        System.out.println(Arrays.asList(pt).get(pt.length - 1));
    }
}
