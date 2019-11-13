package com.spring.mooncy.Controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mooncy.dto.QuRepPager;
import com.spring.mooncy.dto.QuRepVO;
import com.spring.mooncy.service.QuRepService;


// REST : Representational State Transfer
// ?•˜?‚˜?˜ URIê°? ?•˜?‚˜?˜ ê³ ìœ ?•œ ë¦¬ì†Œ?Š¤ë¥? ???‘œ?•˜?„ë¡? ?„¤ê³„ëœ ê°œë…

// http://localhost/spring02/list?bno=1 ==> url+?ŒŒ?¼ë¯¸í„°
// http://localhost/spring02/list/1 ==> url
// RestController?? ?Š¤?”„ë§? 4.0ë¶??„° ì§??›
// @Controller, @RestController ì°¨ì´? ?? ë©”ì„œ?“œê°? ì¢…ë£Œ?˜ë©? ?™”ë©´ì „?™˜?˜ ?œ ë¬?

@Controller

@RequestMapping("/reply/*")
public class QuRepController {
	
	@Inject
	QuRepService replyService;
	
	// 1_1. ?Œ“ê¸? ?…? ¥(@Controllerë°©ì‹?œ¼ë¡? ?Œ“ê¸? ?…? ¥)
	@RequestMapping(value="insert", method=RequestMethod.POST)
	public void insert(@ModelAttribute QuRepVO vo, HttpSession session){
		// ?„¸?…˜?— ???¥?œ ?šŒ?›?•„?´?””ë¥? ?Œ“ê¸??‘?„±??— ?„¸?Œ…
		String userId = (String) session.getAttribute("m_id");
		vo.setR_id(userId);
		// ?Œ“ê¸? ?…? ¥ ë©”ì„œ?“œ ?˜¸ì¶?
		replyService.create(vo);
		
	}
	
