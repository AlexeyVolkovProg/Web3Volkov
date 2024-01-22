package web.lab3.server.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import web.lab3.server.utils.PointChecker;
import web.lab3.server.model.PointCheck;

import java.io.Serializable;
import java.util.Date;

@Named
@RequestScoped
public class CheckPointController implements Serializable {
    private double x;
    private double y;
    private double r;
    private boolean isHit;

    @Inject
    private PointCheckStorageController pointCheckStorageController;

    public void checkPoint(){
        PointCheck pointCheckResult = new PointCheck();
        pointCheckResult.setX(x);
        pointCheckResult.setY(y);
        pointCheckResult.setR(r);
        pointCheckResult.setHit(PointChecker.isPointInsideArea(x, y, r));
        pointCheckResult.setCreatedAt(new Date(System.currentTimeMillis()));
        pointCheckStorageController.savePointCheck(pointCheckResult);
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setR(double r) {
        this.r = r;
    }

    public void setHit(boolean hit) {
        isHit = hit;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return r;
    }

    public boolean getIsHit() {
        return isHit;
    }
}
