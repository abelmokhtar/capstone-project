<!DOCTYPE html>
<html dir="ltr" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description"content="">
    <meta name="robots" content="noindex,nofollow">
    <title>Bug Tracker</title>
    <link rel="icon" type="image/png" sizes="16x16" href="assets/images/favicon.png">
    <link href="assets/plugins/chartist/dist/chartist.min.css" rel="stylesheet" />
    <link href="css/style.min.css" rel="stylesheet" />
</head>

<body>
    <div class="preloader">
        <div class="lds-ripple">
            <div class="lds-pos"></div>
            <div class="lds-pos"></div>
        </div>
    </div>
    <div id="main-wrapper"data-layout="vertical" data-navbarbg="skin6" data-sidebartype="full" data-sidebar-position="absolute" data-header-position="absolute" data-boxed-layout="full">
            <div class="container-fluid" >
                <div class="d-flex justify-content-center" style="padding-top: 10%;">
                    <div class="col-sm-3 align-middle" style="text-align: center;">                                  
                            <div style="font-size: 25pt; margin-bottom: 15px; padding-bottom: 5px;"><span class="logo-text" style="margin-left: 20px;">Bug Tracker</span></b></div>
                            <div class="col-md-12">${msg}</div>
                            <form action="../authenticate" method="post" style="margin: 0 auto; display: table; width: 80%; padding-top: 25px; padding-bottom: 25px;" class="border-top border-bottom">
                                <input type="text" style="margin-bottom: 10px; padding: 10px 10px;" class="form-control" name="username" placeholder="Username...">
                                <input type="text"  style="margin-bottom: 20px;  padding: 10px 10px;" class="form-control" name="password" placeholder="Password...">
                                <input type="submit" class="btn btn-success" style="color: #FFF;" value="Login User"/>
                            </form>
                            <br />
                            <a href="register.html" style="margin-right: 50px; color: #0C5F0C; text-decoration: underline; font-size: 12pt;">Register Here</a>
                            <a href="forgot.html" style="color: #0C5F0C; text-decoration: underline; font-size: 12pt;">Forgot Password</a>
                    </div>
                </div>
                <div class="d-flex justify-content-center" style="padding-top: 25px;">
                    <div class="col-sm-3 align-middle" style="text-align: center;">        
                            <br />    
                            <b>Project Manager Access</b><br />
                            Username: admin<br />
                            Password: capstone
                            <br /><br /><br />
                            <b>User Access</b><br />
                            Username: user<br />
                            Password: capstone<br />
                    </div>
                </div>
            </div>
        </div>
    </div>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
    
    <script src="http://localhost/capstone/assets/plugins/jquery/dist/jquery.min.js"></script>
    <script src="http://localhost/capstone/assets/plugins/bootstrap/dist//js/bootstrap.bundle.min.js"></script>
    <script src="http://localhost/capstone/js/app-style-switcher.js"></script>
    <script src="http://localhost/capstone/js/waves.js"></script>
    <script src="http://localhost/capstone/js/sidebarmenu.js"></script>
    <script src="http://localhost/capstone/js/custom.js"></script>
    <script src="http://localhost/capstone/assets/plugins/flot/jquery.flot.js"></script>
    <script src="http://localhost/capstone/assets/plugins/flot.tooltip//js/jquery.flot.tooltip.min.js"></script>
    <script src="http://localhost/capstone/js/pages/dashboards/dashboard1.js"></script>
</body>
</html>