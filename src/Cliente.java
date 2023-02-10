public abstract class Cliente extends Locadora {
    private String idCliente;

    public Cliente(String idCliente) {
        this.idCliente = idCliente;
    }



    public String getIdCliente() {
        return this.idCliente;
    }

    //public abstract void alugar(TipoVeiculo.Tipo tipo, String idCliente);

    public String getNomeCliente() {
        return null;
    }
    public String getCpfCliente() {
        return null;
    };
    public String getRazaoSocialCliente() {
        return null;
    };
    public String getCnpjCliente() {
        return null;
    };

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente='" + idCliente + '\'' +
                '}';
    }


}
