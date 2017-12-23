package com.xiaozl.initialwork1.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xiaozl.initialwork1.entity.User;
import com.xiaozl.initialwork1.entity.Upload;
import com.xiaozl.initialwork1.service.UserService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.List;

/**
 * @author xiaozl
 * @date 2017/11/20
 */
@Controller
@RequestMapping(value = "")
public class IndexController {

    @Resource
    private UserService userService;

    @RequestMapping(value = {"", "/", "/login"}, method = RequestMethod.GET)
    public String toLogin(HttpServletRequest request)
    {
        //If session have attribute "user", jump to index page, else jump to login page.
        if (request.getSession().getAttribute("user") != null){
            return "index";
        }
        else {
            return "login";
        }
    }

    //登录
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(User user, Model model, HttpServletRequest request) throws Exception{
        try {
            //If pass, set attribute to session, then redirect to index page.
            if (userService.checkLogin(user)) {
                request.getSession().setAttribute("user", user);
                return "index";
            }
            //If not pass, send error attribute.
            else{
                model.addAttribute("login_err", "登录失败!");
                return "login";
            }
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "login";
        }
    }
    //注册
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView showReguster(HttpServletRequest request,HttpServletResponse response){
        ModelAndView mav=new ModelAndView("register");
        mav.addObject("User",new User());
        return mav;
    }



    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView addUser(HttpServletRequest request,HttpServletResponse response, @ModelAttribute("user")User user) throws Exception {
        userService.newUser(user);
        return new ModelAndView("index","entity",user.getUserName());

    }
//查询
    @RequestMapping(value = "userList", method = RequestMethod.GET)
    public String userList(Model model) {
        try {
            // 查询user表中所有记录
            List<User> userList = userService.userList();
            // 将所有记录传递给要返回的jsp页面，放在userList当中
            model.addAttribute("userList", userList);
        } catch (Exception e){

        }
        // 返回pages目录下的admin/users.jsp页面
        return "userList";
    }

    /**
     * 跳转到添加的页面
     * @return
     */
  @RequestMapping(value="/add",method = RequestMethod.GET)
    public String toAdd()
        {
            return "toAdd";

    }

    @RequestMapping(value="/insert",method = RequestMethod.POST)
    public String insert(User user){
        userService.insert(user);
        return "redirect:/userList";
    }
    /*/**
     * 根据ID查找用户
     * @param id
     * @return
     */


    /* @RequestMapping(value="/findById")
    public String findById(Model model,int id){
        User user=userService.findById(id);
        model.addAttribute("user", user);

        return "toEdit";
    }*/


    @RequestMapping(value="/deleteByid")
    public String delete(int id){
        userService.delete(id);
        return "redirect:/userList";
    }



    @RequestMapping(value = {"", "/", "/update11"}, method = RequestMethod.GET)
    public String update(HttpServletRequest request,HttpServletResponse response,Integer id,Model model)
    {

        User user=userService.findById(id);
        model.addAttribute("user", user);

            return "update";







    }



    @RequestMapping(value="/update22",method = RequestMethod.POST)
    public String update(User user){
        userService.update(user);
        return "redirect:/userList";
    }


    @RequestMapping(value="/findBYId",method = RequestMethod.POST)
    public String find(HttpServletRequest request,HttpServletResponse response,Model model)

    {
        Integer id=Integer.parseInt(request.getParameter("id"));


       User user=userService.findById(id);

        model.addAttribute("user", user);

            return "search";

    }
        @RequestMapping(value="/upload",method=RequestMethod.POST)
        public String register(HttpServletRequest request,
                               @ModelAttribute User user,
                               Model model) throws Exception {

            //如果文件不为空，写入上传路径
            if(!user.getImage().isEmpty()) {
                //上传文件路径
                String path = request.getServletContext().getRealPath("/images/");
                //上传文件名
                String filename = user.getImage().getOriginalFilename();
                File filepath = new File(path,filename);
                //判断路径是否存在，如果不存在就创建一个
                if (!filepath.getParentFile().exists()) {
                    filepath.getParentFile().mkdirs();
                }
                //将上传文件保存到一个目标文件当中
                user.getImage().transferTo(new File(path + File.separator + filename));
                //将用户添加到model
                model.addAttribute("user", user);
                return "upLoad";
            } else {
                return "error";
            }
        }

    @RequestMapping(value="/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,
                                           @RequestParam("filename") String filename,
                                           Model model)throws Exception {
        //下载文件路径
        String path = request.getServletContext().getRealPath("/images/");
        File file = new File(path + File.separator + filename);
        HttpHeaders headers = new HttpHeaders();
        //下载显示的文件名，解决中文名称乱码问题
        String downloadFielName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
        //通知浏览器以attachment（下载方式）打开图片
        headers.setContentDispositionFormData("attachment", downloadFielName);
        //application/octet-stream ： 二进制流数据（最常见的文件下载）。
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }
}
