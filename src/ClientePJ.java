import java.time.LocalDateTime;
import java.util.Date;
import java.util.Locale;

public class ClientePJ extends Cliente{
    private String razaoSocialCliente;
    private String cnpjCliente;

    public ClientePJ(String idCliente, LocalDateTime dataLocacao, LocalDateTime dataDevolucao, String razaoSocialCliente, String cnpjCliente) {
        super(idCliente, dataLocacao, dataDevolucao);
        this.razaoSocialCliente = razaoSocialCliente;
        this.cnpjCliente = cnpjCliente;
    }

//    @Override
//    public void alugar(TipoVeiculo.Tipo tipo, String cnpjCliente) {
//        double valorAluguel = 0;
//
//        if(tipo == TipoVeiculo.Tipo.PEQUENO) {
//            valorAluguel = calcularAluguel() * 100.00;
//        } else if (tipo == TipoVeiculo.Tipo.MEDIO) {
//            valorAluguel = calcularAluguel() * 150.00;
//        } else if (tipo == TipoVeiculo.Tipo.SUV) {
//            valorAluguel = calcularAluguel() * 200.00;
//        }
//        System.out.println("O aluguel desse veículo por " + calcularAluguel() +" dias" + " irá custar: " + valorAluguel + " reais.");
//
//    }

    public String getRazaoSocialCliente() {
        return this.razaoSocialCliente;
    };
    public String getCnpjCliente() {
        return this.cnpjCliente;
    };
}
