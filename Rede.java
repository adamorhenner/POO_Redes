import java.util.ArrayList;
import java.util.List;

public class Rede {
    private EnderecoRede enderecoRede;
    List<Host> listaDeHost = new ArrayList<>();

    public Rede(EnderecoRede enderecoRede) {
        this.enderecoRede = enderecoRede;
    }

    public EnderecoRede getEnderecoRede() {
        return enderecoRede;
    }

    public void setEnderecoRede(EnderecoRede enderecoRede) {
        this.enderecoRede = enderecoRede;
    }
}
