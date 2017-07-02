package cn.it.shop.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserFilter implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		if(req.getSession().getAttribute("user") == null){
			//���浱ǰ�ͻ���Ҫȥ��url��ַ
			String goURL = req.getServletPath();
			String param = req.getQueryString();
			if(param!=null){
				goURL = goURL + "?" + param;
			}
			req.getSession().setAttribute("goURL", goURL);
			req.getSession().setAttribute("error", "�Ƿ�����");
			res.sendRedirect(req.getContextPath() + "/ulogin.jsp");
		}else{
			//�������һ������������ת������ֱ�ӵ�Ŀ��ҳ��
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
