package dio.budgeting.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TransactionTest {

    @Test
    void acceptsPositiveAmountInCents() {
        var transaction = new Transaction("Almoço", 4_500L, Category.GROCERIES);

        assertEquals(4_500L, transaction.getAmount());
    }

    @Test
    void rejectsZeroAmount() {
        assertThrows(IllegalArgumentException.class,
                () -> new Transaction("Almoço", 0L, Category.GROCERIES));
    }

    @Test
    void rejectsNegativeAmount() {
        assertThrows(IllegalArgumentException.class,
                () -> new Transaction("Almoço", -4_500L, Category.GROCERIES));
    }
}
