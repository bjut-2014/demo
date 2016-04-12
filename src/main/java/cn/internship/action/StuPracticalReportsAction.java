package cn.internship.action;

import cn.internship.entity.PracticalReports;
import cn.internship.entity.Student;
import cn.internship.service.PracticalReportsService;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

/**
 * 实训报告页面
 * @author dreamlate
 *
 */
public class StuPracticalReportsAction extends ActionSupport implements ServletRequestAware, ServletResponseAware {
    private HttpServletRequest request;
    private HttpServletResponse response;

    private PracticalReportsService practicalReportsService;

    private String addTitle;
    private String addContent;

    private Integer deleteId;

    private Integer practicalReportsId;

    private String updateTitle;
    private Integer updateId;
    private String updateContent;

    @Override
    public String execute() throws Exception {
        Student student = (Student) request.getSession().getAttribute("currentUser");
        List<PracticalReports> list = practicalReportsService.getAll(student.getStudentId());
        request.setAttribute("practicalreports", list);

        return super.execute();
    }

    //获得某一条实训报告
    public String getOnePracticalreport() {
        PracticalReports onePracticalReport = practicalReportsService.get(practicalReportsId);
        request.setAttribute("onePracticalreport", onePracticalReport);

        return SUCCESS;
    }

    public String get() throws Exception {
        PracticalReports onePracticalReport = practicalReportsService.get(practicalReportsId);
        JSONObject jo = new JSONObject();

        jo.put("id", onePracticalReport.getId());
        jo.put("practicalReportsTitle", onePracticalReport.getPracticalReportsTitle());
        jo.put("practicalReportsContent", onePracticalReport.getPracticalReportsContent());
        jo.put("practicalReportsDate", onePracticalReport.getPracticalReportsDate());

        try {
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            out.println(jo);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public String add(){
        Student student = (Student) request.getSession().getAttribute("currentUser");

        PracticalReports practicalReports = new PracticalReports();
        practicalReports.setStudentId(student.getStudentId());
        practicalReports.setPracticalReportsTitle(addTitle);
        practicalReports.setPracticalReportsContent(addContent);
        practicalReports.setPracticalReportsDate(new Date(new java.util.Date().getTime()));
        practicalReportsService.save(practicalReports);

        return SUCCESS;
    }

    public String delete(){
        practicalReportsService.delete(deleteId);

        return SUCCESS;
    }

    public String update(){
        PracticalReports practicalReports = practicalReportsService.get(updateId);
        JSONObject jo = new JSONObject();

        practicalReports.setPracticalReportsTitle(updateTitle);
        practicalReports.setPracticalReportsContent(updateContent);
        practicalReports.setPracticalReportsDate(new Date(new java.util.Date().getTime()));
        practicalReportsService.update(practicalReports);

        try {
            response.setCharacterEncoding("utf-8");
            PrintWriter out = response.getWriter();
            out.println(jo);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return SUCCESS;
    }

    //-------------------------------------get与set方法-----------------------------------------------------------
    
    public void setServletResponse(HttpServletResponse response) {
        this.response = response;
    }

    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

	public PracticalReportsService getPracticalReportsService() {
		return practicalReportsService;
	}

	public void setPracticalReportsService(PracticalReportsService practicalReportsService) {
		this.practicalReportsService = practicalReportsService;
	}

	public String getAddTitle() {
		return addTitle;
	}

	public void setAddTitle(String addTitle) {
		this.addTitle = addTitle;
	}

	public String getAddContent() {
		return addContent;
	}

	public void setAddContent(String addContent) {
		this.addContent = addContent;
	}

	public Integer getDeleteId() {
		return deleteId;
	}

	public void setDeleteId(Integer deleteId) {
		this.deleteId = deleteId;
	}

	public String getUpdateTitle() {
		return updateTitle;
	}

	public void setUpdateTitle(String updateTitle) {
		this.updateTitle = updateTitle;
	}

	public Integer getUpdateId() {
		return updateId;
	}

	public void setUpdateId(Integer updateId) {
		this.updateId = updateId;
	}

	public String getUpdateContent() {
		return updateContent;
	}

	public void setUpdateContent(String updateContent) {
		this.updateContent = updateContent;
	}

    public Integer getPracticalReportsId() {
        return practicalReportsId;
    }

    public void setPracticalReportsId(Integer practicalReportsId) {
        this.practicalReportsId = practicalReportsId;
    }
}
