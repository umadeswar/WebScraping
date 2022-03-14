package pageobjects;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.ExcelUtils;
import utils.Helper;
import config.ScrapingConfig;
public class WebScrapingObjects {
	WebDriver driver;
	Helper helper = new Helper(driver);

	public WebScrapingObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="text-input-what")
	WebElement inputWhat;

	@FindBy(id="text-input-where")
	WebElement inputWhere;

	@FindBy(className ="yosegi-InlineWhatWhere-primaryButton")
	WebElement searchButton;

	@FindBy(xpath ="//div[@class='yosegi-FilterPill-dropdownPillContainer'][2]")
	WebElement selectDatePosted;

	@FindBy(xpath="//div[@class='yosegi-FilterPill-dropdownPillContainer'][2]/ul/li[1]")
	WebElement selectTimeinDropDown;

	@FindBy(id="popover-x")
	WebElement alert;

	//	@FindBy(xpath="//div[@class='job_seen_beacon']")
	//	List<WebElement> jobList;

	@FindBy(xpath="//div[@id='mosaic-provider-jobcards']/a")
	List<WebElement> jobList;

	@FindBy(css = "p[class='jobsearch-HiringInsights-entry--bullet'] span[class='jobsearch-HiringInsights-entry--text']")
	WebElement jobDate;

	@FindBy(xpath="//h1[@class='icl-u-xs-mb--xs icl-u-xs-mt--none jobsearch-JobInfoHeader-title is-embedded']")
	WebElement jobTitle;

	@FindBy(xpath="//div[@class='jobsearch-InlineCompanyRating icl-u-xs-mt--xs icl-u-xs-mb--md']")
	WebElement companyName;

	@FindBy(xpath="//div[@class='icl-u-xs-mt--xs is-embedded jobsearch-JobInfoHeader-subtitle icl-u-xs-mb--md']/div[2]")
	WebElement jobLocation;

	@FindBy(xpath="//div[@class='jobsearch-JobDescriptionSection-sectionItem']/div[2]")
	WebElement jobType;

	@FindBy(xpath="//div[@id='jobDescriptionText']")
	WebElement jobDesc;

	@FindBy(css="a[aria-label='Next']") //"//ul[@class='pagination-list']//li[last()]")
	WebElement pagination;


	public void setInputWhat(String text) {
		inputWhat.sendKeys(text);
	}

	public void setInputWhere(String text) {
		//		inputWhere.sendKeys(Keys.CONTROL,"A") ;
		//		inputWhere.sendKeys(Keys.DELETE);
		//		inputWhere.sendKeys(text);
		Actions action = new Actions(driver); 
		action.doubleClick(inputWhere).sendKeys(Keys.BACK_SPACE).doubleClick(inputWhere).sendKeys(Keys.BACK_SPACE).sendKeys("Remote").build().perform(); 
	}

	public void clickSearch() {
		searchButton.click();
	}
	public void clickDatePosted() {
	//	WebElement ele = driver.findElement(By.xpath("//div[@class='yosegi-FilterPill-dropdownPillContainer'][2]"));
		//helper.WaitforElement(selectDatePosted, 30);
		//WebDriverWait wait = new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='yosegi-FilterPill-dropdownPillContainer'][2]")));
		selectDatePosted.click();
	}
	public void clickTime() {
		selectTimeinDropDown.click();
	}
	public void closeAlert() {
		alert.click();
	}
	public List<WebElement> getJobList() {
		return jobList;
	}
	public String getjobType() {
		return jobType.getText();
	}
	public String getjobTitle() {
		return jobTitle.getText();
	}
	public String getjobDate() {
		return jobDate.getText();
	}
	public String getcompanyName() {
		return companyName.getText();
	}
	public String getjobDesc() {
		return jobDesc.getText();
	}
	public String getjobLOcation() {
		return jobLocation.getText();
	}
	public String getScrapedDate() {
	//	String timeStamp = new SimpleDateFormat("yyyy/MM/dd_HH:mm:ss").format(Calendar.getInstance().getTime());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		String scrappedDate = dtf.format(now);
		return scrappedDate;
	}
	//	public boolean getPagination() {
	//		String a= pagination.getText();
	//		//System.out.println("LINK TXT"+a);
	//		if(a.isEmpty()) {
	//			 pagination.click();
	//			return true;
	//		}
	//		else {
	//		
	//		 return false;
	//		 }
	//	}
	public void getPagination() {
		pagination.click();

	}

	//	public void scrapeAllData(String excelpath) {
	//		int currentRow=0;
	//		int validate=1;
	//		
	//		ArrayList<String> data = new ArrayList<String>();
	//		ExcelUtils xlUtils= new ExcelUtils(excelpath);
	//		while(validate==1) {
	//			try {
	//				try {
	//				closeAlert();}
	//				catch(Exception e) {
	//					System.out.println("pop");
	//				}
	//				List<WebElement> allJobsList = getJobList();
	//				helper.waitInSec(2000);
	//
	//				for(int i=0;i<allJobsList.size();i++) {
	//					currentRow++;
	//					WebElement yourElement = allJobsList.get(i);
	//					List<WebElement> disable = driver.findElements(By.xpath("//span[@class='more_loc_container']"));
	//					for(WebElement a: disable)
	//					{
	//						helper.disableElement(a);
	//					}
	//
	//					System.out.println("***************"+i+"**********");
	//					helper.WaitforElement(allJobsList.get(i),30);
	//					allJobsList.get(i).click(); 
	//					closeAlert();		
	//					helper.waitInSec(2000);
	//					driver.switchTo().frame(0);
	//					try {
	//						closeAlert();}
	//						catch(Exception e) {
	//							System.out.println("pop");
	//						}		
	//
	//					WebElement disable2 = driver.findElement(By.xpath("//button[@class='mpci-hao5hh']"));
	//					helper.disableElement(disable2);
	//
	//					data.add(getjobDate());
	//					data.add(getjobTitle());
	//					data.add(getcompanyName());
	//					data.add(getjobLOcation());
	//					
	//					try { 
	//						data.add(getjobType());
	//					}
	//					catch(Exception e) {
	//						data.add("N/A");
	//					}
	//					try{ 
	//						data.add(getjobDesc());
	//					}
	//					catch(Exception e) { 
	//						data.add("N/A");
	//
	//					} 
	//
	//					data.add(getScrapedDate());
	//					xlUtils.writeToExcel(data, "JobScrappedSheet", currentRow);
	//					data.clear();
	//					driver.switchTo().defaultContent();
	//					helper.WaitforElement(allJobsList.get(i), 30);
	//
	//				}
	//
	//				try {
	//					Thread.sleep(2000);
	//					getPagination();
	//					Thread.sleep(2000);
	//				}
	//				catch(Exception e) {
	//					validate = 0;
	//					break;
	//				}
	//
	//			}
	//			catch(Exception e) {
	//				System.out.println(e.getMessage());
	//			}
	//		}
	//}
	public void scrapeAllData(String excelpath,String keyword) throws InterruptedException, IOException {
		int currentRow=1;
		int validate=1;
		Helper helper = new Helper(driver);
		ArrayList<String> data = new ArrayList<String>();
		ExcelUtils xlUtils= new ExcelUtils(excelpath);
		data.add("Job Category");
		data.add("Job Title");
		data.add("Job Type");
		data.add("Job Company Name");
		data.add("Job Location");
		data.add("Job Posted Date");
		data.add("Job Description");		
		data.add("Job Scraped URL");
		data.add("Job Scraped Date");
		xlUtils.writeToExcel(data, "JobScrappedSheet", 0);
		data.clear();
		while(validate==1) {
			try {

				closeAlert();		
			}
			catch (Exception e) {
				//System.out.println("No pop up");
			}

			Thread.sleep(2000);
			List<WebElement> allJobsList = getJobList();
			Thread.sleep(1000);
			System.out.println(allJobsList.size());
		
			
		
			for(int i=0;i<allJobsList.size();i++) {
				data.add(keyword);
				
				List<WebElement> disable = driver.findElements(By.xpath("//span[@class='more_loc_container']"));
				for(WebElement a: disable) {
					helper.disableElement(a);
				}
				System.out.println("***************"+i+"st Row **********");
				helper.WaitforElement(allJobsList.get(i), 30);
				allJobsList.get(i).click(); 
				try {
					closeAlert();		
				}
				catch (Exception e) {
					System.out.println("No pop up");
				}
				String jobURL=allJobsList.get(i).getAttribute("href");
				System.out.println(jobURL);
				
				
				Thread.sleep(1000);
				driver.switchTo().frame(0);
				
				try {
					closeAlert();
					WebElement disable2 = driver.findElement(By.xpath("//button[@class='mpci-hao5hh']"));
					helper.disableElement(disable2);
				}
				catch (Exception e) {
					System.out.println("No pop up");
				}
				
				String jobTitle = getjobTitle();
				System.out.println("TITLE:"+jobTitle); 
				data.add(jobTitle);

				
				try {
					String jobType = getjobType();
					System.out.println("Job Type"+jobType);
					data.add(jobType);
				}
				catch(Exception e) {
					data.add("N/A");
				}
				String companyName = getcompanyName();
				System.out.println("company name"+companyName);
				data.add(companyName);
				

				String jobLocation = getjobLOcation();
				System.out.println(jobLocation); 
				data.add(jobLocation);
				
				String jobDate = getjobDate();
				System.out.println("Job Date "+jobDate);
				data.add(jobDate);

		
				
				try {
					Thread.sleep(2000);
					String jobDesc = getjobDesc();
					System.out.println("Job Desc"+jobDesc);
					data.add(jobDesc);
				}
				catch(Exception e) {
					System.out.println("No Job Desc");
					data.add("N/A");

				} 	
				
				
			
				data.add(jobURL);
				String scrappedDate = getScrapedDate();
				data.add(scrappedDate);
				
				xlUtils.writeToExcel(data, "JobScrappedSheet", currentRow);
				
				currentRow++;
				data.clear();
				driver.switchTo().defaultContent();
				helper.WaitforElement(allJobsList.get(i), 30);

			}

			try {
				Thread.sleep(2000);
				getPagination();
				Thread.sleep(2000);
				
			}
			catch(Exception e) {
				

				validate = 0;
				break;
			}

		}


	}
}



