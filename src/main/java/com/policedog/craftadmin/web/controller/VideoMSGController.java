package com.policedog.craftadmin.web.controller;

import com.policedog.craftadmin.commons.BaseResult;
import com.policedog.craftadmin.domain.VideoMSG;
import com.policedog.craftadmin.service.VideoMSGService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping(value = "/videomsg")
public class VideoMSGController {
    @Autowired
    private VideoMSGService videoMSGService;

    @ModelAttribute
    public VideoMSG getVideoMSG(Long id){
        VideoMSG videoMSG = null;
        //id不为空，则从数据库获取
        if (id!=null){
            videoMSG = videoMSGService.getById(id);
        }else {
            videoMSG = new VideoMSG();
        }
        return videoMSG;
    }


    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model){
        List<VideoMSG> videoMSGList = videoMSGService.selectAll();
        model.addAttribute("videoMSGList",videoMSGList);
        return "videomsg_list";
    }

    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form(Model model){
        return "videomsg_form";
    }


    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(VideoMSG videoMSG, Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult = videoMSGService.save(videoMSG);
        if (baseResult.getStatus()==BaseResult.STATUS_SUCCESS){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/videomsg/list";
        }else {
            model.addAttribute("baseResult",baseResult);
            return "videomsg_form";
        }
    }

    @RequestMapping(value = "search",method = RequestMethod.POST)
    public String search(String keyword,Model model){
        List<VideoMSG> videoMSGList = videoMSGService.search(keyword);
        model.addAttribute("videoMSGList",videoMSGList);
        return "videomsg_list";
    }

    @ResponseBody
    @RequestMapping(value = "delete" ,method = RequestMethod.POST)
    public BaseResult delete(String ids){
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)){
            String[] idArray = ids.split(",");
            videoMSGService.deleteMulti(idArray);
            baseResult = BaseResult.success("删除成功");
        }
        else {
            baseResult = BaseResult.fail("删除失败");
        }
        return baseResult;
    }
}
