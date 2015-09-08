package com.extenprise.mapp.service.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.extenprise.mapp.common.*;
import com.extenprise.mapp.service.form.ServiceProvider;


public class SignUpDoc extends Action {
	
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, NamingException, IOException {
		DebugManager.doAudit("in the signUpDoctor");
		String target = "failure", query = "";
		Response res = new Response();
		ServiceProvider c1 = null;
		int stat = 1;
		ServletOutputStream out = null;

		if (form != null) {
			ServiceProvider c = (ServiceProvider) form;
			
			if (c != null) {
				c1 = ServiceProvider.getDoctor(c.getEmailId());
				/*DoctorHasClinic clinic = c.getClinic();
				ServProvHasSpeciality speciality = c.getSpeciality();*/
				
				if (c1 != null) {
					DebugManager.doAudit("Updating Doctor " + target);
					query = "update ServiceProvider set " + c.getColumnListForUpdate()
							+ " where loginID=?";
					//res.setObj(c1);
					
				}
				else {
					String[] insertFields = c.getColumnListForInsert();
					query = "insert into ServiceProvider " + insertFields[0]
							+ " values" + insertFields[1];
					//res.setObj(c);

				}
				Object[][] params = new Object[][] { c.toStringArray() };
				QueryRunner run = DBManager.getQueryRunner();
				DebugManager.doAudit("Query = " + query);
				int[] i = run.batch(query, params);
				if(i.length != 0) {
					target = "success";
					stat = 0;
				}else {
					stat = 1;
				}
			}
		}
		DebugManager.doAudit("target " + target);
		/*response.sendRedirect(target);*/
		res.setStatus(stat);
		res.setType("ServiceProvider");
		if(res.send(response, res)) {
			if (c1 != null) {
				out = response.getOutputStream();
				out.print(c1.toString());
				DebugManager.doAudit("Doctor object sent.");
				try {
					out.flush();
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		return null;

	}
	
	
	/*public ActionForward saveRecord(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		DebugManager.doAudit("in the signUpDoctor");
		String target = "failure";
		HttpSession session = request.getSession(true);
		ActionErrors errors = new ActionErrors();
		if (form != null) {
			Doctor c = (Doctor) form;
			
			if (c != null) {
				Doctor c1 = c.getDoctor(c.getEmailId());
				String[] insertFields = c.getColumnListForInsert();
				String query = "insert into Doctor " + insertFields[0]
						+ " values" + insertFields[1];
				if (c1 != null) {
					query = "update Doctor set " + c.getColumnListForUpdate()
							+ " where loginID=?";
				}
				Object[][] params = new Object[][] { c.toStringArray() };
				QueryRunner run = DBManager.getQueryRunner();
				DebugManager.doAudit("Query = " + query);
				run.batch(query, params);		
			}
			try {
				
				DebugManager.doAudit("target " + target);
			} catch (Exception e) {
				DebugManager.doLog("LoginAction", e);
			}
		}
		if(! errors.isEmpty()) {
			saveErrors(request, errors);
		}

		return (mapping.findForward(target));
	}*/
}
