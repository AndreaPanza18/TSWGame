package controller;
import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.*;
import model.*;
import java.util.*;

@WebServlet("/AddGame")
@MultipartConfig
public class AddGame extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("image");
        String name= request.getParameter("name");
        String category = request.getParameter("category");
        int price = Integer.parseInt(request.getParameter("price"));
        addImage(filePart, name.replace(" ", ""), response);
        GameDOA createGame = new GameDOA();
        Game g = new Game();
        g.setName(name);
        g.setPrice(price);
        g.setCategory(category);
        createGame.saveGame(g);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/search-category-form.html");
        dispatcher.forward(request, response);

    }

    protected void addImage(Part file, String name,  HttpServletResponse response) throws IOException {
        String uploadDir = "C:\\Users\\ACER\\Desktop\\java code\\ProjectDB\\src\\main\\webapp\\images";
        String filePath = uploadDir + File.separator + name + ".jpg";
        try (InputStream fileContent = file.getInputStream();
             OutputStream outputStream = new FileOutputStream(filePath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileContent.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            // Handle any errors
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error uploading file");
            return;
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
