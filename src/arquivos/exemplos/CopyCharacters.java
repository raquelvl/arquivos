package arquivos.exemplos;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {
    public static void main(String[] args) throws IOException {
        FileReader inputStream = null;
        FileWriter outputStream = null;
        int numeroDeCaracteres = 0;
        try {
            inputStream = new FileReader("proverbiochines.txt");
            outputStream = new FileWriter("copia_caracteres_do_proverbio_chines.txt");
            int c;
            while ((c = inputStream.read()) != -1) {
                numeroDeCaracteres++;
                outputStream.write(c);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            System.out.println(numeroDeCaracteres +
                    " caracteres copiados para o arquivo copiacaracteresdoproverbioschineses.txt.");
        }
    }
}