import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

public class ClientePF extends Cliente {
    private String nomeCliente;
    private String cpfCliente;

    public ClientePF(String idCliente, LocalDateTime dataDaLocacao, LocalDateTime dataDaDevolucao, String nomeCliente, String cpfCliente) {
        super(idCliente, dataDaLocacao, dataDaDevolucao);
        this.nomeCliente = nomeCliente;
        this.cpfCliente = cpfCliente;
    }


    @Override
    public String getNomeCliente() {
        return this.nomeCliente;
    }

    @Override
    public String getCpfCliente() {
        return this.cpfCliente;
    }
}
