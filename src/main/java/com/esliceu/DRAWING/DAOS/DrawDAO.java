package com.esliceu.DRAWING.DAOS;

import com.esliceu.DRAWING.Model.Draw;
import com.esliceu.DRAWING.Model.User;

import java.util.List;

public interface DrawDAO {
    void saveDrawing(Draw draw, String username);

    List<Draw> myDrawings();

    List<Draw> all();

    Draw getDrawingDetailsById(int drawingId);
}


