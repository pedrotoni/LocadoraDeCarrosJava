public class Moto extends Veiculo{
    private String idMoto;

    public Moto(String modelo, String marca, String ano, String categoria, String placa, Double quilometragem, String idMoto) {
        super(modelo, marca, ano, categoria, placa, quilometragem);
        this.idMoto = idMoto;
    }

    public String getIdMoto() {
        return this.idMoto;
    }
}
