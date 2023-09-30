package ada.tech.cielo2.infra.queue;

import ada.tech.cielo2.domain.entities.Customer;
import ada.tech.cielo2.exceptions.BadRequestException;
import org.springframework.stereotype.Service;

@Service
public class ServiceQueue implements ServiceQueueInterface {
    private Customer[] data;
    private int front = 0;
    private int rear = -1;
    private int size = 0;

    public ServiceQueue(int capacity) {
        data = new Customer[capacity];
    }

    public ServiceQueue() {
        data = new Customer[10];
    }

    public void enqueue(Customer customer) {
        if (isFull()) {
            resize();
        }
        rear = (rear + 1) % data.length;
        data[rear] = customer;
        size++;
        System.out.println("Enqueued customer: " + customer);
    }

    public Customer dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("ServiceQueue is empty");
        }
        Customer customer = data[front];
        front = (front + 1) % data.length;
        size--;
        return customer;
    }

    public Customer getFirst() {
        if (isEmpty()) {
            throw new BadRequestException("ServiceQueue is empty");
        }
        return data[front];
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == data.length;
    }

    private void resize() {
        Customer[] newData = new Customer[2 * data.length];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[(front + i) % data.length];
        }
        front = 0;
        rear = data.length - 1;
        data = newData;
    }
}
