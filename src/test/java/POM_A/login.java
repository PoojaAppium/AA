package POM_A;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.microsoft.appcenter.appium.EnhancedAndroidDriver;

import Utility.Excel;
import Utility.Generic;
import io.appium.java_client.MobileElement;

public class login {
	
	
	
	
	
	
	
	
	EnhancedAndroidDriver<MobileElement> Driver ;
	 Generic G;
	 
	 public login(EnhancedAndroidDriver<MobileElement> Driver) {
		 this.Driver=Driver;
		 
	 }
	 
	By Title = By.xpath("//android.widget.TextView[@text='by Zenegy']");
	By TerminalID = By.xpath("(//android.widget.EditText[@index='3'])[1]");
	By Password = By.xpath("(//android.widget.EditText[@index='4'])[1]");
	By LoginButton = By.xpath("(//android.view.ViewGroup[@index='5'])[1]");
	By WrongCredErrorMessage = By.xpath("//android.widget.TextView[@bounds='[309,1154][772,1207]']");
	By TerminalNotFoundError = By.xpath("//android.widget.TextView[@bounds='[338,1154][743,1207]']");
	By PleaseEnterTerminalAndPassword = By.xpath("//android.widget.TextView[@bounds='[176,1131][904,1230]']");
	By ForgotPasswordButton = By.xpath("//android.widget.TextView[@index='4']");
	
	
	public void Wait(WebElement Web) {
		WebDriverWait WW = new WebDriverWait(Driver,12000);
		WW.until(ExpectedConditions.visibilityOf(Web));
	}
	
	
	
	
	public void ValidateTitle() {
		WebElement Ele = Driver.findElement(Title);
		Wait(Ele);
		Assert.assertTrue(Ele.isDisplayed());
	}
	
	
	public void FillTerminalID(String Terminalid) {
		G = new Generic(Driver);
		G.SendKeys(TerminalID, Terminalid);
	}
	
	public void FillPassword(String PasswordValue) {
		G = new Generic(Driver);
		G.SendKeys(Password, PasswordValue);
		
	}
	
	public void Submit() {
		WebElement submit = Driver.findElement(LoginButton);
		Wait(submit);
		submit.click();
	}
	
	public void ValidateError_WrongCredential(String Text) throws InterruptedException {
		Thread.sleep(3000);
		WebElement ErrorMessage = Driver.findElement(WrongCredErrorMessage);
		Wait(ErrorMessage);
		String ErrorText = ErrorMessage.getText();
		System.out.println(ErrorText);
		Assert.assertEquals(ErrorText , Text);
	}
	
	public void ValidateError_TerminalNotFound(String Text) throws InterruptedException {
		Thread.sleep(3000);
		WebElement ErrorMessage = Driver.findElement(TerminalNotFoundError);
		Wait(ErrorMessage);
		String ErrorText = ErrorMessage.getText();
		System.out.println(ErrorText);
		Assert.assertEquals(ErrorText , Text);
	}
	
	
	public void ValidateError_EmptyTerminalAndPassword(String Text) throws InterruptedException {
		Thread.sleep(3000);
		WebElement ErrorMessage = Driver.findElement(PleaseEnterTerminalAndPassword);
		Wait(ErrorMessage);
		String ErrorText = ErrorMessage.getText();
		System.out.println(ErrorText);
		Assert.assertEquals(ErrorText , Text);
	}
	
	public void ForgotPasswordButton(String Text) throws InterruptedException {
		Thread.sleep(3000);
		WebElement button = Driver.findElement(ForgotPasswordButton);
		Wait(button);
		button.click();
		
	}
	
	public void LoginUsingValidCred(String Text) throws InterruptedException {
		
		
	}
	
	public void LoginUsingInValidCred() throws InterruptedException {
		
		String	Terminalid = "PP-1";
			
			G = new Generic(Driver);
			G.SendKeys(TerminalID, Terminalid);
			G.SendKeys(Password, "12345");
			WebElement submit = Driver.findElement(LoginButton);
			Wait(submit);
			submit.click();
			
			//ASSERT TOAST
			Thread.sleep(3000);
			WebElement ErrorMessage = Driver.findElement(TerminalNotFoundError);
			Wait(ErrorMessage);
			String ErrorText = ErrorMessage.getText();
			System.out.println(ErrorText);
			Assert.assertEquals(ErrorText , "Terminal app not found");
			
			
			ErrorMessage.click();
			
		
	}
	
	
	
	
	
//___________________________________________ TC_1_____________________________________________________________________________________________________
	
	
	public void TC_1() throws IOException, InterruptedException {
	
		Excel E = new Excel(Driver);
	String	Terminalid = E.ReadFromExcel(6, 2);
		
		G = new Generic(Driver);
		G.SendKeys(TerminalID, Terminalid);
		G.SendKeys(Password, "12345");
		WebElement submit = Driver.findElement(LoginButton);
		Wait(submit);
		submit.click();
		
		//ASSERT TOAST
		Thread.sleep(3000);
		WebElement ErrorMessage = Driver.findElement(TerminalNotFoundError);
		Wait(ErrorMessage);
		String ErrorText = ErrorMessage.getText();
		System.out.println(ErrorText);
		Assert.assertEquals(ErrorText , "Terminal app not found");
		
		
		ErrorMessage.click();
		
		
	}
	
	public void TC_2() throws IOException, InterruptedException {
		
		Excel E = new Excel(Driver);
	String	Terminalid = E.ReadFromExcel(7, 2);
		
		G = new Generic(Driver);
		G.SendKeys(TerminalID, Terminalid);
		G.SendKeys(Password, "65566");
		WebElement submit = Driver.findElement(LoginButton);
		Wait(submit);
		submit.click();
		
		//ASSERT TOAST
	//	Thread.sleep(20000);
		WebElement ErrorMessage = Driver.findElement(WrongCredErrorMessage);
		Wait(ErrorMessage);
		String ErrorText = ErrorMessage.getText();
		System.out.println(ErrorText);
		Assert.assertEquals(ErrorText , "Wrong Credentials Entered");
		

		ErrorMessage.click();
		
	}
	
	public void TC_3() throws IOException, InterruptedException {
		
		Excel E = new Excel(Driver);
	String	Terminalid = E.ReadFromExcel(8, 2);
		
		G = new Generic(Driver);
		G.SendKeys(TerminalID, Terminalid);
		G.SendKeys(Password, "12345");
		WebElement submit = Driver.findElement(LoginButton);
		Wait(submit);
		submit.click();
		
		//ASSERT TOAST
		Thread.sleep(3000);
		WebElement ErrorMessage = Driver.findElement(PleaseEnterTerminalAndPassword);
		Wait(ErrorMessage);
		String ErrorText = ErrorMessage.getText();
		System.out.println(ErrorText);
		Assert.assertEquals(ErrorText , "Please enter your Terminal Id and Password to login");
		

		ErrorMessage.click();
		
	}
	
	public void TC_4() throws IOException, InterruptedException {
		
		Excel E = new Excel(Driver);
	String	Terminalid = E.ReadFromExcel(9, 2);
	String	password = E.ReadFromExcel(17, 3);
		
		G = new Generic(Driver);
		G.SendKeys(TerminalID, Terminalid);
		G.SendKeys(Password, password);
		WebElement submit = Driver.findElement(LoginButton);
		Wait(submit);
		submit.click();

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
