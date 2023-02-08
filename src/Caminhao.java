public class Caminhao extends Veiculo {
    private String idCaminhao;

    public Caminhao(TipoVeiculo.Tipo tipo, String modelo, String marca, String ano, String placa, Double quilometragem, String idCaminhao) {
        super(modelo, marca, ano, placa, quilometragem);

        if(TipoVeiculo.Tipo.SUV == tipo) {
            throw new IllegalArgumentException("Tipo de veículo não suportado");
        }

        this.setTipo(tipo);
        this.idCaminhao = idCaminhao;
    }

    public String getIdCaminhao() {
        return this.idCaminhao;
    }
}
