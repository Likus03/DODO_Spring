package by.it.academy.dodo.repositories.client;

import by.it.academy.dodo.entities.Client;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.UUID;

import static by.it.academy.dodo.entities.QClient.client;

public class ClientRepositoryCustomImpl extends QuerydslRepositorySupport implements ClientRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    public ClientRepositoryCustomImpl(JPAQueryFactory jpaQueryFactory) {
        super(Client.class);
        this.jpaQueryFactory = jpaQueryFactory;
    }

    @Override
    public boolean deleteClient(UUID id) {
        long deleteCount = jpaQueryFactory.delete(client)
                .where(client.id.eq(id))
                .execute();

        return deleteCount > 0;
    }

    @Override
    public boolean updateClient(UUID id, Client newClient) {
        long updateCount = jpaQueryFactory.update(client)
                .set(client.firstname, newClient.getFirstname())
                .set(client.email, newClient.getEmail())
                .where(client.id.eq(id))
                .execute();

        return updateCount > 0;
    }
}
