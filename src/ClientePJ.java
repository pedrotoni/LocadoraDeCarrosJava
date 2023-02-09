import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

public class ClientePJ extends Cliente{
    private String razaoSocialCliente;
    private String cnpjCliente;

    public ClientePJ(String idCliente, String razaoSocialCliente, String cnpjCliente) {
        super(idCliente);
        this.razaoSocialCliente = razaoSocialCliente;
        this.cnpjCliente = cnpjCliente;
    }

    public String getRazaoSocialCliente() {
        return this.razaoSocialCliente;
    };
    public String getCnpjCliente() {
        return this.cnpjCliente;
    };
}
