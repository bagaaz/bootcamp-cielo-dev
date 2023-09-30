package ada.tech.cielo3.application.usecases;

import ada.tech.cielo3.application.dtos.OutputGetQueueItem;
import ada.tech.cielo3.domain.entities.Customer;
import ada.tech.cielo3.infra.database.repository.ServiceQueueRepository;

public class GetQueueItem {

    private ServiceQueueRepository queueRepository;

    public OutputGetQueueItem execute() {
        Customer customer = this.queueRepository.getCustomerByQueue();
        return new OutputGetQueueItem(
            customer.getUuid(),
            customer.getFullName(),
            customer.getCpf().getValue(),
            customer.getEmail().getValue(),
            customer.getCompany().getCnpj() == null ? null : customer.getCompany().getCnpj().getValue(),
            customer.getCompany().getCompanyName(),
            customer.getCompany().getMerchantCategoryCode()
        );
    }
}