	// 1_2. ?Œ“ê¸??…? ¥ (@RestControllerë°©ì‹?œ¼ë¡? json? „?‹¬?•˜?—¬ ?Œ“ê¸??…? ¥)
	// @ResponseEntity : ?°?´?„° + http status code
	// @ResponseBody : ê°ì²´ë¥? json?œ¼ë¡? (json - String)
	// @RequestBody : json?„ ê°ì²´ë¡?
	@RequestMapping(value="insertRest", method=RequestMethod.POST)
	public ResponseEntity<String> insertRest(@RequestBody QuRepVO vo, HttpSession session){
		ResponseEntity<String> entity = null;
		try {
			String userId = (String) session.getAttribute("m_id");
			vo.setR_id(userId);
			replyService.create(vo);
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
	// 2_1. ?Œ“ê¸? ëª©ë¡(@Controllerë°©ì‹ : veiw(?™”ë©?)ë¥? ë¦¬í„´)
	@RequestMapping("list")
	public ModelAndView list(@RequestParam int bno,	@RequestParam(defaultValue="1") int curPage, ModelAndView mav, HttpSession session){
		// ?˜?´ì§? ì²˜ë¦¬ 
		int count = replyService.count(bno); // ?Œ“ê¸? ê°??ˆ˜
		QuRepPager replyPager = new QuRepPager(count, curPage);
		// ?˜„?¬ ?˜?´ì§??˜ ?˜?´ì§? ?‹œ?‘ ë²ˆí˜¸
		int start = replyPager.getPageBegin();
		// ?˜„?¬ ?˜?´ì§??˜ ?˜?´ì§?  ? ë²ˆí˜¸
		int end = replyPager.getPageEnd();
		List<QuRepVO> list = replyService.list(bno, start, end, session);
		// ë·°ì´ë¦? ì§?? •
		mav.setViewName("menu/replyList");
		// ë·°ì— ? „?‹¬?•  ?°?´?„° ì§?? •
		mav.addObject("list", list);
		mav.addObject("replyPager", replyPager);
		// replyList.jspë¡? ?¬?›Œ?”©
		return mav;
	}
	
	// 2_2. ?Œ“ê¸? ëª©ë¡(@RestControllerë°©ì‹ : Json?œ¼ë¡? ?°?´?„°ë¥? ë¦¬í„´)
	@RequestMapping("listJson")
	@ResponseBody // ë¦¬í„´?°?´?„°ë¥? json?œ¼ë¡? ë³??™˜(RestController?‚¬?š©?‹œ @ResponseBody?ƒ?µê°??Š¥)
	public List<QuRepVO> listJson(@RequestParam int bno, @RequestParam(defaultValue="1") int curPage, HttpSession session){
		// ?˜?´ì§? ì²˜ë¦¬
		int count = replyService.count(bno); // ?Œ“ê¸? ê°??ˆ˜
		QuRepPager pager = new QuRepPager(count, curPage);
		// ?˜„?¬ ?˜?´ì§??˜ ?˜?´ì§? ?‹œ?‘ ë²ˆí˜¸
		int start = pager.getPageBegin();
		// ?˜„?¬ ?˜?´ì§??˜ ?˜?´ì§?  ? ë²ˆí˜¸
		int end = pager.getPageEnd();
		List<QuRepVO> list = replyService.list(bno, start, end, session);
		// listë¥? ë¦¬í„´
		return list;
	}
	
	// ** Controller ì¶”ê? ?‚¬?•­ - Restë°©ì‹?œ¼ë¡? ?Œ“ê¸? ëª©ë¡, ?ˆ˜? •, ?‚­? œ ì²˜ë¦¬
	
	// 2_3. ?Œ“ê¸? ëª©ë¡(@RestControllerë°©ì‹ :  json?œ¼ë¡? ? „?‹¬?•˜?—¬ ëª©ë¡?ƒ?„±)
	// /reply/list/1 => 1ë²? ê²Œì‹œë¬¼ì˜ ?Œ“ê¸? ëª©ë¡ ë¦¬í„´
	// /reply/list/2 => 2ë²? ê²Œì‹œë¬¼ì˜ ?Œ“ê¸? ëª©ë¡ ë¦¬í„´
	// @PathVariable : url?— ?…? ¥?  ë³??ˆ˜ê°? ì§?? •
	@RequestMapping(value="/list/{bno}/{curPage}", method=RequestMethod.GET)
	public ModelAndView replyList(@PathVariable("bno") int bno, @PathVariable int curPage, ModelAndView mav, HttpSession session){
		// ?˜?´ì§? ì²˜ë¦¬
		int count = replyService.count(bno); // ?Œ“ê¸? ê°??ˆ˜
		QuRepPager replyPager = new QuRepPager(count, curPage);
		// ?˜„?¬ ?˜?´ì§??˜ ?˜?´ì§? ?‹œ?‘ ë²ˆí˜¸
		int start = replyPager.getPageBegin();
		// ?˜„?¬ ?˜?´ì§??˜ ?˜?´ì§?  ? ë²ˆí˜¸
		int end = replyPager.getPageEnd();
		List<QuRepVO> list = replyService.list(bno, start, end, session);
		// ë·°ì´ë¦? ì§?? •
		mav.setViewName("menu/replyList");
		// ë·°ì— ? „?‹¬?•  ?°?´?„° ì§?? •
		mav.addObject("list", list);
		mav.addObject("replyPager", replyPager);
		// replyList.jspë¡? ?¬?›Œ?”©
		return mav;
	}
	
	
	// 3. ?Œ“ê¸? ?ƒ?„¸ ë³´ê¸°
	// /reply/detail/1 => 1ë²? ?Œ“ê¸??˜ ?ƒ?„¸?™”ë©? ë¦¬í„´
	// /reply/detail/2 => 2ë²? ?Œ“ê¸??˜ ?ƒ?„¸?™”ë©? ë¦¬í„´
	// @PathVariable : url?— ?…? ¥?  ë³??ˆ˜ê°? ì§?? •

	
	// 4. ?Œ“ê¸? ?ˆ˜? • ì²˜ë¦¬ - PUT:? „ì²? ?ˆ˜? •, PATCH:?¼ë¶??ˆ˜? •
	// RequestMethodë¥? ?—¬?Ÿ¬ ë°©ì‹?œ¼ë¡? ?„¤? •?•  ê²½ìš° {}?•ˆ?— ?‘?„±
	@RequestMapping(value="/update/{rno}", method={RequestMethod.POST})
	public ResponseEntity<String> replyUpdate(@PathVariable("rno") Integer rno, @RequestBody QuRepVO vo){
		ResponseEntity<String> entity = null;
		try {
			vo.setQ_r_no(rno);
			replyService.update(vo);
			// ?Œ“ê¸? ?ˆ˜? •?´ ?„±ê³µí•˜ë©? ?„±ê³? ?ƒ?ƒœë©”ì‹œì§? ???¥
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			// ?Œ“ê¸? ?ˆ˜? •?´ ?‹¤?Œ¨?•˜ë©? ?‹¤?Œ¨ ?ƒ?ƒœë©”ì‹œì§? ???¥
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		// ?ˆ˜? • ì²˜ë¦¬ HTTP ?ƒ?ƒœ ë©”ì‹œì§? ë¦¬í„´
		return entity;
	}
	
	// 5. ?Œ“ê¸? ?‚­? œì²˜ë¦¬
	@RequestMapping(value="/delete/{rno}")
	public ResponseEntity<String> replyDelete(@PathVariable("rno") Integer rno){
		ResponseEntity<String> entity = null;
		try {
			replyService.delete(rno);
			// ?Œ“ê¸? ?‚­? œê°? ?„±ê³µí•˜ë©? ?„±ê³? ?ƒ?ƒœë©”ì‹œì§? ???¥
			entity = new ResponseEntity<String>("success", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			// ?Œ“ê¸? ?‚­? œê°? ?‹¤?Œ¨?•˜ë©? ?‹¤?Œ¨ ?ƒ?ƒœë©”ì‹œì§? ???¥
			entity = new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		// ?‚­? œ ì²˜ë¦¬ HTTP ?ƒ?ƒœ ë©”ì‹œì§? ë¦¬í„´
		return entity;
	}
}
