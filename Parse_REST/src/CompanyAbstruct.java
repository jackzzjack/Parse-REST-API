import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public abstract class CompanyAbstruct {
	
	private String className;
	
	public CompanyAbstruct(String className) {
		this.className = className;
	}
	
	public void connect() {
		URL url = null;
		try {
			url = new URL("https://api.parse.com/1/classes/"+className);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		HttpURLConnection con = null;
		try {
			con = (HttpURLConnection) url.openConnection();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		con.addRequestProperty("X-Parse-Application-Id", "Oqq1RXS7CJcpjp1fi0FZHnvvw3kFGwXZ4OiZw0CS");
		con.addRequestProperty("X-Parse-REST-API-Key", "OXtLiBTVSl1eYWPTgi5FWL8FyIN82O66mVfEcwve");
		con.setDoInput(true);
		try {
			con.setRequestMethod("GET");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}
		try {
			con.connect();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			if (con.getResponseCode() == 200) {
				BufferedReader BR = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String tmp = "";
				while ((tmp=BR.readLine()) != null) {
					System.out.println(tmp);
				}
			} else {
				BufferedReader BRerror = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				String tmp = "";
				while ((tmp=BRerror.readLine()) != null) {
					System.out.println(tmp);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public abstract String ParseTheJson(String json);
}