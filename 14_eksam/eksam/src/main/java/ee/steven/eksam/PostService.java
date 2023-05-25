package ee.steven.eksam;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    // private static final String CHROME_DRIVER_PATH = "C:\\Users\\Stewmeister\\Downloads\\chromedriver.exe";
    private static final String CHROME_DRIVER_PATH = "C:\\Users\\Student Admin\\Downloads\\chromedriver.exe";

    @Autowired
    PostRepository postRepository;

    public String archivePost(String instagramUrl) {
        try {
            Document htmlDocument = this.getHtmlDocument(instagramUrl);

            String image = this.getImage(htmlDocument);
            String title = this.getTitle(htmlDocument);

            return "Title: " + title + "\nImage URL: " + image;
        } catch (InterruptedException e) {
            return "Error occurred while processing the Instagram post.";
        }
    }

    private Document getHtmlDocument(String instagramUrl) throws InterruptedException {
        try {
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            WebDriver driver = new ChromeDriver(options);

            driver.get(instagramUrl);
            Thread.sleep(5000);

            String htmlContent = driver.getPageSource();

            driver.quit();

            return Jsoup.parse(htmlContent);
        } catch (InterruptedException e) {
            System.out.println("Error occurred while processing the Instagram post.");
            throw e;
        }
    }

    private String getImage(Document document) {
        Elements imgElements = document.select("div._aagv img");

        if (imgElements.isEmpty()) {
            return "No image found in the specified Instagram post.";
        }

        String imgUrls = imgElements.first().attr("srcset");

        String[] urls = imgUrls.split(",");
        String lastUrl = urls[urls.length - 1].trim();
        String imgUrl = lastUrl.substring(0, lastUrl.length() - 6);

        // postRepository.save(new Post(instagramUrl, imgUrl));

        return imgUrl;
    }

    private String getTitle(Document document) {
        Elements h1Elements = document.getElementsByTag("title");
        // postRepository.save(new Post(instagramUrl, imgUrl));

        for (Element element : h1Elements) {
            return element.text();
        }

        return "No title found in the specified Instagram post.";
    }
}
