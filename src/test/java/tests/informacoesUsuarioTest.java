package tests;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class informacoesUsuarioTest {

    @Test
    public void testAdicionarUmaInformacaoAdicionalDoUsuario() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\User\\Documents\\Drivers\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.get("http://www.juliodelima.com.br/taskit");
        assertEquals(1,1);
    }
}
