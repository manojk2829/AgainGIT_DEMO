package resourses;

public enum API_resorces {
	
	add_Place_API("maps/api/place/add/json"),
	get_Place_API("maps/api/place/get/json"),
	delete_Place_API("maps/api/place/delete/json");
	
	private String resource;
	
	 API_resorces(String resource){
		this.resource=resource;
	}
	
	public String getResorce(){
		return resource;
	}
}
