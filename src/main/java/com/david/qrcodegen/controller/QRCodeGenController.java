package com.david.qrcodegen.controller;

import com.david.qrcodegen.model.RequestBody;
import com.david.qrcodegen.service.QRCodeGenService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
public class QRCodeGenController {

    @Autowired
    public QRCodeGenService service;

    private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode.png";

    @Operation(description = "To generate & Download QR Code Image")
    @PostMapping("/generateAndDownloadQRCode")
    public void download(@org.springframework.web.bind.annotation.RequestBody RequestBody body
    ) throws Exception{

        service.generateQRCodeImage(body);
    }


    @Operation(description = "To generate QR code")
    @PostMapping("/generateQRCode")
    public ResponseEntity generateQRCode (@org.springframework.web.bind.annotation.RequestBody RequestBody body ) throws Exception{

        byte[]response = service.getQRCodeImage(body);
        String qrcode  = Base64.getEncoder().encodeToString(response);
        return  ResponseEntity.status(HttpStatus.OK).body(qrcode);
    }


//    @Operation(description = "To generate & Download QR Code Image")
//    @GetMapping("/generateAndDownloadQRCode/{codeText}/{width}/{height}")
//    public void download(String codeText, String width, String height
//                         ) throws Exception{
//
//        service.generateQRCodeImage(codeText, width, height, QR_CODE_IMAGE_PATH);
//    }
//
//
//    @Operation(description = "To generate QR code")
//    @GetMapping("/generateQRCode/{codeText}/{width}/{height}")
//    public ResponseEntity generateQRCode (@PathVariable ("codeText") String codeText,
//                                                  @PathVariable ("width") Integer width,
//                                                  @PathVariable ("height") Integer height
//    ) throws Exception{
//
//        byte[]response = service.getQRCodeImage(codeText, width, height);
//        String qrcode  = Base64.getEncoder().encodeToString(response);
//        return  ResponseEntity.status(HttpStatus.OK).body(qrcode);
//    }



}
