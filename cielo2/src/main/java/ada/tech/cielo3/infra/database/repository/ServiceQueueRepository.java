package ada.tech.cielo3.infra.database.repository;

import ada.tech.cielo3.domain.entities.Customer;
import ada.tech.cielo3.infra.queue.ServiceQueue;
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
