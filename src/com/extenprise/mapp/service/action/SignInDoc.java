package com.extenprise.mapp.service.action;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.codehaus.jettison.json.JSONException;
import com.extenprise.mapp.common.*;
import com.extenprise.mapp.service.form.ServiceProvider;

public class SignInDoc extends Action {

	@SuppressWarnings("deprecation")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, JSONException {
		// System.out.println("in LoginAction");
		DebugManager.doAudit("in the LoginAction of doctor");
		ServiceProvider d = null;
		String target = "failure";
		Response res = new Response();
		ServletOutputStream out = null;
		if (form != null) {
			ServiceProvider loginForm = (ServiceProvider) form;
			String loginId = loginForm.getEmailId();
			String password = loginForm.getPasswd();
			d = ServiceProvider.getDoctor(loginId, password);
			
			if(d != null) {
				target = "success";
				res.setStatus(0);
				res.setType("ServiceProvider");
				//res.setObj(d);
				res.setArray(false);
			}
			else {
				res.setStatus(1);
				res.setType(null);
				res.setArray(false);
				//res.setObj(null);				
			}
		}
		DebugManager.doAudit("target " + target);
		if(res.send(response, res)) {
			if (d != null) {
				out = response.getOutputStream();
				out.print(d.toString());
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
		/*return (mapping.findForward(target));*/
		/*response.sendRedirect(target);*/
		return null;
		
	}
	
}
