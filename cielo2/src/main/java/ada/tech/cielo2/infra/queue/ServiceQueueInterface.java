package ada.tech.cielo2.infra.queue;

import ada.tech.cielo2.domain.entities.Customer;
import ada.tech.cielo2.infra.database.models.CustomerModel;

public interface ServiceQueueInterface {
    void enqueue(Customer customer);
    Customer dequeue();
    Customer getFirst();
    boolean isEmpty();
    boolean isFull();
}
