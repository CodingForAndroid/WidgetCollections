package com.bczm.widgetcollections.http;

import com.bczm.widgetcollections.utils.SharedPreferenceUtils;

import java.util.HashMap;
import java.util.Map;

/**  常量类
 * @author：Jorge on 2015/9/7 14:45
 */
public class ConfigManage {


    public static final String HOME_DATA ="http://www.weather.com.cn/data/sk/101010100.html";

    // 点击  进入视频界面 传递 的intent 参数   trackid,content_id
    public static final String INTENT_EXTRA_TRACKID="trackid";
    public static final String INTENT_EXTRA_CONTENT_ID="content_id";

    /**
     *  api  get请求服务器  传递的 头信息
     * @return
     */
public static Map<String, String>  getHeaders(){
    Map<String, String> headers = new HashMap<String, String>();
    headers.put("User-Agent", "Client(ERDO/4.0.11;Android/4.4.4;720*1280;G620S-UL00;PAYMD/1.0.02;)");
    headers.put("Cookie","sto-id-51017=BIBKKIMAMHEJ");
    String value = String.valueOf(System.currentTimeMillis()).subSequence(0, 10).toString();
    headers.put("timestamp",value);
    headers.put("app_id","dm_zk_6001100_81");
    headers.put("client_style","1");
    headers.put("access_token", SharedPreferenceUtils.getAccessToken());
    headers.put("promotion_id","020000000003");
    return  headers;
}





