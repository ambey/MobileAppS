package com.extenprise.mapp.common;

import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.extenprise.mapp.customer.form.Customer;
import com.extenprise.mapp.customer.form.Patient;
import com.extenprise.mapp.service.form.ServiceProvider;
import com.google.gson.Gson;

public class Response {
	
	private int status;
	private String type;
	private boolean array;
	
	/*private Object obj;*/
	

	public String getType() {
		return type;
	}
	
	public boolean isArray() {
		return array;
	}

	public void setArray(boolean array) {
		this.array = array;
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public void setType(String type) {
		this.type = type;
	}

	public boolean send(HttpServletResponse response, Response res) {
		
		DebugManager.doAudit("in the Response.send()");
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		/*PrintWriter out = response.getWriter()*/;
		ServletOutputStream out = null;
		try {
			
			out = response.getOutputStream();
			Gson gson = new Gson();
			String js = gson.toJson(res);
			JSONObject json = new JSONObject(js);
			out.print(json.toString());
			DebugManager.doAudit("Response object sent.");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally {
			try {
				out.flush();
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}
}
