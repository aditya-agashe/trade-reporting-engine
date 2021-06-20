package au.com.vanguard.tradereportingengine.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Event {

    @Id
    @GeneratedValue
    private Long id;
    private String buyerParty;
    private String sellerParty;
    private String amount;
    private String currency;

    public String getBuyerParty() {
        return buyerParty;
    }

    public String getSellerParty() {
        return sellerParty;
    }

    public String getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event e = (Event) o;
        return id == e.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, buyerParty, sellerParty, currency, amount);
    }


    public static class Builder {

        private Long id;
        private String buyerParty;
        private String sellerParty;
        private String amount;
        private String currency;

        public Builder withId(long id) {
            this.id = id;
            return this;
        }

        public Builder withBuyerParty(String buyerParty){
            this.buyerParty = buyerParty;
            return this;
        }

        public Builder withSellerParty(String sellerParty){
            this.sellerParty = sellerParty;
            return this;
        }

        public Builder withAmount(String amount){
            this.amount = amount;
            return this;
        }

        public Builder withCurrency(String currency){
            this.currency = currency;
            return this;
        }

        public Event build(){
            Event event = new Event();
            event.id = this.id;
            event.buyerParty = this.buyerParty;
            event.sellerParty = this.sellerParty;
            event.amount = this.amount;
            event.currency = this.currency;
            return event;
        }
    }
}
