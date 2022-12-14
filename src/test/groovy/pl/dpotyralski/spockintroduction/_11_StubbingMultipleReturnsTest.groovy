package pl.dpotyralski.spockintroduction


import pl.dpotyralski.spockintroduction.rental.*
import spock.lang.Specification
import spock.lang.Subject

class _11_StubbingMultipleReturnsTest extends Specification {

    private CardProcessor cardProcessor = Stub(CardProcessor)

    @Subject
    private BillingService sub = new BillingService(cardProcessor)

    def "should charge call process for rental"() {
        given:
        CreditCard card = new CreditCard("5105105105105100", "12/23", 123)
        Rental rental = new Rental("1", 2, new Movie("Matrix", CategoryType.PREMIUM))

        and: "stubbing"
        cardProcessor.charge(card, _ as BigDecimal) >>> [new ChargeResult(false), new ChargeResult(true)]

        expect:
        sub.chargeRental(rental, card) == false
        sub.chargeRental(rental, card) == true
        sub.chargeRental(rental, card) == true
        sub.chargeRental(rental, card) == true
    }

}