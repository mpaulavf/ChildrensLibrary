package com.example.childrenslibrayapp.objects;
import com.example.childrenslibrayapp.structures.DynamicArray;
import java.util.Calendar;
import java.util.Date;

public class BorrowState {

    private DynamicArray listOfWait;
    public boolean borrow;
    public boolean inLibrary;
    protected Date startDate;
    protected Date endDate;

    public void startBorrow(boolean borrow){
        if(borrow){
            startDate = new Date();  // Inicializa en la fecha y hora del día
            endDate = endDateSet(startDate);
        }
    }

    public Date endDateSet(Date startDate){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startDate);
        calendar.add(Calendar.DAY_OF_YEAR, 15);
        return calendar.getTime();
    }

    public void nextInLine(){
    }

}
