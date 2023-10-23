package arquivos.exemplos;

import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ObjectStreams {
    static final String dataFile = "objetos.dat";
    static final BigDecimal[] prices = {new BigDecimal("19.99"),
            new BigDecimal("9.99"), new BigDecimal("15.99"), new BigDecimal("3.99"), new BigDecimal("4.99")};
    static final int[] units = {12, 8, 13, 29, 50};
    static final String[] descs = {"Camiseta Java", "Caneca Java",
            "Boneco Java", "Broche Java", "Chaveiro Java"};

    public static void main(String[] args) throws IOException,
            ClassNotFoundException {
        writeObjects();
        readObjects();
    }

    private static void writeObjects() throws IOException {
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)));
            out.writeObject(LocalDateTime.now());
            for (int i = 0; i < prices.length; i++) {
                out.writeObject(prices[i]);
                out.writeInt(units[i]);
                out.writeUTF(descs[i]);
            }
        } finally {
            out.close();
        }
    }

    private static void readObjects() throws IOException, ClassNotFoundException {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)));
            LocalDateTime date = null;
            BigDecimal price;
            int unit;
            String desc;
            BigDecimal total = new BigDecimal(0);
            date = (LocalDateTime) in.readObject();
            System.out.format("%tA, %<tB %<te, %<tY:%n", date);
            try {
                while (true) {
                    price = (BigDecimal) in.readObject();
                    unit = in.readInt();
                    desc = in.readUTF();
                    total = total.add(price.multiply(new BigDecimal(unit)));
                    System.out.println("Você pediu " + unit + " unidades de " + desc + " por R$ " + total.doubleValue());
                }
            } catch (EOFException e) {
            }
            System.out.format("Valor TOTAL da compra: R$%.2f%n", total);
        } finally {
            in.close();
        }
    }
}