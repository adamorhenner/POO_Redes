public interface Host {
    
    public boolean verificarPacote(Pacote pacote, Host host);
    public void receberPacote(Pacote pacote);
    public void enviarPacote(Pacote pacote);

}
