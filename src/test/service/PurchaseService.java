package test.service;

import com.qa.framework.ioc.annotation.Autowired;
import com.qa.framework.ioc.annotation.Page;
import test.Untils.ConstantEnum;
import test.Untils.StringUtils;
import test.page.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/14.
 */
@Page
public class PurchaseService {
    @Autowired
    private PurchasePage purchasePage;
    @Autowired
    private HomePage homePage;
    @Autowired
    private GameSelectPage gameSelectPage;
    @Autowired
    private PlanDetailPage planDetailPage;
    @Autowired
    private SuperLottoPage superLottoPage;
    @Autowired
    private ConfirmTakeTicketPage confirmTakeTicketPage;
    @Autowired
    private ConfirmSelectPage confirmSelectPage;
    @Autowired
    private CopyPage copyPage;

    public PurchaseService() {
    }

    public void purchase(int field, String playWay, ConstantEnum privacySettings, String multiples) {


        homePage.chosePlayWay(ConstantEnum.JCZQ);
        gameSelectPage.choseWay(ConstantEnum.JCZQ, field, StringUtils.transformSinglePass(playWay));
        confirmSelectPage.setPlayWays(StringUtils.transformSinglePass(playWay), multiples, purchasePage.getDataMap());
        confirmTakeTicketPage.setPrivacy(privacySettings);
        confirmTakeTicketPage.getPageData(purchasePage.getDataMap());
        confirmTakeTicketPage.confrimPay();
        confirmTakeTicketPage.buySucceedChose(false);
        planDetailPage.checkDetailDate(planDetailPage.getDetailData(), field, StringUtils.transformSinglePass(playWay));
    }

    public void BuyInBulk(int field, String playWay, String privacySettings, String multiples, int degree) {


        homePage.chosePlayWay(ConstantEnum.JCZQ);
        gameSelectPage.jczq(playWay,field);
        confirmSelectPage.setPlayWays(StringUtils.transformSinglePass(playWay), multiples, purchasePage.getDataMap());
        confirmTakeTicketPage.confrimPay();
        confirmTakeTicketPage.buySucceedChose(true);
        for (int i = 0; i < degree; i++) {

            gameSelectPage.jczq(playWay,field);
            confirmSelectPage.setPlayWays(StringUtils.transformSinglePass(playWay), multiples, purchasePage.getDataMap());
            confirmTakeTicketPage.confrimPay();
            confirmTakeTicketPage.buySucceedChose(true);
            System.out.println(i);
        }
    }


    public void purchaseSuperLotto(int redBall, int buleBall, ConstantEnum privacySettings, ConstantEnum playWay, int multiples) {


        homePage.chosePlayWay(ConstantEnum.DLT);
        superLottoPage.shake();
//        superLottoPage.choseBall(redBall, buleBall);
        confirmSelectPage.superLottoSetPlayWays(multiples, playWay);
        confirmTakeTicketPage.setPrivacy(privacySettings);
        confirmTakeTicketPage.getPageData(purchasePage.getDataMap());
        confirmTakeTicketPage.confrimPay();
    }

    public void copyTest() {
        homePage.choseFragment(ConstantEnum.FLLOW);
        for(int i=0;i<100;i++) {


           copyPage.copy();


        }
    }

    public void test(int field, String playWay) {
        homePage.chosePlayWay(ConstantEnum.JCZQ);
        List<String> list=new ArrayList<>();
        list.add("胜平负");
        list.add("比分");
        list.add("半全场");
        list.add("进球数");
        gameSelectPage.jczq(playWay,field);

    }


    public void choseFragment(ConstantEnum key) {

        switch (key) {
            case HOME:

                break;
            case FLLOW:

                copyPage.copy();

                break;
            case BUYDATA:

                break;
            case USERCENTER:

                break;
            default:
        }
    }
}

