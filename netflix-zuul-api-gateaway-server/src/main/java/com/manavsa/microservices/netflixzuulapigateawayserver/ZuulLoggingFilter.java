package com.manavsa.microservices.netflixzuulapigateawayserver;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component // FTW this should always be there
public class ZuulLoggingFilter extends ZuulFilter {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public Object run() throws ZuulException {
		
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest req = context.getRequest();
		log.info("REQUEST - {} request uri - {}",req, req.getRequestURI());
		
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}
