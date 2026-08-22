package dio.budgeting.application;

import dio.budgeting.application.output.TransactionOutput;
import dio.budgeting.domain.Category;
import dio.budgeting.domain.TransactionRepository;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListTransactionsByCategoryUseCase {

    private final TransactionRepository transactionRepository;

    public ListTransactionsByCategoryUseCase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Tool(name = "list-transactions-by-category", description = "Lista transações financeiras por categoria")
    public List<TransactionOutput> execute(@ToolParam(description = "Categoria de uma transação") Category category) {
        // 1. Busca as transações cadastradas no repositório
        var transacoes = transactionRepository.findAllByCategory(category);

        // 2. Validação (Cláusula de Guarda): se não houver registros, lança um aviso amigável para a IA
        if (transacoes.isEmpty()) {
            throw new IllegalArgumentException("Nenhuma transação foi encontrada para a categoria " + category + ". Informe ao usuário que não há gastos registrados nesta categoria.");
        }

        // 3. Mapeia as transações encontradas e retorna a lista
        return transacoes.stream().map(TransactionOutput::from).toList();
    }
}