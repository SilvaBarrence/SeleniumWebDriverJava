package suporte;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Screenshot {

    public static void take(WebDriver navegador, String arquivo) {
        File sceenshot =((TakesScreenshot)navegador).getScreenshotAs(OutputType.FILE);
        try{
            FileUtils.copyFile(sceenshot, new File(arquivo));
        }catch (Exception e){
            System.out.println("Houveram problemas ao copiar o arquivo para a pasta. ERRO: "+ e.getMessage());
        }
    }
}