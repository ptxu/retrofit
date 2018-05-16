/**
 * Copyright: Copyright (c) 2018 
 * Company:深圳市深网视界科技有限公司
 * 
 * @author dell
 * @date 2018年4月28日 下午5:29:22
 * @version V1.0
 */
package com.ptxu.retrofit.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ptxu.retrofit.domain.Hotel;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @ClassName: HotelController
 * @Description: TODO
 * @author dell
 * @date 2018年4月28日 下午5:29:22
 *
 */
@RestController
@RequestMapping("/hotel")
@Api("HotelController相关api")
public class HotelController {

    @ApiOperation("获取酒店Hotel信息：getHotelWithQueryParameter")
    @RequestMapping(value = "/getHotelWithQueryParameter", method = RequestMethod.GET)
    public Hotel getHotelWithQueryParameter(@RequestParam("hotelname") String hotelname) {
        if (hotelname.equals("nana")) {
            return new Hotel(777, "假日酒店");
        }
        return new Hotel(1314, "玫瑰酒店");
    }

    @ApiOperation("获取酒店Hotel信息：getHotelList")
    @RequestMapping(value = "/getHotelList", method = RequestMethod.POST)
    public List<Hotel> getHotelList() {
        List<Hotel> hotelList = new ArrayList<Hotel>();
        hotelList.add(new Hotel(1314, "玫瑰酒店"));
        hotelList.add(new Hotel(2046, "2046酒店"));
        return hotelList;
    }

    @ApiOperation("获取酒店Hotel信息：getHotelListWithBody")
    @RequestMapping(value = "/getHotelListWithBody", method = RequestMethod.POST)
    public List<Hotel> getHotelListWithBody(@RequestBody Hotel hotel) {
        List<Hotel> hotelList = new ArrayList<Hotel>();
        if (hotel.getHotelname().equals("武林酒店")) {
            hotelList.add(new Hotel(13141, "玫瑰酒店1"));
            hotelList.add(new Hotel(20461, "2046酒店1"));
            return hotelList;
        }
        hotelList.add(new Hotel(1314, "玫瑰酒店"));
        hotelList.add(new Hotel(2046, "2046酒店"));
        return hotelList;
    }
}
