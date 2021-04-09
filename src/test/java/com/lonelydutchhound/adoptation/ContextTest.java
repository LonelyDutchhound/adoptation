//package com.lonelydutchhound.adoptation;
//
//import com.lonelydutchhound.adoptation.configuration.CoreContextConfiguration;
//import org.junit.ClassRule;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.util.TestPropertyValues;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.context.ApplicationContextInitializer;
//import org.springframework.context.ConfigurableApplicationContext;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
//import org.testcontainers.containers.PostgreSQLContainer;
//import org.testcontainers.junit.jupiter.Testcontainers;
//
//import java.util.Map;
//
//import static org.assertj.core.api.BDDAssertions.then;
//
//@Testcontainers
//@ActiveProfiles("test")
//@SpringJUnitConfig
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//@TestPropertySource(properties = {"management.port=0"})
//@ContextConfiguration(classes = {CoreContextConfiguration.class}, initializers = ContextTest.Initializer.class)
//public class ContextTest {
//
//
//    public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:13-alpine")
//            .withDatabaseName("integration-tests-db")
//            .withUsername("sa")
//            .withPassword("sa");
//
//    static {
//        postgreSQLContainer.start();
//    }
//
//
//    @LocalServerPort
//    private int port;
//
//    @Value("${local.management.port}")
//    private int mgt;
//
//    @Autowired
//    private TestRestTemplate testRestTemplate;
//
//    @Test
//    public void shouldReturn200WhenSendingRequestToManagementEndpoint() throws Exception {
//        @SuppressWarnings("rawtypes")
//        ResponseEntity<Map> entity = this.testRestTemplate.getForEntity(
//                "http://localhost:" + this.mgt + "/actuator/info", Map.class);
//
//        then(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
//    }
//
//    static class Initializer
//            implements ApplicationContextInitializer<ConfigurableApplicationContext> {
//        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
//            TestPropertyValues.of(
//                    "db.url=" + postgreSQLContainer.getJdbcUrl(),
//                    "db.username=" + postgreSQLContainer.getUsername(),
//                    "db.password=" + postgreSQLContainer.getPassword()
//            ).applyTo(configurableApplicationContext.getEnvironment());
//        }
//    }
//
//}