    /*******************************写死一些数据*******************************************/
    // 猜你喜欢
   public static final   String GUESS_FAVOURIATE="{\"record_count\":10,\"items\":[{\"content_id\":\"2S201507082200092729\",\"content_type\":\"2\",\"title\":\"魔女猎人\",\"description\":\"故事讲述因涉嫌杀害物理学家海因茨·修奈达而遭到通缉的少女艾莉丝，不知何故被黑社会高价悬赏。赏金猎人娜蒂在墨西哥的乡间发现了艾莉丝，却因偶然的原委从其他猎人手中将她救下。\",\"cover\":\"http://img0.icartoons.cn/opftp/20150710/7504/201507082200092729/cover/web165x220.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862\",\"w_type\":0,\"superscript\":\"\",\"author\":\"真下耕一\",\"lastupdate\":null,\"trackid\":\"1442463131280313184a128030188f97-c7---\",\"pic\":\"http://img0.icartoons.cn/spftp/temp/2015071609212700000075912542/720x405.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862\"},{\"content_id\":\"2S201504272200092406\",\"content_type\":\"2\",\"title\":\"梦幻妖子\",\"description\":\"在远古时代，天女从天上来到人间沐浴。天女沐浴时把她的羽衣挂在一旁，可是羽衣却被拿走了。由于没有羽衣无法回到天上，天女只有留在人间。于是她嫁给拿走羽衣的男人，繁衍了后代。他们的后代也因此继承了天女的血统……\",\"cover\":\"http://img0.icartoons.cn/opftp/20150428/7504/201504272200092406/cover/web165x220.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862\",\"w_type\":0,\"superscript\":\"\",\"author\":\"渡瀬悠宇\",\"lastupdate\":null,\"trackid\":\"1442463131280313184a128030188f97-c7---\",\"pic\":\"http://img0.icartoons.cn/opftp/20150428/7504/201504272200092406/cover/720x405.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862\"},{\"content_id\":\"2S201506032200092634\",\"content_type\":\"2\",\"title\":\"搜神记\",\"description\":\"传说中的三皇五帝时代，随着天下公认的领袖神农氏的去世，金、木、水、火、土，五族群雄开始蠢蠢欲动。就在此波涛暗涌的动荡时代，一位少年横空出世，在机缘巧合下开始了一段惊心动魄的传奇历程。\",\"cover\":\"http://img0.icartoons.cn/opftp/20150604/7504/201506032200092634/cover/web165x220.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862\",\"w_type\":0,\"superscript\":\"\",\"author\":\"杭州九越数字动画\",\"lastupdate\":null,\"trackid\":\"1442463131280313184a128030188f97-c7---\",\"pic\":\"http://img0.icartoons.cn/opftp/20150604/7504/201506032200092634/cover/720x405.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862\"},{\"content_id\":\"2S201308022200088196\",\"content_type\":\"2\",\"title\":\"三目童子\",\"description\":\"故事讲述古代三眼族后裔写乐保介，是个天真烂漫的中学生，但他天生拥有三颗眼，而且拥有异于常人的超能力，只要把封印在第三颗眼上的胶布撕开，善良的写乐便会立即变成满脑子想着征服世界的狂人。而唯一能制止写乐变为恶魔的人，就是他的同学兼女友和登千代子\",\"cover\":\"http://img0.icartoons.cn/opftp/20130805/7504/201308022200088196/cover/web165x220.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862\",\"w_type\":0,\"superscript\":\"\",\"author\":\"手冢治虫\",\"lastupdate\":null,\"trackid\":\"1442463131280313184a128030188f97-c7---\",\"pic\":\"http://img0.icartoons.cn/spftp/temp/2015051303355100000084112542/720x405.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862\"},{\"content_id\":\"2S201501152200091741\",\"content_type\":\"2\",\"title\":\"黑之契约者第一季\",\"description\":\"被称为地狱门的不可侵领域突然出现在东京。 真正的星空消失，取而代之的是虚假的星星。世界各地开始出现被称为“契约者”的超能力者。\",\"cover\":\"http://img0.icartoons.cn/opftp/20150116/129600/201501152200091741/cover/web165x220.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862\",\"w_type\":0,\"superscript\":\"\",\"author\":\"骨头社\",\"lastupdate\":null,\"trackid\":\"1442463131280313184a128030188f97-c7---\",\"pic\":\"http://img0.icartoons.cn/spftp/temp/2015091102502300000090813215/720x405.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862\"},{\"content_id\":\"2S201501282200091818\",\"content_type\":\"2\",\"title\":\"魔笛MAGI第一季\",\"description\":\"作品中的登场人物名字部分取材于《一千零一夜》，舞台是与欧亚大陆和非洲相似的架空世界。故事主要讲述了作为选定世界之王的“魔奇”之一的小主人公阿拉丁，由此而展开的一系列有趣惊险的冒险旅程。\\r\\n\",\"cover\":\"http://img0.icartoons.cn/opftp/20150129/129600/201501282200091818/cover/web165x220.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862\",\"w_type\":0,\"superscript\":\"\",\"author\":\"大高忍\",\"lastupdate\":null,\"trackid\":\"1442463131280313184a128030188f97-c7---\",\"pic\":\"http://img0.icartoons.cn/spftp/temp/2015081210145300000021513215/魔笛1.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862\"},{\"content_id\":\"2S201501232200091794\",\"content_type\":\"2\",\"title\":\"魔笛MAGI第二季\",\"description\":\"作品中的登场人物名字部分取材于《一千零一夜》，舞台是与欧亚大陆和非洲相似的架空世界。故事主要讲述了作为选定世界之王的“魔奇”之一的小主人公阿拉丁，由此而展开的一系列有趣惊险的冒险旅程。\",\"cover\":\"http://img0.icartoons.cn/opftp/20150123/129600/201501232200091794/cover/web165x220.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862\",\"w_type\":0,\"superscript\":\"\",\"author\":\"大高忍\",\"lastupdate\":null,\"trackid\":\"1442463131280313184a128030188f97-c7---\",\"pic\":\"http://img0.icartoons.cn/spftp/temp/2015042310422700000098313215/720x405.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862\"},{\"content_id\":\"2S201306062200087595\",\"content_type\":\"2\",\"title\":\"魔笛MAGI\",\"description\":\"故事主要讲述了作为选定世界之王的“魔奇”之一的小主人公阿拉丁的一系列有趣惊险的冒险旅程。\",\"cover\":\"http://img0.icartoons.cn/opftp/20130607/129600/201306062200087595/cover/web165x220.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862\",\"w_type\":0,\"superscript\":\"\",\"author\":\"大高忍\",\"lastupdate\":null,\"trackid\":\"1442463131280313184a128030188f97-c7---\",\"pic\":\"http://img0.icartoons.cn/spftp/temp/2015082810084700000017813228/720x405.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862\"},{\"content_id\":\"2S201408192200091001\",\"content_type\":\"2\",\"title\":\"圣枪修女\",\"description\":\"年幼时的萝塞特一次不慎和弟弟尤休亚一起掉入墓穴，与自称是恶魔的克罗诺相遇，她与弟弟从此与克罗诺之间建立了绝对的信赖关系。。\",\"cover\":\"http://img0.icartoons.cn/opftp/20141015/5907/201408192200091001/cover/web165x220.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862\",\"w_type\":0,\"superscript\":\"\",\"author\":\"NTV\",\"lastupdate\":null,\"trackid\":\"1442463131280313184a128030188f97-c7---\",\"pic\":\"http://img0.icartoons.cn/spftp/temp/2015082504342600000096313228/720x405.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862\"},{\"content_id\":\"2S201504152200092350\",\"content_type\":\"2\",\"title\":\"血族\",\"description\":\"总是幻想着成为吸血鬼猎人的夜壬，意外地被卷入血族少女与圣地的激战之中开始。成为临时血仆的夜壬，并不知道自己所将要面对的，是一段绵延千年的仇恨与争斗……\",\"cover\":\"http://img0.icartoons.cn/opftp/20150819/129591/201504152200092350/cover/web165x220.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862\",\"w_type\":0,\"superscript\":\"\",\"author\":\"杭州九漫信息技术有限公司\",\"lastupdate\":null,\"trackid\":\"1442463131280313184a128030188f97-c7---\",\"pic\":\"http://img0.icartoons.cn/opftp/20150819/129591/201504152200092350/cover/血族_副本.jpg?flow_flag=74559208&flow_type=1&flow_channel=api&dm_sid=1442463131280313184a128030188f97&trackid=1442463131280313184a128030188f97----&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862\"}]}";
    // 当前点播的视频
   public static final   String VIDEO_CURRENT_PLAY="{\"title\":\"六花的勇者 第1集\",\"totalcount\":1430,\"baseurl\":\"\",\"items\":[{\"content_id\":\"2C201507053200190282\",\"set_num\":\"1\",\"url\":\"http://streaming-http.icartoons.cn:7388/cmstest/20150725/7504/201507053200190282/W1280.3gp?msisdn=74559208&spid=001&sid=005&appid=dm_zk_6001100_10069_30&trackid=1442463131280313184a128030188f97-c1-2-3-&dm_sid=1442463131280313184a128030188f97&loginfo=74559208|68a0f6a3d862|4|68a0f6a3d862|000000000000000|68a0f6a3d862&client_style=1&animeversion=j\",\"page\":1,\"single_filesize\":\"141251350\",\"width\":null,\"height\":null}],\"provision\":\"W1280\",\"filesize\":141251350,\"serial_title\":\"六花的勇者\",\"next_chapter_id\":\"2C201507123200190855\"}";
   // 视频介绍
   public static  final  String  VIDEO_DETAIL_DESC="[{\"content_id\":\"2S201507052200092708\",\"content_type\":\"2\",\"category_id\":\"32\",\"category_name\":\"神魔\",\"title\":\"六花的勇者\",\"is_out_show\":0,\"description\":\"【爱动漫日漫新番同步首发】传说，当魔物从黑暗深渊觉醒，世间化为地狱之时，命运之神会选出六位勇者并将授予此六人拯救世界之力。现在开始所要讲述的，便是背负着拯救世界使命的勇者们的故事。\",\"cover\":\"http://img0.icartoons.cn/opftp/20150706/7504/201507052200092708/cover/web165x220.jpg\",\"lastupdate\":\"1436173194\",\"is_fav\":0,\"author\":\"山形石雄\",\"is_whb\":\"0\",\"trackid\":\"1442463131280313184a128030188f97-c1-2-3-\",\"serial_status\":\"0\",\"is_continue\":0,\"continue_id\":\"\",\"update_set\":\"11\",\"is_sort\":1,\"is_down\":0,\"pic\":\"http://img0.icartoons.cn/spftp/temp/2015070610364100000062612542/720x405.jpg\"}]";
  // 同一系列的 其他视频
  public  static  final  String VIDEO_SET="{\"record_num\":11,\"items\":[{\"content_id\":\"2C201507053200190282\",\"title\":\"六花的勇者 第1集\",\"set_num\":\"1\",\"is_free\":1,\"url\":\"http://192.168.26.75:18889/dm189/index.php?m=content&c=index&a=play_anime&id=200092708&provisionid=200359898\",\"lastupdate\":\"1437834301\",\"heght\":\"240\",\"width\":\"320\",\"is_new\":0},{\"content_id\":\"2C201507123200190855\",\"title\":\"六花的勇者 第2集\",\"set_num\":\"2\",\"is_free\":1,\"url\":\"http://192.168.26.75:18889/dm189/index.php?m=content&c=index&a=play_anime&id=200092708&provisionid=200360630\",\"lastupdate\":\"1437986241\",\"heght\":\"240\",\"width\":\"320\",\"is_new\":0},{\"content_id\":\"2C201507193200191440\",\"title\":\"六花的勇者 第3集\",\"set_num\":\"3\",\"is_free\":1,\"url\":\"http://192.168.26.75:18889/dm189/index.php?m=content&c=index&a=play_anime&id=200092708&provisionid=200361451\",\"lastupdate\":\"1438147950\",\"heght\":\"240\",\"width\":\"320\",\"is_new\":0},{\"content_id\":\"2C201507263200192281\",\"title\":\"六花的勇者 第4集\",\"set_num\":\"4\",\"is_free\":1,\"url\":\"http://192.168.26.75:18889/dm189/index.php?m=content&c=index&a=play_anime&id=200092708&provisionid=200362509\",\"lastupdate\":\"1438665606\",\"heght\":\"240\",\"width\":\"320\",\"is_new\":0},{\"content_id\":\"2C201508023200192866\",\"title\":\"六花的勇者 第5集\",\"set_num\":\"5\",\"is_free\":1,\"url\":\"http://192.168.26.75:18889/dm189/index.php?m=content&c=index&a=play_anime&id=200092708&provisionid=200363313\",\"lastupdate\":\"1439198925\",\"heght\":\"240\",\"width\":\"320\",\"is_new\":0},{\"content_id\":\"2C201508093200193414\",\"title\":\"六花的勇者 第6集\",\"set_num\":\"6\",\"is_free\":0,\"url\":\"http://192.168.26.75:18889/dm189/index.php?m=content&c=index&a=play_anime&id=200092708&provisionid=200364124\",\"lastupdate\":\"1439549663\",\"heght\":\"240\",\"width\":\"320\",\"is_new\":0},{\"content_id\":\"2C201508153200193857\",\"title\":\"六花的勇者 第7集\",\"set_num\":\"7\",\"is_free\":0,\"url\":\"http://192.168.26.75:18889/dm189/index.php?m=content&c=index&a=play_anime&id=200092708&provisionid=200364801\",\"lastupdate\":\"1440051380\",\"heght\":\"240\",\"width\":\"320\",\"is_new\":0},{\"content_id\":\"2C201508223200194218\",\"title\":\"六花的勇者 第8集\",\"set_num\":\"8\",\"is_free\":0,\"url\":\"http://192.168.26.75:18889/dm189/index.php?m=content&c=index&a=play_anime&id=200092708&provisionid=200365289\",\"lastupdate\":\"1441519095\",\"heght\":\"240\",\"width\":\"320\",\"is_new\":0},{\"content_id\":\"2C201508293200194522\",\"title\":\"六花的勇者 第9集\",\"set_num\":\"9\",\"is_free\":0,\"url\":\"http://192.168.26.75:18889/dm189/index.php?m=content&c=index&a=play_anime&id=200092708&provisionid=200365973\",\"lastupdate\":\"1442209626\",\"heght\":\"240\",\"width\":\"320\",\"is_new\":0},{\"content_id\":\"2C201509053200194635\",\"title\":\"六花的勇者 第10集\",\"set_num\":\"10\",\"is_free\":0,\"url\":\"http://192.168.26.75:18889/dm189/index.php?m=content&c=index&a=play_anime&id=200092708&provisionid=200366194\",\"lastupdate\":\"1442210554\",\"heght\":\"240\",\"width\":\"320\",\"is_new\":0},{\"content_id\":\"2C201509123200194855\",\"title\":\"六花的勇者 第11集\",\"set_num\":\"11\",\"is_free\":0,\"url\":\"http://192.168.26.75:18889/dm189/index.php?m=content&c=index&a=play_anime&id=200092708&provisionid=200366775\",\"lastupdate\":\"1442362701\",\"heght\":\"240\",\"width\":\"320\",\"is_new\":0}],\"out_type\":0,\"out_source\":[{\"source_name\":\"\"}]}";
    /*******************************写死一些数据*******************************************/
}
