package com.jjx.ssh.action;

import com.jjx.ssh.common.utils.AjaxUtil;
import com.jjx.ssh.entity.User;
import com.jjx.ssh.service.IUserService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * @author jiangjx
 */
@Controller
@Namespace("/user")
public class UserAction extends ActionSupport {

    @Autowired
    private IUserService userService;

    private String id;
    private User user;
    private List<User> users;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Action(value = "all", results = {@Result(name = "success", location = "/content/user/user.jsp")})
    public String all() {
        users = userService.all();
        return SUCCESS;
    }

    @Action(value = "detail", results = {@Result(name = "success", location = "/content/user/user.jsp")})
    public void detail() {
        String id = ServletActionContext.getRequest().getParameter("id");
        user = userService.get(id);
        AjaxUtil.ajaxJSONResponse(ServletActionContext.getResponse(), "", user);
    }

}
