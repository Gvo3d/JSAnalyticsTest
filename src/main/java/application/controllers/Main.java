package application.controllers;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.servlet.ModelAndView;

@Controller
public class Main {

    @RequestMapping("/")
    public ModelAndView index(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping("/test")
    public ModelAndView test(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index2");
        return mav;
    }

    @RequestMapping("/test2")
    public ModelAndView test2(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("frontend/src/index");
        return mav;
    }
}