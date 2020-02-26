package awsTest.acceptance;

import awsTest.AwsTestApplication;
import awsTest.models.DBData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= AwsTestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestControllerTest {
    @Value("${local.server.port}")
    private int port;

    @Autowired
    private TestRestTemplate mockRestTemplate;

    @Test
    public void getData_shouldReturnTestData() {
        ResponseEntity<DBData> response = mockRestTemplate.getForEntity("http://localhost:8080/getData", DBData.class);
        assertThat(response.getBody().getDbString(), is("testData"));
    }
}
