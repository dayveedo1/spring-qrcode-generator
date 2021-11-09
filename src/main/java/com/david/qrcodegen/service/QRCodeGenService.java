package com.david.qrcodegen.service;

import com.david.qrcodegen.model.RequestBody;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

@Service
public class QRCodeGenService {

    private String QR_CODE_PATH = "C:\\Users\\A\\Pictures\\QRCode-Server\\";

//    public  void generateQRCodeImage (String text, int width, int height, String filePath) throws IOException, WriterException{
//
//        QRCodeWriter writer = new QRCodeWriter();
//        BitMatrix bitMatrix = writer.encode(text, BarcodeFormat.QR_CODE, width, height);
//
//        Path path = FileSystems.getDefault().getPath(filePath);
//        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
//    }
//
//
//    public  byte[] getQRCodeImage (String text, int width, int height) throws WriterException, IOException {
//        QRCodeWriter writer = new QRCodeWriter();
//        BitMatrix bitMatrix = writer.encode(text, BarcodeFormat.QR_CODE, width, height);
//
//        ByteArrayOutputStream  outputStream = new ByteArrayOutputStream();
//        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
//
//        byte[] pngData = outputStream.toByteArray();
//        return pngData;
//
//    }


    public void generateQRCodeImage (RequestBody body) throws IOException, WriterException{

        String QrCode = QR_CODE_PATH + body.getUserName()+ body.getBank()+ "-QRCODE.PNG";


        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix bitMatrix = writer.encode(body.getUserName() + "\n" +
                body.getMobileNumber()+ "\n" +
                body.getAccountType() + "\n" +
                body.getAccountNumber() + "\n" +
                body.getBank(),
                BarcodeFormat.QR_CODE, 350, 350);

        Path path = FileSystems.getDefault().getPath(QrCode);
        MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);

    }


    public  byte[] getQRCodeImage (RequestBody body) throws WriterException, IOException {
        QRCodeWriter writer = new QRCodeWriter();
        BitMatrix bitMatrix = writer.encode(body.getUserName() + "\n" +
                        body.getMobileNumber()+ "\n" +
                        body.getAccountType() + "\n" +
                        body.getAccountNumber() + "\n" +
                        body.getBank(),
                BarcodeFormat.QR_CODE, 350, 350);

        ByteArrayOutputStream  outputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);

        byte[] pngData = outputStream.toByteArray();
        return pngData;

    }
}
