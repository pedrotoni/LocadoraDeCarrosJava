import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

public class ClientePF extends Cliente {
    private String nomeCliente;
    private String cpfCliente;

    public ClientePF(String idCliente, String nomeCliente, String cpfCliente) {
        super(idCliente);
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
