package test.Untils;

/**
 * Created by Administrator on 2017/4/24.
 */
public enum ConstantEnum {


    JCZQ("竞彩足球"),
    JCLQ("竞彩篮球"),
    DLT("大乐透"),
    ZC("足彩"),
    YYFD("预约发单"),
    BFZB("比分直播"),
    M_1_N_1("1串1"),
    SINGLE_WAY("单关"),
    PUBLIC("公开"),
    AFTERGAME("开赛后公开"),
    SECRET("保密"),
    ORDERNO("方案编号"),
    MULTIPLE("倍数"),
    STATUS("委托状况"),
    PRIZESTATUS("中奖状况"),
    CREATETYPE("方案类型"),
    PLANTITLE("方案宣言"),
    GMTCREATE("发起时间"),
    USERNAME("发起人"),
    PLANFEE("方案金额"),
    MIXTYPES("投注方式"),
    HOME("首页"),
    BUYDATA("购彩记录"),
    FLLOW("我要跟单"),
    USERCENTER("会员中心"),
    MAINACTIVITY_NAME("com.huored.android.lt.MainActivity"),
    YOURBUY("您的认购"),
    TOTAL_FEE("total_fee"),

    TOTALFEE("投注金额"),
    WIN("win"),
    DRAW("draw"),
    LOST("lost"),
    RQ_WIN("rWin"),
    RQ_DRAW("rDraw"),
    RQ_LOST("rLost"),
    JQS("进球数"),
    BF("比分"),
    BQC("半全场"),
    SUPERLOTTO_NORMAL("normal"),
    SUPERLOTTO_ADD("add"),
    SUPERLOTTO_ADDRANDOM("addRandom"),
    SUPERLOTTO_ADDSELF("addSelf");
    public String name;

    ConstantEnum(String name) {
        this.name = name;
    }

}
