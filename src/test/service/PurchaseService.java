package test.service;

import com.qa.framework.ioc.annotation.Autowired;
import com.qa.framework.ioc.annotation.Service;
import test.Untils.ConstantEnum;
import test.Untils.MyStringUtils;
import test.page.*;

import java.util.List;

/**
 * Created by Administrator on 2017/3/14.
 */
@Service
public class PurchaseService {

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
    @Autowired
    private ResultPage resultPage;


    public void purchaseSuperLotto(int redBall, int buleBall, ConstantEnum privacySettings, ConstantEnum playWay, String multiples, String version) {


        homePage.chosePlayWay(ConstantEnum.DLT);
//        superLottoPage.shake();
        superLottoPage.choseBall(redBall, buleBall);
        confirmSelectPage.superLottoSetPlayWays(multiples, playWay);
        confirmTakeTicketPage.setPrivacy(privacySettings);
        confirmTakeTicketPage.getOkBtn().click();
        confirmTakeTicketPage.getOkBtn().click();
        resultPage.choseNextStep("继续购买");
        gameSelectPage.getBackBtn().click();
        gameSelectPage.getBackBtn().click();
        confirmTakeTicketPage.getOkBtn().click();
        gameSelectPage.getBackBtn().click();
        homePage.choseFragment(ConstantEnum.USERCENTER);
        homePage.checkVersion(version);
    }

    public void copyTest() {
        homePage.choseFragment(ConstantEnum.FLLOW);
        for (int i = 0; i < 100; i++) {


            copyPage.copy();

        }
    }

    public void testZq(List<String> playWay1, ConstantEnum privacy, String multiples, List<String> playWays1, String version) {
        homePage.chosePlayWay(ConstantEnum.JCZQ);

        String playWay = playWay1.get(0);
        String playWays = playWays1.get(0);

        gameSelectPage.jczq(playWay, playWays);
        confirmSelectPage.setPlayWays(playWay, multiples);
        confirmTakeTicketPage.setPrivacy(privacy);
        confirmTakeTicketPage.getOkBtn().click();
        confirmTakeTicketPage.getOkBtn().click();
        resultPage.choseNextStep("继续购买");
        gameSelectPage.getBackBtn().click();
        homePage.choseFragment(ConstantEnum.USERCENTER);
        homePage.checkVersion(version);

    }


    public void testZc(List<String> playWay1, ConstantEnum privacy, String multiples, String version) {
        homePage.chosePlayWay(ConstantEnum.ZC);

        String playWay = playWay1.get(0);


        gameSelectPage.choseZc(playWay);
        gameSelectPage.getBuyBtn().click();
        confirmTakeTicketPage.setPrivacy(privacy);
        confirmTakeTicketPage.getOkBtn().click();
        confirmTakeTicketPage.getOkBtn().click();
        resultPage.choseNextStep("继续购买");
        gameSelectPage.getBackBtn().click();
        homePage.choseFragment(ConstantEnum.USERCENTER);
        homePage.checkVersion(version);

    }

//    多次购彩
//    public void testLq(List<String> playWay1, String privacy, String multiples, List<String> playWays1,String version) {
//        homePage.chosePlayWay(ConstantEnum.JCLQ);
//
//        for (int i = 0; i < playWay1.size(); i++) {
//            String playWay = playWay1.get(i);
//            String playWays = playWays1.get(i);
//
//            gameSelectPage.jclq(playWay, playWays);
//            confirmSelectPage.setPlayWays(playWay, multiples);
//            confirmTakeTicketPage.setPrivacy(ConstantEnum.SECRET);
//            confirmTakeTicketPage.getOkBtn().click();
//            confirmTakeTicketPage.getOkBtn().click();
//            resultPage.choseNextStep("继续购买");
//        }
//
//    }

    public void testLq(List<String> playWay1, ConstantEnum privacy, String multiples, List<String> playWays1, String version) {
        homePage.chosePlayWay(ConstantEnum.JCLQ);

        String playWay = playWay1.get(0);
        String playWays = playWays1.get(0);

        gameSelectPage.jclq(playWay, playWays);
        confirmSelectPage.setPlayWays(playWay);
        confirmTakeTicketPage.setPrivacy(privacy);
        confirmTakeTicketPage.getOkBtn().click();
        confirmTakeTicketPage.getOkBtn().click();
        resultPage.choseNextStep("继续购买");
        gameSelectPage.getBackBtn().click();

        homePage.choseFragment(ConstantEnum.USERCENTER);
        homePage.checkVersion(version);

    }


    public void test() {
        homePage.choseFragment(ConstantEnum.USERCENTER);
//        homePage.checkVersion();
    }

}

