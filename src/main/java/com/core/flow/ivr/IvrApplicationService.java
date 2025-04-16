package com.core.flow.ivr;

import com.core.flow.shared.events.CustomerContactedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IvrApplicationService {

    private final ApplicationEventPublisher eventPublisher;

    public void handleIvrInteraction(String customerId) {
        System.out.println("IVR handled call for customer: " + customerId);

        // Publish an event to notify other modules (like CRM)
        eventPublisher.publishEvent(new CustomerContactedEvent(customerId));
    }
}
