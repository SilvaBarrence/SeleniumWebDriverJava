package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class informacoesUsuarioTest {

    private ChromeDriver navegador;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\Drivers\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // espera implícita

        navegador.get("http://www.juliodelima.com.br/taskit ");

        //Seleciona a opção para realizar o login
        navegador.findElement(By.linkText("Sign in")).click();

        //Identifica o forumlario de login
        WebElement formularioSignInBox = navegador.findElement(By.id("signinbox"));

        //Preencher o campo "login"
        formularioSignInBox.findElement(By.name("login")).sendKeys("julio0001");

        //Preencher o campo password
        formularioSignInBox.findElement(By.name("password")).sendKeys("123456");

        //Clicar no link sign in
        navegador.findElement(By.linkText("SIGN IN")).click();

        //Clicar em um link que possua a class "me"
        navegador.findElement(By.className("me")).click();

        //Clicar em um link que possua o texto "More data about you"
        navegador.findElement(By.linkText("MORE DATA ABOUT YOU")).click();
    }

    // @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario() {
        //Clicar no botão atravez do seu xpath "//button[@data-target="addmoredata"]"
        navegador.findElement(By.xpath("//button[@data-target=\"addmoredata\"]")).click();

        //Identificar o popup onde esta o forumário de ID "addmoredata"
        WebElement popupAddMoreData = navegador.findElement(By.id("addmoredata"));

        //No combo name "type" escolher a opção "Phone"
        WebElement campoType = popupAddMoreData.findElement(By.name("type"));
        new Select(campoType).selectByVisibleText("Phone"); // Forma de interagir com combo box

        //Campo name "contact" digitar "+5511123456789"
        popupAddMoreData.findElement(By.name("contact")).sendKeys("+5511123456789");

        //Clicar no link do text "SAVE" que está no popup
        popupAddMoreData.findElement(By.linkText("SAVE")).click();

        //Na mensagem de "toast-container" que o texto é "Your contact has been added!"
        WebElement msgPop = navegador.findElement(By.id("toast-container"));
        String msg = msgPop.getText();
        assertEquals("Your contact has been added!", msg);
    }

    @Test
    public void removendoContatoDoUsuario() {
        //  //span[text()="+1111111111111"]/following-sibling::a
        navegador.findElement(By.xpath("//span[text()=\"+1111111111111\"]/following-sibling::a")).click();

        //Confirmar janela javascript
        navegador.switchTo().alert().accept();

        //Validar que a mensgem apresentada foi "Rest in peace, dear phone!"
        WebElement msgPop = navegador.findElement(By.id("toast-container"));
        String msg = msgPop.getText();
        assertEquals("Rest in peace, dear phone!", msg);

        //Aguardar 10 segundos para que a janela desapareça - espera explicita
        WebDriverWait aguardar = new WebDriverWait(navegador, 10);
        aguardar.until(ExpectedConditions.stalenessOf(msgPop));

        //Clicar no link com texto "Logout"
        navegador.findElement(By.linkText("Logout")).click();
    }

    @After
    public void tearDown() {
        //Fechar navegador
        //navegador.quit();
    }
}
