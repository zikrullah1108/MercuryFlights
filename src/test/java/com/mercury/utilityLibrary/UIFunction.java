package com.mercury.utilityLibrary;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import static org.junit.Assert.*;

import com.google.common.base.Function;

/***
 * 
 * @author zikrul-PC
 *
 */
public class UIFunction {
	private WebDriver driver;

	// Constructor
	public UIFunction(WebDriver _driver) {
		driver = _driver;
	}

	/***
	 * This method starts firefox browser
	 * 
	 * @return
	 */
	private WebDriver startFirefoxBrowser() {
		try {
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
		return driver;
	}

	/***
	 * This method starts IE browser
	 * 
	 * @return
	 */
	private WebDriver startIEBrowser() {
		try {
			System.setProperty("webdriver.ie.driver", "src/test/resources/IEDriverServer.exe");
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);

			driver = new InternetExplorerDriver(cap);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
		return driver;
	}

	/***
	 * This method starts chrome browser
	 * 
	 * @return
	 */
	private WebDriver startChromeBrowser() {
		try {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");

			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}

		return driver;
	}

	/***
	 * This method starts user defined browser
	 * 
	 * @param browserName
	 * @return
	 */
	public WebDriver startLocalBrowser(String browserName) {
		try {
			if (browserName.contains("IE")) {
				driver = startIEBrowser();
			} else if (browserName.contains("Chrome")) {
				driver = startChromeBrowser();
			} else if (browserName.contains("Firefox")) {
				driver = startFirefoxBrowser();
			} else {
				throw new Exception(
						"You choose '" + browserName + "', Currently supporting browsers are 'IE, Chrome and Firefox'");
			}
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
		return driver;
	}
	/***
	 * This method waits for user given seconds
	 * @param inSeconds
	 */
	public void customWait(int inSeconds)
	{
		try {
			Thread.sleep(inSeconds * 1000);
		} catch (InterruptedException ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	/***
	 * This method used for dynamic element search
	 * @param by
	 * @return
	 */
	public WebElement fluentWait(final By by)
	{
		WebElement targetElem = null;
		
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30,TimeUnit.SECONDS)
					.pollingEvery(3,TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			
			targetElem = wait.until(new Function<WebDriver, WebElement>()
					{
						public WebElement apply(WebDriver driver)
						{
							return driver.findElement(by);
						}
					});
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
		return targetElem;
	}
	
	/***
	 * This method enters user defined text to text field
	 * @param by
	 * @param textValue
	 */
	public void enterTextField(By by, String textValue)
	{
		try {
			WebElement textFieldElem = driver.findElement(by);
			textFieldElem.clear();
			textFieldElem.sendKeys(textValue);
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	/***
	 * This method clicks any user given element
	 * @param by
	 */
	public void clickElement(By by)
	{
		try {
			WebElement element = driver.findElement(by);
			element.click();
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	/***
	 * This method verifies user defined page title
	 * @param ExpectPageTitle
	 */
	public void verifyTitle(String ExpectPageTitle)
	{
		try {
			if(! ExpectPageTitle.equals(driver.getTitle()))
			{
				System.out.println("Page Title: '" + driver.getTitle() + "'");
				throw new IllegalStateException("This is not the right page title");
			}
			System.out.println(driver.getTitle());
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	/***
	 * This method selects radio button by index
	 * @param by
	 * @param index
	 */
	public void selectRadioButton(By by, int index) {
		
		try {
			WebElement radio = driver.findElement(by);
			List<WebElement> radioButtonGroup = radio.findElements(By.tagName("input"));
			radioButtonGroup.get(index).click();
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	/***
	 * This method selects radio button if parent id can not be found
	 * @param by
	 * @param index
	 */
	public void selectRadioButton2(By by, int index) {
		
		try {
			List<WebElement> radioButtonGroup = driver.findElements(by);
			radioButtonGroup.get(index).click();
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	/***
	 * This method selects radio button by label
	 * @param by
	 * @param labelName
	 */
	public void selectRadioButton(By by, String labelName) {
		
		try {
			WebElement radio = driver.findElement(by);
			List<WebElement> radioButtonGroupLabels = radio.findElements(By.tagName("label"));
			for (WebElement labelElement : radioButtonGroupLabels) {
				if (labelElement.getText().contains(labelName)) {
					labelElement.click();
					break;
				}
			}
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	/***
	 * This method selects drop-down value (Used only for Select and option HTML tags)
	 * @param by
	 * @param targetValue
	 */
	public void selectDropDown(By by, String targetValue)
	{
		try {
			WebElement dropDownElem = driver.findElement(by);
			Select selectList = new Select(dropDownElem);
			selectList.selectByVisibleText(targetValue);
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	/***
	 * This method verifies the actual text in page with text we expect.
	 * @param by
	 * @param expectedText
	 */
	public void verifyText(By by, String expectedText)
	{
		try {
			WebElement TextElem = driver.findElement(by);
			String actualText = TextElem.getText();
			if(!actualText.equals(expectedText))
			{
				System.out.println("Verify text is: " + actualText);
			}
			assertEquals(expectedText, actualText);
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	/***
	 * This method verifies text that has parent element
	 * @param parentBy
	 * @param childBy
	 * @param index
	 * @param expectedText
	 */
	public void verifyText(By parentBy, By childBy, int index, String expectedText)
	{
		try {
			WebElement parentElem = driver.findElement(parentBy);
			List<WebElement> childElems = parentElem.findElements(childBy);
			WebElement childElem = childElems.get(index);
			String actualText = childElem.getText();
			if(!actualText.equals(expectedText))
			{
				System.out.println("Verify text is: " + actualText);
			}
			assertEquals(expectedText, actualText);
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	/***
	 * This method handles browser check-box element
	 * @param checkBoxLocator
	 * @param isCheck
	 */
	public void handleCheckBox(By checkBoxLocator, boolean isCheck)
	{
		try {
			WebElement CheckBoxElem = driver.findElement(checkBoxLocator);
			boolean userCheckboxState = CheckBoxElem.isSelected();
			
			if(isCheck == true)
			{
				if(userCheckboxState == true) //default selected
				{
					//do nothing
				} else //default not selected
				{
					CheckBoxElem.click();
				}
			}else //user do not wanna select
			{
				if(userCheckboxState == true) //default selected
				{
					CheckBoxElem.click();
				} else {
					//do nothing
				}
			}
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	/***
	 * This method handles browser check-box element that has parent
	 * @param checkBoxLocator
	 * @param isCheck
	 */
	public void handleCheckBox(By ParentCheckBoxLocator, int index, boolean isCheck)
	{
		try {
			List<WebElement> parentCheckBoxElems = driver.findElements(ParentCheckBoxLocator);
			WebElement childCheckBoxElem = parentCheckBoxElems.get(index);
			boolean userCheckboxState = childCheckBoxElem.isSelected();
			
			if(isCheck == true)
			{
				if(userCheckboxState == true) //default selected
				{
					//do nothing
				} else //default not selected
				{
					childCheckBoxElem.click();
				}
			}else //user do not wanna select
			{
				if(userCheckboxState == true) //default selected
				{
					childCheckBoxElem.click();
				} else {
					//do nothing
				}
			}
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	/***
	 * this method prints the given String in the console
	 * @param printValue
	 */
	public void printText(By by, String additionalText)
	{
		try {
			WebElement textElem = driver.findElement(by);
			String printValue = textElem.getText();
			System.out.println(additionalText + printValue);
		} catch (Exception ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}
