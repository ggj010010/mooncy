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

@Controller    // 현재 클래스를 컨트롤러 빈(bean)으로 등록

public class QuController {
    
    // 의존관계 주입 => QuServiceImpl 생성
    // IoC 의존관계 역전
    @Inject
    QuService quService;
    @Inject
    QuRepService qurepService;
    
    // 01. 게시글 목록
    @RequestMapping("/menu/quview")
    public ModelAndView list() throws Exception{
        List<QuVO> list = quService.listAll();
        // ModelAndView - 모델과 뷰
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/menu/quview"); // 뷰를 list.jsp로 설정
        mav.addObject("list", list); // 데이터를 저장
        return mav; // list.jsp로 List가 전달된다.
    }
    
    // 02_01. 게시글 작성화면
    // @RequestMapping("board/write.do")
    // value="", method="전송방식"
    @RequestMapping(value="/menu/write.do", method=RequestMethod.GET)
    public String write(){
        return "/menu/quwrite"; // quwrite.jsp로 이동
    }
    
    // 02_02. 게시글 작성처리
    @RequestMapping(value="/menu/insert.do", method=RequestMethod.POST)
    public String insert(@ModelAttribute QuVO vo) throws Exception{
        quService.create(vo);
        return "redirect:/menu/quview";
    }
    
    // 03. 게시글 상세내용 조회, 게시글 조회수 증가 처리
    // @RequestParam : get/post방식으로 전달된 변수 1개
    // HttpSession 세션객체
    @RequestMapping(value="/menu/detail.do", method=RequestMethod.GET)
    public ModelAndView detail(@RequestParam int q_no, HttpSession session) throws Exception{
        // 조회수 증가 처리
   //     quService.increaseViewcnt(q_no, session);
        // 모델(데이터)+뷰(화면)를 함께 전달하는 객체
        ModelAndView mav = new ModelAndView();
        // 뷰의 이름
        mav.setViewName("/menu/qudetail");
        // 뷰에 전달할 데이터
        System.out.println("q"+q_no);
        mav.addObject("dto", quService.read(q_no));
        mav.addObject("dtoRep",qurepService.readRep(q_no));
        return mav;
    }
    
    // 04. 게시글 수정
    // 폼에서 입력한 내용들은 @ModelAttribute QuVO vo로 전달됨
    @RequestMapping(value="/menu/update.do", method=RequestMethod.POST)
    public String update(@ModelAttribute QuVO vo) throws Exception{
        quService.update(vo);
        return "redirect:/menu/quview";
    }
    
    // 05. 게시글 삭제
    @RequestMapping("/menu/delete.do")
    public String delete(@RequestParam int q_no) throws Exception{
        quService.delete(q_no);
        return "redirect:/menu/quview";
    }
    
}
 
