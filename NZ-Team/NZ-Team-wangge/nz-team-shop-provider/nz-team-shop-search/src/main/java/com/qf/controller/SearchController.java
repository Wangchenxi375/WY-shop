package com.qf.controller;


import com.qf.dto.ResultBean;
import com.qf.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

   @Autowired
    private ISearchService searchService;


    /**
     * 根据关键字，进行搜索，返回的是搜索页面，页面上带着这一次搜索的记过
     * @param keyword
     * @param model
     * @return
     */
    @RequestMapping("/select")
    public String searchByKeyword(String keyword, Model model){

        ResultBean resultBean = searchService.searchByKeyword(keyword);

        //List<TProductSearchDTO>
        model.addAttribute("products",resultBean.getData());


        return "search";
    }


    @RequestMapping("/addProduct")
    public ResultBean addProduct(Long pid){

        return searchService.addProduct(pid);


    }

}
