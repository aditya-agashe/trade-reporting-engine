package au.com.vanguard.tradereportingengine.util;

import java.util.Arrays;

public class Util {
    public boolean isAnagran(String sellerParty, String buyerParty) {
        if (sellerParty.isEmpty() || buyerParty.isEmpty()) {
            return false;
        }
        char[] sellerPartyArray = sellerParty.toCharArray();
        Arrays.sort(sellerPartyArray);
        char[] buyerPartyArray = buyerParty.toCharArray();
        Arrays.sort(buyerPartyArray);
        return (Arrays.equals(sellerPartyArray, buyerPartyArray));
    }

    public boolean bankCurrencyCriteria(Bank bank, Currency currency) {
        return (bank == Bank.EMU_BANK && currency == Currency.AUD) || (bank == Bank.BISON_BANK && currency == Currency.USD);
    }
}
