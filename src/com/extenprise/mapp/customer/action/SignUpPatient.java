package com.extenprise.mapp.customer.action;

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
import com.extenprise.mapp.customer.form.Patient;
import com.extenprise.mapp.service.*;


public class SignUpPatient extends Action {
	
	
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, NamingException, IOException {
		DebugManager.doAudit("in the signUpPatient");
		String target = "failure", query = "", status = "";
		int stat = 1;
		Response res = new Response();
		ServletOutputStream out = null;
		Patient c1 = null;

		if (form != null) {
			Patient c = (Patient) form;
			
			if (c != null) {
				c1 = Patient.getPatient(c.getEmailId());
				if (c1 != null) {
					status = "update";
					DebugManager.doAudit("Updating Patient " + target);
					query = "update Customer set " + c.getColumnListForUpdate()
							+ " where loginID=?";
					
				}
				else {
					status = "save";
					String[] insertFields = c.getColumnListForInsert();
					query = "insert into Customer " + insertFields[0]
							+ " values" + insertFields[1];
				}
				Object[][] params = new Object[][] { c.toStringArray() };
				QueryRunner run = DBManager.getQueryRunner();
				DebugManager.doAudit("Query = " + query);
				int[] i = run.batch(query, params);
				if(i.length != 0) {
					target = "success";
					stat = 0;
					if(status.equals("save")) {
						c.save();
					} else {
						c.update();
					}
				} else {
					stat = 1;
				}
			}
		}
		DebugManager.doAudit("target " + target);
		/*response.sendRedirect(target);*/
		res.setStatus(stat);
		res.setType("Patient");
		if(res.send(response, res)) {
			if (c1 != null) {
				out = response.getOutputStream();
				out.print(c1.toString());
				DebugManager.doAudit("Patient object sent.");
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
		
		DebugManager.doAudit("in the signUpPatient");
		String target = "failure", query = "";
		HttpSession session = request.getSession(true);
		ActionErrors errors = new ActionErrors();
		if (form != null) {
			Patient p = (Patient) form;
			
			if (p != null) {
				Customer c1 = p.getCustomer(p.getEmailId());
				
				if (c1 != null) {
					query = "update Customer set " + p.getColumnListForUpdate()
							+ " where loginID=?";
					p.update();
				} else {
					String[] insertFields = p.getColumnListForInsert();
					query = "insert into Customer " + insertFields[0]
							+ " values" + insertFields[1];
				}
				p.save();
				Object[][] params = new Object[][] { p.toStringArray() };
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
