package sample;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        String html = "\n" +
                "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gb2312\" />\n" +
                "<title>玉都商城</title>\n" +
                "<link href=\"css/css.css\" rel=\"stylesheet\" type=\"text/css\" />\n" +
                "</head>\n" +
                "<body>\n" +
                "\n" +
                "<LINK rel=stylesheet type=text/css href=\"css/main.css\">\n" +
                "<style type=\"text/css\">\n" +
                "* {\n" +
                "\tmargin:0;\n" +
                "\tpadding:0;\n" +
                "}\n" +
                "ul, ol {\n" +
                "\tlist-style:none;\n" +
                "}\n" +
                "a img {\n" +
                "\tborder:none;\n" +
                "}\n" +
                "#content {\n" +
                "\twidth:222px;margin:0px auto;\n" +
                "}\n" +
                ".main_nav {\n" +
                "\twidth:100%;height:45px;\n" +
                "}\n" +
                ".main_nav ul li {\n" +
                "\tfloat:left;\n" +
                "\twidth:222px;\n" +
                "\theight:100px;\n" +
                "\tposition:relative;\n" +
                "\ttext-align:center\n" +
                "}\n" +
                ".main_nav ul li a {\n" +
                "\tdisplay:block;\n" +
                "\theight:100px;\n" +
                "\tline-height:100px;\n" +
                "\ttext-align:center;\n" +
                "\tcolor:#333333;\n" +
                "\ttext-decoration:none;\n" +
                "}\n" +
                ".main_nav ul li dl {\n" +
                "\tposition:absolute;\n" +
                "\tleft:0px;\n" +
                "\ttop:100px;\n" +
                "\twidth:222px;\n" +
                "\tdisplay:none;\n" +
                "}\n" +
                ".main_nav ul li dl dd {\n" +
                "\theight:45px;\n" +
                "}\n" +
                ".main_nav ul li dl dd a {\n" +
                "\tdisplay:block;\n" +
                "\theight:45px;\n" +
                "\tline-height:45px;\n" +
                "\ttext-align:center;\n" +
                "\tcolor:#000000;\n" +
                "\tfont-size:20px;\n" +
                "\tfont-family:'微软雅黑';\n" +
                "\tbackground:#FFFFFF;\n" +
                "}\n" +
                ".main_nav ul li dl dd a:hover{background:#F1F1F1;color:#333333;font-family:'微软雅黑'}\n" +
                "</style>\n" +
                "\n" +
                "\n" +
                "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-bottom:1px #ECECEC solid\">\n" +
                "  <tr>\n" +
                "    <td height=\"30\" bgcolor=\"#F3F3F3\" style=\"border-bottom:1px #EAEAEA solid\" align=\"center\">\n" +
                "\t\n" +
                "\t\n" +
                "\t<table width=\"1196\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "      <tr>\n" +
                "        <td height=\"30\" align=\"left\" style=\"font-size:14px; color:#666666\">\n" +
                "\t\t\n" +
                "\t\t\t您好，欢迎来到玉都商城！&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "\t\t\t<a href=\"reg.aspx\" style=\"color:#666666\">免费注册</a>&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "\t\t\t<a href=\"user.aspx\" style=\"color:#666666\">登录</a>\n" +
                "\t\t\t\t</td>\n" +
                "        <td height=\"30\">&nbsp;</td>\n" +
                "        <td height=\"30\" align=\"right\" style=\"font-size:14px; color:#666666\">\n" +
                "\t\t\t<a href=\"/member/index.aspx\" style=\"color:#666666\" target=\"_blank\">账户中心</a>&nbsp;&nbsp;&nbsp;&nbsp;\n" +
                "\t\t\t<a href=\"help.aspx\" style=\"color:#666666\">帮助中心</a>\n" +
                "\t\t</td>\n" +
                "        </tr>\n" +
                "    </table>\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td height=\"100\" bgcolor=\"#FFFFFF\" align=\"center\">\n" +
                "\t\t  <table width=\"1196\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "\t\t\t<tr>\n" +
                "\t\t\t  <td width=\"250\" height=\"150\"><img src=\"http://www.cnydvip.net/load/logo/2018082239811637.png\" width=\"220\" border=\"0\"></td>\n" +
                "\t\t\t  <td height=\"150\">&nbsp;</td>\n" +
                "\t\t\t  <td height=\"150\" align=\"right\">\n" +
                "\t\t\t  \n" +
                "\t\t\t<form id=\"form1\" name=\"form1\" method=\"post\" action=\"product.aspx\">\n" +
                "\t\t\t    <table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-radius:4px; border:1px #FF4C66 solid\">\n" +
                "                  <tr>\n" +
                "                    <td align=\"center\" style=\"border:0px #FF4C66 solid;\"><input type=\"text\" name=\"pro_search\" style=\"width:240px; height:35px; border:0px; padding-left:10px;\" /></td>\n" +
                "                    <td align=\"center\" style=\"border:0px #FF4C66 solid;\"><input type=\"submit\" name=\"Submit\" value=\"搜索\" style=\"width:80px; height:40px; background-color:#FF4C66; border:0px; color:#FFFFFF\" /></td>\n" +
                "                  </tr>\n" +
                "                </table>\n" +
                "\t\t\t</form>\t\t\t  \n" +
                "\t\t\t  </td>\n" +
                "\t\t\t  <td width=\"150\" height=\"150\" align=\"right\">\n" +
                "\t\t\t  \n" +
                "\t\t\t  \n" +
                "\t\t\t  \n" +
                "\t\t\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "\t\t\t\t\t  <tr>\n" +
                "\t\t\t\t\t\t<td width=\"100\">\n" +
                "\t\t\t\t\t\t\t<div style=\"float:left; cursor:pointer\" onclick=\"javascript:location.href='mycart.aspx'\"><img src=\"image/45.png\" width=\"37\" height=\"37\" /></div>\n" +
                "\t\t\t\t\t\t\t<div style=\"border-radius:20px; margin-left:-5px; margin-top:-5px; line-height:20px; color:#FFFFFF; background:#CC0000; width:20px; height:20px; font-size:12px; float:left;\" align=\"center\">0</div>\n" +
                "\t\t\t\t\t\t</td>\n" +
                "\t\t\t\t\t  </tr>\n" +
                "\t\t\t\t\t</table>\n" +
                "\t\t\t  </td>\n" +
                "\t\t\t</tr>\n" +
                "\t  </table>\n" +
                "    </td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td height=\"100\" align=\"center\">\n" +
                "\t\t<table width=\"1196\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "\t\t  <tr>\n" +
                "\t\t\t<td width=\"222\" height=\"50\" align=\"center\" bgcolor=\"#FF4C66\" style=\"cursor:pointer; color:#FFFFFF; font-size:20px;\">\n" +
                "<div id=\"content\">\n" +
                "\t<div class=\"main_nav hover\">\n" +
                "\t\t<ul>\n" +
                "\t\t\t<li>\n" +
                "\t\t\t\t<a href=\"#\" style=\"color:#FFFFFF\">\n" +
                "\t\t\t\t\t<div style=\"width:100%\" align=\"center\">\n" +
                "\t\t\t\t\t  <table border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "\t\t\t\t\t\t  <tr>\n" +
                "\t\t\t\t\t\t\t  <td style=\"padding-left:15px; font-size:20px;\">全部分类</td>\n" +
                "\t\t\t\t\t\t  </tr>\n" +
                "\t\t\t\t\t  </table>\n" +
                "\t\t\t\t\t</div>\n" +
                "\t\t\t\t</a>\n" +
                "\t\t\t\t<dl>\n" +
                "\t\t\t\t\t\t\t\t\t\n" +
                "\t\t\t\t\t  <dd><a href=\"product.aspx?class_big_id=357\">家用电器</a></dd>\n" +
                "\t\t\t\t\t\t\t\n" +
                "\t\t\t\t\t  <dd><a href=\"product.aspx?class_big_id=359\">家居百货</a></dd>\n" +
                "\t\t\t\t\t\t\t\n" +
                "\t\t\t\t\t  <dd><a href=\"product.aspx?class_big_id=362\">汽车用品</a></dd>\n" +
                "\t\t\t\t\t\t\t\n" +
                "\t\t\t\t\t  <dd><a href=\"product.aspx?class_big_id=364\">数码办公</a></dd>\n" +
                "\t\t\t\t\t\t\t\n" +
                "\t\t\t\t\t  <dd><a href=\"product.aspx?class_big_id=368\">户外运动</a></dd>\n" +
                "\t\t\t\t\t\t\t\n" +
                "\t\t\t\t\t  <dd><a href=\"product.aspx?class_big_id=371\">服装配饰</a></dd>\n" +
                "\t\t\t\t\t\t\t\n" +
                "\t\t\t\t\t  <dd><a href=\"product.aspx?class_big_id=373\">食品饮料</a></dd>\n" +
                "\t\t\t\t\t\t\t\n" +
                "\t\t\t\t\t  <dd><a href=\"product.aspx?class_big_id=380\">生活用品</a></dd>\n" +
                "\t\t\t\t\t\t\t\n" +
                "\t\t\t\t\t  <dd><a href=\"product.aspx?class_big_id=387\">字画工艺</a></dd>\n" +
                "\t\t\t\t\t\t\t\n" +
                "\t\t\t\t\t  <dd><a href=\"product.aspx?class_big_id=390\">双11</a></dd>\n" +
                "\t\t\t\t\t\t\t\n" +
                "\t\t\t\t</dl>\n" +
                "\t\t\t</li>\n" +
                "\t\t</ul>\n" +
                "\t</div>\n" +
                "</div>\n" +
                "<script type=\"text/javascript\" src=\"js/jquery-1.4.2.min.js\"></script>\n" +
                "<script type=\"text/javascript\">\n" +
                "\t$(\".hover ul li\").hover(function(){\n" +
                "\t\t$(this).children(\"dl\").slideDown(300)\n" +
                "\t}, function(){\n" +
                "\t\t$(this).children(\"dl\").slideUp(100)\n" +
                "\t});\n" +
                "</script>\t\t\t\n" +
                "\t\t\t</td>\n" +
                "\t\t\t<td width=\"50\" height=\"100\" align=\"center\">&nbsp;</td>\n" +
                "\t\t\t<td height=\"100\" align=\"center\"><a href=\"index.aspx\" style=\"color:#333333; font-size:20px;\">商城首页</a></td>\n" +
                "\t\t\t<td width=\"50\" height=\"100\" align=\"center\" style=\"color:#c1c1c1\">&nbsp;</td>\n" +
                "\t\t\t<td height=\"100\" align=\"center\"><a href=\"product.aspx\" style=\"color:#333333; font-size:20px;\">全部商品</a></td>\n" +
                "\t\t\t<!--<td width=\"50\" height=\"100\" align=\"center\" style=\"color:#c1c1c1\">&nbsp;</td>\n" +
                "\t\t\t<td height=\"100\" align=\"center\"><a href=\"product_t.aspx\" style=\"color:#333333; font-size:20px;\">推荐专区</a></td>-->\n" +
                "\t\t\t<td width=\"50\" height=\"100\" align=\"center\" style=\"color:#c1c1c1\">&nbsp;</td>\n" +
                "\t\t\t<td height=\"100\" align=\"center\"><a href=\"ghd.aspx\" style=\"color:#333333; font-size:20px;\">活动专区</a></td>\n" +
                "\t\t\t<td width=\"50\" height=\"100\" align=\"center\" style=\"color:#c1c1c1\">&nbsp;</td>\n" +
                "\t\t\t<td height=\"100\" align=\"center\"><a href=\"gpf.aspx\" style=\"color:#333333; font-size:20px;\">批发专区</a></td>\n" +
                "\t\t\t<td width=\"50\" height=\"100\" align=\"center\" style=\"color:#c1c1c1\">&nbsp;</td>\n" +
                "\t\t\t<td height=\"100\" align=\"center\"><a href=\"quanyi.aspx\" style=\"color:#333333; font-size:20px;\">权益专区</a></td>\n" +
                "\t\t\t<td width=\"50\" height=\"100\" align=\"center\" style=\"color:#c1c1c1\">&nbsp;</td>\n" +
                "\t\t\t<td height=\"100\" align=\"center\"><a href=\"news.aspx\" style=\"color:#333333; font-size:20px;\">商城快讯</a></td>\n" +
                "\t\t  </tr>\n" +
                "    </table>\n" +
                "\t</td>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "\n" +
                "<div style=\"width:100%\" align=\"center\">\n" +
                "  <table width=\"1200\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"margin-top:10px;\">\n" +
                "    <tr>\n" +
                "      <td><div style=\"line-height:25px; font-size:15px; color:#333333; float:left\">首页&nbsp;>&nbsp;</div>\n" +
                "        <div style=\"line-height:25px; font-size:15px; color:#333333; border:1px #e1e1e1 solid; padding-left:10px; padding-right:10px; float:left\">批发专区</div></td>\n" +
                "      <td>&nbsp;</td>\n" +
                "      <td align=\"right\" style=\"font-size:15px; color:#333333\">&nbsp;</td>\n" +
                "    </tr>\n" +
                "  </table>\n" +
                "  <table width=\"1200\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"margin-top:10px;\">\n" +
                "    <tr>\n" +
                "      <td valign=\"top\" style=\"border-top:#ffffff 1px solid;border-left:#ffffff 1px solid;\">\n" +
                "\n" +
                "\t\t<div onmousemove=\"this.style.border='1px solid #FF4C66';\" onmouseout=\"this.style.border='1px solid #F1F1F1';\" style=\" cursor:pointer; border:1px #F1F1F1 solid;float:left;position:relative;margin-right:10px;\" align=\"center\" onclick=\"javascript:location.href='gp_show.aspx?gp_id=184'\">\n" +
                "\t\t  \n" +
                "          <div style=\"position:absolute;bottom:80px;background-color:rgba(248,49,102,0.7);width:100%;line-height:35px;height:35px;color:#FFFFFF;font-size:12px;\" align=\"center\">\n" +
                "\t\t\t  <table width=\"95%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "\t\t\t\t  <tr>\n" +
                "\t\t\t\t\t<td height=\"20\"><img src=\"image/daoji.png\" height=\"20\" /></td>\n" +
                "\t\t\t\t\t<td height=\"20\" style=\"font-size:15px;\">\n" +
                "<span id=\"LeftTime1\"></span>\n" +
                "<script> \n" +
                "\tfunction checktime(i)\n" +
                "\t{\n" +
                "\t\tif(i<10)\n" +
                "\t\t{\n" +
                "\t\t\ti=\"0\"+i;\n" +
                "\t\t}\n" +
                "\t\telse{i=i;}\n" +
                "\t\treturn i;\n" +
                "\t}  \n" +
                "\tfunction freshTime1()\n" +
                "\t{\n" +
                "\t\tvar endtime=new Date('2018/11/28');\n" +
                "\t\tvar nowtime=new Date();\n" +
                "\t\tvar lefttime=parseInt(endtime.getTime()-nowtime.getTime());\n" +
                "\t\tvar dm=24*60*60*1000;  \n" +
                "\t\tvar d=parseInt(lefttime/dm);  \n" +
                "\t\tvar hm=60*60*1000;  \n" +
                "\t\tvar h=parseInt((lefttime/hm)%24);  \n" +
                "\t\tvar mm=60*1000;  \n" +
                "\t\tvar m=parseInt((lefttime/mm)%60);  \n" +
                "\t\tvar s=parseInt((lefttime/1000)%60);  \n" +
                "\t\tm=checktime(m);  \n" +
                "\t\ts=checktime(s);  \n" +
                "\t\tdocument.getElementById('LeftTime1').innerHTML=d+\"天\"+h+\"小时\"+m+\"分钟\"+s+\"秒\";  \n" +
                "\t\tif (lefttime<0)\n" +
                "\t\t{\n" +
                "\t\t\tdocument.getElementById('LeftTime1').innerHTML=\"商品出售已结束\";  \n" +
                "\t\t} \n" +
                "\t}  \n" +
                "\tfreshTime1();  \n" +
                "\tvar sh;  \n" +
                "\tsh=setInterval('freshTime1()',1000)  \n" +
                "</script> \n" +
                "\t\t\t\t\t</td>\n" +
                "\t\t\t\t  </tr>\n" +
                "\t\t\t\t</table>\n" +
                "\t\t  </div>\n" +
                "\t\t  \n" +
                "          <table width=\"230\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "            <tr>\n" +
                "              <td height=\"5\" colspan=\"4\"><img src=\"http://www.cnydvip.net/load/bz/2018112102469074.jpg\" style=\"width:214px; height:214px;\" border=\"0\"/>\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t<div style=\"position:absolute;top:10px;border-radius:50px;background-color:#999999;width:50px;line-height:50px;height:50px;color:#FFFFFF;font-size:12px; right:10px;\" align=\"center\">已售罄</div>\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "              <td height=\"35\" colspan=\"2\" align=\"left\" valign=\"bottom\" style=\"font-size:12px; padding-left:10px;\">和田碧玉手镯...</td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "              <td height=\"45\" colspan=\"2\" align=\"left\" style=\"font-size:20px; color:#FF4C66; padding-left:10px;\">1,000.00-5,000.00</td>\n" +
                "            </tr>\n" +
                "          </table>\n" +
                "        </div>\n" +
                "        \n" +
                "\t\t<div onmousemove=\"this.style.border='1px solid #FF4C66';\" onmouseout=\"this.style.border='1px solid #F1F1F1';\" style=\" cursor:pointer; border:1px #F1F1F1 solid;float:left;position:relative;margin-right:10px;\" align=\"center\" onclick=\"javascript:location.href='gp_show.aspx?gp_id=185'\">\n" +
                "\t\t  \n" +
                "          <div style=\"position:absolute;bottom:80px;background-color:rgba(248,49,102,0.7);width:100%;line-height:35px;height:35px;color:#FFFFFF;font-size:12px;\" align=\"center\">\n" +
                "\t\t\t  <table width=\"95%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "\t\t\t\t  <tr>\n" +
                "\t\t\t\t\t<td height=\"20\"><img src=\"image/daoji.png\" height=\"20\" /></td>\n" +
                "\t\t\t\t\t<td height=\"20\" style=\"font-size:15px;\">\n" +
                "<span id=\"LeftTime2\"></span>\n" +
                "<script> \n" +
                "\tfunction checktime(i)\n" +
                "\t{\n" +
                "\t\tif(i<10)\n" +
                "\t\t{\n" +
                "\t\t\ti=\"0\"+i;\n" +
                "\t\t}\n" +
                "\t\telse{i=i;}\n" +
                "\t\treturn i;\n" +
                "\t}  \n" +
                "\tfunction freshTime2()\n" +
                "\t{\n" +
                "\t\tvar endtime=new Date('2018/11/28');\n" +
                "\t\tvar nowtime=new Date();\n" +
                "\t\tvar lefttime=parseInt(endtime.getTime()-nowtime.getTime());\n" +
                "\t\tvar dm=24*60*60*1000;  \n" +
                "\t\tvar d=parseInt(lefttime/dm);  \n" +
                "\t\tvar hm=60*60*1000;  \n" +
                "\t\tvar h=parseInt((lefttime/hm)%24);  \n" +
                "\t\tvar mm=60*1000;  \n" +
                "\t\tvar m=parseInt((lefttime/mm)%60);  \n" +
                "\t\tvar s=parseInt((lefttime/1000)%60);  \n" +
                "\t\tm=checktime(m);  \n" +
                "\t\ts=checktime(s);  \n" +
                "\t\tdocument.getElementById('LeftTime2').innerHTML=d+\"天\"+h+\"小时\"+m+\"分钟\"+s+\"秒\";  \n" +
                "\t\tif (lefttime<0)\n" +
                "\t\t{\n" +
                "\t\t\tdocument.getElementById('LeftTime2').innerHTML=\"商品出售已结束\";  \n" +
                "\t\t} \n" +
                "\t}  \n" +
                "\tfreshTime2();  \n" +
                "\tvar sh;  \n" +
                "\tsh=setInterval('freshTime2()',1000)  \n" +
                "</script> \n" +
                "\t\t\t\t\t</td>\n" +
                "\t\t\t\t  </tr>\n" +
                "\t\t\t\t</table>\n" +
                "\t\t  </div>\n" +
                "\t\t  \n" +
                "          <table width=\"230\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "            <tr>\n" +
                "              <td height=\"5\" colspan=\"4\"><img src=\"http://www.cnydvip.net/load/bz/2018112102723931.jpg\" style=\"width:214px; height:214px;\" border=\"0\"/>\n" +
                "\t\t\n" +
                "\t\t\t\n" +
                "\t\t\t\t<div style=\"position:absolute;top:10px;border-radius:50px;background-color:#999999;width:50px;line-height:50px;height:50px;color:#FFFFFF;font-size:12px; right:10px;\" align=\"center\">已售罄</div>\n" +
                "\t\t\t\n" +
                "\t\t\t</td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "              <td height=\"35\" colspan=\"2\" align=\"left\" valign=\"bottom\" style=\"font-size:12px; padding-left:10px;\">新疆和田青玉墨玉印章...</td>\n" +
                "            </tr>\n" +
                "            <tr>\n" +
                "              <td height=\"45\" colspan=\"2\" align=\"left\" style=\"font-size:20px; color:#FF4C66; padding-left:10px;\">300.00-1,500.00</td>\n" +
                "            </tr>\n" +
                "          </table>\n" +
                "        </div>\n" +
                "        \n" +
                "      </td>\n" +
                "    </tr>\n" +
                "  </table>\n" +
                "</div>\n" +
                "<div style=\"height:20px;\"></div>\n" +
                "\n" +
                "  <table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" style=\"margin-top:20px;\">\n" +
                "    <tr>\n" +
                "      <td height=\"70\" align=\"center\" bgcolor=\"#F4F4F4\"><table width=\"1196\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "          <tr>\n" +
                "            <td width=\"25%\" height=\"141\">\n" +
                "\t\t\t\t<div style=\"border:3px #DE1B1B solid;border-radius:50px; color:#DE1B1B; font-size:35px; line-height:50px; width:50px; height:50px; float:left\" align=\"center\">多</div>\n" +
                "\t\t\t\t<div style=\"color:#333333; font-size:20px; line-height:50px;height:50px; margin-left:10px; float:left\" align=\"center\">品类齐全，轻松购物</div>\n" +
                "\t\t\t\t<div style=\"clear:both\"></div>\n" +
                "\t\t\t</td>\n" +
                "            <td width=\"25%\" height=\"141\">\n" +
                "\t\t\t\t<div style=\"border:3px #DE1B1B solid;border-radius:50px; color:#DE1B1B; font-size:35px; line-height:50px; width:50px; height:50px; float:left\" align=\"center\">快</div>\n" +
                "\t\t\t\t<div style=\"color:#333333; font-size:20px; line-height:50px;height:50px; margin-left:10px; float:left\" align=\"center\">多仓直发，极速配送</div>\n" +
                "\t\t\t\t<div style=\"clear:both\"></div>\n" +
                "\t\t\t</td>\n" +
                "            <td width=\"25%\" height=\"141\">\n" +
                "\t\t\t\t<div style=\"border:3px #DE1B1B solid;border-radius:50px; color:#DE1B1B; font-size:35px; line-height:50px; width:50px; height:50px; float:left\" align=\"center\">好</div>\n" +
                "\t\t\t\t<div style=\"color:#333333; font-size:20px; line-height:50px;height:50px; margin-left:10px; float:left\" align=\"center\">正品行货，精致服务</div>\n" +
                "\t\t\t\t<div style=\"clear:both\"></div>\n" +
                "\t\t\t</td>\n" +
                "            <td width=\"25%\" height=\"141\">\n" +
                "\t\t\t\t<div style=\"border:3px #DE1B1B solid;border-radius:50px; color:#DE1B1B; font-size:35px; line-height:50px; width:50px; height:50px; float:left\" align=\"center\">省</div>\n" +
                "\t\t\t\t<div style=\"color:#333333; font-size:20px; line-height:50px;height:50px; margin-left:10px; float:left\" align=\"center\">天天低价，畅选无忧</div>\n" +
                "\t\t\t\t<div style=\"clear:both\"></div>\n" +
                "\t\t\t</td>\n" +
                "          </tr>\n" +
                "        </table></td>\n" +
                "    </tr>\n" +
                "  </table>\n" +
                "  \n" +
                "  \n" +
                "  \n" +
                "  \n" +
                "  <table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" style=\"border-top:1px #CCCCCC solid\">\n" +
                "  <tr>\n" +
                "    <td bgcolor=\"#414141\" align=\"center\">\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t<table width=\"1196\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "      <tr>\n" +
                "\t  \t<td align=\"center\">\n" +
                "\n" +
                "</td>\n" +
                "        <td width=\"278\" align=\"center\">&nbsp;</td>\n" +
                "      </tr>\n" +
                "    </table>\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t\n" +
                "\t</td>\n" +
                "  </tr>\n" +
                "  <tr>\n" +
                "    <td bgcolor=\"#414141\" align=\"center\" style=\"border-top:0px #CCCCCC solid;padding-top:10px; padding-bottom:10px;\">\n" +
                "\t  <table width=\"1196\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "      <tr>\n" +
                "        <td width=\"65\" height=\"40\" valign=\"top\" style=\"color:#C6C6C6; font-size:12px;\">\n" +
                "\t\t\t友情链接：</td>\n" +
                "        <td valign=\"top\" style=\"color:#C6C6C6; font-size:12px;\"></td>\n" +
                "      </tr>\n" +
                "    </table>\n" +
                "\t\n" +
                "\t</td>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n" +
                "  <tr>\n" +
                "    <td align=\"center\" bgcolor=\"#282828\" style=\"font-size:12px; color:#C6C6C6; padding-top:20px; padding-bottom:20px;\">Copyright &#169; 2018  玉都商城</td>\n" +
                "  </tr>\n" +
                "</table>\n" +
                "\n" +
                "\n" +
                "<div style=\"position:fixed; right:20px; bottom:50px; width:30px; z-index:100\">\n" +
                "\t<a href=\"mycart.aspx\"><img src=\"image/11.png\" border=\"0\"/></a>\n" +
                "\t<a href=\"#\"><img src=\"image/12.png\" border=\"0\"/></a>\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>\n";

        String[] arr = handleHtml(html);
        System.out.println(Arrays.toString(arr));
        String[] str = Arrays.stream(arr)
                .reduce("0-0", (a, b) -> Integer.parseInt(a.split("-")[1]) > Integer.parseInt(b.split("-")[1]) ? a : b)
                .split("-");
        System.out.println(Arrays.toString(str));
    }

    private static String[] handleHtml(String html) {
        String[] parts = html.split("gp_show.aspx\\?");
        return Arrays.stream(parts)
                .filter(subPart -> subPart.contains("gp_id="))
                .map(subPart -> subPart.split("\\.00</td>")[0])
                .map(subPart -> between(subPart, "gp_id=", "'")[0] + subPart.substring(subPart.indexOf(".00-") + 3).replace(",", ""))
                .toArray(String[]::new);
    }

    private static String[] between(String value, String start, String end) {
        String[] parts = value.split(end);
        return Arrays.stream(parts)
                .filter(subPart -> subPart.contains(start))
                .map(subPart -> subPart.substring(subPart.indexOf(start) + start.length()))
                .toArray(String[]::new);
    }
}
