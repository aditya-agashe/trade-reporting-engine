package au.com.vanguard.tradereportingengine.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    private Util util = new Util();

    @BeforeEach
    void setUp() {
    }

    @Test
    void shouldBeAnagram() {
        String sellerParty = "KANMU_EB";
        String buyerParty = "EMU_BANK";
        Assertions.assertTrue(util.isAnagran(sellerParty, buyerParty));
    }

    @Test
    void shouldNotBeAnagram() {
        String sellerParty = "KANMU-EB";
        String buyerParty = "EMU_BANK";
        Assertions.assertFalse(util.isAnagran(sellerParty, buyerParty));
    }

    @Test
    void shouldNotBeAnagram_PartiesEmpty() {
        String sellerParty = "";
        String buyerParty = "";
        Assertions.assertFalse(util.isAnagran(sellerParty, buyerParty));
    }
}