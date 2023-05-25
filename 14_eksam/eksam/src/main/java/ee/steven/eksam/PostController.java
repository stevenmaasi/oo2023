package ee.steven.eksam;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
    private static final String CHROME_DRIVER_PATH = "C:\\Users\\Stewmeister\\Downloads\\chromedriver.exe";
    @Autowired
    PostRepository postRepository;

    @PostMapping("archive-post")
    public String archivePost(@RequestBody String instagramUrl) {
        try {
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            WebDriver driver = new ChromeDriver(options);

            driver.get(instagramUrl);
            Thread.sleep(3000);

            String htmlContent = driver.getPageSource();

            driver.quit();

            Document document = Jsoup.parse(htmlContent);
            Elements imgElements = document.select("div._aagv img");

            if (imgElements.isEmpty()) {
                return "No image found in the specified Instagram post.";
            }

            String imgUrls = imgElements.first().attr("srcset");

            String[] urls = imgUrls.split(",");
            String lastUrl = urls[urls.length - 1].trim();
            String imgUrl = lastUrl.substring(0, lastUrl.length() - 6);

            postRepository.save(new Post(instagramUrl, imgUrl));

            System.out.println("Image URL: " + imgUrl);
            return "Saved!";
        } catch (InterruptedException e) {
            e.printStackTrace();
            return "Error occurred while processing the Instagram post.";
        }

    }
}
