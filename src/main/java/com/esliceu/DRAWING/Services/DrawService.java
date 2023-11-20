package com.esliceu.DRAWING.Services;

import com.esliceu.DRAWING.DAOS.DrawDAO;
import com.esliceu.DRAWING.DAOS.DrawDAOImpl;
import com.esliceu.DRAWING.Model.Draw;
import com.esliceu.DRAWING.Model.User;

import java.util.List;

public class DrawService {
    DrawDAO drawDAO = new DrawDAOImpl();

    public void saveDrawing(String shapesJSON, User user){
        Draw mydraw = new Draw();
        mydraw.setShapesJSON(shapesJSON);
        mydraw.setUser(user);
        drawDAO.saveDrawing(mydraw, user.getUsername());
    }

    public List<Draw> myDrawings(String username) {
       return drawDAO.myDrawings();
    }

    public List<Draw> all() {
        return drawDAO.all();
    }

    public Draw getDrawingDetailsById(int drawingId) {
       return drawDAO.getDrawingDetailsById(drawingId);
    }
}
