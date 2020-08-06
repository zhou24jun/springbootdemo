package com.example.demo;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @className: ReadPdfTest
 * @description:
 * @author: junZhou
 * @date: 2020/8/6
 **/
public class ReadPdfTest {

    @Test
    void readPDF() {
        String pdfStr = "D:\\MyData\\zhoujun46\\Desktop\\java.pdf";
        String destStr = "D:\\MyData\\zhoujun46\\Desktop\\java2020080603.txt";
        PrintWriter writer = null;
        PdfReader reader = null;

        try {

            writer = new PrintWriter(new FileOutputStream(destStr));

            reader = new PdfReader(pdfStr);

            int num = reader.getNumberOfPages();// 获得页数

            System.out.println("Total Page: " + num);

            String content = ""; // 存放读取出的文档内容
            String line = null;

            for (int i = 1; i <= num; i++) {

                // 读取第i页的文档内容

                line = PdfTextExtractor.getTextFromPage(reader, i);
                System.out.println(line);
                content += line;

            }

            writer.write(content);// 写入文件内容
            writer.flush();
            writer.close();

        } catch (IOException e) {

            e.printStackTrace();

        }


    }
}
