package pl.dpotyralski.spockintroduction.customer;

import lombok.Value;

import java.util.List;

@Value(staticConstructor = "from")
public class CustomersResponse {

    List<CustomerResponse> customers;

    @Value
    static class CustomerResponse {
        String id;
        String name;
    }

}
