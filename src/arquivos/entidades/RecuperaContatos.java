package arquivos.entidades;

import java.io.FileNotFoundException;
import java.io.IOException;

//isso também podia ser da interface em linha de comando
public class RecuperaContatos {
    public static void main(String[] args) {

        ListaDeContatos copiaDosContatos = null;
        try {
            copiaDosContatos = ListaDeContatos.recuperaListaDeContatos("contatos.ser");
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        System.out.println(copiaDosContatos);
    }
}