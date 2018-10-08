package com.youpu.test;
import com.youpu.DowloadPaperApplication;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import javafx.application.Application;
import net.sf.json.JSONObject;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.*;
import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DowloadPaperApplication.class)
public class TestFreemarker {
    @Autowired


    @Before
    public void before() throws Exception{

    }
    @After
    public void after() throws Exception {
    }
    @Test
    public void testJson(){
        //123
        String json="{\n" +
                "  \"paperType\": 1,\n" +
                "  \"recode\": 0,\n" +
                "  \"answerTokinaga\": 90,\n" +
                "  \"subject\": 2,\n" +
                "  \"score\": 70,\n" +
                "  \"difficulty\": \"0.27\",\n" +
                "  \"phaseId\": 2,\n" +
                "  \"materialid\": 15,\n" +
                "  \"testedNum\": 0,\n" +
                "  \"choosenum\": 10,\n" +
                "  \"answernum\": 12,\n" +
                "  \"allnum\": 22,\n" +
                "  \"source\": \"物理组\",\n" +
                "  \"testedPeople\": 0,\n" +
                "  \"name\": \"2018年内蒙古呼和浩特市中考物理试卷\",\n" +
                "  \"grade\": 109,\n" +
                "  \"resultlist\": [\n" +
                "    {\n" +
                "      \"abilityNameList\": [\n" +
                "        \"理解能力\"\n" +
                "      ],\n" +
                "      \"text\": \"<P>（2018•呼和浩特）如图所示的四种现象中，属于光的反射现象的是（　　）<\\/P>\",\n" +
                "      \"answers\": [\n" +
                "        {\n" +
                "          \"id\": 2203917,\n" +
                "          \"rightanswer\": 1,\n" +
                "          \"answertext\": \"<P><img src=\\\"http://img2.51youpu.com/Public2/pic/73e11f340bc04241938be25e666286ea.png\\\"><\\/P><P>山在水中的倒影<\\/P>\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 2203918,\n" +
                "          \"rightanswer\": 0,\n" +
                "          \"answertext\": \"<P><img src=\\\"http://img2.51youpu.com/Public2/pic/954df5768e5d41b38308694170132837.png\\\"><\\/P><P>影子的形成<\\/P>\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 2203919,\n" +
                "          \"rightanswer\": 0,\n" +
                "          \"answertext\": \"<P><img src=\\\"http://img2.51youpu.com/Public2/pic/af5b928d7cde4662b55d7d780e2122ee.png\\\"><\\/P><P>雨后的彩虹<\\/P>\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 2203920,\n" +
                "          \"rightanswer\": 0,\n" +
                "          \"answertext\": \"<P><img src=\\\"http://img2.51youpu.com/Public2/pic/5c770ba662994bb28563db4d7271bbbc.png\\\"><\\/P><P>钢勺好像在水面处折断<\\/P>\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"score\": \"2\",\n" +
                "      \"spenttime\": 100,\n" +
                "      \"qtype\": 1,\n" +
                "      \"difficulty\": \"0.10\",\n" +
                "      \"thoughtNameList\": [],\n" +
                "      \"analysis\": \"<P><FONT color=\\\"0000FF\\\"><\\/FONT>（1）光在同种、均匀、透明介质中沿直线传播，产生的现象有小孔成像、激光准直、影子的形成、日食和月食等；<\\/P><P>（2）光线传播到两种介质的表面上时会发生光的反射现象，例如水面上出现岸上物体的倒影、平面镜成像、玻璃等光滑物体反光都是光的反射形成的；<\\/P><P>（3）光线在同种不均匀介质中传播或者从一种介质进入另一种介质时，就会出现光的折射现象，例如水池底变浅、水中筷子变弯、海市蜃楼、凸透镜成像等都是光的折射形成的。<\\/P>\",\n" +
                "      \"pointNameList\": [\n" +
                "        \"光的反射\"\n" +
                "      ],\n" +
                "      \"id\": 759640,\n" +
                "      \"qexplain\": \"<P><FONT color=\\\"0000FF\\\"><\\/FONT>解：<\\/P><P>A、山在水中的倒影，属于平面镜成像，是由于光的反射形成的，故A正确。<\\/P><P>B、影子的形成说明光是沿直线传播的，故B错误；<\\/P><P>C、雨过天晴时，常在天空出现彩虹，这是太阳光通过悬浮在空气中细小的水珠折射而成的，白光经水珠折射以后，分成各种彩色光，这种现象叫做光的色散现象，所以说雨后的天空出现彩虹是由光的色散形成的。故C错误；<\\/P><P>D、从水中钢勺上反射的光从水斜射入空气中时，发生折射，折射光线远离法线，当人逆着折射光线的方向看时，看到的是钢勺的虚像，比实际位置偏高，所以感觉钢勺被折断了，故D错误；<\\/P><P>故选：A。<\\/P>\",\n" +
                "      \"num\": \"1\",\n" +
                "      \"questionNum\": 1,\n" +
                "      \"source\": \"\",\n" +
                "      \"serialNum\": null,\n" +
                "      \"explain\": \"\",\n" +
                "      \"comments\": \"<P><FONT color=\\\"0000FF\\\"><\\/FONT>此题通过几个日常生活中的现象考查了对光的折射、光的直线传播、光的反射的理解，在学习过程中要善于利用所学知识解释有关现象。<\\/P>\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"abilityNameList\": [\n" +
                "        \"理解能力\"\n" +
                "      ],\n" +
                "      \"text\": \"<P>（2018•呼和浩特）在试管中放少量碘，塞紧盖子放入热水中。当固态碘变为紫色的碘蒸气并充满试管后，将试管从热水中取出，放入凉水中，碘蒸气又会变为固态碘附着在试管内壁上，关于物质碘的物态变化过程，下列说法正确的是（　　）<\\/P>\",\n" +
                "      \"answers\": [\n" +
                "        {\n" +
                "          \"id\": 2203921,\n" +
                "          \"rightanswer\": 0,\n" +
                "          \"answertext\": \"<P>先放热升华后吸热凝华<\\/P>\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 2203922,\n" +
                "          \"rightanswer\": 1,\n" +
                "          \"answertext\": \"<P>先吸热升华后放热凝华<\\/P>\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 2203923,\n" +
                "          \"rightanswer\": 0,\n" +
                "          \"answertext\": \"<P>先放热熔化后吸热凝固<\\/P>\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 2203924,\n" +
                "          \"rightanswer\": 0,\n" +
                "          \"answertext\": \"<P>先吸热熔化后放热凝固<\\/P>\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"score\": \"2\",\n" +
                "      \"spenttime\": 100,\n" +
                "      \"qtype\": 1,\n" +
                "      \"difficulty\": \"0.12\",\n" +
                "      \"thoughtNameList\": [],\n" +
                "      \"analysis\": \"<P><FONT color=\\\"0000FF\\\"><\\/FONT>物体由固态直接变为气态叫升华，升华吸热；物体由气态直接变为固态叫凝华，凝华放热。<\\/P>\",\n" +
                "      \"pointNameList\": [\n" +
                "        \"升华和凝华的定义和特点\"\n" +
                "      ],\n" +
                "      \"id\": 759641,\n" +
                "      \"qexplain\": \"<P><FONT color=\\\"0000FF\\\"><\\/FONT>解：碘由固态变为碘蒸气，是升华现象，需要吸收热量；碘蒸气遇到较冷的玻璃板会放出热量直接变成固态的碘，这是凝华现象，故B正确。<\\/P><P>故选：B。<\\/P>\",\n" +
                "      \"num\": \"2\",\n" +
                "      \"questionNum\": 2,\n" +
                "      \"source\": \"\",\n" +
                "      \"serialNum\": null,\n" +
                "      \"explain\": \"\",\n" +
                "      \"comments\": \"<P><FONT color=\\\"0000FF\\\"><\\/FONT>分析生活中的热现象属于哪种物态变化，关键要看清物态变化前后，物质各处于什么状态；另外对六种物态变化的吸热和放热情况也要有清晰的认识。<\\/P>\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"abilityNameList\": [\n" +
                "        \"理解能力\"\n" +
                "      ],\n" +
                "      \"text\": \"<P>（2018•呼和浩特）如图所示，关于电磁现象，下列说法正确的是（　　）<\\/P>\",\n" +
                "      \"answers\": [\n" +
                "        {\n" +
                "          \"id\": 2203925,\n" +
                "          \"rightanswer\": 0,\n" +
                "          \"answertext\": \"<P><img src=\\\"http://img2.51youpu.com/Public2/pic/143deebaa2fa49f9bf2cafd16a445e94.png\\\"><\\/P><P>如图，把小磁针放在地理赤道附近，小磁针静止时磁针N极指向地理南极附近<\\/P>\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 2203926,\n" +
                "          \"rightanswer\": 0,\n" +
                "          \"answertext\": \"<P><img src=\\\"http://img2.51youpu.com/Public2/pic/dff038b77ada47b18e6c342c54b018de.png\\\"><\\/P><P>如图，通电线圈在磁场作用下转动，机械能转化为电能<\\/P>\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 2203927,\n" +
                "          \"rightanswer\": 0,\n" +
                "          \"answertext\": \"<P><img src=\\\"http://img2.51youpu.com/Public2/pic/69f7d39b819f45c38abdd06a243c3749.png\\\"><\\/P><P>如图，利用“电生磁”将铁钉磁化，利用安培右手定则可判定铁钉上端为N极<\\/P>\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 2203928,\n" +
                "          \"rightanswer\": 1,\n" +
                "          \"answertext\": \"<P><img src=\\\"http://img2.51youpu.com/Public2/pic/f87eb1105f34477786a81045ca9498fb.png\\\"><\\/P><P>如图，当用力让线圈发生转动时，电流表就有电流通过，工作原理是法拉第电磁感应现象<\\/P>\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"score\": \"2\",\n" +
                "      \"spenttime\": 100,\n" +
                "      \"qtype\": 1,\n" +
                "      \"difficulty\": \"0.15\",\n" +
                "      \"thoughtNameList\": [],\n" +
                "      \"analysis\": \"<P><FONT color=\\\"0000FF\\\"><\\/FONT>（1）地球的周围存在着磁场，地磁北极在地理的南极附近，地磁南极在地理北极附近，这就是地磁场；<\\/P><P>（2）通电线圈在磁场力的作用下转动，消耗电能得到机械能；<\\/P><P>（3）电磁铁是利用电流的磁效应，安培定则：用右手握住螺线管，四指指向电流的方向，大拇指所指的就是N极；<\\/P><P>（4）发电机是根据电磁感应现象制成的。<\\/P>\",\n" +
                "      \"pointNameList\": [\n" +
                "        \"地磁场\"\n" +
                "      ],\n" +
                "      \"id\": 759642,\n" +
                "      \"qexplain\": \"<P><FONT color=\\\"0000FF\\\"><\\/FONT>解：A、在地理赤道附近，悬挂起来的小磁针静止时，小磁针的N极指向地理的北极附近，故A错误；<\\/P><P>B、如果通电线圈在磁场力的作用下转动，将电能转化为线圈的机械能，故B错误；<\\/P><P>C、利用“电生磁”将铁钉磁化，据安培定则可知，该螺线管的下方是N极，上方是S极，故C错误。<\\/P><P>D、当用力让线圈发生转动时，电流表就有电流通过是发电机，发电机的工作原理是法拉第发现的电磁感应现象，故D正确。<\\/P><P>故选：D。<\\/P>\",\n" +
                "      \"num\": \"3\",\n" +
                "      \"questionNum\": 3,\n" +
                "      \"source\": \"\",\n" +
                "      \"serialNum\": null,\n" +
                "      \"explain\": \"\",\n" +
                "      \"comments\": \"<P><FONT color=\\\"0000FF\\\"><\\/FONT>此题考查地磁场，电磁场，发电机和电动机原理，是一道综合题。<\\/P>\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"abilityNameList\": [\n" +
                "        \"理解能力\"\n" +
                "      ],\n" +
                "      \"text\": \"<P>（2018•呼和浩特）下列估测数据中，最不符合实际的是（　　）<\\/P>\",\n" +
                "      \"answers\": [\n" +
                "        {\n" +
                "          \"id\": 2203929,\n" +
                "          \"rightanswer\": 0,\n" +
                "          \"answertext\": \"<P>人散步时的速度约为lm/s<\\/P>\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 2203930,\n" +
                "          \"rightanswer\": 0,\n" +
                "          \"answertext\": \"<P>一个普通成年人身体的体积约为60dm<SUP>3<\\/SUP><\\/P>\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 2203931,\n" +
                "          \"rightanswer\": 0,\n" +
                "          \"answertext\": \"<P>我国正在研制的新一代“蛟龙号”探测器，目标探测深度是1.1×10<SUP>4<\\/SUP>m<\\/P>\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 2203932,\n" +
                "          \"rightanswer\": 1,\n" +
                "          \"answertext\": \"<P>一本人教版初三物理教科书的重力约为20N<\\/P>\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"score\": \"2\",\n" +
                "      \"spenttime\": 100,\n" +
                "      \"qtype\": 1,\n" +
                "      \"difficulty\": \"0.18\",\n" +
                "      \"thoughtNameList\": [],\n" +
                "      \"analysis\": \"<P><FONT color=\\\"0000FF\\\"><\\/FONT>首先要对选项中涉及的几种物理量有个初步的了解，对于选项中的单位，可根据需要进行相应的换算或转换，排除与生活实际相差较远的选项，找出符合生活实际的答案。<\\/P>\",\n" +
                "      \"pointNameList\": [\n" +
                "        \"长度的估测\"\n" +
                "      ],\n" +
                "      \"id\": 759643,\n" +
                "      \"qexplain\": \"<P><FONT color=\\\"0000FF\\\"><\\/FONT>解：<\\/P><P>A、人正常步行的速度约为1.1m/s，人散步时的速度略小，在1m/s左右。此选项符合实际。<\\/P><P>B、一个普通成年人的质量为60kg，密度约为1.0×10<SUP>3<\\/SUP>kg/m<SUP>3<\\/SUP>，根据ρ=<img src=\\\"http://img2.51youpu.com/Public2/pic/7b21a1e90f174d0783d52c4eaa102694.png\\\">可得，体积约为V=<img src=\\\"http://img2.51youpu.com/Public2/pic/48af587b3f894a68bb4266e87fc83fed.png\\\">=<img src=\\\"http://img2.51youpu.com/Public2/pic/d3e9a12a65d240ea890b403e402c4e7e.png\\\">=0.06m<SUP>3<\\/SUP>=60dm<SUP>3<\\/SUP>，此选项符合实际。<\\/P><P>C、我国正在研制的新一代“蛟龙号”探测器，目标探测深度是1.1×10<SUP>4<\\/SUP>m．此选项符合实际。<\\/P><P>D、物理课本的质量在300g=0.3kg左右，受到的重力在G=mg=0.3kg×10N/kg=3N左右。此选项不符合实际。<\\/P><P>故选：D。<\\/P>\",\n" +
                "      \"num\": \"4\",\n" +
                "      \"questionNum\": 4,\n" +
                "      \"source\": \"\",\n" +
                "      \"serialNum\": null,\n" +
                "      \"explain\": \"\",\n" +
                "      \"comments\": \"<P><FONT color=\\\"0000FF\\\"><\\/FONT>此题考查对生活中常见物理量的估测，结合对生活中物理量的了解和对物理单位的认识，找出符合实际的选项即可。<\\/P>\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"abilityNameList\": [\n" +
                "        \"理解能力\"\n" +
                "      ],\n" +
                "      \"text\": \"<P>（2018•呼和浩特）如图所示，一铁块吸附在竖直放置的足够长的磁性平板上，在竖直向上拉力F的作用下，铁块竖直向上做匀速直线运动。下列说法正确的是（　　）<\\/P><P><img src=\\\"http://img2.51youpu.com/Public2/pic/28818bacb0994c4cb872de34acdd953f.png\\\"><\\/P>\",\n" +
                "      \"answers\": [\n" +
                "        {\n" +
                "          \"id\": 2203933,\n" +
                "          \"rightanswer\": 0,\n" +
                "          \"answertext\": \"<P>磁性平板对铁块的吸引力和铁块对磁性平板的吸引力是一对平衡力<\\/P>\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 2203934,\n" +
                "          \"rightanswer\": 0,\n" +
                "          \"answertext\": \"<P>拉力和重力是一对相互作用力<\\/P>\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 2203935,\n" +
                "          \"rightanswer\": 1,\n" +
                "          \"answertext\": \"<P>若一切力突然消失，铁块会一直向上做匀速直线运动<\\/P>\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 2203936,\n" +
                "          \"rightanswer\": 0,\n" +
                "          \"answertext\": \"<P>铁块受到的滑动摩擦力方向竖直向上<\\/P>\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"score\": \"2\",\n" +
                "      \"spenttime\": 100,\n" +
                "      \"qtype\": 1,\n" +
                "      \"difficulty\": \"0.20\",\n" +
                "      \"thoughtNameList\": [],\n" +
                "      \"analysis\": \"<P><FONT color=\\\"0000FF\\\"><\\/FONT>（1）平衡力的条件：大小相等、方向相反、作用在同一个物体上，作用在同一条直线上。<\\/P><P>（2）相互作用力的条件：大小相等、方向相反、作用在两个物体上，作用在同一条直线上。<\\/P><P>（3）根据牛顿定律进行分析，即物体在不受任何外力时，总保持静止状态或匀速直线运动状态。<\\/P><P>（4）铁块受到的滑动摩擦力方向竖直向上。<\\/P>\",\n" +
                "      \"pointNameList\": [\n" +
                "        \"平衡力和相互作用力的区分\"\n" +
                "      ],\n" +
                "      \"id\": 759644,\n" +
                "      \"qexplain\": \"<P><FONT color=\\\"0000FF\\\"><\\/FONT>解：A、磁性平板对铁块的吸引力和铁块对磁性平板的吸引力是分别作用在不同物体上的两个力，所以不是一对平衡力。故A错误；<\\/P><P>B、拉力和重力是作用在同一个物体上的两个力，所以不是一对相互作用力。故B错误；<\\/P><P>C、根据牛顿第一定律可知，物体不受外力作用时，原来静止的物体将永远保持静止状态，原来运动的物体将永远做匀速直线运动，速度的大小和方向都不改变；铁块原来是向上运动的，当一切外力突然消失，铁块仍然保持原来的运动状态，所以铁块将一直向上做匀速直线运动，故C正确；<\\/P><P>D、铁块竖直向上运动，所以受到的滑动摩擦力方向竖直向下。故D错误。<\\/P><P>故选：C。<\\/P>\",\n" +
                "      \"num\": \"5\",\n" +
                "      \"questionNum\": 5,\n" +
                "      \"source\": \"\",\n" +
                "      \"serialNum\": null,\n" +
                "      \"explain\": \"\",\n" +
                "      \"comments\": \"<P><FONT color=\\\"0000FF\\\"><\\/FONT>此题考查了对物体的受力分析及平衡力与相互作用力的区别，同时考查牛顿第一定律和摩擦力的方向，关键是正确理解平衡力和相互作用力的区别：平衡力是作用在同一物体上的两个力；相互作用力是作用在两个物体上的力。<\\/P>\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"abilityNameList\": [\n" +
                "        \"理解能力\"\n" +
                "      ],\n" +
                "      \"text\": \"<P>（2018•呼和浩特）关于电学知识，下列法正确的（　　）<\\/P>\",\n" +
                "      \"answers\": [\n" +
                "        {\n" +
                "          \"id\": 2203937,\n" +
                "          \"rightanswer\": 0,\n" +
                "          \"answertext\": \"<P><img src=\\\"http://img2.51youpu.com/Public2/pic/7ef14dcc1f164a58a3f901b41a3560f2.png\\\"><\\/P><P>如图，表盘上的“3000r/kW•h”表示电能表转盘转过3000圈，消耗电能3600kW<\\/P>\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 2203938,\n" +
                "          \"rightanswer\": 1,\n" +
                "          \"answertext\": \"<P><img src=\\\"http://img2.51youpu.com/Public2/pic/7d9851551ecd45d3a2a862a8e3b21b8d.png\\\"><\\/P><P>如图，在家庭电路中，开关应接在火线和用电器之间<\\/P>\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 2203939,\n" +
                "          \"rightanswer\": 0,\n" +
                "          \"answertext\": \"<P><img src=\\\"http://img2.51youpu.com/Public2/pic/571963980a77430f93583bd70aeb6578.png\\\"><\\/P><P>如图，在“伏安法测小灯泡电阻”的实验中，为了减少误差，应调节滑动变阻器在电路中的阻值，多次测量求平均值<\\/P>\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 2203940,\n" +
                "          \"rightanswer\": 0,\n" +
                "          \"answertext\": \"<P><img src=\\\"http://img2.51youpu.com/Public2/pic/1348ee2133a149c08b2e0daeaa1e22d0.png\\\"><\\/P><P>如图，实验表明：在电流相同、通电时间相同的情况下，电阻越小，这个电阻产生的热量越多<\\/P>\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"score\": \"2\",\n" +
                "      \"spenttime\": 100,\n" +
                "      \"qtype\": 1,\n" +
                "      \"difficulty\": \"0.22\",\n" +
                "      \"thoughtNameList\": [],\n" +
                "      \"analysis\": \"<P><FONT color=\\\"0000FF\\\"><\\/FONT>（1）电能表是测量电路消耗电能（电功）的仪表，其中“3000r/kW•h”表示每消耗1kW•h的电能，电能表的转盘转3000转；<\\/P><P>（2）在家庭电路中，为了有效的控制用电器，需要将开关和用电器串联，并且开关要接在火线和用电器之间，这样断开开关时，用电器上没有电，便于维修或换灯泡；<\\/P><P>（3）灯丝电阻随温度的升高而增大；<\\/P><P>（4）根据焦耳定律Q=I<SUP>2<\\/SUP>Rt分析判断。<\\/P>\",\n" +
                "      \"pointNameList\": [\n" +
                "        \"滑动变阻器的使用\"\n" +
                "      ],\n" +
                "      \"id\": 759645,\n" +
                "      \"qexplain\": \"<P><FONT color=\\\"0000FF\\\"><\\/FONT>解：<\\/P><P>A、“3000r/kW•h”表示电能表的转盘转3000转，消耗电能1kW•h，故A错；<\\/P><P>B、在家庭电路中，开关要接在火线和灯之间，这样断开开关时，灯没有电，便于维修或换灯泡，故B正确；<\\/P><P>C、由于灯丝电阻随温度的升高而增大，在“伏安法测小灯泡电阻”的验中，调节滑动变阻器在电路中的阻值，多次测量求平均值无意义，故C错；<\\/P><P>D、由Q=I<SUP>2<\\/SUP>Rt可知在电流相同、通电时间相同的情况下，电阻越大，这个电阻产生的热量越多，故D错。<\\/P><P>故选：B。<\\/P>\",\n" +
                "      \"num\": \"6\",\n" +
                "      \"questionNum\": 6,\n" +
                "      \"source\": \"\",\n" +
                "      \"serialNum\": null,\n" +
                "      \"explain\": \"\",\n" +
                "      \"comments\": \"<P><FONT color=\\\"0000FF\\\"><\\/FONT>本题为电学综合题，考查了电能表参数的理解、开关的连接方法、灯丝电阻与温度的关系、焦耳定律，知识点较多，要求认真审题，易错题！<\\/P>\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"abilityNameList\": [\n" +
                "        \"理解能力\"\n" +
                "      ],\n" +
                "      \"text\": \"<P>（2018•呼和浩特）如图所示是小刚在中考体育测试中投掷铅球的过程示意图，铅球在b点离手，c点是铅球运动的最高点，d点是铅球运动的最低点，整个过程中，若不计空气阻力，下列说法错误的是（　　）<\\/P><P><img src=\\\"http://img2.51youpu.com/Public2/pic/2019ae35d56a47a9ba579f73892584e8.png\\\"><\\/P>\",\n" +
                "      \"answers\": [\n" +
                "        {\n" +
                "          \"id\": 2203941,\n" +
                "          \"rightanswer\": 0,\n" +
                "          \"answertext\": \"<P>在a到d的过程中，铅球相对于地面是运动的<\\/P>\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 2203942,\n" +
                "          \"rightanswer\": 1,\n" +
                "          \"answertext\": \"<P>在b到d的过程中，铅球的机械能先增加后减少<\\/P>\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 2203943,\n" +
                "          \"rightanswer\": 0,\n" +
                "          \"answertext\": \"<P>在c到d的过程中，铅球的重力势能转化为动能<\\/P>\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 2203944,\n" +
                "          \"rightanswer\": 0,\n" +
                "          \"answertext\": \"<P>在a到b的过程中，小刚对铅球做了功<\\/P>\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"score\": \"2\",\n" +
                "      \"spenttime\": 100,\n" +
                "      \"qtype\": 1,\n" +
                "      \"difficulty\": \"0.25\",\n" +
                "      \"thoughtNameList\": [],\n" +
                "      \"analysis\": \"<P><FONT color=\\\"0000FF\\\"><\\/FONT>（1）研究物体的运动情况时，首先要选取一个物体作为标准，这个被选作标准的物体叫做参照物。研究对象的运动情况是怎样的，就看它与参照物的相对位置是否变化；<\\/P><P>（2）（3）影响动能的影响因素是物体的质量和物体运动的速度，影响重力势能的因素是物体的质量和物体的高度，其中动能和势能统称为机械能；<\\/P><P>（4）此题要依据做功的两个条件（一是物体要受力的作用，二是物体要在力的方向上通过一定的距离），看在不同阶段是否具备这两个条件，若具备就做功，否则不做功。<\\/P>\",\n" +
                "      \"pointNameList\": [\n" +
                "        \"运动和静止的相对性\"\n" +
                "      ],\n" +
                "      \"id\": 759646,\n" +
                "      \"qexplain\": \"<P><FONT color=\\\"0000FF\\\"><\\/FONT>解：A、在a到d的过程中，铅球相对于地面有位置的变化，铅球是运动的，故A正确；<\\/P><P>B、在b到d的过程中，由于不计空气阻力，所以铅球的机械能不变，故B错误；<\\/P><P>C、在c到d的过程中，铅球的质量不变，高度减小，速度增大，故重力势能减小，动能增大，铅球的重力势能转化为动能，故C正确；<\\/P><P>D、在a到b的过程中，运动员对铅球有一个推力的作用且铅球在推力作用下移动了一段距离，所以在这个阶段，运动员对铅球做了功；铅球离开手，由于惯性继续运动，所以手就不做功了，故D正确；<\\/P><P>故选：B。<\\/P>\",\n" +
                "      \"num\": \"7\",\n" +
                "      \"questionNum\": 7,\n" +
                "      \"source\": \"\",\n" +
                "      \"serialNum\": null,\n" +
                "      \"explain\": \"\",\n" +
                "      \"comments\": \"<P><FONT color=\\\"0000FF\\\"><\\/FONT>该题考查了是否做功的判断、运动与静止的相对性、机械能的变化、重力势能大小影响因素和运动状态改变的理解，是一道综合题。<\\/P>\"\n" +
                "    },\n" +

                "    {\n" +
                "      \"abilityNameList\": [\n" +
                "        \"理解能力\",\n" +
                "        \"实验能力\"\n" +
                "      ],\n" +
                "      \"text\": \"<P>（2018•呼和浩特）小涵同学利用如图所示的器材探究“液体内部压强的特点”<\\/P><P><img src=\\\"http://img2.51youpu.com/Public2/pic/8ee07208df934021a9e8533ac056cb01.png\\\"><\\/P><P>（1）压强计<U>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<\\/U>（选填“属于”或“不属于”）连通器；<\\/P><P>（2）当压强计的金属盒在空气中时，U形管两边的液面应当相平，而她所观察到如图甲所示的情景，调节的方法是<U>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<\\/U>（选填“A“或“B”）<\\/P><P>A．将此时右边支管中高出的液体倒出  B．取下软管重新安装<\\/P><P>（3）调好后，将探头放入水中，并多次改变探头在水中的深度如图乙所小，同时比较每次的深度及相应的U形管左右两侧液面的高度差。这是为了探究<U>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<\\/U>。<\\/P>\",\n" +
                "      \"answers\": [\n" +
                "        {\n" +
                "          \"id\": 2203959,\n" +
                "          \"rightanswer\": 1,\n" +
                "          \"answertext\": \"\"\n" +
                "        }\n" +
                "      ],\n" +
                "      \"score\": \"3\",\n" +
                "      \"spenttime\": 100,\n" +
                "      \"qtype\": 3,\n" +
                "      \"difficulty\": \"0.28\",\n" +
                "      \"thoughtNameList\": [\n" +
                "        \"控制变量思想\"\n" +
                "      ],\n" +
                "      \"analysis\": \"<P><FONT color=\\\"0000FF\\\"><\\/FONT>（1）测量液体压强的仪器叫压强计；上端开口，下端连通的容器叫连通器。<\\/P><P>（2）只要取下软管，让U形管左端液面和大气相通，这样U形管两端的液面就是相平的；（3）液体内部压强大小通过U形管两侧液面高度差的大小来反映，这是转换法；液体压强和液体的密度、深度有关，实验中采用控制变量法来设计实验。<\\/P>\",\n" +
                "      \"pointNameList\": [\n" +
                "        \"探究液体压强的特点实验\"\n" +
                "      ],\n" +
                "      \"id\": 759652,\n" +
                "      \"qexplain\": \"<P><FONT color=\\\"0000FF\\\"><\\/FONT>解：（1）这是测量液体压强的压强计；它的左端是密闭的，所以不是连通器。<\\/P><P>（2）当压强计的橡皮膜没有受到压强时，U形管中液面应该就是相平的，若U形管中的液面出现了高度差，就说明软管中的气体压强大于大气压，在压力差的作用下，U形管中的液面出现高度差；要调节，只需要将软管取下，再重新安装，这样的话，U形管中两管上方的气体压强就是相等的（都等于大气压），当橡皮膜没有受到压强时，U形管中的液面就是相平的，故选B；<\\/P><P>（3）实验中液体的密度不变，改变探头在水中的深度，研究的是液体内部压强与深度的关系。<\\/P><P>故答案为：<\\/P><P>（1）不属于；（2）B；（3）液体内部压强与深度的关系。<\\/P>\",\n" +
                "      \"num\": \"13\",\n" +
                "      \"questionNum\": 13,\n" +
                "      \"source\": \"\",\n" +
                "      \"serialNum\": null,\n" +
                "      \"explain\": \"<P><FONT color=\\\"0000FF\\\"><\\/FONT>解：（1）这是测量液体压强的压强计；它的左端是密闭的，所以不是连通器。<\\/P><P>（2）当压强计的橡皮膜没有受到压强时，U形管中液面应该就是相平的，若U形管中的液面出现了高度差，就说明软管中的气体压强大于大气压，在压力差的作用下，U形管中的液面出现高度差；要调节，只需要将软管取下，再重新安装，这样的话，U形管中两管上方的气体压强就是相等的（都等于大气压），当橡皮膜没有受到压强时，U形管中的液面就是相平的，故选B；<\\/P><P>（3）实验中液体的密度不变，改变探头在水中的深度，研究的是液体内部压强与深度的关系。<\\/P><P>故答案为：<\\/P><P>（1）不属于；（2）B；（3）液体内部压强与深度的关系。<\\/P>\",\n" +
                "      \"comments\": \"<P><FONT color=\\\"0000FF\\\"><\\/FONT>此题主要考查的是学生对液体压强的影响因素实验的理解和掌握以及液体压强的计算，要了解压强计的构造与原理，并能学会观察压强计来判断压强的大小，是解答本题的关键。<\\/P>\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"abilityNameList\": [\n" +
                "        \"理解能力\",\n" +
                "        \"解决问题的能力\"\n" +
                "      ],\n" +
                "      \"text\": \"<P>（2018•呼和浩特）体感器的可以把力学物理量转化成电学信号，然后通过相互之间的函数关系，直接引用力的大小。测量压力大小的压力传感器，工作原理如图所示，其中M、N均为绝缘材料，M、N间有可收缩的导线（电阻大小不计），弹簧上端和滑动变阻器R<SUB>2<\\/SUB>的滑片P固定在一起，电源电压恒为12V，已知压力F的大小与R<SUB>2<\\/SUB>的阻值大小成正比例关系。闭合开关S，压力F<SUB>0<\\/SUB>=0时，滑片P在最上端；压力F<SUB>1<\\/SUB>=1N时，电流表示数为1A，电压示数为3V，当滑片P滑至最下端时，电压表示数为7.5V．求：<\\/P><P>（1）定值电阻R<SUB>1<\\/SUB>的大小；压力F<SUB>1<\\/SUB>与R<SUB>2<\\/SUB>阻值之比k；<\\/P><P>（2）当滑片P滑至最下端时，压力F<SUB>2<\\/SUB>的大小；<\\/P><P>（3）压力F的大小与电压表示数之间的函数关系表达式。<\\/P><P><img src=\\\"http://img2.51youpu.com/Public2/pic/38fb1b4782e842d486e2f7c7d6681078.png\\\"><\\/P>\",\n" +
                "      \"answers\": [],\n" +
                "      \"score\": \"6\",\n" +
                "      \"spenttime\": 100,\n" +
                "      \"qtype\": 4,\n" +
                "      \"difficulty\": \"0.50\",\n" +
                "      \"thoughtNameList\": [],\n" +
                "      \"analysis\": \"<P><FONT color=\\\"0000FF\\\"><\\/FONT>（1）由图知，两电阻串联，电压表测R<SUB>2<\\/SUB>两端电压，电流表测电路中电流，电流表示数为1A，电压表示数为3V，由串联电路特点和欧姆定律可计算R<SUB>1<\\/SUB>的阻值；<\\/P><P>再计算出压力1N时，变阻器连入电路的阻值，根据压力F的大小与R<SUB>2<\\/SUB>的阻值大小成正比例关系可得F<SUB>1<\\/SUB>与R<SUB>2<\\/SUB>阻值之比；<\\/P><P>（2）当滑片P滑至最下端时，电压表示数为7.5V，由串联电路特点和欧姆定律计算此时R<SUB>2<\\/SUB>连入电路的阻值，由压力F的大小与R<SUB>2<\\/SUB>的阻值大小成正比例关系计算压力F<SUB>2<\\/SUB>的大小；<\\/P><P>（3）由F与R<SUB>2<\\/SUB>的关系式表示出R<SUB>2<\\/SUB>，由串联电路特点和欧姆定律表示电压表示数，从而得到F的大小与电压表示数之间的函数关系表达式。<\\/P>\",\n" +
                "      \"pointNameList\": [\n" +
                "        \"欧姆定律的应用\"\n" +
                "      ],\n" +
                "      \"id\": 759661,\n" +
                "      \"qexplain\": \"<P><FONT color=\\\"0000FF\\\"><\\/FONT>解：（1）由图可知，R<SUB>1<\\/SUB>、R<SUB>2<\\/SUB>串联，电压表测R<SUB>2<\\/SUB>两端电压，电流表测电路中电流，<\\/P><P>当F<SUB>1<\\/SUB>=1N时，电流表示数为1A，电压数为3V，由串联电路特点可知，此时U<SUB>1<\\/SUB>=U﹣U<SUB>2<\\/SUB>=12V﹣3V=9V，并且：I<SUB>1<\\/SUB>=I<SUB>2<\\/SUB>=1A，<\\/P><P>由欧姆定律可得，R<SUB>1<\\/SUB>的阻值：R<SUB>1<\\/SUB>=<img src=\\\"http://img2.51youpu.com/Public2/pic/378223685e2e48139194165b18179faf.png\\\">=<img src=\\\"http://img2.51youpu.com/Public2/pic/3235ba1bc7a04947a2e9ee31003ba5ea.png\\\">=9Ω；<\\/P><P>此时R<SUB>2<\\/SUB>连入电路的阻值：R<SUB>2<\\/SUB>=<img src=\\\"http://img2.51youpu.com/Public2/pic/5be61079fcbb4a00a0e58d777f79f112.png\\\">=<img src=\\\"http://img2.51youpu.com/Public2/pic/ee8e840d62b248c3ba8f622d47464436.png\\\">=3Ω，<\\/P><P>所以压力F<SUB>1<\\/SUB>与R<SUB>2<\\/SUB>阻值之比：k=<img src=\\\"http://img2.51youpu.com/Public2/pic/12a6f531219941d68b63f21199d8ff0c.png\\\">=<img src=\\\"http://img2.51youpu.com/Public2/pic/be51c12b25724d29b6d229f97f49803c.png\\\">=<img src=\\\"http://img2.51youpu.com/Public2/pic/884d74106f904a4fb774ff26e3d62111.png\\\">N/Ω，<\\/P><P>（2）当滑片P滑至最下端时，变阻器连入阻值最大，电压表示数为7.5V，<\\/P><P>此时电路中电流：I'=I<SUB>2<\\/SUB>′=I<SUB>1<\\/SUB>′=<img src=\\\"http://img2.51youpu.com/Public2/pic/e8301e09ebc5423d9d30d8c05d870a19.png\\\">=<img src=\\\"http://img2.51youpu.com/Public2/pic/91880d96215a466b8fbcafc9e95f8732.png\\\">=<img src=\\\"http://img2.51youpu.com/Public2/pic/26e04a72222c444ba8f0f3252bb5f890.png\\\">=0.5A，<\\/P><P>所以R<SUB>2<\\/SUB>的最大值：R<SUB>2<\\/SUB><SUB>最大<\\/SUB>=<img src=\\\"http://img2.51youpu.com/Public2/pic/2ad41d5ff175407cbc34c1773faa53a7.png\\\">=<img src=\\\"http://img2.51youpu.com/Public2/pic/45a93684c9f94b70b708a6efc49b8931.png\\\">=15Ω，<\\/P><P>因为压力F的大小与R<SUB>2<\\/SUB>的阻值大小成正比例关系，即：F=kR<SUB>2<\\/SUB>，<\\/P><P>所以压力F<SUB>2<\\/SUB>=<img src=\\\"http://img2.51youpu.com/Public2/pic/32ec8b5f7402409382bb0b7ac5bca743.png\\\">N/Ω×R<SUB>2<\\/SUB><SUB>最大<\\/SUB>=<img src=\\\"http://img2.51youpu.com/Public2/pic/4604f2e417e74f658a3287cc8245465f.png\\\">N/Ω×15Ω=5N；<\\/P><P>（3）由F=kR<SUB>2<\\/SUB>有：R<SUB>2<\\/SUB>=<img src=\\\"http://img2.51youpu.com/Public2/pic/d091000de62243f6982265aa6923d4ce.png\\\">=<img src=\\\"http://img2.51youpu.com/Public2/pic/03619e034bd24e5fbd998694697910ec.png\\\">，<\\/P><P>串联电路特点和欧姆定律表示电压表示数：<\\/P><P>U<SUB>V<\\/SUB>=IR<SUB>2<\\/SUB>=<img src=\\\"http://img2.51youpu.com/Public2/pic/24cb49977b4c49748d5c38b5b41ddc63.png\\\">•R<SUB>2<\\/SUB>=<img src=\\\"http://img2.51youpu.com/Public2/pic/87fb810d6b254c1e86eb21631cd60fb3.png\\\">=<img src=\\\"http://img2.51youpu.com/Public2/pic/47f3190a09c74f428143671395394ea8.png\\\">，<\\/P><P>化简可得：F=<img src=\\\"http://img2.51youpu.com/Public2/pic/023aff11450a4d2888d39027c62195de.png\\\">（N）。<\\/P><P>答：（1）定值电阻R<SUB>1<\\/SUB>为9Ω；压力F<SUB>1<\\/SUB>与R<SUB>2<\\/SUB>阻值之比k为<img src=\\\"http://img2.51youpu.com/Public2/pic/03f5720c9bde4d378a370ab722f3b717.png\\\">N/Ω；<\\/P><P>（2）当滑片P滑至最下端时，压力F<SUB>2<\\/SUB>为5N；<\\/P><P>（3）压力F的大小与电压表示数之间的函数关系表达式为F=<img src=\\\"http://img2.51youpu.com/Public2/pic/36a9cf36e2214b3fbdef1bb5e514353b.png\\\">（N）。<\\/P>\",\n" +
                "      \"num\": \"22\",\n" +
                "      \"questionNum\": 22,\n" +
                "      \"source\": \"\",\n" +
                "      \"serialNum\": null,\n" +
                "      \"explain\": \"<P><FONT color=\\\"0000FF\\\"><\\/FONT>解：（1）由图可知，R<SUB>1<\\/SUB>、R<SUB>2<\\/SUB>串联，电压表测R<SUB>2<\\/SUB>两端电压，电流表测电路中电流，<\\/P><P>当F<SUB>1<\\/SUB>=1N时，电流表示数为1A，电压数为3V，由串联电路特点可知，此时U<SUB>1<\\/SUB>=U﹣U<SUB>2<\\/SUB>=12V﹣3V=9V，并且：I<SUB>1<\\/SUB>=I<SUB>2<\\/SUB>=1A，<\\/P><P>由欧姆定律可得，R<SUB>1<\\/SUB>的阻值：R<SUB>1<\\/SUB>=<img src=\\\"http://img2.51youpu.com/Public2/pic/378223685e2e48139194165b18179faf.png\\\">=<img src=\\\"http://img2.51youpu.com/Public2/pic/3235ba1bc7a04947a2e9ee31003ba5ea.png\\\">=9Ω；<\\/P><P>此时R<SUB>2<\\/SUB>连入电路的阻值：R<SUB>2<\\/SUB>=<img src=\\\"http://img2.51youpu.com/Public2/pic/5be61079fcbb4a00a0e58d777f79f112.png\\\">=<img src=\\\"http://img2.51youpu.com/Public2/pic/ee8e840d62b248c3ba8f622d47464436.png\\\">=3Ω，<\\/P><P>所以压力F<SUB>1<\\/SUB>与R<SUB>2<\\/SUB>阻值之比：k=<img src=\\\"http://img2.51youpu.com/Public2/pic/12a6f531219941d68b63f21199d8ff0c.png\\\">=<img src=\\\"http://img2.51youpu.com/Public2/pic/be51c12b25724d29b6d229f97f49803c.png\\\">=<img src=\\\"http://img2.51youpu.com/Public2/pic/884d74106f904a4fb774ff26e3d62111.png\\\">N/Ω，<\\/P><P>（2）当滑片P滑至最下端时，变阻器连入阻值最大，电压表示数为7.5V，<\\/P><P>此时电路中电流：I'=I<SUB>2<\\/SUB>′=I<SUB>1<\\/SUB>′=<img src=\\\"http://img2.51youpu.com/Public2/pic/e8301e09ebc5423d9d30d8c05d870a19.png\\\">=<img src=\\\"http://img2.51youpu.com/Public2/pic/91880d96215a466b8fbcafc9e95f8732.png\\\">=<img src=\\\"http://img2.51youpu.com/Public2/pic/26e04a72222c444ba8f0f3252bb5f890.png\\\">=0.5A，<\\/P><P>所以R<SUB>2<\\/SUB>的最大值：R<SUB>2<\\/SUB><SUB>最大<\\/SUB>=<img src=\\\"http://img2.51youpu.com/Public2/pic/2ad41d5ff175407cbc34c1773faa53a7.png\\\">=<img src=\\\"http://img2.51youpu.com/Public2/pic/45a93684c9f94b70b708a6efc49b8931.png\\\">=15Ω，<\\/P><P>因为压力F的大小与R<SUB>2<\\/SUB>的阻值大小成正比例关系，即：F=kR<SUB>2<\\/SUB>，<\\/P><P>所以压力F<SUB>2<\\/SUB>=<img src=\\\"http://img2.51youpu.com/Public2/pic/32ec8b5f7402409382bb0b7ac5bca743.png\\\">N/Ω×R<SUB>2<\\/SUB><SUB>最大<\\/SUB>=<img src=\\\"http://img2.51youpu.com/Public2/pic/4604f2e417e74f658a3287cc8245465f.png\\\">N/Ω×15Ω=5N；<\\/P><P>（3）由F=kR<SUB>2<\\/SUB>有：R<SUB>2<\\/SUB>=<img src=\\\"http://img2.51youpu.com/Public2/pic/d091000de62243f6982265aa6923d4ce.png\\\">=<img src=\\\"http://img2.51youpu.com/Public2/pic/03619e034bd24e5fbd998694697910ec.png\\\">，<\\/P><P>串联电路特点和欧姆定律表示电压表示数：<\\/P><P>U<SUB>V<\\/SUB>=IR<SUB>2<\\/SUB>=<img src=\\\"http://img2.51youpu.com/Public2/pic/24cb49977b4c49748d5c38b5b41ddc63.png\\\">•R<SUB>2<\\/SUB>=<img src=\\\"http://img2.51youpu.com/Public2/pic/87fb810d6b254c1e86eb21631cd60fb3.png\\\">=<img src=\\\"http://img2.51youpu.com/Public2/pic/47f3190a09c74f428143671395394ea8.png\\\">，<\\/P><P>化简可得：F=<img src=\\\"http://img2.51youpu.com/Public2/pic/023aff11450a4d2888d39027c62195de.png\\\">（N）。<\\/P><P>答：（1）定值电阻R<SUB>1<\\/SUB>为9Ω；压力F<SUB>1<\\/SUB>与R<SUB>2<\\/SUB>阻值之比k为<img src=\\\"http://img2.51youpu.com/Public2/pic/03f5720c9bde4d378a370ab722f3b717.png\\\">N/Ω；<\\/P><P>（2）当滑片P滑至最下端时，压力F<SUB>2<\\/SUB>为5N；<\\/P><P>（3）压力F的大小与电压表示数之间的函数关系表达式为F=<img src=\\\"http://img2.51youpu.com/Public2/pic/36a9cf36e2214b3fbdef1bb5e514353b.png\\\">（N）。<\\/P>\",\n" +
                "      \"comments\": \"<P><FONT color=\\\"0000FF\\\"><\\/FONT>本题考查了串联电路特点和欧姆定律公式的应用，关键是根据题意得到F与R<SUB>2<\\/SUB>的表达式。<\\/P>\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"errmsg\": \"\",\n" +
                "  \"semester\": 2\n" +
                "}\n";
        //json字符串转成对象
        JSONObject jsonObject = JSONObject.fromObject(json);
        Map<String, Object> map = (Map<String, Object>) JSONObject.toBean(jsonObject,Map.class);
        Set<String> set = map.keySet();
        for (String s : set) {
            System.out.println("key:"+s+"----------value:"+map.get(s));
        }
        //创建一个合适的Configration对象
        Configuration configuration = new Configuration();
        try {
            configuration.setDirectoryForTemplateLoading(new File("C:\\MingrenProject\\dowload_paper\\src\\main\\resources\\templates"));
            Template template = configuration.getTemplate("temp.html");
            configuration.setObjectWrapper(new DefaultObjectWrapper());
            configuration.setDefaultEncoding("UTF-8");   //这个一定要设置，不然在生成的页面中 会乱码
            //获取或创建一个模版。
            Writer writer  = new OutputStreamWriter(new FileOutputStream("C:\\MingrenProject\\dowload_paper\\src\\main\\resources\\templates\\shijuan.html"),"UTF-8");
            template.process(map, writer);

            System.out.println("恭喜，生成成功~~");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testgenerateHtml(){
        //JSONObject转成对象
        File file = new File("C:\\file\\paperInfo.json");
        FileReader reader = null;//定义一个fileReader对象，用来初始化BufferedReader
        try {
            reader = new FileReader(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader bReader = new BufferedReader(reader);//new一个BufferedReader对象，将文件内容读取到缓存
        StringBuilder sb = new StringBuilder();//定义一个字符串缓存，将字符串存放缓存中
        String s = "";
        try {
            while ((s =bReader.readLine()) != null) {//逐行读取文件内容，不读取换行符和末尾的空格
                sb.append(s + "\n");//将读取的字符串添加换行符后累加存放在缓存中
                System.out.println(s);
            }
            bReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String json = sb.toString();
        //json字符串转成对象
        JSONObject jsonObject = JSONObject.fromObject(json);
        Map<String, Object> map = (Map<String, Object>) JSONObject.toBean(jsonObject,Map.class);
        Set<String> set = map.keySet();
        for (String s1 : set) {
            System.out.println("key:"+s1+"----------value:"+map.get(s1));
        }
        //创建一个合适的Configration对象
        Configuration configuration = new Configuration();
        try {
            configuration.setDirectoryForTemplateLoading(new File("C:\\file"));
            Template template = configuration.getTemplate("temp.html");
            configuration.setObjectWrapper(new DefaultObjectWrapper());
            configuration.setDefaultEncoding("UTF-8");   //这个一定要设置，不然在生成的页面中 会乱码
            //获取或创建一个模版。
            Writer writer  = new OutputStreamWriter(new FileOutputStream("C:\\file\\shijuan.html"),"UTF-8");
            template.process(map, writer);

            System.out.println("恭喜，生成成功~~");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void insertShop() throws Exception {
        try {
            //创建一个合适的Configration对象
            Configuration configuration = new Configuration();
            configuration.setDirectoryForTemplateLoading(new File("D:\\dowload_paper\\src\\main\\resources\\templates"));
            configuration.setObjectWrapper(new DefaultObjectWrapper());
            configuration.setDefaultEncoding("UTF-8");   //这个一定要设置，不然在生成的页面中 会乱码
            //获取或创建一个模版。
            Template template = configuration.getTemplate("testTemplate.html");
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("description", "我正在学习使用Freemarker生成静态文件！");

            List<String> nameList = new ArrayList<String>();
            nameList.add("陈靖仇");
            nameList.add("玉儿");
            nameList.add("宇文拓");
            paramMap.put("nameList", nameList);

            Map<String, Object> weaponMap = new HashMap<String, Object>();
            weaponMap.put("first", "轩辕剑");
            weaponMap.put("second", "崆峒印");
            weaponMap.put("third", "女娲石");
            weaponMap.put("fourth", "神农鼎");
            weaponMap.put("fifth", "伏羲琴");
            weaponMap.put("sixth", "昆仑镜");
            weaponMap.put("seventh", null);
            paramMap.put("weaponMap", weaponMap);

            Writer writer  = new OutputStreamWriter(new FileOutputStream("success.html"),"UTF-8");
            template.process(paramMap, writer);

            System.out.println("恭喜，生成成功~~");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
    }
}


