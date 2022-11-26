import java.util.ArrayList;

public class Main {

    private static Computador computador1;
    private static Computador computador2;
    private static String IP_COMPUTADOR_1 = "10.10.10.2";
    private static String IP_COMPUTADOR_2 = "12.12.12.2";

    private static Switch switch1;
    private static Switch switch2;

    private static Roteador roteador1;
    private static Roteador roteador2;

    public static void main(String[] args) {

        criar_roteadores();
        criar_switchs();
        criar_computadores();
        conectar_componentes();
        inserir_tabela_de_rota();

        computador1.enviar_mensagem("Bora jogar?", IP_COMPUTADOR_2);
        computador2.enviar_mensagem("Sim!!!", IP_COMPUTADOR_1);

        System.out.println("Tá funcionando");

    }


    private static void criar_roteadores() {
        criar_roteador1();
        criar_roteador2();
    }

    public static void criar_computadores() {

        computador1 = new Computador("Matheus", IP_COMPUTADOR_1, "H1");
        computador2 = new Computador("Adamor",IP_COMPUTADOR_2, "H2");

    }

    public static void criar_switchs() {

        criar_switch1();
        criar_switch2();
    }

    public static void criar_switch1() {

        PortaSwitch porta1 = new PortaSwitch(1, "PORTA:1:1");
        PortaSwitch porta2 = new PortaSwitch(2, "PORTA:1:2");

        ArrayList<PortaSwitch> portas = new ArrayList();
        portas.add(porta1);
        portas.add(porta2);

        switch1 = new Switch(portas, "Switch-1");

    }

    public static void criar_switch2() {

        PortaSwitch porta1 = new PortaSwitch(1, "PORTA:2:1");
        PortaSwitch porta2 = new PortaSwitch(2, "PORTA:2:2");

        ArrayList<PortaSwitch> portas = new ArrayList();
        portas.add(porta1);
        portas.add(porta2);

        switch2 = new Switch(portas, "Switch-2");

    }
    public static void criar_roteador1() {
        PortaSwitch porta1 = new PortaSwitch(1, "PORTA:3:1");
        PortaSwitch porta2 = new PortaSwitch(2, "PORTA:3:2");

        ArrayList<PortaSwitch> portas = new ArrayList();
        portas.add(porta1);
        portas.add(porta2);

        roteador1 = new Roteador(portas, "Roteador-1", "192.145.200.1");
    }
    public static void criar_roteador2() {
        PortaSwitch porta1 = new PortaSwitch(1, "PORTA:4:1");
        PortaSwitch porta2 = new PortaSwitch(2, "PORTA:4:2");

        ArrayList<PortaSwitch> portas = new ArrayList();
        portas.add(porta1);
        portas.add(porta2);

        roteador2 = new Roteador(portas, "Roteador-2","195.142.250.1");
    }

    public static void inserir_tabela_de_rota(){
        EnderecoRede enderecoRede = new EnderecoRede("10.10.10.0", 23);
        RegistroRotas rota = new RegistroRotas(enderecoRede, switch1);
        roteador1.getTabelaRota().add(rota);

        EnderecoRede enderecoRede2 = new EnderecoRede("12.12.12.1", 23);
        RegistroRotas rota2 = new RegistroRotas(enderecoRede2, roteador2);
        roteador1.getTabelaRota().add(rota2);

        EnderecoRede enderecoRede3 = new EnderecoRede("12.12.12.1", 23);
        RegistroRotas rota3 = new RegistroRotas(enderecoRede3, switch2);
        roteador2.getTabelaRota().add(rota3);

        EnderecoRede enderecoRede4 = new EnderecoRede("10.10.10.0", 23);
        RegistroRotas rota4 = new RegistroRotas(enderecoRede4, roteador1);
        roteador2.getTabelaRota().add(rota4);
    }
    public static void conectar_componentes() {

        switch1.conectarHost(computador1, 1);
        switch1.conectarHost(roteador1, 2);

        switch2.conectarHost(computador2, 1);
        switch2.conectarHost(roteador2, 2);

        computador1.setConexao(switch1);
        computador2.setConexao(switch2);

        roteador1.conectarHost(switch1, 1);
        roteador1.conectarHost(roteador2, 2);

        roteador2.conectarHost(switch2, 1);
        roteador2.conectarHost(roteador1, 2);


    }

}