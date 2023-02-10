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

    public Locadora() {
        locadora = new HashMap<>();
    }
    public void alugar(Cliente cliente, Veiculo veiculo, TipoVeiculo.Tipo tipo) {

            if(locadora.containsKey(veiculo) && veiculo.getDisponivel() == false) {
                System.out.println("Este veiculo não está disponivel");
            } else {
                locadora.put(veiculo, cliente);
                setDataLocacao(LocalDateTime.now());
                veiculo.setDisponivel(false);
                System.out.println("Veículo alugado com sucesso!");
            }
    }

    public Double devolver(Veiculo veiculo, TipoVeiculo.Tipo tipo) {
        if(locadora.containsKey(veiculo)) {
            locadora.remove(veiculo);
            setDataDevolucao(LocalDateTime.now());
            System.out.println("Valor total do aluguel: "+ calcularAluguel(veiculo, tipo));
            return calcularAluguel(veiculo, tipo);
        }
        System.out.println("Esse veículo não foi alugado.");
        return null;
    }

    private Double calcularAluguel(Veiculo veiculo, TipoVeiculo.Tipo tipo) {
        //double valorAluguel = 0;

        Cliente cliente = locadora.get(veiculo);

        long dias = Duration.between(getDataDevolucao(), getDataLocacao()).toDays() + 1;
        Double desconto = 0.0;

        if (cliente instanceof ClientePF && dias > 5) {
            desconto = 0.05;
            if (cliente instanceof ClientePJ && dias > 3) {
                desconto = 0.1;
            }
        }
//        if(tipo == TipoVeiculo.Tipo.PEQUENO) {
//            valorAluguel = dias * 100.00;
//        } else if (tipo == TipoVeiculo.Tipo.MEDIO) {
//            valorAluguel = dias * 150.00;
//        } else if (tipo == TipoVeiculo.Tipo.SUV) {
//            valorAluguel = dias * 200.00;
//        }
//        System.out.println("O aluguel desse veículo por " + dias +" dias" + " irá custar: " + valorAluguel + " reais.");
        return switch (tipo) {
            case PEQUENO -> (double) (dias * 100) - (dias * 100 * desconto);
            case MEDIO -> (double) (dias * 150) - (dias * 150 * desconto);
            case SUV -> (double) (dias * 200) - (dias * 200 * desconto);
        };
    }

    public LocalDateTime getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(LocalDateTime dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public LocalDateTime getDataDevolucao() {
        return dataDevolucao;
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
        for (Veiculo alugado : alugados) {
            if (alugado != null)
                System.out.println(alugado + " | " + locadora.get(alugado));
        }
    }

}
