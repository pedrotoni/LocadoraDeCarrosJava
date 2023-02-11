import java.sql.SQLOutput;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;

public class Locacao {
    HashMap<Veiculo, Cliente> locadora;
    private LocalDateTime dataLocacao;
    private LocalDateTime dataDevolucao;
    private Locale local;
    private static final double BASE_CALC_VEIC_PEQUENO = 100;
    private static final double BASE_CALC_VEIC_MEDIO = 150;
    private static final double BASE_CALC_VEIC_SUV = 200;

    public Locacao() {
        locadora = new HashMap<>();
    }

    public void alugar(Veiculo veiculo, Cliente cliente, LocalDateTime dataDeLocacao, Locale local) {
        if (locadora.containsKey(veiculo) && !veiculo.getDisponivel()) {
            System.out.println("Este veiculo "+veiculo.getModelo()+" não está disponivel para locação.");
            System.out.println("--------------------");
        } else {
            locadora.put(veiculo, cliente);
            setDataLocacao(dataDeLocacao);
            veiculo.setDisponivel(false);
            System.out.println("Veículo "+veiculo.getModelo()+
                    " alugado com sucesso por cliente ID: "+cliente.getIdCliente());
            System.out.println("--------------------");
        }
    }

    public void devolver(Veiculo veiculo, Cliente cliente,
                          LocalDateTime dataDeDevolucao, Locale local) {
        if(locadora.containsKey(veiculo)) {
            locadora.remove(veiculo);
            setDataDevolucao(dataDeDevolucao);
            System.out.println("Valor total do aluguel: R$"+
                    calcularAluguel(cliente,veiculo.getTipo(),dataLocacao,dataDeDevolucao));
            calcularAluguel(cliente,veiculo.getTipo(),dataLocacao,dataDeDevolucao);
            System.out.println("--------------------");
        } else {
            System.out.println("Esse veículo "+veiculo.getModelo()+" não foi alugado.");
            System.out.println("--------------------");
        }

    }

    private Double calcularDesconto(Cliente cliente, long dias) {

        if (cliente instanceof ClientePF && dias > 5) {
            return 0.05;
        }
        if (cliente instanceof ClientePJ && dias > 3) {
            return 0.1;
        }
        return 0.0;
    }

    private Double calcularAluguel(Cliente cliente, TipoVeiculo.Tipo tipoVeiculo,
                                   LocalDateTime dataLocacao, LocalDateTime dataDevolucao) {
        if (dataDevolucao.isBefore(dataLocacao)) {
            throw new IllegalArgumentException("A data de devolução deve ser posterior à data de locação");
        }

        long minutos = Duration.between(dataLocacao, dataDevolucao).toMinutes();
        long minutosRestantes = minutos % 1440;
        long dias = (minutos / 1440) + (minutosRestantes > 0 ? 1 : 0);

        if (dias <= 1) {
            dias = 1;
        }


        Double desconto = 0.0;

        if (cliente instanceof ClientePF && dias > 5) {
            desconto = 0.05;
        }
        if (cliente instanceof ClientePJ && dias > 3) {
            desconto = 0.1;
        }

        return switch (tipoVeiculo) {

            case PEQUENO -> (dias * BASE_CALC_VEIC_PEQUENO) - (dias * BASE_CALC_VEIC_PEQUENO * desconto);
            case MEDIO ->  (dias * BASE_CALC_VEIC_MEDIO) - (dias * BASE_CALC_VEIC_MEDIO * desconto);
            case SUV -> (dias * BASE_CALC_VEIC_SUV) - (dias * BASE_CALC_VEIC_SUV * desconto);
        };
    }

    public LocalDateTime getDataLocacao() {
        return this.dataLocacao;
    }

    public void setDataLocacao(LocalDateTime dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public LocalDateTime getDataDevolucao() {
        return this.dataDevolucao;
    }

    public void setDataDevolucao(LocalDateTime dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Locale getLocal() {
        return local;
    }

    public void setLocal(Locale local) {
        this.local = local;
    }

    public void listarVeiculosAlugados() {
        Set<Veiculo> alugados = locadora.keySet();
        System.out.println("Veiculos alugados: ");
        if (alugados.isEmpty()) {
            System.out.println("Não há veículos alugados.");
        } else {
            for (Veiculo alugado : alugados) {
                if (alugado != null)
                    System.out.println(alugado+ "\nCliente: "+locadora.get(alugado));
                System.out.println("--------------------");
            }
        }
    }

}
