package services.facilityimpl;

import controllers.BookingController;
import models.Booking;
import models.Customer;
import services.IServices;
import utils.DisplayScanner;

import java.util.Scanner;

public class BookingServices implements IServices {
    private BookingController controller = new BookingController();
    private 

    public String getId() {
        return "BO" + String.format("%04d", controller.getId());
    }

    public void findAll() {
        controller.findAll();
    }

    @Override
    public void add() {
        controller.add(new Booking(getId(), DisplayScanner.getInfoFromConsole(Booking.getInfo())));
    }

    @Override
    public void updateById(Scanner scanner) {

    }
}
