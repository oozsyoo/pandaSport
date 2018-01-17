package test.page;

import com.qa.framework.common.Swipe;
import com.qa.framework.ioc.annotation.Page;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import test.Untils.ConstantEnum;
import test.Untils.DataUtils;
import test.Untils.Utils;
import test.datamodel.TestModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Page
public class PlanDetailPage  extends  AbstractPage{

    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/homeTeamNameTv")
    private List<WebElement> homeTeamNameTv;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/guestTeamNameTv")
    private List<WebElement> guestTeamNameTv;



    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/gameNoTv")
    private List<WebElement> gameNos;

    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/gmtCreateTv")
    private WebElement gmtCreateTv;//方案发起时间

    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/titleTv")
    private WebElement titleTv;//方案宣言
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/purchaseNoTv")
    private WebElement purchaseNoTv;//方案编号
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/nicknameTv")
    private WebElement nicknameTv;//发起人
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/createTypeTv")
    private WebElement createTypeTv;//方案类型
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/totalFeeTv")
    private WebElement totalFeeTv;//方案金额-金额
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/multipleTv")
    private WebElement multipleTv;//方案金额-倍数
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/myPaidFeeTv")
    private WebElement myPaidFeeTv;//您的认购
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/mixTypesTv")
    private WebElement mixTypesTv;//投注方式
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/statusTv")
    private WebElement statusTv;//委托状况
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/prizeStatusTv")
    private WebElement prizeStatusTv;//中奖状况

    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/etOptionTv")
    private List<WebElement> etOptionTv;
    @AndroidFindBy(id = "com.huored.android.DongFangHong:id/ltTypeSubTv")
    List<WebElement> ltTypeSubTv;
    Utils utils =new Utils();



    public Map<String, String> getDetailData() {
        Map<String, String> map = new HashMap<>();


        //获取相应数据
        if (titleTv.getText() != null) {
            map.put(ConstantEnum.PLANTITLE.name, titleTv.getText());
        } else {
            map.put(ConstantEnum.PLANTITLE.name, " ");
            logger.info("无" + ConstantEnum.PLANTITLE.name);
        }

        map.put(ConstantEnum.ORDERNO.name, purchaseNoTv.getText());
        map.put(ConstantEnum.USERNAME.name, nicknameTv.getText());
        map.put(ConstantEnum.GMTCREATE.name, gmtCreateTv.getText());
        map.put(ConstantEnum.CREATETYPE.name, createTypeTv.getText());
        map.put(ConstantEnum.PLANFEE.name, totalFeeTv.getText() + "元" + multipleTv.getText() + "倍");
        map.put(ConstantEnum.YOURBUY.name, myPaidFeeTv.getText());
        map.put(ConstantEnum.MIXTYPES.name, mixTypesTv.getText());
        map.put(ConstantEnum.STATUS.name, statusTv.getText());
        map.put(ConstantEnum.PRIZESTATUS.name, prizeStatusTv.getText());
        map.put(ConstantEnum.MULTIPLE.name, multipleTv.getText());
        map.put(ConstantEnum.TOTALFEE.name, totalFeeTv.getText());

       new Swipe(getDriver()).swipeToUp();


        return map;


    }

    private void getGameDetail(int field, String playWay) {
        Map<String, List<String>> gameDetailMap = new HashMap<>();
        if (playWay.equals(ConstantEnum.M_1_N_1.name)) {//判断是否是单关
            for (int j = 0; j < gameNos.size(); j++) {
                List<String> list = new ArrayList<>();
                list.add(homeTeamNameTv.get(j).getText() + "VS" + guestTeamNameTv.get(j).getText());
                for (int i = 0; i < field; i++) {

                    list.add(ltTypeSubTv.get(i).getText() + " " + etOptionTv.get(i).getText());
                }
                gameDetailMap.put(gameNos.get(j).getText(), list);
            }
        } else {//不是单关
            for (int j = 0; j < gameNos.size(); j++) {
                List<String> list = new ArrayList<>();
                list.add(homeTeamNameTv.get(j).getText() + "VS" + guestTeamNameTv.get(j).getText());
                list.add(ltTypeSubTv.get(j).getText() + " " + etOptionTv.get(j).getText());
                gameDetailMap.put(gameNos.get(j).getText(), list);
            }
        }

        logger.info(gameDetailMap);
    }





    public void checkDetailDate(Map<String, String> detail, int field, String playWay) {

        String detail_order_no;
        detail_order_no = detail.get(ConstantEnum.ORDERNO.name);
        Map<String, Object> trueDetail = TestModel.getCheckDetail(1, detail_order_no);

        new DataUtils().getData("mix_types", ConstantEnum.MIXTYPES, detail, trueDetail);
        new DataUtils().getData("gmt_create", ConstantEnum.GMTCREATE, detail, trueDetail);
        new DataUtils().getData("multiple", ConstantEnum.MULTIPLE, detail, trueDetail);
        new DataUtils().getData("creater_type", ConstantEnum.CREATETYPE, detail, trueDetail);
        new DataUtils().getData(ConstantEnum.TOTAL_FEE.name, ConstantEnum.TOTALFEE, detail, trueDetail);
        new DataUtils().getData("title", ConstantEnum.PLANTITLE, detail, trueDetail);
        new DataUtils().getData("owner_user_id", "login_name", ConstantEnum.USERNAME, detail, trueDetail);
        new DataUtils().getData("plan_fee", ConstantEnum.PLANFEE, detail, trueDetail);



        getGameDetail(field, playWay);
//        untils.monkey();
    }





}
