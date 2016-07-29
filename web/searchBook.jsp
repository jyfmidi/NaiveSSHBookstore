<%--
  Created by IntelliJ IDEA.
  User: 滩涂上的芦苇
  Date: 2016/6/6
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import = "java.util.*"%>
<%@ page import = "com.entity.BooksEntity" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>芦苇书店</title>

    <!-- Bootstrap core CSS -->
    <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="bookstrap/css/dashboard.css" rel="stylesheet">
    <link href="bookstrap/css/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="../../assets/js/ie-emulation-modes-warning.js"></script>
    <script src="ajax.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#"><%=
            session.getAttribute("username")
            %> </a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="profileQuery.action">设置</a></li>
                <li><a href="history.action">历史</a></li>
                <li><a href="logout.action">注销</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
            <ul class="nav nav-sidebar">
                <li ><a href="main.jsp">概览</a></li>
                <li class="active"><a href="#">高级查询 <span class="sr-only">(current)</span></a></li>
                <li><a href="searchAllbook.action">所有书籍</a></li>
                <li><a href="showCart.action">我的购物车</a></li>
            </ul>
            <%
                if((int)session.getAttribute("isAdmin")==1){
            %>
            <ul class="nav nav-sidebar">
                <li><a href="queryUser.action">用户管理</a></li>
                <li><a href="manageBook.action">书籍管理</a></li>
                <li><a href="Stat.jsp">销售统计</a></li>
            </ul>
            <%
                }
            %>
        </div>
        <div class="container">
            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <form class="form-signin" action="searchBookHL.action">
                <h2 class="form-signin-heading">高级查询</h2>
                <label for="inputMessage" class="sr-only">Username</label>
                <input type="text" id="inputMessage" class="form-control" placeholder="Search Books" required name="content">
                <select class="form-control" name="method">
                    <option value="title">按书名查询</option>
                    <option value="isbn">按书号查询</option>
                    <option value="category">按种类查询</option>
                </select>
                <button class="btn btn-lg btn-primary btn-block" type="submit">查询</button>
            </form>
            <%
                if(request.getAttribute("booklist")!=null)
                {
            %>
            <h2 class="sub-header">查询结果</h2>
            <%
                Vector<BooksEntity> books = (Vector<BooksEntity>)request.getAttribute("booklist");
                int size = books.size();
                if (size > 0) {
            %>
            <div class="table-responsive">
                <table class="table table-striped">
                    <tr>
                        <td>书名</td>
                        <td>书号</td>
                        <td>种类</td>
                        <td>价格</td>
                        <td>操作</td>
                    </tr>
                    <%
                        for (int i = 0; i < size; i++) {
                    %>
                    <tr>
                        <td id="<%=books.get(i).getIsbn()%>" onmouseover="getDetial(this)" onmouseout="clearData()"><%= books.get(i).getTitle() %>&nbsp;</td>
                        <td><%= books.get(i).getIsbn() %>&nbsp;</td>
                        <td><%= books.get(i).getCategory() %>&nbsp;</td>
                        <td><%= books.get(i).getPrice() %>&nbsp;</td>
                        <td>
                            <form action = "updateCart.action" method = "post" class="form-inline">
                                <input type = "number" name = "quantity" class="form-control"/>
                                <input type = "hidden" name = "bookname" value = <%= books.get(i).getIsbn() %> />
                                <input type = "submit" value = "加入购物车" class="btn btn-primary"/>
                            </form>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </table>
                <div style="position:absolute;" id="popup">
                    <table bgcolor="#FFFAFA" border="0" cellspacing="2" cellpadding="2">
                        <tbody id="dataBody"></tbody>
                    </table>
                </div>
                <%
                }else{
                %>
                <div class="alert alert-info" role="alert">
                    <strong>Heads up!</strong>
                    未找到任何相关书籍
                </div>
                <%
                    }
                %>
            </div>
            <%
                }
            %>
        </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript
================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="//cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<script src="//cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
<script src="../../assets/js/vendor/holder.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
