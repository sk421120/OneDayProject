package com.com.food.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.com.food.model.DailyFoodDTO;
import com.com.food.model.FoodDTO;
import com.com.food.service.DailyService;
import com.com.food.service.impl.dailyServiceImplV1;

@WebServlet("/date/*")
public class DateController extends HttpServlet {
	
	DailyService dService;
	
	public DateController() {
		dService = new dailyServiceImplV1();
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 처음화면 get
		String date = "0000-00-00";
		req.setAttribute("DATE", date);
		
		req.getRequestDispatcher("/WEB-INF/views/date.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		String m_date = req.getParameter("m_date");
		String result = "날짜는 YYYY-MM-DD 형식으로 입력해주세요!";
		if ( m_date == null || m_date.equals("")) {
			result = "값을 입력해주세요!";
		} else if (checkDate(m_date)) {
			List<DailyFoodDTO> dfList = dService.selectByDate(m_date);
			
			if (dfList.size() > 0 && dfList != null) {
				req.setAttribute("DAILYS", dfList);
				result = " ";
			} else {
				result = "날짜 조회 정보가 없습니다.";
			}
		}

		req.setAttribute("RESULT", result);
		req.setAttribute("DATE", m_date);
		req.getRequestDispatcher("/WEB-INF/views/date.jsp").forward(req, resp);
	}
	
	private boolean checkDate(String date) {
		String[] dates = date.split("-");
		Integer[] nDates = new Integer[dates.length];
		boolean result = true;

		try {
			for (int i = 0; i < dates.length; i++) {
				nDates[i] = Integer.valueOf(dates[i]);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			result = false;
		}

		if (nDates[0] < 2021 || nDates[0] > 2021 || nDates[1] < 1 || nDates[1] > 12 || nDates[2] < 1
				|| nDates[2] > 31) {
			result = false;
		}

		return result;
	}
}
