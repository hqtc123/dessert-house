package com.hqtc.action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 * User: hqtc
 * Date: 13-3-9
 * Time: 下午5:23
 * To change this template use File | Settings | File Templates.
 */
@Component
@ParentPackage("json-default")
@Namespace("/member")
public class MemberAjaxAction extends ActionSupport {
}
