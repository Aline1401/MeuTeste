package suporte;


import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Web {
	protected static WebDriver driver;
	@Before
	public static WebDriver createChrome() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Note Gamer\\Downloads\\Teste automatizado\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.siagri.com.br");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		

		return driver;

	}
	
}