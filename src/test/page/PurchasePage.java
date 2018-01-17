package test.page;

import com.qa.framework.ioc.annotation.Page;

import java.util.HashMap;
import java.util.Map;
@Page
public class PurchasePage  extends  AbstractPage{

    private Map<String, String> dataMap = new HashMap<>();

    public Map<String, String> getDataMap() {
        return dataMap;
    }








}