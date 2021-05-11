package com.com.food.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.com.food.model.FoodDTO;
import com.com.food.model.MyFoodsVO;
import com.com.food.service.DailyService;
import com.com.food.service.FoodService;
import com.com.food.service.impl.dailyServiceImplV1;
import com.com.food.service.impl.foodServiceImplV1;

@WebServlet("/insert/*")
public class InsertController extends HttpServlet {

	protected FoodService fService;
	protected DailyService dService;

	public InsertController() {
		fService = new foodServiceImplV1();
		dService = new dailyServiceImplV1();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		String code = req.getParameter("code");
		String date = req.getParameter("date");

		FoodDTO foodDTO = fService.selectByCode(code);
		String f_name = foodDTO.getF_name();
		req.setAttribute("DATE", date);
		req.setAttribute("NAME", f_name);
		req.setAttribute("RESULT", "섭취량은 0 이상 입력해주세요!");
		req.getRequestDispatcher("/WEB-INF/views/insert.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=UTF-8");
		req.setCharacterEncoding("UTF-8");

		String m_date = req.getParameter("m_date");
		String m_fname = req.getParameter("m_fname");
		String m_intake = req.getParameter("m_intake");
		String result = "섭취량은 0 이상 입력해주세요!";

		if (m_intake == null || m_intake.equals("")) {
			result = "섭취량을 입력해주세요!";
			req.setAttribute("DATE", m_date);
			req.setAttribute("NAME", m_fname);
			req.setAttribute("RESULT", result);
			req.getRequestDispatcher("/WEB-INF/views/insert.jsp").forward(req, resp);
		} else {
			Integer intake = checkIntake(m_intake);
			if (intake == null) {
				req.setAttribute("DATE", m_date);
				req.setAttribute("NAME", m_fname);
				req.setAttribute("RESULT", result);
				req.getRequestDispatcher("/WEB-INF/views/insert.jsp").forward(req, resp);
			}
			if (intake != null) {
				MyFoodsVO mfVO = new MyFoodsVO();
				mfVO.setM_date(m_date);
				mfVO.setM_fcode(fService.selectByName(m_fname).get(0).getF_code());
				mfVO.setM_intake(intake);
				int insertR = dService.insert(mfVO);
				if(insertR > 0) {
					resp.sendRedirect("/myfood");
				} else {
					result = "일일섭취 추가 실패";
					req.setAttribute("DATE", m_date);
					req.setAttribute("NAME", m_fname);
					req.setAttribute("RESULT", result);
					req.getRequestDispatcher("/WEB-INF/views/insert.jsp").forward(req, resp);
				}
			}
		}
		

		
	}

	private Integer checkIntake(String m_intake) {
		Integer nIntake = 0;
		try {
			nIntake = Integer.valueOf(m_intake);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			nIntake = null;
		}

		if (nIntake < 1 || nIntake > 50) {
			nIntake = null;
		}
		return nIntake;
	}
}