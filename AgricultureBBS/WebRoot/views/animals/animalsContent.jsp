<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>Agriculture论坛  铲屎官专区- 文章页面</title>
    <meta name="keywords" content="H+后台主题,后台bootstrap框架,会员中心主题,后台HTML,响应式后台">
    <meta name="description" content="H+是一个完全响应式，基于Bootstrap3最新版本开发的扁平化主题，她采用了主流的左右两栏式布局，使用了Html5+CSS3等现代技术">

    <link rel="shortcut icon" href="favicon.ico"> <link href="${pageContext.request.contextPath}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="${pageContext.request.contextPath}/css/animate.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/css/style.css?v=4.1.0" rel="stylesheet">
    
    <style type="text/css">  
        html, body {width:100%;height:100%;} /*非常重要的样式让背景图片100%适应整个屏幕*/  
        .bg {display: table;width: 100%;height: 100%;padding: 100px 0;text-align: center;color: #fff;background: url(http://www.xiandanke.cn/Image/intro-bg.jpg) no-repeat bottom center;background-color: #000;background-size: cover;}  
        .my-navbar {padding:7px 0;transition: background 0.5s ease-in-out, padding 0.5s ease-in-out;background: #3bbd66;}  
        .my-navbar a{background:transparent !important;color:#fff !important}  
        .my-navbar a:hover {color:#45bcf9 !important;background:transparent;outline:0}  
        .my-navbar a {transition: color 0.5s ease-in-out;}/*-webkit-transition ;-moz-transition*/  
        .top-nav {padding:0;background:#000;}  
        button.navbar-toggle {background-color:#fbfbfb;}/*整个背景都是transparent透明的，会看不到，所以再次覆盖一下*/  
        button.navbar-toggle > span.icon-bar {background-color:#dedede}  
    </style> 

</head>

<body class="gray-bg">
	<nav class="navbar navbar-fixed-top my-navbar" role="navigation">  
        <div class="container-fluid">  
            <div class="navbar-header">  
                <button type="button" class="navbar-toggle" data-toggle="collapse"  
                        data-target="#example-navbar-collapse">  
                    <span class="sr-only">切换导航</span>  
                    <span class="icon-bar"></span>  
                    <span class="icon-bar"></span>  
                    <span class="icon-bar"></span>  
                </button>  
                <a class="navbar-brand" href="#">Agriculture论坛</a>  
            </div>  
            <div class="collapse navbar-collapse" id="example-navbar-collapse">  
                <ul class="nav navbar-nav">  
                    <li><a href="${pageContext.request.contextPath}/">首页</a></li>  
                    <li class="active"><a href="${pageContext.request.contextPath}/animals/animalsList">铲屎官</a></li>  
                    <li>  
                        <a href="#">德鲁伊</a>  
                    </li>  
                </ul>  
            </div>  
            
            
        </div>  
    </nav>
    <div class="wrapper wrapper-content  animated fadeInRight article" style="padding-top: 75px;">
        <div class="row">
            <div class="col-lg-10 col-lg-offset-1">
                <div class="ibox">
                    <div class="ibox-content">
                        <div class="pull-right">
                            <button class="btn btn-white btn-xs" type="button">700BIKE</button>
                            <button class="btn btn-white btn-xs" type="button">BeginOne</button>
                            <button class="btn btn-white btn-xs" type="button">乐视超级自行车</button>
                        </div>
                        <div class="text-center article-title">
                            <h1>
                                    自行车都智能化了，你可知道它的历史？
                                </h1>
                        </div>
                        <p>
                            在不少旁观者的眼里，智能化几乎成了一种避之唯恐不及的“瘟疫”，开始攀附上大大小小、各式各样的工具和设备，从水杯、灯泡、体重秤这样的小物件，再到冰箱、洗衣机这些生活中的庞然大物。
                        </p>
                        <p>
                            兜兜转转之后，这场“瘟疫”又找上了在生活中不那么起眼的自行车。然而，在搭上智能化的顺风车之前，你可知道自行车的历史？虽然，在乐视超级自行车的发布会上，它已经用了自行车史上有着重要地位的三个名字——斯塔利、西夫拉克、阿尔普迪埃——来命名自家的自行车，但那远远不够。Gizmodo 为我们梳理了自行车发展的关键节点。
                        </p>
                        <p>
                            在开始之前，我们先来看看丹麦的设计师制作的动画，一分钟看完自行车近 200 年的演变。
                        </p>
                        <p>
                            比较公认的说法是，第一辆自行车由法国手工艺人西夫拉克（Médé de Sivrac）设计，在两个轮子上安装了支架并配上马鞍，前进的话需要用脚蹬地提供动力。这还只是一个很简单的雏形，没有方向舵，转弯的时候需要骑行者下车抬起前轮，稳定性也不好。
                        </p>
                        <p>
                            德国人杜莱斯（Karl Drais von Sauerbronn）制作了一辆和西夫拉克的设计相近的两轮车子，增加了车把，可以改变行进中的方向，速度可以达到 15km/h。不过，还是需要靠双脚蹬地提供动力。
                        </p>
                        <p>
                            这时候第一辆真正意义上的自行车诞生了，是由苏格兰铁匠麦克米伦（Kirkpatrik Macmillan）设计的，它还有一个专门的名字——Velocipede。
                        </p>
                        <p>
                            在不少旁观者的眼里，智能化几乎成了一种避之唯恐不及的“瘟疫”，开始攀附上大大小小、各式各样的工具和设备，从水杯、灯泡、体重秤这样的小物件，再到冰箱、洗衣机这些生活中的庞然大物。
                        </p>
                        <p>
                            兜兜转转之后，这场“瘟疫”又找上了在生活中不那么起眼的自行车。然而，在搭上智能化的顺风车之前，你可知道自行车的历史？虽然，在乐视超级自行车的发布会上，它已经用了自行车史上有着重要地位的三个名字——斯塔利、西夫拉克、阿尔普迪埃——来命名自家的自行车，但那远远不够。Gizmodo 为我们梳理了自行车发展的关键节点。
                        </p>
                        <p>
                            在开始之前，我们先来看看丹麦的设计师制作的动画，一分钟看完自行车近 200 年的演变。
                        </p>
                        <p>
                            比较公认的说法是，第一辆自行车由法国手工艺人西夫拉克（Médé de Sivrac）设计，在两个轮子上安装了支架并配上马鞍，前进的话需要用脚蹬地提供动力。这还只是一个很简单的雏形，没有方向舵，转弯的时候需要骑行者下车抬起前轮，稳定性也不好。
                        </p>
                        <p>
                            德国人杜莱斯（Karl Drais von Sauerbronn）制作了一辆和西夫拉克的设计相近的两轮车子，增加了车把，可以改变行进中的方向，速度可以达到 15km/h。不过，还是需要靠双脚蹬地提供动力。
                        </p>
                        <p>
                            这时候第一辆真正意义上的自行车诞生了，是由苏格兰铁匠麦克米伦（Kirkpatrik Macmillan）设计的，它还有一个专门的名字——Velocipede。
                        </p>
                        <p>
                            在不少旁观者的眼里，智能化几乎成了一种避之唯恐不及的“瘟疫”，开始攀附上大大小小、各式各样的工具和设备，从水杯、灯泡、体重秤这样的小物件，再到冰箱、洗衣机这些生活中的庞然大物。
                        </p>
                        <p>
                            兜兜转转之后，这场“瘟疫”又找上了在生活中不那么起眼的自行车。然而，在搭上智能化的顺风车之前，你可知道自行车的历史？虽然，在乐视超级自行车的发布会上，它已经用了自行车史上有着重要地位的三个名字——斯塔利、西夫拉克、阿尔普迪埃——来命名自家的自行车，但那远远不够。Gizmodo 为我们梳理了自行车发展的关键节点。
                        </p>
                        <p>
                            在开始之前，我们先来看看丹麦的设计师制作的动画，一分钟看完自行车近 200 年的演变。
                        </p>
                        <p>
                            比较公认的说法是，第一辆自行车由法国手工艺人西夫拉克（Médé de Sivrac）设计，在两个轮子上安装了支架并配上马鞍，前进的话需要用脚蹬地提供动力。这还只是一个很简单的雏形，没有方向舵，转弯的时候需要骑行者下车抬起前轮，稳定性也不好。
                        </p>
                        <p>
                            德国人杜莱斯（Karl Drais von Sauerbronn）制作了一辆和西夫拉克的设计相近的两轮车子，增加了车把，可以改变行进中的方向，速度可以达到 15km/h。不过，还是需要靠双脚蹬地提供动力。
                        </p>
                        <p>
                            这时候第一辆真正意义上的自行车诞生了，是由苏格兰铁匠麦克米伦（Kirkpatrik Macmillan）设计的，它还有一个专门的名字——Velocipede。
                        </p>
                        <p>
                            在不少旁观者的眼里，智能化几乎成了一种避之唯恐不及的“瘟疫”，开始攀附上大大小小、各式各样的工具和设备，从水杯、灯泡、体重秤这样的小物件，再到冰箱、洗衣机这些生活中的庞然大物。
                        </p>
                        <p>
                            兜兜转转之后，这场“瘟疫”又找上了在生活中不那么起眼的自行车。然而，在搭上智能化的顺风车之前，你可知道自行车的历史？虽然，在乐视超级自行车的发布会上，它已经用了自行车史上有着重要地位的三个名字——斯塔利、西夫拉克、阿尔普迪埃——来命名自家的自行车，但那远远不够。Gizmodo 为我们梳理了自行车发展的关键节点。
                        </p>
                        <p>
                            在开始之前，我们先来看看丹麦的设计师制作的动画，一分钟看完自行车近 200 年的演变。
                        </p>
                        <p>
                            比较公认的说法是，第一辆自行车由法国手工艺人西夫拉克（Médé de Sivrac）设计，在两个轮子上安装了支架并配上马鞍，前进的话需要用脚蹬地提供动力。这还只是一个很简单的雏形，没有方向舵，转弯的时候需要骑行者下车抬起前轮，稳定性也不好。
                        </p>
                        <p>
                            德国人杜莱斯（Karl Drais von Sauerbronn）制作了一辆和西夫拉克的设计相近的两轮车子，增加了车把，可以改变行进中的方向，速度可以达到 15km/h。不过，还是需要靠双脚蹬地提供动力。
                        </p>
                        <p>
                            这时候第一辆真正意义上的自行车诞生了，是由苏格兰铁匠麦克米伦（Kirkpatrik Macmillan）设计的，它还有一个专门的名字——Velocipede。
                        </p>
                        <hr>

                        <div class="row">
                            <div class="col-lg-12">

                                <h2>评论：</h2>
                                <div class="social-feed-box">
                                    <div class="social-avatar">
                                        <a href="" class="pull-left">
                                            <img alt="image" src="${pageContext.request.contextPath}/img/a1.jpg">
                                        </a>
                                        <div class="media-body">
                                            <a href="#">
                                                    逆光狂胜蔡舞娘
                                                </a>
                                            <small class="text-muted">17 小时前</small>
                                        </div>
                                    </div>
                                    <div class="social-body">
                                        <p>
                                            好东西，我朝淘宝准备跟进，1折开卖
                                        </p>
                                    </div>
                                </div>
                                <div class="social-feed-box">
                                    <div class="social-avatar">
                                        <a href="" class="pull-left">
                                            <img alt="image" src="${pageContext.request.contextPath}/img/a2.jpg">
                                        </a>
                                        <div class="media-body">
                                            <a href="#">
                                                    避雷范儿
                                                </a>
                                            <small class="text-muted"> 16 小时前</small>
                                        </div>
                                    </div>
                                    <div class="social-body">
                                        <p>
                                            第一个真的好美 就是噪音太大了 挺唯美的意境瞬间变成工厂了
                                        </p>
                                    </div>
                                </div>
                                <div class="social-feed-box">
                                    <div class="social-avatar">
                                        <a href="" class="pull-left">
                                            <img alt="image" src="${pageContext.request.contextPath}/img/a3.jpg">
                                        </a>
                                        <div class="media-body">
                                            <a href="#">
                                                    kamppi
                                                </a>
                                            <small class="text-muted"> 6 小时前</small>
                                        </div>
                                    </div>
                                    <div class="social-body">
                                        <p>
                                            好美的装置艺术，第二个让我想起了海中缓缓游动的鲸鱼。
                                        </p>
                                    </div>
                                </div>
                                <div class="social-feed-box">
                                    <div class="social-avatar">
                                        <a href="" class="pull-left">
                                            <img alt="image" src="${pageContext.request.contextPath}/img/a5.jpg">
                                        </a>
                                        <div class="media-body">
                                            <a href="#">
                                                    kamppi
                                                </a>
                                            <small class="text-muted">6 小时前</small>
                                        </div>
                                    </div>
                                    <div class="social-body">
                                        <p>
                                            “Flylight 的灯管并不固定，由一套软件控制：每一个灯管都根据与其它灯管的互动进行移动，就像一群真正的鸟群一样。” 好像介绍的描述不对，灯管是固定的，控制的只是点亮和熄灭的时间，模拟成一团亮点移动
                                        </p>
                                    </div>
                                </div>


                            </div>
                        </div>


                    </div>
                </div>
            </div>
        </div>

    </div>

    <!-- 全局js -->
    <script src="${pageContext.request.contextPath}/js/jquery.min.js?v=2.1.4"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js?v=3.3.6"></script>



    <!-- 自定义js -->
    <script src="${pageContext.request.contextPath}/js/forum/content.js"></script>

	<script>  
        $(window).scroll(function () {  
            if ($(".navbar").offset().top > 50) {$(".navbar-fixed-top").addClass("top-nav");  
            }else {$(".navbar-fixed-top").removeClass("top-nav");}  
        })
    </script> 

</body>

</html>
