package map.project.FitnessCenter.controller;

import map.project.FitnessCenter.service.PaidSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class for managing paid subscription-related operations in the fitness center.
 * This controller extends the SubscriptionController and provides endpoints for common CRUD operations on paid subscriptions.
 */
@RestController
@RequestMapping("/paidSubscription")
public class PaidSubscriptionController extends SubscriptionController {
    @Autowired
    public PaidSubscriptionController(PaidSubscriptionService service) {
        super(service);
    }


}
