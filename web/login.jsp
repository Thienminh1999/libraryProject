<%-- 
    Document   : login
    Created on : Jun 3, 2020, 3:10:15 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            <%@include file="resource/css/bootstrap.min.css" %>
            <%@include file="resource/css/mycss.css" %>
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <div class="container">
            <div class="main-content">
                <div class="image-area">
                    <img src="resource/img/bg-01.jpg" height="900" width="100%">
                </div>
                <div class="login-area">
                    <div class="form-panel">
                        <form action="MainController" method="POST">
                            <div class="form-name">ACCOUNT LOGIN</div>
                            <div class="form-fill">
                                <div class="form-row align-items-center">
                                    <div class="col-auto">
                                        <label class="sr-only" for="inlineFormInputGroup">Username</label>
                                        <div class="input-group mb-2">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">@</div>
                                            </div>
                                            <input type="text" name="txtUsername" value="" class="form-control" id="inlineFormInputGroup" placeholder="Username">
                                        </div>
                                    </div>
                                    <div class="col-auto">
                                        <label class="sr-only" for="inlineFormInputGroup">Password</label>
                                        <div class="input-group mb-2">
                                            <div class="input-group-prepend">
                                                <div class="input-group-text">@</div>
                                            </div>
                                            <input type="password" name="txtPassword" class="form-control" placeholder="Password">
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="button-area">
                                <button type="submit" name="btnAction" value="Login" class="btn btn-success login-button">LOGIN</button>
                            </div>
                            <div class="registry-area">
                                Forgot <a href="#">username/password?</a>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
