import xxl.core.collections.containers.io.BlockFileContainer;
import xxl.core.collections.containers.io.ConverterContainer;

import java.util.Iterator;

/**
 * Created by qwert on 30/10/2016.
 */
public class Main {
    public static void main(String[] args) {
        String file_name = "Testdata.bin";
        StockCursor stockCursor = new StockCursor(file_name);
        BlockFileContainer blockFileContainer = new BlockFileContainer("blockFileContainer", 1024);
        StockConverter stockConverter = new StockConverter();
        ConverterContainer converterContainer = new ConverterContainer(blockFileContainer, stockConverter);
        log("Read file: " + file_name);

        while (stockCursor.hasNextObject()) {
            StockEntry currentEntry = stockCursor.nextObject();

            if (currentEntry.getKurswert() > 50){
                converterContainer.insert(currentEntry);
            }
        }

        Iterator iterator = converterContainer.objects();
        while (iterator.hasNext()){
            log(iterator.next().toString());
        }
        stockCursor.close();
        converterContainer.close();
    }

    static void log(Object o) {
        System.out.println(o);
    }
}
