package cookatz.employee.bean;

public class Employee {
	private String id ;
	private String password ;
	private String name ;
	private String birth1 ;
	private String birth2 ;
	private String birth3 ;
	private String gender ;
	private String phone ;
	private String email ;
	private int zipcode;
	private String address1 ;
	private String address2 ;
	private int mpoint ;
	
	
	

	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", password=" + password + ", name=" + name + ", birth1=" + birth1 + ", birth2="
				+ birth2 + ", birth3=" + birth3 + ", gender=" + gender + ", phone=" + phone + ", email=" + email
				+ ", zipcode=" + zipcode + ", address1=" + address1 + ", address2=" + address2 + ", mpoint=" + mpoint
				+ "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getBirth1() {
		return birth1;
	}

	public void setBirth1(String birth1) {
		this.birth1 = birth1;
	}

	public String getBirth2() {
		return birth2;
	}

	public void setBirth2(String birth2) {
		this.birth2 = birth2;
	}

	public String getBirth3() {
		return birth3;
	}

	public void setBirth3(String birth3) {
		this.birth3 = birth3;
	}

	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public int getMpoint() {
		return mpoint;
	}
	public void setMpoint(int mpoint) {
		this.mpoint = mpoint;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	
}
