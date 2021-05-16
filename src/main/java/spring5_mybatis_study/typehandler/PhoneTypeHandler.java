package spring5_mybatis_study.typehandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import spring5_mybatis_study.dto.PhoneNumber;

public class PhoneTypeHandler extends BaseTypeHandler<PhoneNumber> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, PhoneNumber parameter, JdbcType jdbcType) //int 매개변수는 몇번쨰에
			throws SQLException {
		ps.setString(i, parameter.toString());// toString:countryCode, stateCode, number  db단에 이렇게 들어간다??
	}

	@Override
	public PhoneNumber getNullableResult(ResultSet rs, String columnName) throws SQLException {

		return new PhoneNumber(rs.getString(columnName)); //가져올때는 이거나 밑에껄로 둘중에 하나 가져올거
	}

	@Override
	public PhoneNumber getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return new PhoneNumber(rs.getString(columnIndex));
	}

	@Override
	public PhoneNumber getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {// 프로시저 처리쓰
		// TODO Auto-generated method stub
		return new PhoneNumber(cs.getString(columnIndex));
	}

}
