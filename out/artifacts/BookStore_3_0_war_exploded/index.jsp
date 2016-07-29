<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/5/17
  Time: 17:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>滩涂上的芦苇的书店</title>

    <!-- Bootstrap core CSS -->
    <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="jumbotron.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>

    <link href="bookstrap/css/bootstrap.css" rel="stylesheet">
  </head>
  <body>
  <nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
      <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
          <span class="sr-only">Toggle navigation</span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
          <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand" href="#">芦苇书店</a>
      </div>
      <div id="navbar" class="navbar-collapse collapse">
        <form class="navbar-form navbar-right" action = "login.action" method = "post">
          <div class="form-group">
            <input type="text" placeholder="用户名" class="form-control" name="username">
          </div>
          <div class="form-group">
            <input type="password" placeholder="密码" class="form-control" name="password">
          </div>
          <button type="submit" class="btn btn-success">登录</button>
        </form>
      </div><!--/.navbar-collapse -->
    </div>
  </nav>

  <!-- Main jumbotron for a primary marketing message or call to action -->
  <div class="jumbotron">
    <div class="container">
      <h1>欢迎来到芦苇书店</h1>
      <p>请于登陆后开始购书。如果您尚未注册，请点击注册</p>
      <p><a class="btn btn-primary btn-lg" href="register.jsp" role="button">注册 &raquo;</a></p>
    </div>
  </div>

  <div class="container">
    <!-- Example row of columns -->
    <div class="row">
      <div class="col-md-4">
        <h2>工商管理学</h2>
        <p>本书旨在介绍西方现代管理学的发展，并对管理学及其重要分支的主要理论和观点、现状及未来发展趋势进行综述和预测。内容涉及运营管理、供应链管理、质量管理、库存管理、收益管理、运输管理、商业预测、战略管理、人力资源管理、创业学及中小企业管理、创新与技术管理、跨文化管理、组织行为学、组织理论、管理研究方法等诸多方面。每章的作者均为当前在美国高校从事管理学教育和研究的学者，对西方管理学的历史脉络和前沿理论有着深刻的认识和见解。每一章都对所选研究领域内主要理论及观点、代表性学者及其著作、最新研究成果和发展趋势进行具体评述。他们试图通过本书向读者对管理学理论提供一个全景式的深入介绍和探索。
        </p>
        <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
      </div>
      <div class="col-md-4">
        <h2>他改变了中国</h2>
        <div class="col-md-6">
          <img src="pictures/The%20Man.jpg">
        </div>
        <div class="col-md-6">
          <p>该书是一部人物传记，作者为美国作家罗伯特·劳伦斯·库恩（Robert Lawrence Kuhn），中文翻译本署名“谈峥，于海江等”。作者长期关注中国，关注江泽民，并向江泽民的亲属、好友及有关工作人员进行了深入细致的采访，掌握了大量第一手资料，在此基础上写成本书。</p>
        </div>
        <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
      </div>
      <div class="col-md-4">
        <h2>寻找太阳草</h2>
        <img src="pictures/timg.jpg">
        <p><a class="btn btn-default" href="#" role="button">View details &raquo;</a></p>
      </div>
    </div>

    <hr>

    <footer>
      <p>&copy; Company 2014</p>
    </footer>
  </div> <!-- /container -->


  <!-- Bootstrap core JavaScript
  ================================================== -->
  <!-- Placed at the end of the document so the pages load faster -->
  <script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
  <script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
  <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
