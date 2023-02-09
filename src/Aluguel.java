import java.time.Duration;
import java.time.LocalDateTime;

public class Aluguel {
    private LocalDateTime dataLocacao;
    private Devolucao dataDevolucao;

    public void alugar(TipoVeiculo.Tipo tipo) {
        double valorAluguel = 0;

        if(tipo == TipoVeiculo.Tipo.PEQUENO) {
            valorAluguel = calcularAluguel() * 100.00;
        } else if (tipo == TipoVeiculo.Tipo.MEDIO) {
            valorAluguel = calcularAluguel() * 150.00;
        } else if (tipo == TipoVeiculo.Tipo.SUV) {
            valorAluguel = calcularAluguel() * 200.00;
        }
    }

    public Devolucao getDataDevolucao() {
        return dataDevolucao;
    }

    public double calcularAluguel() {
        long dias = Duration.between(dataDevolucao.getDataDevolucao(), getDataDaLocacao()).toDays() + 1;
        return dias * 100;
    }

    public LocalDateTime getDataDaLocacao() {
        return dataLocacao;
    }

}
