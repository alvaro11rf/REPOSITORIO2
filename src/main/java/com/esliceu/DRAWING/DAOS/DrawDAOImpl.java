package com.esliceu.DRAWING.DAOS;

import com.esliceu.DRAWING.Model.Draw;
import com.esliceu.DRAWING.Model.User;

import java.util.ArrayList;
import java.util.List;

public class DrawDAOImpl implements DrawDAO {
    private static int nextId = 1;
    static List<Draw> drawList = new ArrayList<>();

    @Override
    public void saveDrawing(Draw draw, String username) {
        draw.setId(nextId++);
        drawList.add(draw);
    }

    public Draw getDrawByUsername(String username) {
        for (Draw draw : drawList) {
            if (draw.getUser().equals(username))
                return draw;
        }
        return null;
    }

    @Override
    public List<Draw> myDrawings() {

        return drawList;
    }

    @Override
    public List<Draw> all() {
        return drawList;
    }

    @Override
    public Draw getDrawingDetailsById(int drawingId) {
        for (Draw draw: drawList){
            if (draw.getId() == drawingId){

                return draw;
            }
        }
        return null;
    }


}
