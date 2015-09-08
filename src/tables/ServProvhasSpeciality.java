package tables;

import java.util.ArrayList;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.extenprise.mapp.common.DBManager;
import com.extenprise.mapp.common.DebugManager;

public class ServProvhasSpeciality {
	
	private int idServiceProvider;
	private String speciality;
	private float experience;

	
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public int getIdServiceProvider() {
		return idServiceProvider;
	}
	public void setIdServiceProvider(int idServiceProvider) {
		this.idServiceProvider = idServiceProvider;
	}
	public float getExperience() {
		return experience;
	}

	public void setExperience(float experience) {
		this.experience = experience;
	}
	public boolean save() {
		try {
			String[] insertFields = getColumnListForInsert();
			String query = "insert into Doctor_has_Speciality " + insertFields[0]
					+ " values" + insertFields[1];
			
			Object[][] params = new Object[][] { toStringArray() };
			QueryRunner run = DBManager.getQueryRunner();
			DebugManager.doAudit("Query = " + query);
			run.batch(query, params);
		} catch (Exception x) {
			x.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean update() {
		try {
			String query = "update Doctor_has_Speciality set " + getColumnListForUpdate()
			+ " where idDoctor=? and idSpeciality=?";
			
			Object[][] params = new Object[][] { toStringArray() };
			QueryRunner run = DBManager.getQueryRunner();
			DebugManager.doAudit("Query = " + query);
			run.batch(query, params);
		} catch (Exception x) {
			x.printStackTrace();
			return false;
		}
		return true;
	}
	
	public String[] getColumnListForInsert() {
		return new String[] { "(idServiceProvider,speciality,experience)", "(?,?,?)" };
	}
	
	public String getColumnListForUpdate() {
		return "idServiceProvider=?,speciality=?,experience=?";

	}
	
	public Object[] toStringArray() {
		ArrayList<String> fields = new ArrayList<String>();
		int index = 0;
		fields.add(index++, "" + idServiceProvider);
		fields.add(index++, speciality);
		fields.add(index++, "" + experience);
		return fields.toArray();
	}
	
}
