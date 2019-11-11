package com.spring.mooncy.Controller;

import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.spring.mooncy.dto.QuVO;
import com.spring.mooncy.service.QuRepService;
import com.spring.mooncy.service.QuService;

@Controller    // ���� Ŭ������ ��Ʈ�ѷ� ��(bean)���� ���

public class QuController {
    
    // �������� ���� => QuServiceImpl ����
    // IoC �������� ����
    @Inject
    QuService quService;
    @Inject
    QuRepService qurepService;
    
    // 01. �Խñ� ���
    @RequestMapping("/menu/quview")
    public ModelAndView list() throws Exception{
        List<QuVO> list = quService.listAll();
        // ModelAndView - �𵨰� ��
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/menu/quview"); // �並 list.jsp�� ����
        mav.addObject("list", list); // �����͸� ����
        return mav; // list.jsp�� List�� ���޵ȴ�.
    }
    
    // 02_01. �Խñ� �ۼ�ȭ��
    // @RequestMapping("board/write.do")
    // value="", method="���۹��"
    @RequestMapping(value="/menu/write.do", method=RequestMethod.GET)
    public String write(){
        return "/menu/quwrite"; // quwrite.jsp�� �̵�
    }
    
    // 02_02. �Խñ� �ۼ�ó��
    @RequestMapping(value="/menu/insert.do", method=RequestMethod.POST)
    public String insert(@ModelAttribute QuVO vo) throws Exception{
        quService.create(vo);
        return "redirect:/menu/quview";
    }
    
    // 03. �Խñ� �󼼳��� ��ȸ, �Խñ� ��ȸ�� ���� ó��
    // @RequestParam : get/post������� ���޵� ���� 1��
    // HttpSession ���ǰ�ü
    @RequestMapping(value="/menu/detail.do", method=RequestMethod.GET)
    public ModelAndView detail(@RequestParam int q_no, HttpSession session) throws Exception{
        // ��ȸ�� ���� ó��
   //     quService.increaseViewcnt(q_no, session);
        // ��(������)+��(ȭ��)�� �Բ� �����ϴ� ��ü
        ModelAndView mav = new ModelAndView();
        // ���� �̸�
        mav.setViewName("/menu/qudetail");
        // �信 ������ ������
        System.out.println("q"+q_no);
        mav.addObject("dto", quService.read(q_no));
        mav.addObject("dtoRep",qurepService.readRep(q_no));
        return mav;
    }
    
    // 04. �Խñ� ����
    // ������ �Է��� ������� @ModelAttribute QuVO vo�� ���޵�
    @RequestMapping(value="/menu/update.do", method=RequestMethod.POST)
    public String update(@ModelAttribute QuVO vo) throws Exception{
        quService.update(vo);
        return "redirect:/menu/quview";
    }
    
    // 05. �Խñ� ����
    @RequestMapping("/menu/delete.do")
    public String delete(@RequestParam int q_no) throws Exception{
        quService.delete(q_no);
        return "redirect:/menu/quview";
    }
    
}
 
