package by.it.academy.dodo.config;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * Configuration class for setting up application-specific beans and configurations.
 * This class defines a method to create and configure a JPAQueryFactory bean.
 */
@Configuration
public class ApplicationConfig {

    /**
     * Creates and configures a JPAQueryFactory bean.
     *
     * @param entityManager The EntityManager used by JPAQueryFactory.
     * @return An instance of JPAQueryFactory configured with the provided EntityManager.
     */
    @Bean
    public JPAQueryFactory jpaQueryFactory(EntityManager entityManager){
        return new JPAQueryFactory(entityManager);
    }
}
