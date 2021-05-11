package com.com.food.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.com.food.model.DailyFoodDTO;
import com.com.food.model.MyFoodsVO;
import com.com.food.persistence.DBContract;
import com.com.food.persistence.DBInfo;
import com.com.food.service.DailyService;

public class dailyServiceImplV1 implements DailyService {

	protected Connection dbConn;
	
	public dailyServiceImplV1() {
		dbConn = DBContract.getDBConnection();
	}
	
	protected List<DailyFoodDTO> select(PreparedStatement pStr) throws SQLException {
		List<DailyFoodDTO> dfList = new ArrayList<DailyFoodDTO>();
		ResultSet rStr = pStr.executeQuery();
		
		while(rStr.next()) {
			
			DailyFoodDTO dfDTO = new DailyFoodDTO();
			dfDTO.setM_seq(rStr.getInt(DBInfo.DAILYFOOD.m_seq));
			dfDTO.setM_date(rStr.getString(DBInfo.DAILYFOOD.m_date));
			dfDTO.setF_name(rStr.getString(DBInfo.DAILYFOOD.f_name));
			dfDTO.setM_intake(rStr.getInt(DBInfo.DAILYFOOD.m_intake));
			dfDTO.setF_cap(rStr.getInt(DBInfo.DAILYFOOD.f_cap));
			dfDTO.setF_energy(rStr.getInt(DBInfo.DAILYFOOD.f_energy));
			dfDTO.setF_protein(rStr.getInt(DBInfo.DAILYFOOD.f_protein));
			dfDTO.setF_fat(rStr.getInt(DBInfo.DAILYFOOD.f_fat));
			dfDTO.setF_carbo(rStr.getInt(DBInfo.DAILYFOOD.f_carbo));
			dfDTO.setF_sugar(rStr.getInt(DBInfo.DAILYFOOD.f_sugar));

			dfList.add(dfDTO);
		}
		rStr.close();
		return dfList;
	}
	
	@Override
	public List<DailyFoodDTO> selectAll() {
		// TODO 일일섭취 전체 리스트
		
		String sql = " SELECT * FROM view_일일섭취 ";
		sql += " ORDER BY ";
		sql += DBInfo.DAILYFOOD.m_seq;
		
		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);

			List<DailyFoodDTO> dfList = this.select(pStr);
			
			pStr.close();
			
			return dfList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public DailyFoodDTO selectBySeq(int m_seq) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DailyFoodDTO> selectByDate(String m_date) {
		// TODO 일일섭취 날짜로 조회
		String sql = " SELECT * FROM view_일일섭취 ";
		sql += " WHERE 날짜 = ? ";

		PreparedStatement pStr = null;

		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, m_date);

			List<DailyFoodDTO> dfList = this.select(pStr);
			pStr.close();
			return dfList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public int insert(MyFoodsVO mfVO) {
		// TODO myfood에 추가
		String sql = " INSERT INTO tbl_myfoods ";
		sql += "( m_seq, m_date, m_fcode, m_intake )";
		sql += " VALUES(seq_myfoods.NEXTVAL, ?, ?, ? ) ";
		
		System.out.println(sql);
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, mfVO.getM_date() );
			pStr.setString(2, mfVO.getM_fcode() );
			pStr.setInt(3, mfVO.getM_intake());

			int result = pStr.executeUpdate();
			pStr.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
	
}
