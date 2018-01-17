package test.datamodel;

import com.qa.framework.library.database.DBHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by Administrator on 2017/3/10.
 */
public class TestModel extends ModelBase{
    public static Map<String, Object> getUser(int enable) {
        String sql = String.format("select * from CIF_USER where CELL like '1%%' and login_password='0782bf638ce851ab08dd41cb3c86dda1' and can_login=%s", enable);
        logger.info(sql);
        return DBHelper.queryOneRow(sql, "cif_oap");
        //return DBHelper.queryOneRow(sql);
    }
    public static boolean checkUserName(String login_name,int enable) {
        String sql = String.format("select login_name from CIF_USER where login_name='"+login_name+"'", enable);
        logger.info(sql);
        if(DBHelper.queryOneRow(sql, "cif_oap")==null){
        return true;
        }else {
            return false;
        }
        //return DBHelper.queryOneRow(sql);
    }
    public static Map<String, Object> getMoney(int enable) {
        String sql = String.format("select * from acc_account t where t.user_id=8201608246575805", enable);
        logger.info(sql);
        return DBHelper.queryOneRow(sql, "account");
        //return DBHelper.queryOneRow(sql);
    }

    public static Map<String, Object> getCheckPlay(String issue,String gameNo) {
        String sql = String.format("select * from ltbs_jczq_data t where t.issue_no='"+issue+"'   and t.game_no='"+gameNo+"'");
        logger.info(sql);
        return DBHelper.queryOneRow(sql, "ltbase");
        //return DBHelper.queryOneRow(sql);
    }
    public static Map<String, Object> getCheckDetail(int enable ,String order_no) {
        String sql = String.format("select * from ltpu_purchase_order t where t.order_no='"+order_no+"'", enable);
        logger.info(sql);
        return DBHelper.queryOneRow(sql, "ltpurchase");
        //return DBHelper.queryOneRow(sql);
    }
    public static Map<String, Object> getUserName(int enable ,String user_id) {
        String sql = String.format("select * from cif_user t where t.user_id='"+user_id+"'", enable);
        logger.info(sql);
        return DBHelper.queryOneRow(sql, "cif");
        //return DBHelper.queryOneRow(sql);
    }
    public static Map<String, Object> getRegUser() {
        Random r = new Random();
        String sql = "select * from lts_customer t where customer_register_status ='WAIT_RESISTER' and cell1 is not null";
        List<Map<String, Object>> list = DBHelper.queryRows(sql, "ltstation");
        sql = "select * from cif_user where cell is not null";
        List<Map<String, Object>> list2 = DBHelper.queryRows(sql, "cif_oap");
        ArrayList<String> cellHaveReg = new ArrayList<String>();
        for (Map<String, Object> aList2 : list2) {
            cellHaveReg.add(aList2.get("cell").toString());
        }
        int rN = r.nextInt(list.size());
        while (checkNumber(cellHaveReg, list.get(rN).get("cell1").toString())) {
            rN = r.nextInt(list.size());
        }
        return list.get(rN);
    }
    public static String getChangeYzm(String cell) {
        String sql = String.format("select * from(select * from gtc_sms_out_his t where receiver='%s' order by gmt_send_success desc) where rownum<=1", cell);
        logger.info(sql);
        String message = DBHelper.queryOneRow(sql, "gotonecore_oap").get("content").toString();
        String[] cut = message.split("校验码");


        return cut[1];
    }


    public static List<Map<String, Object>> getGame2(int enable, String match_name, int season_start, int season_end) {
        String sql = String.format("select b.guest_team_name 客队名,sum(case when b.guest_score - b.home_score >= 3 then 1 else 0 end) 净胜3球以上,  sum(case when b.guest_score - b.home_score = 2 then 1 else 0 end) 净胜2球,sum(case when b.guest_score - b.home_score = 1 then 1 else 0 end) 净胜1球,sum(case when b.home_score - b.guest_score = 0 then 1 else 0 end) 平手,sum(case when b.home_score - b.guest_score = 1 then 1 else 0 end) 净负1球,sum(case when b.home_score - b.guest_score = 2 then 1 else 0 end) 净负2球,sum(case when b.home_score - b.guest_score >= 3 then 1 else 0 end) 净负3球以上 from ftc_season_race b where b.season_id in (select a.id from ftc_season a where a.season_start = " + season_start + " and a.season_end = " + season_end + ")and b.match_name = '" + match_name + "' and b.enabled = 1 and b.status = 'FINISH' group by b.guest_team_name order by (净胜1球+净胜2球+净胜3球以上) desc", enable);
        logger.info(sql);
        return DBHelper.queryRows(sql, "ftcore");
        //return DBHelper.queryOneRow(sql);
    }




    public static List<Map<String, Object>> getGame(int enable, String match_name, int season_start, int season_end) {
        String sql = String.format("select b.home_team_name 主队名, sum(case when b.home_score - b.guest_score >= 3 then 1 else 0 end) 净胜3球以上, sum(case when b.home_score - b.guest_score = 2 then 1 else 0 end) 净胜2球,sum(case when b.home_score - b.guest_score = 1 then 1 else 0 end) 净胜1球, sum(case when b.home_score - b.guest_score = 0 then 1 else 0 end) 平手, sum(case when b.guest_score - b.home_score = 1 then 1 else 0 end) 净负1球, sum(case when b.guest_score - b.home_score = 2 then 1 else 0 end) 净负2球, sum(case when b.guest_score - b.home_score >= 3 then 1 else 0 end) 净负3球以上 from ftc_season_race b where b.season_id in ( select a.id from ftc_season a where a.season_start = " + season_start + " and a.season_end = " + season_end + ") and b.match_name = '" + match_name + "' and b.enabled = 1 and b.status = 'FINISH' group by b.home_team_name order by (净胜1球+净胜2球+净胜3球以上) desc", enable);
        logger.info(sql);
        return DBHelper.queryRows(sql, "ftcore");
        //return DBHelper.queryOneRow(sql);
    }
    public static Integer getCanByGameNum() {
        String sql = String.format("select COUNT(1) from dc_jczq_data t where t.gg_stop_sell_date>sysdate");
        logger.info(sql);
        List<Map<String, Object>> list=DBHelper.queryRows(sql, "drawcenter");
        int i=Integer.parseInt(list.get(0).get("COUNT(1)").toString());
        return i;
        //return DBHelper.queryOneRow(sql);
    }



    public static boolean checkNumber(ArrayList<String> list, String text) {
        for (String aList : list) {
            if (aList.equals(text)) {
                return true;
            }
        }
        return false;
    }
}
