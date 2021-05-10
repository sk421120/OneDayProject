package com.com.food.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.com.food.model.FoodDTO;
import com.com.food.persistence.DBInfo;
import com.com.food.service.FoodService;

@WebServlet("/daily/*")
public class DailyController extends HttpServlet{
	
	protected FoodService fService;
	public FoodController() {
		fService = null;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		req.getRequestDispatcher("/WEB-INF/views/daily.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String subPath = req.getPathInfo();
		resp.setContentType("text/html;charset=UTF-8");
		if( subPath.equals("/date") ) {
			String m_date = req.getParameter("m_date");
			
			// check
			
			req.setAttribute("DAILY", subPath);
			
		} else
		// 이름으로 식품조회
		if( subPath.equals("/name") ) {
			List<FoodDTO> fdList = fService.selectByName("name");
			req.setAttribute("FOODS", fdList);
			
			req.getRequestDispatcher("/WEB-INF/views/daily.jsp").forward(req, resp);
		} else if( subPath.equals("/input")) {
			String m_date = req.getParameter("m_date");
			String f_name = req.getParameter("f_name");
		}
	}
	
	private String checkDate(String date) {
		String[] dates = date.split("-");
		Integer[] nDates = new Integer[dates.length];
		
		try {
			for(int i = 0; i < dates.length ; i++) {
				nDates[i] = Integer.valueOf(dates[i]);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			date = "YYYY-MM-DD 형식으로 입력해주세요!";
		}
		
		if(nDates[0] < 2021 || nDates[0] > 2021) {
			
		} else if( nDates[1] < 1 || nDates[1] > 12) {
			
		} else if( nDates[2] < 1 || nDates[2] > 31) {
			
		}
		
		return date;
	}
}
