package kr.ac.kopo.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 무조건 모두 다 Controller를 상속받아 사용하겠다
public interface Controller {
	String handleRequest(HttpServletRequest request, HttpServletResponse response)throws Exception;
}
