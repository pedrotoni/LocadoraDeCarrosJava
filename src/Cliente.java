public abstract class Cliente {
    private String idCliente;
    public Cliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdCliente() {
        return this.idCliente;
    }
}
