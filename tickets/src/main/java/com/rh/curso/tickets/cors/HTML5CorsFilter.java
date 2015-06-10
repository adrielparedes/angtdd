package com.rh.curso.tickets.cors;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(filterName = "cors-filter", urlPatterns = { "/*" })
public class HTML5CorsFilter implements javax.servlet.Filter {

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		this.corsHeaders(res);
		chain.doFilter(req, res);
		this.corsHeaders(res);

	}

	private void corsHeaders(HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader(
				"Access-Control-Allow-Headers",
				"Overwrite , Destination , Content-Type , Depth , "
						+ "User-Agent , X-File-Size , X-Requested-With , If-Modified-Since , "
						+ "X-File-Name , Cache-Control , email , accept , "
						+ "Authorization , version , operation , username");
		response.setHeader("Access-Control-Allow-Methods",
				"GET , POST , OPTIONS , HEAD , UPDATE , PUT , DELETE");
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}