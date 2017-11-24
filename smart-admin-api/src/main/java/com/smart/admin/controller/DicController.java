package com.smart.admin.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.smart.admin.entity.Dic;
import com.smart.admin.form.DicSearchForm;
import com.smart.admin.service.IDicService;
import com.smart.common.result.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* 字典数据
* @author xiaobai
* @date 2017/10/30 12:30
**/
@Api(description = "字典数据接口")
@RestController
@RequestMapping("/dic")
public class DicController extends BaseController {

    @Autowired
    private IDicService dicService;


    @ApiOperation(value = "获取字典列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ApiResult<Page<Dic>> list(@RequestBody DicSearchForm dicSearchForm){
        Page<Dic> page = getPage(dicSearchForm);
        EntityWrapper<Dic> wrapper = new EntityWrapper<>();
        if(StringUtils.isNotBlank(dicSearchForm.getCode())){
            wrapper.like(Dic.CODE,dicSearchForm.getCode());
        }
        wrapper.orderBy(Dic.CODE,true);
        wrapper.orderBy(Dic.ORDER_NUM,true);
        Page<Dic> dicPage = dicService.selectPage(page, wrapper);
        return ApiResult.success(dicPage);
    }


    @ApiOperation(value = "获取字典详情")
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public ApiResult detail(@PathVariable Long id){
        Dic dic = dicService.selectById(id);
        return ApiResult.success(dic);
    }

    @ApiOperation(value = "保存字典")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ApiResult save(@RequestBody Dic dic){
        if(dic.getId()==null){
            dicService.insert(dic);
        }else{
            dicService.updateById(dic);
        }
        return ApiResult.success(dic);
    }

    @ApiOperation(value = "获取全部字典数据")
    @RequestMapping(value = "/dicData", method = RequestMethod.GET)
    public ApiResult dicData(){
        EntityWrapper<Dic> wrapper = new EntityWrapper<>();
        wrapper.groupBy(Dic.CODE);
        List<Dic> dics = dicService.selectList(wrapper);
        Map<String,Map<String,String>> map = new HashMap<>(dics.size());
        for (Dic dic : dics) {
            EntityWrapper<Dic> dicEntityWrapper = new EntityWrapper<>();
            dicEntityWrapper.eq(Dic.CODE,dic.getCode());
            dicEntityWrapper.orderBy(Dic.ORDER_NUM,true);
            List<Dic> dicItems = dicService.selectList(dicEntityWrapper);
            Map<String,String> data = new HashMap<>(dicItems.size());
            for (Dic dicItem : dicItems) {
                data.put(dicItem.getValue(),dicItem.getName());
            }
            map.put(dic.getCode(),data);
        }
        return ApiResult.success(map);
    }
}
