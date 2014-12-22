package com.yooli.autoloan.common.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * 安全模块的总代理,安全处理入口
 * @author Mike.Lin
 * @createDate 2014年11月3日 上午11:43:06
 * @version 2014年11月3日
 */
public class SecurityFilter implements Filter {
	
//	//安全处理器链
//	private SecurityFilterChain securityChain = null;
//	
//	public void init(FilterConfig arg0) throws ServletException {
//		securityChain = new SecurityFilterChain();
//	}
//	private static LoginController loginController;
    
    private static final Log log = LogFactory.getLog(SecurityFilter.class);
    
    public void init(FilterConfig config) throws ServletException {
//    	loginController = (LoginController)ApplicationContextHolder.getBean("loginController");
    }
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
//		//通过安全处理器链来处理用户请求
//		securityChain.doFilter(request, response);
		HttpServletResponse res = (HttpServletResponse)response;
        HttpServletRequest req = (HttpServletRequest)request;
        
        //---------------prevent browser to cache---------------------------
        res.setHeader("Pragma", "no-cache");
        res.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        res.setHeader("Expires", "-1");
        //----------------------------------------
        HttpSession session = req.getSession(false);
       // UserManagement user = session == null ? null:(UserManagement)session.getAttribute("loginUser");
        String path = req.getServletPath();
        log.debug("request-URL: " + req.getRequestURI());
        /**
         */
//        if(path.contains("/back/") && user==null ){          
//            System.err.println("由于您长时间为操作系统,为了保障您的账户安全系统SESSION自动已过期,请重新登陆!");
//            res.sendRedirect(req.getContextPath()+"/login");  
//            return; 
//        } else if (path.contains("/back/")) {
//        	if( !"0".equals(user.getUserType())){
//        		res.sendRedirect(req.getContextPath()+"/login");  
//                System.err.println("不予粗访问!");
//        	}
//        	//if(path.contains("/back/opinions")&&"A".baohan(user.getUserType()){
//        		//可以访问A权限对应的访问资源/back/opinions
//        	//}else if(path.contains("/back/dddd")&&"b".baohan(user.getUserType()){}
//        		//可以访问B权限对应的访问资源/back/dddd
//        	//else{
//        		//访问的路径和权限没有匹配，阻止继续访问
//        	//}
//
//      
//		} 
        try{
            chain.doFilter(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }  
	}

	public void destroy() {

	}


}
