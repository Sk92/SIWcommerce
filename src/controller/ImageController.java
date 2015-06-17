package controller;

import sun.misc.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/images/*")
public class ImageController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String imagePath = System.getProperty("catalina.base") + "/smcommerceimages";
        String filename = request.getPathInfo().substring(1);
        File file = new File(imagePath, filename);
        response.setHeader("Content-Type", getServletContext().getMimeType(filename));
        response.setHeader("Content-Length", String.valueOf(file.length()));
        response.setHeader("Content-Disposition", "inline; filename=\"" + filename + "\"");

        byte[] bFile = new byte[(int) file.length()];
        FileInputStream fileInputStream=null;
        try {
            //convert file into array of bytes
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bFile);
            fileInputStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        response.getOutputStream().write(bFile);
    }

}

