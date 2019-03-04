package com.sunfy;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

/**
 * 简单过虑器
 */
public class SimpleFilter extends ZuulFilter{

	/**
	 * 前置过滤
	 */
	public String filterType() {
		return "pre";
	}

	/**
	 * 过滤执行顺序（越小越靠前）
	 */
	public int filterOrder() {
		return 1;
	}

	/**
	 * 是否执行过滤
	 */
	public boolean shouldFilter() {
		return true;
	}

	/**
	 * 包含过滤器功能
	 */
	public Object run() throws ZuulException {
		// 获得当前上下文，存放请求和状态信息
		RequestContext ctx = RequestContext.getCurrentContext() ;
		HttpServletRequest request = ctx.getRequest();
		// 获取方法名称
		String method = request.getMethod();
		// 获取url地址
		String url = request.getRequestURL().toString() ;
		// 输出谁在请求这个地址（格式化）
		System.out.printf("%s request to %s\r\n" , method , url);
		return null;
	}
}
