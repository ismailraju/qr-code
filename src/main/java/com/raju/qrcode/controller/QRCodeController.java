package com.raju.qrcode.controller;


import com.google.zxing.EncodeHintType;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.raju.qrcode.payload.QrRequest;
import com.raju.qrcode.service.GenerateQrCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;


@RestController
//@RequestMapping("/qr-code")
public class QRCodeController {

    public static final Logger LOGGER = LoggerFactory.getLogger(QRCodeController.class);

    @Autowired
    private GenerateQrCode generateQRcode;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getQrGeneratePage(Model model, HttpServletRequest request, HttpServletResponse response) {

        model.addAttribute("qrRequest", new QrRequest("rajuu"));
        return new ModelAndView("home");

    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView getQrGenerateResponse(
              QrRequest qrRequest,
            Model model,
            HttpServletRequest request,
            HttpServletResponse response) {
        LOGGER.info(qrRequest.toString());


        try {

            String path = "C:\\Users\\Raju\\Downloads\\qr-code\\Quote-L.png";
            //Encoding charset to be used
            String charset = "UTF-8";
            Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
            //generates QR code with Low level(L) error correction capability
            hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
            //invoking the user-defined method that creates the QR code
            generateQRcode.generateQRcode(qrRequest.getContent(), path, charset, hashMap, 400, 400);//increase or decrease height and width accodingly
            //prints if the QR code is generated
            System.out.println("QR Code created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());
        }


        return new ModelAndView("home");

    }


}
