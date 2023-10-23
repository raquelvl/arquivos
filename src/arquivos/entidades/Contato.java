package arquivos.entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Contato implements Serializable, Comparable<Contato> {
    static final long serialVersionUID = -3961425924658203637L;
    private String nome;
    private String celular;
    private LocalDate aniversario;

    public Contato(String nome, String celular, int dia, int mes) {
        this.nome = nome;
        this.celular = celular;
        aniversario = LocalDate.of(0, mes, dia);
    }

    public Contato(String nome, String celular) {
        this.nome = nome;
        this.celular = celular;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * Representa a pessoa como string
     */
    public String toString() {
        String aniversario = "";
        if (this.aniversario != null) {
            DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM");
            aniversario += ", aniversario " + formatador.format(this.aniversario);
        }
        return "Nome " + nome + ", celular " + celular + aniversario;
    }

    @Override
    public int hashCode() {
        return Objects.hash(celular, nome);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof Contato other))
            return false;
        return Objects.equals(celular, other.celular) && Objects.equals(nome, other.nome);
    }

    @Override
    public int compareTo(Contato outroContato) {
        return this.nome.compareTo(outroContato.nome);
    }
}