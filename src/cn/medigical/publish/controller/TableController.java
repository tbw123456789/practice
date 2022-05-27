package cn.medigical.publish.controller;

import cn.medigical.publish.dao.impl.PatientLinkDao;
import cn.medigical.publish.pojo.patientLink.AnesthesiaRecord;
import cn.medigical.publish.pojo.patientLink.PatientLink;
import cn.medigical.publish.utils.Constants;
import cn.medigical.publish.utils.SpringUtils;
import cn.medigical.publish.utils.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

@Controller
@RequestMapping("TableController")
public class TableController {

    PatientLinkDao patientLinkDao = SpringUtils.getBean(PatientLinkDao.class);

    /**
     * 直接返回 -1 未查到该病人，返回 -2 没有该表单，返回 -3 参数异常
     * @param type
     * @param id
     * @param response
     * @throws Exception
     */
    @RequestMapping(value = "index/{type}/{id}", method = RequestMethod.POST)
    public void index(@PathVariable("type") String type, @PathVariable("id") String id, HttpServletResponse response) throws Exception {
        if(StringUtil.isEmpty(type)||StringUtil.isEmpty(id)){
            response.getOutputStream().write("-3".getBytes());
        }
        response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition", "attachment;fileName=test.pdf");
        PatientLink patientLink = patientLinkDao.getPatientLinkBySssqdh(id);
        if(patientLink == null) {
            patientLink = patientLinkDao.getPatientLinkforZyh(id);
            if(patientLink == null){
                response.getOutputStream().write("-1".getBytes());
                return;
            }
        }
        Map<String,byte[]> stringMap = patientLink.getEmrPngMap();
        if(stringMap == null) {
            response.getOutputStream().write("-2".getBytes());
            return;
        }
        byte[] data;
        switch (type){
            case Constants.PDF_ANESTABLE:
                data = stringMap.get(Constants.PDF_ANESTABLE);
                if(data == null){
                    response.getOutputStream().write("-2".getBytes());
                }else {
                    response.getOutputStream().write(data);
                }
                break;
            case Constants.PDF_PACUTABLE:
                data = stringMap.get(Constants.PDF_PACUTABLE);
                if(data == null){
                    response.getOutputStream().write("-2".getBytes());
                }else {
                    response.getOutputStream().write(data);
                }
                break;
            default:
                response.getOutputStream().write("-3".getBytes());
                break;
        }
    }

    @RequestMapping(value = "table", method = RequestMethod.GET)
    public String table(Model m,String type,String id, HttpServletRequest request,HttpServletResponse response){
        m.addAttribute("type",type);
        m.addAttribute("id",id);
        RequestDispatcher requestDispatcher;
        switch (type){
            case Constants.PDF_SHUQIANFANGSHITABLE:
                requestDispatcher = request.getRequestDispatcher("/hezhouyiyan/shuqianfangshi.do?sssqdh="+id+"&zyh="+id);
                try {
                    requestDispatcher.forward(request,response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
                break;
            case Constants.PDF_SHUHOUFANGSHITABLE:
                requestDispatcher = request.getRequestDispatcher("/hezhouyiyan/shuhousuifang.do?sssqdh="+id+"&zyh="+id);
                try {
                    requestDispatcher.forward(request,response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
                break;
            case Constants.PDF_MAZUIJINGGUOTABLE:
                requestDispatcher = request.getRequestDispatcher("/hezhouyiyan/mazuijinguo.do?sssqdh="+id+"&zyh="+id);
                try {
                    requestDispatcher.forward(request,response);
                } catch (ServletException | IOException e) {
                    e.printStackTrace();
                }
                break;
            case Constants.PDF_ANESTABLE:
            case Constants.PDF_PACUTABLE:
            default:
                break;
        }
        return "table/table";
    }

}
