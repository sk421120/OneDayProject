package com.com.food.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.com.food.model.FoodDTO;
import com.com.food.persistence.DBContract;
import com.com.food.persistence.DBInfo;
import com.com.food.service.FoodService;

public class foodServiceImplV1 implements FoodService {

	protected Connection dbConn;
	
	public foodServiceImplV1() {
		dbConn = DBContract.getDBConnection();
	}
	
	protected List<FoodDTO> select(PreparedStatement pStr) throws SQLException {
		List<FoodDTO> foodList = new ArrayList<FoodDTO>();
		ResultSet rStr = pStr.executeQuery();
		
		while(rStr.next()) {
			
			FoodDTO foodDTO = new FoodDTO();
			foodDTO.setF_code(rStr.getString(DBInfo.FOODS.f_code));
			foodDTO.setF_name(rStr.getString(DBInfo.FOODS.f_name));
			foodDTO.setF_date(rStr.getInt(DBInfo.FOODS.f_date));
			foodDTO.setF_ccode(rStr.getString(DBInfo.FOODS.f_ccode));
			foodDTO.setF_icode(rStr.getString(DBInfo.FOODS.f_icode));
			foodDTO.setF_serv(rStr.getInt(DBInfo.FOODS.f_serv));
			foodDTO.setF_cap(rStr.getInt(DBInfo.FOODS.f_cap));
			foodDTO.setF_energy(rStr.getInt(DBInfo.FOODS.f_energy));
			foodDTO.setF_protein(rStr.getInt(DBInfo.FOODS.f_protein));
			foodDTO.setF_fat(rStr.getInt(DBInfo.FOODS.f_fat));
			foodDTO.setF_carbo(rStr.getInt(DBInfo.FOODS.f_carbo));
			foodDTO.setF_sugar(rStr.getInt(DBInfo.FOODS.f_sugar));
			System.out.println(foodDTO.toString());
			foodList.add(foodDTO);
		}
		rStr.close();
		return foodList;
	}
	
	@Override
	public List<FoodDTO> selectAll() {
		// TODO Auto-generated method stub
		String sql = " SELECT * FROM view_식품정보 ";
		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);

			List<FoodDTO> foodList = this.select(pStr);
			
			pStr.close();
			
			return foodList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public FoodDTO selectByCode(String f_code) {
		// TODO 식품목록 코드 조회
		String sql = " SELECT * FROM view_식품정보 ";
		sql += " WHERE ";
		sql += DBInfo.FOODS.f_code;
		sql += " = ? ";
		
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, f_code.trim());
			
			List<FoodDTO> foodList = this.select(pStr);
			if( foodList != null && foodList.size() > 0) {
				pStr.close();
				return foodList.get(0);	
			}
			pStr.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<FoodDTO> selectByName(String f_name) {
		// TODO 식품목록 이름 조회
		String sql = " SELECT * FROM view_식품정보 ";
		sql += " WHERE ";
		sql += DBInfo.FOODS.f_name;
		sql += " LIKE '%' || ? || '%' ";
		
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, f_name.trim());

			List<FoodDTO> foodList = this.select(pStr);
			pStr.close();
			return foodList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
