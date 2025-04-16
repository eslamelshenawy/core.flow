package com.core.flow.crm;


import com.core.flow.shared.events.CustomerContactedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CrmApplicationService {

    // Example: listen to an event published by IVR module
    @EventListener
    public void handleCustomerContacted(CustomerContactedEvent event) {
        System.out.println("CRM received customer contact event: " + event.customerId());
        // Here you might update CRM data, logs, or assign follow-up tasks
    }

    public void processCrmTask(String customerId) {
        // Example business logic
        System.out.println("CRM is processing task for customer: " + customerId);
    }
}
