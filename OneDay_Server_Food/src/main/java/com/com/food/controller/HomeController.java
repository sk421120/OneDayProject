package com.com.food.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.com.food.model.DailyFoodDTO;
import com.com.food.service.DailyService;
import com.com.food.service.impl.dailyServiceImplV1;

@WebServlet("/")
public class HomeController extends HttpServlet {

	DailyService dService;
	public HomeController() {
		dService = new dailyServiceImplV1();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 처음화면 get
		String date = "0000-00-00";
		req.setAttribute("DATE", date);
		
		List<DailyFoodDTO> dfList = dService.selectAll();
		req.setAttribute("DAILYS", dfList);
		req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
		
	}
	
}
