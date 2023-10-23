package arquivos.entidades;

import java.io.IOException;

//isso podia ser a interface em linha de comando
public class AdicionaESalvaContatos {
    public static void main(String[] args) {
        ListaDeContatos meusContatos = new ListaDeContatos();
        meusContatos.adicionaContato("Ze de Guga", "83955554444", 31, 1);
        meusContatos.adicionaContato("Marcus", "83999992222", 23, 7);
        meusContatos.adicionaContato("Laura", "83922221111", 26, 8);
        meusContatos.adicionaContato("Lia", "81911115555");
        meusContatos.ordenaContatos();
        try {
            meusContatos.salvaListaDeContatos("contatos.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
        meusContatos.adicionaContato("Xuxa", "21911113333", 28, 3);
        meusContatos.ordenaContatos();
        try {
            meusContatos.salvaListaDeContatos("contatos.ser");
            meusContatos.salvaListaDeContatosTxt("meusContatos.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}