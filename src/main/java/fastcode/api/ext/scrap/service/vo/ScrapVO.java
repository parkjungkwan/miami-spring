package fastcode.api.ext.scrap.service.vo;

import java.util.List;


public class ScrapVO {
	public static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; // 드라이버 ID
	public static final String WEB_DRIVER_PATH = "C:\\Users\\pakjk\\____\\482__Spring\\21__047\\workspace\\lms5\\src\\main\\resources\\chromedirver.exe"; // 드라이버 경로

	public static void main(String[] args) {
		try {
			System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
		} catch (Exception e) {
			e.printStackTrace();
		}
		ChromeOptions options = new ChromeOptions();
		options.addArguments("headless");
		WebDriver driver = new ChromeDriver(options);
		String url = "https://www.naver.com";

		driver.get(url);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}
		;
		List<WebElement> el1 = driver.findElements(By.className("nav"));

		for (int i = 0; i < el1.size(); i++) { // nav 클래스의 객체 중 "뉴스"라는 텍스트를 가진 WebElement를 클릭한다.
			if (el1.get(i).getText().equals("뉴스")) {
				el1.get(i).click();
				break;
			}
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}

		WebElement el2 = driver.findElement(By.id("section_it"));
		List<WebElement> el3 = el2.findElements(By.tagName("strong"));

		int count = 0;
		for (int i = 0; i < el3.size(); i++) { // 뉴스의 제목을 모두 출력한다.
			System.out.println(++count + "번 뉴스: " + el3.get(i).getText());
		}

		try { // 드라이버가 null이 아니라면
			if (driver != null) { // 드라이버 연결 종료
				driver.close(); // 드라이버 연결 해제 //프로세스 종료
				driver.quit();
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}

	}
}
