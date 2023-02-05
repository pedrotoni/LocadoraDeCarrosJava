import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class Main {
    public static void main(String[] args) {
        ManipuladorDeDados banco = new ManipuladorDeDados();
        Moto m1 = new Moto (TipoVeiculo.Tipo.PEQUENO, "Suzuki","Ninja","2000",
                "pequeno","AAA-1111",10000.00,"50");
//        Moto m2 = new Moto ("AAA","BBB","2000",
//                "pequeno","AAA-1111",10000.00,"50");
//        Moto m3 = new Moto ("AAA","BBB","2000",
//                "pequeno","AAA-1112",10000.00,"50");
//        Caminhao cam1 =
//                new Caminhao("Caminhao","Scania",
//                        "1994","medio","RKR-4344",30053.34,"503");
//        Carro c1 =
//                new Carro("Uno","Fiat",
//                        "2000","SUV", "GRJ-3939",595959.33,"594");
        Cliente pf1 = new ClientePF("2", LocalDateTime.of(2023, Month.FEBRUARY, 4, 15, 30), LocalDateTime.of(2023, Month.FEBRUARY, 7, 15, 31), "Pedro","34066655544");
        Cliente pj1 = new ClientePJ("545", LocalDateTime.of(2023, Month.JANUARY, 25, 18, 30), LocalDateTime.of(2023, Month.FEBRUARY, 7, 18, 30),"Fred Lanches","34211222000102");
//        banco.cadastrarVeiculo(m1);
//        banco.cadastrarVeiculo(m3);
//        banco.exibirListaDeVeiculos();
//        banco.deletarVeiculo(m1);
//        banco.cadastrarVeiculo(m2);
//        banco.exibirListaDeVeiculos();

       // System.out.println("Placa do carro:" + banco.consultarPlaca(m1.getPlaca()).toString());

        banco.cadastrarCliente(pf1);
        banco.cadastrarCliente(pj1);
        banco.exibirListaDeClientes();

        System.out.println(m1.toString());

        //System.out.println(banco.consultarCliente(pf1.getIdCliente()));
        System.out.println(pf1.getDataDaLocacao());


    }
}