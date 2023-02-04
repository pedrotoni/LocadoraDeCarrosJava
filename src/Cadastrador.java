import java.util.ArrayList;
import java.util.List;

public interface Cadastrador {
    List<Veiculo> listaDeVeiculos = new ArrayList<>();
    List<Cliente> listaDeClientes = new ArrayList<>();

    <T extends Veiculo> void cadastrarVeiculo(T veiculo);
    <T extends Cliente>void cadastrarCliente(T cliente);


}
