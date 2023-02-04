public class Caminhao extends Veiculo {
    private String idCaminhao;

    public Caminhao(String modelo, String marca, String ano, String categoria, String placa, Double quilometragem, String idCaminhao) {
        super(modelo, marca, ano, categoria, placa, quilometragem);
        this.idCaminhao = idCaminhao;
    }

    public String getIdCaminhao() {
        return this.idCaminhao;
    }
}
