package shopping_admin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class files_delete {

	public files_delete(HttpServletRequest req, product_module pdmd, int del_ck[]) throws Exception {
		List<String> flist = pdmd.img_select(del_ck);
		List<String> data = new ArrayList<String>();
		int n = 0, w;
		do {
			String namearr[] = flist.get(n).split("\\|");
			w = 1;
			do {
				data.add(namearr[w]);
				w += 2;
			} while (w < namearr.length);
			n++;
		} while (n < flist.size());
		this.del_execute(req, data, "/product_img/");
	}
	
	private void del_execute(HttpServletRequest req, List<String> files, String foldername) throws Exception {
		String furl = req.getServletContext().getRealPath(foldername);
		File f = null;
		int n = 0;
		do {
			f = new File(furl + files.get(n));
			f.delete();
			n++;
		} while(n < files.size());
	}
}
