package com.extenprise.mapp.customer.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.codehaus.jettison.json.JSONException;

import com.extenprise.mapp.common.*;
import com.extenprise.mapp.customer.form.Patient;
import com.extenprise.mapp.service.form.ServiceProvider;

public class SignInPatient extends Action {

	
	@SuppressWarnings("deprecation")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, JSONException {
		// System.out.println("in LoginAction");
		DebugManager.doAudit("in the LoginAction of Patient");
		ServletOutputStream out = null;
		Patient p = null;
		String target = "failure";
		Response res = new Response();
		if (form != null) {
			Patient loginForm = (Patient) form;
			String loginId = loginForm.getEmailId();
			String password = loginForm.getPasswd();
			p = Patient.getPatient(loginId, password);
			
			if(p != null) {
				target = "success";
				res.setStatus(0);
				res.setType("Patient");
				res.setArray(false);
				
			}
			else {
				res.setStatus(1);
				res.setType(null);
				res.setArray(false);
			}
		}
		DebugManager.doAudit("target " + target);
		if(res.send(response, res)) {
			if (p != null) {
				out = response.getOutputStream();
				out.print(p.toString());
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
		/*return (mapping.findForward(target));*/
		/*response.sendRedirect(target);*/
		return null;
		
	}
	
	
	/*@SuppressWarnings("deprecation")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// System.out.println("in LoginAction");
		DebugManager.doAudit("in the LoginAction of Patient");
		String target = "failure";
		Response res = new Response();
		HttpSession session = request.getSession(true);
		ActionErrors errors = new ActionErrors();
		Customer p = null;
		if (form != null) {
			Patient loginForm = (Patient) form;
			String loginId = loginForm.getEmailId();
			String password = loginForm.getPasswd();
			p = Customer.getCustomer(loginId, password);
			
			if(p != null) {
				target = "success";
				request.setAttribute("message", loginForm.getfName());
			}
			else {
				errors.add("login.invalid", new ActionError("login.invalid"));
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

		res.sendPatient(response);
		response.sendRedirect(target);
		return null;
		return (mapping.findForward(target));

	}*/
	
}
