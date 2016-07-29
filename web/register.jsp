<%--
  Created by IntelliJ IDEA.
  User: 滩涂上的芦苇
  Date: 2016/6/6
  Time: 22:12
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

    <title>新用户注册</title>

    <!-- Bootstrap core CSS -->
    <link href="//cdn.bootcss.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="bookstrap/css/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
</head>
<body>

<div class="container">

    <form class="form-signin" action="register.action">
        <h2 class="form-signin-heading">新用户请注册</h2>
        <label for="inputName" class="sr-only">Username</label>
        <input type="text" id="inputName" class="form-control" placeholder="Email Address" required name="username">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required name="password">
        <label for="repeatPassword" class="sr-only">Password</label>
        <input type="password" id="repeatPassword" class="form-control" placeholder="Repeat Password" required name="passa">
        <label for="inputEmail" class="sr-only">email</label>
        <input type="email" id="inputEmail" class="form-control" placeholder="E-mail" required name="email">
        <label for="inputQQ" class="sr-only">qq</label>
        <input type="text" id="inputQQ" class="form-control" placeholder="QQ Number" required name="qq">
        <label for="inputTel" class="sr-only">tel</label>
        <input type="tel" id="inputTel" class="form-control" placeholder="Telphone Number" required name="tel">
        <button class="btn btn-lg btn-primary btn-block" type="submit">注册</button>
    </form>

</div> <!-- /container -->
</body>
</html>
