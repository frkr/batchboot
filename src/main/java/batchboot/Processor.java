package batchboot;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ItemProcessor;

public class Processor implements ItemProcessor<TablePojo, TablePojo> {

    private static final Log LOG = LogFactory.getLog(Processor.class);

    @Override
    public TablePojo process(TablePojo item) throws Exception {
        LOG.info(item);
        return item;
    }
}
