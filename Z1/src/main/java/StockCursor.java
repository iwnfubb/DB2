import xxl.core.cursors.AbstractCursor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;


/**
 * Created by OutOffCoffeeException on 30/10/2016.
 */
public class StockCursor extends AbstractCursor<StockEntry> {

    FileInputStream fis = null;

    public StockCursor(String file_name) {
        File file = new File(file_name);
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            log("Error by reading file " + file_name);
        }
    }

    protected boolean hasNextObject() {
        try {
            if(fis.available()>0)
                return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    protected StockEntry nextObject() {
        try {
            byte[] bytes_array = new byte[4];
            fis.read(bytes_array);
            int id = ByteBuffer.wrap(bytes_array).getInt();

            bytes_array = new byte[4];
            fis.read(bytes_array);
            int length = ByteBuffer.wrap(bytes_array).getInt();

            bytes_array = new byte[length];
            fis.read(bytes_array);
            String name = new String(bytes_array);

            bytes_array = new byte[10];
            fis.read(bytes_array);
            String zeitStempel = new String(bytes_array);

            bytes_array = new byte[8];
            fis.read(bytes_array);
            double kurswert= ByteBuffer.wrap(bytes_array).getDouble();

            return new StockEntry(id, name, zeitStempel, kurswert);
        } catch (IOException e) {
            log("Error by reading object");
        }
        return null;
    }

    public void close(){
        try {
            fis.close();
        } catch (IOException e) {
            log("Error by closing File");
        }
    }
    /*
    //test
    public static void main(String[] arg) {
        System.out.println("Testing ...");
        StockCursor stockCursor = new StockCursor("Testdata.bin");
        while ( stockCursor.hasNextObject()){
            System.out.println(stockCursor.nextObject());
        }
        stockCursor.close();
    }
    */
    private void log(Object o) {
        System.out.println(o);
    }
}
