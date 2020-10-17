package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class informacoesUsuarioTest {

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\Drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.get("http://www.juliodelima.com.br/taskit ");
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

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

        //Validar se foi feito o login
        WebElement me = navegador.findElement(By.className("me"));
        String txtMe = me.getText();

        assertEquals("Hi, Julio", txtMe);

        //Fechar navegador
        navegador.quit();


    }
}
