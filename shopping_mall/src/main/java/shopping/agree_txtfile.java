package shopping;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.servlet.http.HttpServletRequest;

public class agree_txtfile {

	private String url = "";
	
	public agree_txtfile(HttpServletRequest req, String filename, String ftext) throws Exception {
		this.url = req.getServletContext().getRealPath("/resources/");
		Files.write(Paths.get(url + filename + "_agree.txt"), ftext.getBytes(), StandardOpenOption.WRITE);
	}
}
