package com.com.food.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.com.food.model.FoodDTO;
import com.com.food.persistence.DBInfo;
import com.com.food.service.FoodService;
import com.com.food.service.impl.foodServiceImplV1;

@WebServlet("/daily/*")
public class DailyController extends HttpServlet {

	protected FoodService fService;

	public DailyController() {
		fService = new foodServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=UTF-8");
		
		String date = "0000-00-00";
		req.setAttribute("DATE", date);

		req.getRequestDispatcher("/WEB-INF/views/daily.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		String m_date = req.getParameter("m_date");
		String f_name = req.getParameter("f_name");
		String result = "날짜는 YYYY-MM-DD 형식으로 입력해주세요!";

		if (f_name == null || m_date == null || f_name.equals("") || m_date.equals("")) {
			result = "값을 입력해주세요!";
		} else if (checkDate(m_date)) {
			List<FoodDTO> fdList = fService.selectByName(f_name);
			if (fdList.size() > 0 && fdList != null) {
				req.setAttribute("FOODS", fdList);
				result = " ";
			} else {
				result = "식품 조회 정보가 없습니다.";
			}
		}

		req.setAttribute("RESULT", result);
		req.setAttribute("DATE", m_date);
		req.setAttribute("NAME", f_name);
		req.getRequestDispatcher("/WEB-INF/views/daily.jsp").forward(req, resp);

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
