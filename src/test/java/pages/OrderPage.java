package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage {

	public OrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(id="ctl00_MainContent_fmwOrder_ddlProduct")
	public WebElement findProduct;
	
	
	@FindBy(id="ctl00_MainContent_fmwOrder_txtQuantity")
	public WebElement findQuantity;
	
	
	@FindBy(id="ctl00_MainContent_fmwOrder_txtUnitPrice")
	public WebElement findPrice;
	
	
	@FindBy(id="ctl00_MainContent_fmwOrder_txtDiscount")
	public WebElement findDiscount;
	
	
	@FindBy(id="ctl00_MainContent_fmwOrder_txtTotal")
	public WebElement findTotal;
	
	
	@FindBy(xpath="//input[@class='btn_dark'][@value='Calculate']")
	public WebElement clickCalculate;
	

	@FindBy(id="ctl00_MainContent_fmwOrder_txtName")
	public WebElement findName;
	
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox2")
	public WebElement findStreet;
	
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox3")
	public WebElement findCity;
	
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox4")
	public WebElement findState;
	
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox5")
	public WebElement findZip;
	
	
	@FindBy(name="ctl00$MainContent$fmwOrder$cardList")
	public WebElement findCard;
	
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox6")
	public WebElement findCardNumber;
	
	
	@FindBy(id="ctl00_MainContent_fmwOrder_TextBox1")
	public WebElement findExpire;
	
	
	@FindBy(id="ctl00_MainContent_fmwOrder_InsertButton")
	public WebElement clickProcess;

	
	@FindBy(id="//*[@id=\"ctl00_menu\"]/li[1]/a")
	public WebElement viewOrders;
	
	
	
	
}
