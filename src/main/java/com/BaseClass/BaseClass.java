package com.BaseClass;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
	public static WebDriver driver;

	/**
	 * @param browser
	 */
	public static void getDriver(String browser) {
		switch (browser) {
		case "chrome":

			driver = new ChromeDriver();
			break;
		case "ie":

			driver = new InternetExplorerDriver();
			break;
		case "firefox":

			driver = new FirefoxDriver();
			break;
		case "edge":

			driver = new EdgeDriver();
			break;
		default:
			break;
		}
	}

	/**
	 * 
	 * @return byte[]
	 * @see maintain screenshot
	 * 
	 */
	public byte[] screenShot() {
		TakesScreenshot sc = (TakesScreenshot) driver;
		byte[] b = sc.getScreenshotAs(OutputType.BYTES);
		return b;

	}

	/**
	 * 
	 * @return String
	 * @see maintain project path
	 */
	public String projectPath() {
		String path = System.getProperty("user.dir");
		return path;
	}

	/**
	 * 
	 * @param key
	 * @return String
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @see maintain to get property values from property file
	 * 
	 */
	public String getPropertFileValue(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(projectPath() + "\\config\\config.properties"));
		Object object = properties.get(key);
		String value = (String) object;
		// String value = object.toString();
		return value;
	}

	/**
	 * 
	 * @param url
	 * @see maintain to enter URL
	 * 
	 */
	public static void enterAppInUrl(String url) {
		driver.get(url);
	}

	/**
	 * 
	 * @throws AWTException
	 * @see maintain to robot press and release the tab button
	 * 
	 */
	public static void tab() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}

	/**
	 * 
	 * @throws AWTException
	 * @see maintain to robot press and release the enter button
	 */
	public static void enter() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	/**
	 * @see maintain to maximize the window
	 * 
	 */
	public static void maximizeWindow() {
		driver.manage().window().maximize();
	}

	/**
	 * 
	 * @param element
	 * @param text
	 * @see maintain send keys logic
	 * 
	 */
	public void elementSendKeys(WebElement element, String text) {
		element.sendKeys(text);

	}

	/**
	 * 
	 * @param element
	 * @see maintain the logics to clear the text field
	 */
	public void elementClear(WebElement element) {
		element.clear();
	}

	/**
	 * 
	 * @param element
	 * @param text
	 * @see maintain send keys logic with use of java scripts
	 */

	public void elementSendKeysjs(WebElement element, String text) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
	}

	/**
	 * 
	 * @param element
	 * @see maintain the business logic to click the web element
	 */
	public void elementClick(WebElement element) {
		element.click();
	}

	/**
	 * 
	 * @return String
	 * @see maintain the business logic to get the application title
	 */
	public String getAppTitle() {
		String title = driver.getTitle();
		return title;
	}

	/**
	 * 
	 * @param attribute
	 * @return WebElement
	 * @see maintain the business logi to find the element by ID
	 */
	public WebElement findElementById(String attribute) {
		WebElement element = driver.findElement(By.id(attribute));
		return element;
	}

	/**
	 * 
	 * @param attribute
	 * @return WebElement
	 * @see maintain the business logi to find the element by ClassName
	 */
	public WebElement findElementByClassName(String attribute) {
		WebElement element = driver.findElement(By.className(attribute));
		return element;
	}

	/**
	 * 
	 * @param xpathExp
	 * @return WebElement
	 * @see maintain the business logi to find the element by xpath
	 */
	public WebElement findElementByXpath(String xpathExp) {
		WebElement element = driver.findElement(By.xpath(xpathExp));
		return element;
	}

	/**
	 * @see maintain to close current the window
	 */
	public void closeWindow() {
		driver.close();
	}

	/**
	 * @see maintain to close all the windows
	 */
	public static void quitWindow() {
		driver.quit();
	}

	/**
	 * 
	 * @param element
	 * @return String
	 * @see maintain the business logic to get the text from webelement
	 * 
	 */
	public String elementGetText(WebElement element) {
		String text = element.getText();
		return text;
	}

	/**
	 * 
	 * @param element
	 * @param attributeName
	 * @return String
	 * @see maintain the business logic to get the attribute-text from webelement
	 */
	public String elementGetAttribute(WebElement element, String attributeName) {
		String attribute = element.getAttribute(attributeName);
		return attribute;
	}

	/**
	 * 
	 * @param element
	 * @param text
	 * @see maintain the business logic to select from dropdown list by text
	 * 
	 */
	public void selectOptionBytext(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	/**
	 * 
	 * @param element
	 * @param value
	 * @see maintain the business logic to select from dropdown list by
	 *      Attribute-value
	 * 
	 */
	public void selectOptionByAttribute(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}

	/**
	 * 
	 * @param element
	 * @param index
	 * @see maintain the business logic to select from dropdown list by index-number
	 * 
	 */
	public void selectOptionByIndex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	/**
	 * 
	 * @param element
	 * @return String
	 * @see maintain the business logic to get the all options from drop-down list
	 */
	public String getOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			WebElement webElement = options.get(i);
			String text = webElement.getText();
			System.out.println(text);
		}
		return null;
	}

	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return String
	 * @throws IOException
	 * @see maintain get the cell value from excel file
	 * 
	 */
	public String getCellValue(String sheetName, int rowNum, int cellNum) throws IOException {
		String res = "";

		File file = new File("C:\\MAGP\\Automation Web\\MAGPWeb\\TestData.xlsx");
		// File file = new
		// File("C:\\Users\\SAM\\eclipse-workspace\\FirstSession\\excel\\facebook.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		CellType type = cell.getCellType();
		switch (type) {
		case STRING:
			res = cell.getStringCellValue();
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date dateCellValue = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				res = dateFormat.format(dateCellValue);
			} else {
				double numericCellValue = cell.getNumericCellValue();
				long check = Math.round(numericCellValue);
				if (check == numericCellValue) {
					res = String.valueOf(numericCellValue);
				} else {
					res = String.valueOf(check);
				}
			}
			break;
		default:
			break;
		}
		return res;
	}

	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param oldData
	 * @param newData
	 * @throws IOException
	 * @see maintain the code to update the cell data in excel file.
	 */
	public void updateCellData(String sheetName, int rowNum, int cellNum, String oldData, String newData)
			throws IOException {

		File file = new File("C:\\Users\\SAM\\eclipse-workspace\\FirstSession\\excel\\adactin.xlsx");
		// File file = new
		// File("C:\\Users\\SAM\\eclipse-workspace\\FirstSession\\excel\\facebook.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		String value = cell.getStringCellValue();
		if (value.equals(oldData)) {
			cell.setCellValue(newData);
		}
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);
	}

	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws IOException
	 * @see maintain the code to create new cell in the excel
	 * 
	 */
	public void createCell(String sheetName, int rowNum, int cellNum, String data) throws IOException {
		File file = new File("C:\\Users\\SAM\\eclipse-workspace\\FirstSession\\excel\\adactin.xlsx");
		// File file = new
		// File("C:\\Users\\SAM\\eclipse-workspace\\FirstSession\\excel\\facebook.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.createCell(cellNum);
		cell.setCellValue(data);
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		workbook.write(fileOutputStream);
	}

	/**
	 * 
	 * @param time
	 * @seemaintain implicit waits as seconds
	 */
	public void implicitWait(long time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	/**
	 * maintain to handle the alert to accept
	 */
	public void alertAccept() {
		Alert al = driver.switchTo().alert();
		al.accept();
	}

	/**
	 * @see maintain to handle the alert to dismiss
	 */
	public void alertDismiss() {
		Alert al = driver.switchTo().alert();
		al.dismiss();
	}

	/**
	 * 
	 * @param text
	 * @see maintain to send keys logic in alert
	 */
	public void alertSendKey(String text) {
		Alert al = driver.switchTo().alert();
		al.sendKeys(text);
	}
}
