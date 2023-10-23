package arquivos.entidades;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListaDeContatos implements Serializable {
    private static final long serialVersionUID = 1L;
    private final List<Contato> contatos = new ArrayList<>();

    public boolean adicionaContato(String nome, String celular, int dia, int mes) {
        return contatos.add(new Contato(nome, celular, dia, mes));
    }

    public boolean adicionaContato(String nome, String celular) {
        return contatos.add(new Contato(nome, celular));
    }

    public void ordenaContatos() {
        Collections.sort(contatos);
    }

    public void salvaListaDeContatos(String nomeDoArquivo) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nomeDoArquivo));
        out.writeObject(this);
        out.close();
    }

    public static ListaDeContatos recuperaListaDeContatos(String nomeDoArquivo) throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(nomeDoArquivo));
        ListaDeContatos contatosRecuperados = (ListaDeContatos) in.readObject();
        in.close();
        return contatosRecuperados;
    }



    public String toString() {
        String str = "";
        for (Contato contato : contatos) {
            str += contato.toString();
            str += "\n";
        }
        return str;
    }

    public void salvaListaDeContatosTxt(String nomeDoArquivo) throws IOException {
        PrintWriter outputStream = null;

        outputStream = new PrintWriter(new BufferedWriter(new FileWriter(nomeDoArquivo)));
        for (Contato contato : contatos) {
            outputStream.println(contato.toString());
        }
        if (outputStream != null)
            outputStream.close();
    }


    public Contato getContato(int posicao) {
        return contatos.get(posicao);
    }
}