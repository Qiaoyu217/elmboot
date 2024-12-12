package team.tjusw.elmboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import team.tjusw.elmboot.po.Business;
import team.tjusw.elmboot.service.BusinessService;

@RestController
@RequestMapping("/BusinessController")
public class BusinessController {
    @Autowired
    private BusinessService businessService;

    @RequestMapping("/listBusinessByOrderTypeId")
    public List<Business> listBusinessByOrderTypeId(Integer orderTypeId) {
        try {
            return businessService.listBusinessByOrderTypeId(orderTypeId);
        } catch (Exception e) {
            // 记录日志
            logger.error("获取商家列表失败", e);
            throw new RuntimeException("获取商家列表失败", e);
        }
    }

    @RequestMapping("/getBusinessById")
    public Business getBusinessById(Integer businessId) {
        try {
            return businessService.getBusinessById(businessId);
        } catch (Exception e) {
            // 记录日志
            logger.error("获取商家信息失败", e);
            throw new RuntimeException("获取商家信息失败", e);
        }
    }

}
