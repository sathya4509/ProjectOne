package Base.org;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	public static WebDriver driver;

	public static WebDriver loadBrowser(String browser) {

		if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("edge")) {
			driver = new EdgeDriver();
		}
		return driver;
	}
public static void navigateBack() {
	driver.navigate().back();
	
}
public static void refresh() {
	driver.navigate().refresh();
}
	public static void maximizeWindow() {

		driver.manage().window().maximize();
	}

	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}

	public static void loadUrl(String url) {

		driver.get(url);
	}

	public static String verifyTitle(String expected) {

		String title = driver.getTitle();
		if (title.equals(expected)) {
			System.out.println(expected);
		}
		return expected;
	}

	public static String verifywithText(WebElement element, String expected) {
		String text = element.getText();

		if (text.equals(expected)) {
			System.out.println(expected);
		}
		return expected;
	}

	public static WebElement findingElement(String locator, String value) {
		WebElement element = null;
		switch (locator) {
		case "id":
			element = driver.findElement(By.id(value));
			break;
		case "name":
			element = driver.findElement(By.name(value));
			break;
		case "tagName":
			element = driver.findElement(By.tagName(value));
			break;
		case "xpath":
			element = driver.findElement(By.xpath(value));
			break;
		case "linkText":
			element = driver.findElement(By.linkText(value));
			break;
		default:

			break;

		}
		return element;
	}

	public static void passValue(WebElement element, String textvalue) {

		element.sendKeys(textvalue);
	}

	public static void clickElement(WebElement element) {
		element.click();
	}
	public static void pageValidation(WebElement element,String webText) {
		String text = element.getText();
		if(text==webText) {
			System.out.println(webText);
		}
		else {
			System.out.println("Text is not equal");
		}
		
	}

	public void takingScreenshot(String fileName) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("C:\\Users\\USER\\eclipse-workspace\\JUnit\\target\\ "+fileName);
		FileUtils.copyFile(srcFile, destFile);
	}
	public static void selectOption(int i) throws AWTException{
		
		Robot robot=new Robot();
		for( i=0;i<=10;i++) {
		
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		}
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_ENTER);
	}
	public static void selectDropDown(WebElement ele,String method,String value) {
		Select select=new Select(ele);
		switch (method)
		{
		case "index":
			int index = Integer.parseInt(value);
			select.selectByIndex(index);
			break;
		case "value":
			select.selectByValue(value);
			break;
		case "text":
			select.selectByVisibleText(value);
		default:
			break;
		}
		
	}
	public static String excelRead(String filePath, String sheetName, int rowNum, int colNum)
			throws FileNotFoundException {

		String value = null;
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		Workbook workbook = null;
		try {
			workbook = new XSSFWorkbook(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(colNum);

		CellType cellType = cell.getCellType();
		switch (cellType) {
		case STRING:
			String stringCellValue = cell.getStringCellValue();
			// System.out.println(stringCellValue);
			value = stringCellValue;
			break;
		case NUMERIC:
			boolean cellDateFormatted = DateUtil.isCellDateFormatted(cell);
			if (cellDateFormatted) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("DD-MM-YYYY");
				String format = dateFormat.format(dateCellValue);
				value = format;

			} else {
				double numericCellValue = cell.getNumericCellValue();
				// System.out.println("Res="+numericCellValue);
				long num = (long) numericCellValue;
				// System.out.println("OP="+num);
				if (numericCellValue == num) {
					// System.out.println(num);
					value = Long.toString(num);
				} else {
					value = Double.toString(numericCellValue);
				}
			}
			break;
		case BOOLEAN:
			boolean booleanCellValue = cell.getBooleanCellValue();
			// System.out.println(booleanCellValue);
			value = Boolean.toString(booleanCellValue);
		default:
			break;

		}
		return value;
		// return sheetName;
	}
	public static Actions mouseActions(WebElement ele) {
		Actions action=new Actions(driver);
		  action.scrollToElement(ele);
		return action ;
	}
	public static void windowHandles() {
		String parent = driver.getWindowHandle();
		Set<String> allWindow = driver.getWindowHandles();
	for(String newWindow:allWindow) {
		driver.switchTo().window(newWindow);
		}
		//Set<String> windowHandles = driver.getWindowHandles();
	}
	public static void closeBrowser() {
		driver.quit();
	}
}



