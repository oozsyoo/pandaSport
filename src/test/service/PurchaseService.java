package test.service;

import com.qa.framework.ioc.annotation.Autowired;
import com.qa.framework.ioc.annotation.Page;
import com.qa.framework.ioc.annotation.Service;
import test.Untils.ConstantEnum;
import test.Untils.MonkeyUtils;
import test.Untils.StringUtils;
import test.page.*;

import java.util.List;

/**
 * Created by Administrator on 2017/3/14.
 */
@Service
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


    @Autowired
    private OnLinePayPage onLinePayPage;

    public PurchaseService() {
    }

    public void purchase(int field, String playWay, ConstantEnum privacySettings, int multiples) {


        homePage.chosePlayWay(ConstantEnum.JCZQ);
        gameSelectPage.choseWay(ConstantEnum.JCZQ, field, StringUtils.transformSinglePass(playWay));
        confirmSelectPage.setPlayWays(StringUtils.transformSinglePass(playWay), multiples);
        confirmTakeTicketPage.setPrivacy(privacySettings);
        confirmTakeTicketPage.getPageData(purchasePage.getDataMap());


        planDetailPage.checkDetailDate(planDetailPage.getDetailData(), field, StringUtils.transformSinglePass(playWay));
    }

    public void BuyInBulk(int field, String playWay, String privacySettings, int multiples, int degree) {


        homePage.chosePlayWay(ConstantEnum.JCZQ);
        gameSelectPage.jczq(field);
        confirmSelectPage.setPlayWays(StringUtils.transformSinglePass(playWay), multiples);


        for (int i = 0; i < degree; i++) {

            gameSelectPage.jczq(field);
            confirmSelectPage.setPlayWays(StringUtils.transformSinglePass(playWay), multiples);


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

    }

    public void copyTest() {
        homePage.choseFragment(ConstantEnum.FLLOW);
        for (int i = 0; i < 100; i++) {


            copyPage.copy();


        }
    }

    public void test(int field, String playWay, int multiples, List<String> playWays,String password,String payWay) {
        homePage.chosePlayWay(ConstantEnum.JCZQ);
//        monkeyUtils.monkeyTest();
        gameSelectPage.jczq(playWay, field, playWays);
        confirmSelectPage.setPlayWays(playWay, multiples);
        confirmTakeTicketPage.setPrivacy(ConstantEnum.SECRET);
        confirmTakeTicketPage.getOkBtn().click();
        onLinePayPage.choseBalancePay(payWay);
        onLinePayPage.getToPayBtn().click();
        onLinePayPage.inputPassWord(password);
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

