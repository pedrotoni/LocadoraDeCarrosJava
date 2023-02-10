import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Locale;
import java.util.Set;

public class Locadora {
    HashMap<Veiculo, Cliente> locadora;
    private LocalDateTime dataLocacao;

    private LocalDateTime dataDevolucao;

    private Locale local;
    private static final double BASE_CALC_VEIC_PEQUENO = 100;
    private static final double BASE_CALC_VEIC_MEDIO = 150;
    private static final double BASE_CALC_VEIC_SUV = 200;

    public Locadora() {
        locadora = new HashMap<>();
    }

    public void alugar(Cliente cliente, Veiculo veiculo, TipoVeiculo.Tipo tipo) {

        if (locadora.containsKey(veiculo) && !veiculo.getDisponivel()) {
            System.out.println("Este veiculo não está disponivel");
        } else {
            locadora.put(veiculo, cliente);
            setDataLocacao(LocalDateTime.now());
            veiculo.setDisponivel(false);
            System.out.println("Veículo alugado com sucesso!");
        }
    }

    public void devolver(Veiculo veiculo, TipoVeiculo.Tipo tipo) {
        if(locadora.containsKey(veiculo)) {
            locadora.remove(veiculo);
            setDataDevolucao(LocalDateTime.now());
            System.out.println("Valor total do aluguel: "+ calcularAluguel(veiculo, tipo));
            calcularAluguel(veiculo, tipo);
        }
        System.out.println("Esse veículo não foi alugado.");
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

    private Double calcularAluguel(Veiculo veiculo, TipoVeiculo.Tipo tipo) {
        //double valorAluguel = 0;
        /*if (getDataDevolucao().isBefore(getDataLocacao())) {
            throw new IllegalArgumentException("A data de devolução deve ser posterior à data de locação");
        }*/

        Cliente cliente = locadora.get(veiculo);

        long dias = Duration.between(getDataDevolucao(), getDataLocacao()).toDays();
        /*
        VERIFICAÇÃO PARA CHECAR O VALOR DE DIAS, DATA DEVOLUCAO E DATA LOCACAO
        System.out.println("Dias: "+dias);
        System.out.println(getDataLocacao());
        System.out.println(getDataDevolucao());*/
        Double desconto = calcularDesconto(cliente,dias);

//        if(tipo == TipoVeiculo.Tipo.PEQUENO) {
//            valorAluguel = dias * 100.00;
//        } else if (tipo == TipoVeiculo.Tipo.MEDIO) {
//            valorAluguel = dias * 150.00;
//        } else if (tipo == TipoVeiculo.Tipo.SUV) {
//            valorAluguel = dias * 200.00;
//        }
//        System.out.println("O aluguel desse veículo por " + dias +" dias" + " irá custar: " + valorAluguel + " reais.");
        return switch (tipo) {
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
