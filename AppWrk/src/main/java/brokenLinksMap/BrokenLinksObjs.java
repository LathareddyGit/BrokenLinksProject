package brokenLinksMap;

import org.openqa.selenium.WebElement;

public class BrokenLinksObjs {

	private static int responseCode;
	private static String url;
	private static WebElement ele;
	
	public static WebElement getEle() {
		return ele;
	}

	public static void setEle(WebElement ele) {
		BrokenLinksObjs.ele = ele;
	}

	public static int getResponseCode() {
		return responseCode;
	}
	
	public static void setResponseCode(int responseCode) {
		BrokenLinksObjs.responseCode = responseCode;
	}
	
	public static String getUrl() {
		return url;
	}
	
	public static void setUrl(String url) {
		BrokenLinksObjs.url = url;
	}
	
	
}
