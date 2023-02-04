import java.util.ArrayList;
import java.util.List;

public interface Cadastrador {
    List<Carro> listaDeCarros = new ArrayList<>();
    List<ClientePF> listaDeClientesPF = new ArrayList<>();
    List<ClientePJ> listaDeClientesPJ = new ArrayList<>();

    void addCarro(Carro carro);
    void exibirListaDeCarros();
    void addClientePF(ClientePF clientePF);
    void exibirListaDeClientesPF();
    void addClientePJ(ClientePJ clientePJ);
    void exibirListaDeClientesPJ();


}
