package test.datamodel;

import org.apache.log4j.Logger;

public class ModelBase {
    protected final static Logger logger = Logger.getLogger(ModelBase.class);

    protected enum STUDENTTYPE {OM, FLB}

    protected enum PRICETYPE {OLD, NEW}
}
