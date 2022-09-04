package com.raju.qrcode.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/qr-code")
public class QRCodeController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getQrGeneratePage(Model model, HttpServletRequest request, HttpServletResponse response) {


        return new ModelAndView("qr/viewQrGeneration");

    }


}
