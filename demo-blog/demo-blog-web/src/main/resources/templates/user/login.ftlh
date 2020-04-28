<#import "../main.ftlh" as main>

<@main.main>
    <div class="row">
        <div class="col s12 m6 l4 push-l4 push-m3">
            <div class="card">
                <div class="card-content">
                    <span class="card-title">Login</span>

                    <div class="row">
                        <form class="col s12" action="/login" method="post">
                            <div class="row">
                                <div class="input-field col s12">
                                    <input name="username" id="username" type="text" class="validate <#if errors?? && errors.getFieldError("username")??>invalid</#if>">
                                    <label for="username">Last Name</label>
                                    <#if errors?? && errors.getFieldError("username")??>
                                        <span class="helper-text" data-error="${errors.getFieldError("username").getDefaultMessage()}"></span>
                                    </#if>
                                </div>
                            </div>

                            <div class="row">
                                <div class="input-field col s12">
                                    <input name="password" id="password" type="password" class="validate <#if errors?? && errors.getFieldError("password")??>invalid</#if>">
                                    <label for="password">Password</label>
                                    <#if errors?? && errors.getFieldError("password")??>
                                        <span class="helper-text" data-error="${errors.getFieldError("password").getDefaultMessage()}"></span>
                                    </#if>
                                </div>
                            </div>

                            <div class="row">
                                <div class="col s6">
                                    <button type="submit" class="waves-effect waves-light btn">login</button>
                                </div>

                                <div class="col s6 right-align">
                                    <a href="/registration" class="waves-effect waves-light btn blue-grey">registration</a>
                                </div>
                            </div>
                            <#if error?? && error>
                                <span class="red-text">Incorrect username or password</span>
                            </#if>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@main.main>