
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.List;
import java.util.Locale;


public class firstclass {
    public firstclass() {
    }

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        driver.get("https://www.a101.com.tr/");
        driver.findElement(By.xpath("//button[@id='CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll']")).click();
        driver.findElement(By.xpath("//a[@data-pk='37a6c1c8-a180-4b87-9ec9-3a29f6453a0c']")).click();
        driver.findElement(By.xpath("//a[@data-value='1565']")).click();
        driver.findElement(By.xpath("//a[@data-value='1567']")).click();
        driver.findElement(By.xpath("//a[@title='Penti Kadın 50 Denye Pantolon Çorabı Siyah']")).click();

        WebElement SecilenRenk = driver.findElement(By.xpath("//h1[@class='product-name js-name']"));
        String expectedSecilenRenk = "Penti Kadın 50 Denye Pantolon Çorabı Siyah";
        String actualSecilenRenk = SecilenRenk.getText();
        if (expectedSecilenRenk.equals(actualSecilenRenk)) {
            System.out.println("Seçilen renk siyah.");
        } else {
            System.out.println("Seçilen renk farklı.");
        }

        driver.findElement(By.xpath("//button[@class='add-to-basket button green block with-icon js-add-basket']")).click();
        driver.findElement(By.xpath("//a[@class='go-to-shop']")).click();
        driver.findElement(By.xpath("//a[@class='button green checkout-button block js-checkout-button']")).click();
        WebElement devamet = driver.findElement(By.cssSelector("a.auth__form__proceed.js-proceed-to-checkout-btn"));
        devamet.click();
        WebElement email = driver.findElement(By.xpath("//input[@name='user_email']"));
        email.sendKeys("testoyku10@a101.com");
        driver.findElement(By.xpath("//button[@class='button block green']")).click();
        driver.findElement(By.xpath("//a[@class='new-address js-new-address']")).click();

        WebElement başlık = driver.findElement(By.xpath("//input[@placeholder='Ev adresim, iş adresim vb.']"));
        başlık.sendKeys("Ev");
        WebElement ad = driver.findElement(By.xpath("//input[@name='first_name']"));
        ad.sendKeys("Öykü");
        WebElement soyad = driver.findElement(By.xpath("//input[@name='last_name']"));
        soyad.sendKeys("Demirel");
        WebElement telefon = driver.findElement(By.xpath("//input[@name='phone_number']"));
        telefon.sendKeys("5538712333");

        WebElement element = driver.findElement(By.cssSelector("select.js-cities"));
        Select sec = new Select(element);
        sec.selectByVisibleText("İZMİR");
        Thread.sleep(500);

        element = driver.findElement(By.cssSelector("select.js-township"));
        sec = new Select(element);
        sec.selectByVisibleText("KARŞIYAKA");
        Thread.sleep(500);

        element = driver.findElement(By.cssSelector("select.js-district"));
        sec = new Select(element);
        sec.selectByVisibleText("İNÖNÜ MAH");
        Thread.sleep(500);

        WebElement adres= driver.findElement(By.xpath("//textarea[@class='js-address-textarea']"));
        adres.sendKeys("SATFCO5LASKHGY89DS54YE");

        driver.findElement(By.xpath("//button[@class='button green address-modal-submit-button js-set-country js-prevent-emoji js-address-form-submit-button']")).click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement tamamla = driver.findElement(By.xpath("//button[@class='button block green js-proceed-button']"));
        wait.until(ExpectedConditions.elementToBeClickable(tamamla));
        tamamla.click();


        WebDriverWait waitt = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement sipariş= driver.findElement(By.xpath("//span[@class='order-complete']"));
        waitt.until(ExpectedConditions.elementToBeClickable(sipariş));
        sipariş.click();


        WebElement ödeme = driver.findElement(By.xpath("//span[text()='Lütfen kart seçin veya kart bilgisi girin.']"));
        String expectedyazı = "Lütfen kart seçin veya kart bilgisi girin.";
        String actualyazı = ödeme.getText();
        if (expectedyazı.equals(actualyazı)) {
            System.out.println("Ödeme ekranına gelindi.");
        } else {
            System.out.println("Ödeme ekranı bulunamadı.");
        }

        driver.close();
    }
}