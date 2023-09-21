import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.TypeOptions.text;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.time.Duration.ofMillis;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class Check {

    @BeforeAll
    static void setup() {
        Configuration.browser = "firefox";
        Configuration.browserVersion = "116.0.2";
    }

    @Test
    public void makeCheck() throws InterruptedException {

        Selenide.open("http://localhost:5000");

        $("[name='username']").type(text("admin").withDelay(ofMillis(100)));
        $("[name='username']").type(text("Parole123").withDelay(ofMillis(100)));
        $("[type='button']").click();

        Thread.sleep(3000);

        assertThat("Tasks page not opened", getWebDriver().getCurrentUrl(), is("http://localhost:5000/tasks"));
    }
}
