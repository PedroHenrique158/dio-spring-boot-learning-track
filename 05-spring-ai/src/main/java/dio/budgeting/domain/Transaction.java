package dio.budgeting.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Transaction {
    private TransactionId id;
    private String description;
    private long amount;
    private Category category;

    // Construtor utilizado para criar novas transações no sistema
    public Transaction(String description, long amount, Category category) {

        // ==========================================
        // EVOLUÇÃO: REGRA DE NEGÓCIO E VALIDAÇÃO
        // ==========================================
        // Garante que o valor da transação nunca seja zero ou negativo.
        // Isso protege o sistema financeiro de dados incorretos vindos da IA.
        if (amount <= 0) {
            throw new IllegalArgumentException("Erro de Negócio: O valor da transação deve ser maior que zero.");
        }
        // ==========================================

        this.id = new TransactionId();
        this.description = description;
        this.amount = amount;
        this.category = category;
    }
}