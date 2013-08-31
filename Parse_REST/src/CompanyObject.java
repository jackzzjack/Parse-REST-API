import com.google.gson.Gson;


public class CompanyObject extends CompanyAbstruct {
	
	private String _className;
	
	public public CompanyObject(String className) {
		_className = className;
	}
	
	@Override
	public String ParseTheJson(String json) {
		Gson gson = new Gson();
		gson.fromJson(json, CompanyData.class);
	}
}
