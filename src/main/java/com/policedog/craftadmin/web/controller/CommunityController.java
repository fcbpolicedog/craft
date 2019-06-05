package com.policedog.craftadmin.web.controller;

import com.policedog.craftadmin.commons.BaseResult;
import com.policedog.craftadmin.domain.Community;
import com.policedog.craftadmin.service.CommunityService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping(value = "Community")
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @ModelAttribute
    public Community getCommunity(Long id){
        Community community = null;
        //id不为空，则从数据库获取
        if (id!=null){
            community = communityService.getBycommunityId(id);
        }else {
            community = new Community();
        }
        return community;
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String communityList(Model model){
        List<Community> communityList = communityService.selectAll();
        model.addAttribute("communityList",communityList);
        return "community_list";
    }

    @RequestMapping(value = "form",method = RequestMethod.GET)
    public String form(Model model){
        return "community_form";
    }



    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String save(Community community, Model model, RedirectAttributes redirectAttributes){
        BaseResult baseResult = communityService.save(community);

        if (baseResult.getStatus()==BaseResult.STATUS_SUCCESS){
            redirectAttributes.addFlashAttribute("baseResult",baseResult);
            return "redirect:/Community/list";
        }else {
            model.addAttribute("baseResult",baseResult);
            return "community_form";
        }
    }

    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String detail(Model model, HttpServletRequest request){
        Long communityid = Long.valueOf(request.getParameter("id"));
        List<Community> communityList = communityService.getSonByFatherId(communityid);
        model.addAttribute("communityList",communityList);
        return "community_detail";
    }

    @ResponseBody
    @RequestMapping(value = "/delete" ,method = RequestMethod.POST)
    public BaseResult delete(String ids){
        BaseResult baseResult = null;
        if (StringUtils.isNotBlank(ids)){
            String[] idArray = ids.split(",");

            communityService.deleteMulti(idArray);
            baseResult = BaseResult.success("删除成功");
        }
        else {
            baseResult = BaseResult.fail("删除失败");
        }
        return baseResult;
    }
}
