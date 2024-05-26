package by.it.academy.dodo.config;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Configuration class for setting up application-specific beans and configurations.
 * This class defines a method to create and configure a JPAQueryFactory bean.
 */
@Configuration
public class ApplicationConfig {
//    @Bean
//    public MongoClient mongo() {
//        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
//        MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
//                .applyConnectionString(connectionString)
//                .build();
//
//        return MongoClients.create(mongoClientSettings);
//    }
//
//    @Bean
//    public MongoTemplate mongoTemplate() {
//        return new MongoTemplate(mongo(), "dodo");
//    }
}
