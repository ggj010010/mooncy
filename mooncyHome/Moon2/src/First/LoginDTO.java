package First;

public class LoginDTO {
	String m_id="";
	String m_pw="";
	String m_name="";
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_pw() {
		return m_pw;
	}
	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	@Override
	public String toString() {
	   return "DTO [  m_name=" + m_id + ", m_pw=" + m_pw + ", m_name=" + m_name + "]";
	}
}
