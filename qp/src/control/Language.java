package control;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class Language extends TagSupport{
	private String key;

	public void setKey(String key) {
		this.key = key;
	}

	public String getKey() {
		return key;
	}
	@Override
	public int doEndTag() throws JspException {
		HttpSession session=pageContext.getSession();
		JspWriter out=pageContext.getOut();
		ResourceBundle rb=(ResourceBundle)session.getAttribute("rb");
		try{out.println(rb.getObject(key).toString());
			}catch(Exception e){e.printStackTrace();}
		return 1;
	}
}
