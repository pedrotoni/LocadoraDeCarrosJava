public class Carro extends Veiculo {
    private String idCarro;

    public Carro(String modelo, String marca, String ano, String categoria, String placa, Double quilometragem, String idCarro) {
        super(modelo, marca, ano, categoria, placa, quilometragem);
        this.idCarro = idCarro;
    }

    public String getIdCarro() {
        return this.idCarro;
    }
}
