<#import "../main.ftlh" as main>

<@main.main>
    <div class="row">
        <div class="col s12 m6 l4 push-l4 push-m3">
            <div class="card">
                <div class="card-content">
                    <span class="card-title">Registration</span>

                    <div class="row">
                        <form class="col s12" action="/registration" method="post">
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
                                <div class="input-field col s12">
                                    <input name="email" id="email" type="email" class="validate <#if errors?? && errors.getFieldError("email")??>invalid</#if>">
                                    <label for="email">Email</label>
                                    <#if errors?? && errors.getFieldError("email")??>
                                        <span class="helper-text" data-error="${errors.getFieldError("email").getDefaultMessage()}"></span>
                                    </#if>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col s6">
                                    <button type="submit" class="waves-effect waves-light btn">sign up</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@main.main>