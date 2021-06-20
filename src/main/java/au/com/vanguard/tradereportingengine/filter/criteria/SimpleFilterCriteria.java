package au.com.vanguard.tradereportingengine.filter.criteria;

import au.com.vanguard.tradereportingengine.model.Event;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SimpleFilterCriteria implements FilterCriteria {

    public List<Event> filterEvents(List<Event> eventsList) {
        return eventsList
                .stream()
                .filter(e -> (
                        !isAnagram(e.getSellerParty(), e.getBuyerParty())
                        && isCorrectBankCurrency(e.getSellerParty(), e.getCurrency())))
                .collect(Collectors.toList());
    }

    boolean isAnagram(String sellerParty, String buyerParty) {
        if (sellerParty.isEmpty() || buyerParty.isEmpty()) {
            return false;
        }
        char[] sellerPartyArray = sellerParty.toUpperCase().toCharArray();
        Arrays.sort(sellerPartyArray);
        char[] buyerPartyArray = buyerParty.toUpperCase().toCharArray();
        Arrays.sort(buyerPartyArray);
        return (Arrays.equals(sellerPartyArray, buyerPartyArray));
    }

    boolean isCorrectBankCurrency(String sellerParty, String currency) {
        return (Bank.EMU_BANK.name().equalsIgnoreCase(sellerParty) && Currency.AUD.name().equalsIgnoreCase(currency))
                || (Bank.BISON_BANK.name().equalsIgnoreCase(sellerParty) && Currency.USD.name().equalsIgnoreCase(currency));
    }
}
