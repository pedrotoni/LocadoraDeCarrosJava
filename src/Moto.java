public class Moto extends Veiculo{
    private String idMoto;

    public Moto(TipoVeiculo.Tipo tipo, String modelo, String marca, String ano, String placa, Double quilometragem, String idMoto) {
        super(modelo, marca, ano, placa, quilometragem);
        if(TipoVeiculo.Tipo.SUV == tipo) {
            throw new IllegalArgumentException("Tipo de veículo não suportado");
        }
        this.setTipo(tipo);
        this.idMoto = idMoto;
    }

    public String getIdMoto() {
        return this.idMoto;
    }
}
