<div class="row">
    <div class="col-md-6">
        <h2>Login</h2>

        <form action="login_function" method="post" class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label" for="login-username">Username</label>

                <div class="col-sm-10">
                    <input class="form-control" type="text" name="username" id="login-username">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label" for="login-password">Password</label>

                <div class="col-sm-10">
                    <input class="form-control" type="password" name="password" id="login-password">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Login</button>
                </div>
            </div>
        </form>
    </div>

    <div class="col-md-6">
        <h2>Register</h2>

        <form action="signin_function" method="post" class="form-horizontal">
            <div class="form-group">
                <label class="col-sm-2 control-label" for="signin-firstname">First name</label>

                <div class="col-sm-10">
                    <input class="form-control" type="text" name="firstname" id="signin-firstname">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label" for="signin-lastname">Last name</label>

                <div class="col-sm-10">
                    <input class="form-control" type="text" name="lastname" id="signin-lastname">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label" for="signin-password">Password</label>

                <div class="col-sm-10">
                    <input class="form-control" type="password" name="password" id="signin-password">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label" for="signin-rpassword">Password Again</label>

                <div class="col-sm-10">
                    <input class="form-control" type="password" name="rPasswort" id="signin-rpassword">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-default">Register</button>
                </div>
            </div>
        </form>
    </div>
</div>