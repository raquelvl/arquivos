package arquivos.exemplos;

import java.io.*;

public class GravaRegistros {
    public static void main(String[] args) {
        String dataFile = "registros.dat";
        escreveDados(dataFile);
        leDados(dataFile);
    }

    private static void escreveDados(String dataFile) {
        double[] prices = {19.99, 9.99, 15.99, 3.99, 4.99};
        int[] units = {12, 8, 13, 29, 50};
        String[] descs = {"Camiseta Java", "Caneca Java", "Boneco Java",
                "Broche Java", "Chaveiro Java "};
        DataOutputStream out = null;
        try {
            out = new DataOutputStream(new BufferedOutputStream(
                    new FileOutputStream(dataFile)));
            for (int i = 0; i < prices.length; i++) {
                out.writeDouble(prices[i]);
                out.writeInt(units[i]);
                out.writeUTF(descs[i]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void leDados(String dataFile) {
        DataInputStream in = null;
        double price;
        int unit;
        String desc;
        double total = 0.0;
        try {
            in = new DataInputStream(new BufferedInputStream(new FileInputStream(dataFile)));
            try {
                while (true) {

                    price = in.readDouble();
                    unit = in.readInt();
                    desc = in.readUTF();
                    System.out.format("Voce pediu %d unidades de %s por $%.2f%n",
                            unit, desc, price);
                    total += unit * price;
                }
            } catch (EOFException e) {
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.format("Valor total a pagar: $%.2f%n", total);
    }
}