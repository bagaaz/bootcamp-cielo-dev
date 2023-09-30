package ada.tech.cielo3.infra.queue;

import ada.tech.cielo3.domain.entities.Customer;

public interface ServiceQueueInterface {
    void enqueue(Customer customer);
    Customer dequeue();
    Customer getFirst();
    boolean isEmpty();
    boolean isFull();
}
