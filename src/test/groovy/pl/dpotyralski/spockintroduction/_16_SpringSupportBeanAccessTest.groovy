package pl.dpotyralski.spockintroduction

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import pl.dpotyralski.spockintroduction.customer.Customer
import pl.dpotyralski.spockintroduction.customer.CustomerJpaRepository
import spock.lang.Specification

@SpringBootTest
class _16_SpringSupportBeanAccessTest extends Specification {

    @Autowired
    private CustomerJpaRepository customersRepository

    def "should use credit card processor implementation in charging process"() {
        when:
        List<Customer> customers = customersRepository.findAll()

        then:
        !customers.isEmpty()
    }


}
