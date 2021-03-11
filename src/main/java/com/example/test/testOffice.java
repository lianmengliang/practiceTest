package com.example.test;

import org.apache.http.entity.ContentType;
import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import javax.activation.FileDataSource;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * @Author ： Leo
 * @Date : 2021/2/23 16:31
 * @Desc:
 */
public class testOffice {
//C:\Users\xw\Desktop\officeTestFile\test01.docx

    /**
     * docx文件转化为 pdf文档
     * @throws IOException
     */
    public static void docxTurnPdf() throws IOException {


        String docPath = "C:\\Users\\xw\\Desktop\\officeTestFile\\test01.docx";
        String pdfPath = "C:\\Users\\xw\\Desktop\\officeTestFile\\test01.pdf";

        String docPath1 = "C:\\Users\\xw\\Desktop\\officeTestFile\\test002.doc";
        String pdfPath1 = "C:\\Users\\xw\\Desktop\\officeTestFile\\test02.pdf";
       /* XWPFDocument document;
        try (InputStream doc = Files.newInputStream(Paths.get(docPath))) {
            document = new XWPFDocument(doc);
        }
        PdfOptions options = PdfOptions.create();
        try (OutputStream out = Files.newOutputStream(Paths.get(pdfPath))) {
            PdfConverter.getInstance().convert(document, out, options);
        }*/

        XWPFDocument docFile = new XWPFDocument(new FileInputStream(docPath1));
        PdfOptions options = PdfOptions.create();
        PdfConverter.getInstance().convert(docFile,new FileOutputStream(pdfPath1),options);


        String pdfStr = docPath.split("\\.")[0]+".pdf";
        System.out.println(pdfStr);

        File file = new File("3311");

    }

    public static void testMultipartFile(){
        String uuid = UUID.randomUUID()+ "" ;
        uuid=uuid.substring(0,8);
        System.out.println(uuid+"--------------------------");


        String filePath = "C:\\Users\\xw\\Desktop\\officeTestFile\\1.jpg";
        String fileName = uuid+ filePath.substring(filePath.indexOf("."));
        // 创建一个新文件
        File file = new File(filePath);

        try {
            MultipartFile mulFile = new MockMultipartFile(
                    "haha.jpg", //文件名
                    "haha.jpg", //originalName 相当于上传文件在客户机上的文件名
                    ContentType.APPLICATION_OCTET_STREAM.toString(), //文件类型
                    new FileInputStream(file) //文件流
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * docx文件转化为pdf文件
     * @param newFileName
     * @param file
     */
    public void docxTurnPdf(String newFileName, MultipartFile file) {

        // 文档docx转换为pdf

        String pdfStr = newFileName.split("\\.")[0] + ".pdf";
        try {
            byte[] b = file.getBytes();
            File docxFile = new File(newFileName);
            OutputStream output = new FileOutputStream(docxFile);
            BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);
            bufferedOutput.write(b);

            XWPFDocument docFile = new XWPFDocument(new FileInputStream(docxFile));
            PdfOptions options = PdfOptions.create();
            PdfConverter.getInstance().convert(docFile, new FileOutputStream(pdfStr), options);

            File pdfFile = new File(pdfStr);
            FileInputStream inputStream = new FileInputStream(pdfFile);
            file = new MockMultipartFile(pdfFile.getName(), inputStream);
            newFileName = pdfStr;




        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 主方法
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
//        docxTurnPdf();

        testMultipartFile();
    }

}
