package ada.tech.cielo2.infra.database.repository;

import ada.tech.cielo2.domain.entities.Customer;
import ada.tech.cielo2.infra.queue.ServiceQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ServiceQueueRepository {

    @Autowired
    private ServiceQueue serviceQueue;

    public Customer getCustomerByQueue() {
        Customer customer = serviceQueue.getFirst();
        serviceQueue.dequeue();
        return customer;
    }
}
