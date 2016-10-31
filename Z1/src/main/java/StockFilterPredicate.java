import xxl.core.predicates.AbstractPredicate;

/**
 * Created by qwert on 31/10/2016.
 */
public class StockFilterPredicate extends AbstractPredicate<StockEntry> {
    @Override
    public boolean invoke(StockEntry argument) {
        if (argument.getKurswert() > 50)
            return true;
        else
            return false;
    }
}
