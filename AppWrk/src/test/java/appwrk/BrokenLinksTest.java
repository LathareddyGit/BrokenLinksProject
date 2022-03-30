package appwrk;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import brokenLinksMap.BrokenLinksObjs;
import browsersettings.*;

public class BrokenLinksTest {
	
	WebDriver driver = null;
	List<BrokenLinksObjs> allBrokenLinks = null;
	
	@BeforeTest
	public void beforeTest() {
		BrowserSetting bs = new BrowserSetting();

		driver = bs.BrowserSettings();

	}
	
	@AfterTest
	public void afterTest() {
		System.out.println("Printing all broken links");
		for(BrokenLinksObjs obj: allBrokenLinks) {
			System.out.println("Url:::   "+obj.getUrl()+"    ::responsecode::   "+obj.getResponseCode());
		}
	}
	
	@Test
	public void test1() {
		System.out.println("In test1");		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total links on home page are"+allLinks.size());
		allBrokenLinks = new ArrayList<BrokenLinksObjs>();
		for(WebElement eachLink: allLinks) {
			String hrefLink = null;
			
			try {
				hrefLink = eachLink.getAttribute("href");	
			}catch(Exception e) {
				
			}
			
			if(hrefLink!=null) {
				try {
					URL url = new URL(hrefLink);
					HttpURLConnection con = (HttpURLConnection) url.openConnection();
					if(con.getResponseCode()==404) {
						BrokenLinksObjs obj = new BrokenLinksObjs();
						obj.setEle(eachLink);
						obj.setResponseCode(con.getResponseCode());
						obj.setUrl(hrefLink);
						allBrokenLinks.add(obj);
					}
					
					
				} catch (Exception e) {
					
					System.out.println("Malformed url:::"+hrefLink);
				}
			}
			
		}	
		
	}

}
