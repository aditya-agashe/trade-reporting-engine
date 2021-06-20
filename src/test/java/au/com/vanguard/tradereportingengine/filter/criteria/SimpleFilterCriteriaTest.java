package au.com.vanguard.tradereportingengine.filter.criteria;

import au.com.vanguard.tradereportingengine.model.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class SimpleFilterCriteriaTest {

    private SimpleFilterCriteria simpleFilterCriteria;

    @BeforeEach
    void setUp() {
        simpleFilterCriteria = new SimpleFilterCriteria();
    }

    @Test
    void shouldBeAnagram() {
        String sellerParty = "KANMU_EB";
        String buyerParty = "EMU_BANK";
        Assertions.assertTrue(simpleFilterCriteria.isAnagram(sellerParty, buyerParty));
    }

    @Test
    void shouldNotBeAnagram() {
        String sellerParty = "KANMU-EB";
        String buyerParty = "EMU_BANK";
        Assertions.assertFalse(simpleFilterCriteria.isAnagram(sellerParty, buyerParty));
    }

    @Test
    void shouldNotBeAnagram_PartiesEmpty() {
        String sellerParty = "";
        String buyerParty = "";
        Assertions.assertFalse(simpleFilterCriteria.isAnagram(sellerParty, buyerParty));
    }

    @Test
    void shouldPassBankCurrencyCriteria_EMU_AUD() {
        Assertions.assertTrue(simpleFilterCriteria.isCorrectBankCurrency(Bank.EMU_BANK.name(), Currency.AUD.name()));
    }

    @Test
    void shouldPassBankCurrencyCriteria_BISON_USD() {
        Assertions.assertTrue(simpleFilterCriteria.isCorrectBankCurrency(Bank.BISON_BANK.name(), Currency.USD.name()));
    }

    @Test
    void shouldPassBankCurrencyCriteria_BISON_AUD() {
        Assertions.assertFalse(simpleFilterCriteria.isCorrectBankCurrency(Bank.BISON_BANK.name(), Currency.AUD.name()));
    }

    @Test
    void shouldPassBankCurrencyCriteria_EMU_USD() {
        Assertions.assertFalse(simpleFilterCriteria.isCorrectBankCurrency(Bank.EMU_BANK.name(), Currency.USD.name()));
    }

    @Test
    void shouldFilter() {
        Event event = new Event.Builder()
                .withSellerParty(Bank.EMU_BANK.name())
                .withBuyerParty("LEFT_BANK")
                .withCurrency(Currency.AUD.name())
                .withAmount("100.00")
                .build();
        Event event1 = new Event.Builder()
                .withSellerParty(Bank.EMU_BANK.name())
                .withBuyerParty(Bank.EMU_BANK.name())
                .withCurrency(Currency.AUD.name())
                .withAmount("100.00")
                .build();
        Event event2 = new Event.Builder()
                .withSellerParty(Bank.EMU_BANK.name())
                .withBuyerParty(Bank.BISON_BANK.name())
                .withCurrency(Currency.USD.name())
                .withAmount("100.00")
                .build();

        List<Event> list = Arrays.asList(event, event1, event2);
        Assertions.assertEquals(1, simpleFilterCriteria.filterEvents(list).size());
    }

}